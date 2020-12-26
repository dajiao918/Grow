package com.dajiao.utils;

import com.alibaba.druid.Constants;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-10 21:42
 **/
public class JDBCUtils {

    private static DataSource dataSource = null;
    private static ThreadLocal<Connection> cons = new ThreadLocal<>();

    static{
        Properties properties = new Properties();
        try {
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 21; i++) {
            Connection connection = getConnection();
            System.out.println(connection);
        }
    }

    public static Connection getConnection(){

        Connection connection = cons.get();
            try {
                if (connection == null) {
                    connection = dataSource.getConnection();
                    //设置为手动管理
                    connection.setAutoCommit(false);
                    cons.set(connection);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        return connection;
    }

    public static void commitAndClose(){

        Connection connection = cons.get();
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        cons.remove();
    }

    public static void rollbackAndClose(){

        Connection connection = cons.get();
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        cons.remove();
    }



}
