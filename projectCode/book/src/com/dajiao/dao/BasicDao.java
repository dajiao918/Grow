package com.dajiao.dao;

import com.dajiao.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-10 22:09
 **/
public class BasicDao {

    QueryRunner queryRunner = new QueryRunner();

    public int update(String sql, Object...params){

        Connection connection = JDBCUtils.getConnection();
        try {
            int update = queryRunner.update(connection, sql, params);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }

    }

    public <T> T querySingle(String sql,Class<T> c, Object...params) {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            T query = queryRunner.query(connection, sql, new BeanHandler<>(c), params);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }

    }

    public <T> List<T> queryMul(String sql, Class<T> c, Object...params) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            List<T> query = queryRunner.query(connection, sql, new BeanListHandler<>(c), params);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }

    }

    public Object querySal(String sql,Object...params) {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            Object query = queryRunner.query(connection, sql, new ScalarHandler(), params);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }

    }

}
