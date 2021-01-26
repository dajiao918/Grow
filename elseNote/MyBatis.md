# MyBatis

* [概述](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#概述)


## 概述

​		

​		mybatis是一个优秀的基于java的持久层框架，它的内部封装了jdbc，是开发者只关注sql语句本身，而不需要去花费精力去加载驱动，创建连接，创建statement的过程。

​		mybatis通过xml或者注解的方式将要执行的各种statement配置起来，并通过java对象和statement中SQL的动态参数进行映射生成最终执行的sql语句，最后由mybatis框架执行结果并将结果映射为java对象并返回





## 搭建mybatis



​		首先，创建一个Maven工程，在pom.xml文件中导入mybatis的坐标，mysql的坐标和junit的坐标。

```xml
<dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
    
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.1</version>
      <scope>test</scope>
    </dependency>
    
    <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>8.0.21</version>
    </dependency>
</dependencies>
```



* 创建数据库数据

```sql
CREATE TABLE `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(32) NOT NULL COMMENT '用户名称',
  `birthday` DATETIME DEFAULT NULL COMMENT '生日',
  `sex` CHAR(1) DEFAULT NULL COMMENT '性别',
  `address` VARCHAR(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY  (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT  INTO `user`(`id`,`username`,`birthday`,`sex`,`address`) 
VALUES (41,'老王','2018-02-27 17:47:08','男','北京'),
(42,'小二王','2018-03-02 15:09:37','女','北京金燕龙'),
(43,'小二王','2018-03-04 11:34:34','女','北京金燕龙'),
(45,'传智播客','2018-03-04 12:04:06','男','北京金燕龙'),
(46,'老王','2018-03-07 17:37:26','男','北京'),
(48,'小马宝莉','2018-03-08 11:44:00','女','北京修正');
```



* 创建数据库表的实体类：

```java
/**
 * @program: study-mybatis-day01
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-25 12:33
 **/
public class User {

    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
```



* 创建持久层接口

```java
public interface IUserDao {

    List<User> selectUsers();
}
```



* 编写mybatis的主配置文件SqlMapConfig.xml，此文件应该在资源目录下

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!--myabtis的约束文件-->
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
    <!--配置环境，可以配置多个环境，default属性表示具体的一种环境-->
	<environments  default="mysql">
        <!--配置环境 id属性表示唯一标识，和default相对应-->
    	<environment id="mysql">
        	<!--配置事务的类型-->
            <transactionManager type="JDBC"></transactionManager>
            <!--配置数据源-->
            <dataSource type="POOLED">
                <!--配置驱动，地址，用户，密码-->
            	<property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC"/>
                <property name="username" value="root"/>
                <property name="password" value="qwer"/>
            </dataSource>
        </environment>
    </environments>
    
    <mappers>
        <!--配置映射文件信息，对应dao独立的xml配置文件
			当使用注解的方式进行数据库的操作时，就要用到class属性，并且属性的值是dao接口的全类名，此时到接口就不能有配置文件了
		-->
    	<mapper resources="com/dajiao/dao/IUserDao.xml" />
    </mappers>
</configuration>
```



* 配置dao接口的配置文件

在resources资源目录下配置一个和dao接口一样的包路径，并在路径下配置dao接口的专属xml文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!--约束文件-->
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--namespace属性配置接口的全限定类名-->
<mapper namespace="com.dajiao.dao.IUserDao">
    <!--id属性表示接口中的方法名称，returnType表示方法返回地类型，值必须是类的全限定类名-->
	<select id="selecrUsers" returnType="com.dajiao.domain.User">
        <!--sql语句-->
    	select * from user
    </select>
</mapper>
```



​		接下来就可以在test目录下测试mybatis的操作数据库的数据了

```java
import com.dajiao.dao.IUserDao;
import com.dajiao.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: study-mybatis-day01
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-25 13:03
 **/
public class TestMybatis{
    
    //读取主配置文件的信息
    InputStream in = Resources.getResourcesAsStream("SqlMapConfig.xml");
    //创建构建者类，构建者可以根据文件信息构建SqlSessionFactory工厂类
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(in);
    //由工厂类的openSession方法生产一个SqlSession类
    SqlSession session = factory.opesSession();
    //根据SqlSession对象创建一个dao接口的代理对象
    IUserDao dao = session.getMapper(IUserDao.class);
    List<User> users = dao.selectUsers();
    //遍历输出集合
    for(User user : users) {
    	System.out.println(user);
    }
    //释放资源
    session.close();
    in.close();
}
```





## 分析mybatis程序过程



​		首先，有一个Resources类的getResourcesAsStream()方法类读取配置文件，生成一个流的形式传递给SQLSessionFactoryBuilder类会使用dom4j的技术来解析该配置文件，具体解析方式不做讨论，首先Builder类会将主配置文件的驱动、数据库地址、用户名、密码等解析出来，封装成一个Configuration对象，然后在获取mappers标签的所有子mapper标签的resources属性的值（这里不考虑注解的方式），根据resources的值得到了到接口的配置文件路径，然后再根据dao接口的配置文件信息获取mapper标签的namespace属性值也就是全限定接口类名和select标签id属性值也就是方法名，将全限定类名和方法名拼接成一个字符串如：**com.dajiao.dao.IUserDao**+ **"."** + **selectUsers**。

​		然后再获取select标签的returnType属性值也就是方法的返回类型和文本内容也就是sql语句，**mybatis会将returnType和sql语句封装成一个mapper对象**，**然后再将全限定类名和方法名拼接的字符串作为一个key值，将mapper对象作为value值，变为一个Map集合封装在Configuration类中**，这个时候Configuration类就有了数据库的驱动、数据库地址、用户名、密码，这样就可以根据这四个属性获取Connection连接，同时configuration类还有dao接口中具体方法要执行的sql语句和返回类型，获取以上这些信息的作用是可以根据sql语句和Connection获取PreStatement预处理对象，然后进行JDBC处理，封装数据，进行返回，封装成Configuration对象中是便于参数获取和参数的传递

​		此时SqlSessionFactoryBuilder类就获取了Configuration类的对象，并且通过build(InStream in)方法将Configuration对象传递给了SqlSessionFactory类，最后SqlSessionFactory通过openSession()方法将configuration对象传递给了SqlSession类，此时SqlSession对象就会调用getMapper(Class<T> daoInterfaceClass)获取传入的接口信息，**根据接口调用的方法获取全限定类名和方法名称（通过代理模式）拼接成字符串，再根据获取的字符串从Configuration对象中的mappers集合中获取mapper对象**，**这样就获取了对应接口的对应方法想要执行的sql语句和返回值类型**，最后在通过工具类进行JDBC处理将处理后的数据返回，这样就得到了我们想要的数据了！



## 自定义mybatis



​		首先把mybaits的依赖删除掉，可以根据实现查询的代码一步一步补全类

​		创建Resources类，并创建

```java
public class Resources{
    
    public static InputStream getResourcesAsStream(String filePath) {
        return ReSources.class.getClassLoader().getResourcesAsStream(filePath);
    }
}
```



​		创建SqlSessionFactoryBuilder类，并编写build方法

```java
public class SqlSessionFactoryBuilder{
    
    public SqlSessionFactory build(InputStream in) {
        Configuration config = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(config);//DefaultSqlSessionFactory是SqlSessionFactory的实现类
    }
}
```



​		创建configuration类

```java
public class Configuration{
    
    private String driver;
    private String url;
    private String username;
    private String password;
    
    //定义map集合，key代表接口和方法的字符串，值代表了sql语句和返回类型封装的mapper对象
    private Map<String,Mapper> mappers = new HashMap<>();
    
    public Map<String,Mapper> getMappers(){
        return this.mappers;
    }

    //利用追加的方式，将获取的mappers对象添加进configuration对象中
    public void setMappers(Map mappers){
        this.mappers.putAll(mappers);
    }
    get/set...
}
```



​		创建mapper类，用于封装sql语句和返回类型

```java
public class Mapper {

    String queryString;
    String resultType;

    get/set...

}
```



​		编写工具类，根据传进来的流文件通过dom4j和xpath技术进行解析，这里要导入相关的依赖

```xml
<dependency>
      <groupId>dom4j</groupId>
      <artifactId>dom4j</artifactId>
      <version>1.6.1</version>
    </dependency>

    <dependency>
      <groupId>jaxen</groupId>
      <artifactId>jaxen</artifactId>
      <version>1.1.6</version>
    </dependency>
```

* XMLConfigBuilder工具类

```java
package com.dajiao.mybatis.utils;

import com.dajiao.mybatis.config.Configuration;
import com.dajiao.mybatis.config.Mapper;
import com.dajiao.mybatis.io.Resources;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLConfigBuilder {



    /**
     * 解析主配置文件，把里面的内容填充到DefaultSqlSession所需要的地方
     * 使用的技术：
     *      dom4j+xpath
     */
    public static Configuration loadConfiguration(InputStream config){
        try{
            //定义封装连接信息的配置对象（mybatis的配置对象）
            Configuration cfg = new Configuration();

            //1.获取SAXReader对象
            SAXReader reader = new SAXReader();
            //2.根据字节输入流获取Document对象
            Document document = reader.read(config);
            //3.获取根节点
            Element root = document.getRootElement();
            //4.使用xpath中选择指定节点的方式，获取所有property节点
            List<Element> propertyElements = root.selectNodes("//property");
            //5.遍历节点
            for(Element propertyElement : propertyElements){
                //判断节点是连接数据库的哪部分信息
                //取出name属性的值
                String name = propertyElement.attributeValue("name");
                if("driver".equals(name)){
                    //表示驱动
                    //获取property标签value属性的值
                    String driver = propertyElement.attributeValue("value");
                    cfg.setDriver(driver);
                }
                if("url".equals(name)){
                    //表示连接字符串
                    //获取property标签value属性的值
                    String url = propertyElement.attributeValue("value");
                    cfg.setUrl(url);
                }
                if("username".equals(name)){
                    //表示用户名
                    //获取property标签value属性的值
                    String username = propertyElement.attributeValue("value");
                    cfg.setUsername(username);
                }
                if("password".equals(name)){
                    //表示密码
                    //获取property标签value属性的值
                    String password = propertyElement.attributeValue("value");
                    cfg.setPassword(password);
                }
            }
            //取出mappers中的所有mapper标签，判断他们使用了resource还是class属性
            List<Element> mapperElements = root.selectNodes("//mappers/mapper");
            //遍历集合
            for(Element mapperElement : mapperElements){
                //判断mapperElement使用的是哪个属性
                Attribute attribute = mapperElement.attribute("resource");
                if(attribute != null){
                    System.out.println("使用的是XML");
                    //表示有resource属性，用的是XML
                    //取出属性的值
                    String mapperPath = attribute.getValue();//获取属性的值"com/itheima/dao/IUserDao.xml"
                    //把映射配置文件的内容获取出来，封装成一个map
                    Map<String, Mapper> mappers = loadMapperConfiguration(mapperPath);
                    //给configuration中的mappers赋值
                    cfg.setMappers(mappers);
                }else{
//                    System.out.println("使用的是注解");
//                    //表示没有resource属性，用的是注解
//                    //获取class属性的值
//                    String daoClassPath = mapperElement.attributeValue("class");
//                    //根据daoClassPath获取封装的必要信息
//                    Map<String,Mapper> mappers = loadMapperAnnotation(daoClassPath);
//                    //给configuration中的mappers赋值
//                    cfg.setMappers(mappers);
                }
            }
            //返回Configuration
            return cfg;
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            try {
                config.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    /**
     * 根据传入的参数，解析XML，并且封装到Map中
     * @param mapperPath    映射配置文件的位置
     * @return  map中包含了获取的唯一标识（key是由dao的全限定类名和方法名组成）
     *          以及执行所需的必要信息（value是一个Mapper对象，里面存放的是执行的SQL语句和要封装的实体类全限定类名）
     */
    private static Map<String,Mapper> loadMapperConfiguration(String mapperPath)throws IOException {
        InputStream in = null;
        try{
            //定义返回值对象
            Map<String,Mapper> mappers = new HashMap<String,Mapper>();
            //1.根据路径获取字节输入流
            in = Resources.getResourceAsStream(mapperPath);
            //2.根据字节输入流获取Document对象
            SAXReader reader = new SAXReader();
            Document document = reader.read(in);
            //3.获取根节点
            Element root = document.getRootElement();
            //4.获取根节点的namespace属性取值
            String namespace = root.attributeValue("namespace");//是组成map中key的部分
            //5.获取所有的select节点
            List<Element> selectElements = root.selectNodes("//select");
            //6.遍历select节点集合
            for(Element selectElement : selectElements){
                //取出id属性的值      组成map中key的部分
                String id = selectElement.attributeValue("id");
                //取出resultType属性的值  组成map中value的部分
                String resultType = selectElement.attributeValue("resultType");
                //取出文本内容            组成map中value的部分
                String queryString = selectElement.getText();
                //创建Key
                String key = namespace+"."+id;
                //创建Value
                Mapper mapper = new Mapper();
                mapper.setQueryString(queryString);
                mapper.setResultType(resultType);
                //把key和value存入mappers中
                mappers.put(key,mapper);
            }
            return mappers;
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            in.close();
        }
    }

    /**
     * 根据传入的参数，得到dao中所有被select注解标注的方法。
     * 根据方法名称和类名，以及方法上注解value属性的值，组成Mapper的必要信息
     * @param daoClassPath
     * @return

    private static Map<String,Mapper> loadMapperAnnotation(String daoClassPath)throws Exception{
        //定义返回值对象
        Map<String,Mapper> mappers = new HashMap<String, Mapper>();

        //1.得到dao接口的字节码对象
        Class daoClass = Class.forName(daoClassPath);
        //2.得到dao接口中的方法数组
        Method[] methods = daoClass.getMethods();
        //3.遍历Method数组
        for(Method method : methods){
            //取出每一个方法，判断是否有select注解
            boolean isAnnotated = method.isAnnotationPresent(Select.class);
            if(isAnnotated){
                //创建Mapper对象
                Mapper mapper = new Mapper();
                //取出注解的value属性值
                Select selectAnno = method.getAnnotation(Select.class);
                String queryString = selectAnno.value();
                mapper.setQueryString(queryString);
                //获取当前方法的返回值，还要求必须带有泛型信息
                Type type = method.getGenericReturnType();//List<User>
                //判断type是不是参数化的类型
                if(type instanceof ParameterizedType){
                    //强转
                    ParameterizedType ptype = (ParameterizedType)type;
                    //得到参数化类型中的实际类型参数
                    Type[] types = ptype.getActualTypeArguments();
                    //取出第一个
                    Class domainClass = (Class)types[0];
                    //获取domainClass的类名
                    String resultType = domainClass.getName();
                    //给Mapper赋值
                    mapper.setResultType(resultType);
                }
                //组装key的信息
                //获取方法的名称
                String methodName = method.getName();
                String className = method.getDeclaringClass().getName();
                String key = className+"."+methodName;
                //给map赋值
                mappers.put(key,mapper);
            }
        }
        return mappers;
    }
    */

}

```



​		由工具类解析xml文件得到了configuration对象的所有属性之后，就将configuration传递到了SqlSessionFactory类中

```java
public interface SqlSessionFactory{
    
    SqlSession openSession();
}

class DefaultSqlSessionFactory implements SqlSessionFactory{
    
    Configuration config;
    
    public DefaultSqlSessionFactory(Configuration config) {
        this.config = config;
    }
    
    @Override
    public SqlSession openSession(){
        return new DefaultSqlSession(config,conn);//DefaultSqlSession是SqlSession接口的实现类
    }
}
```



* SqlSession类的编写

```java
public interface SqlSession{
    
    //关闭资源
    void close();
    
    <T> T getMapper(Class<T> daoInterfaceClass);
}

class DefaultSqlSession implements SqlSession{
    
    Configuration config;
    Connection conn;
    
    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        //传入configuration属性，获取连接
        this.conn  = DataSourceUtils.getConnection(configuration);
    }
    
     @Override
    public void close(){
        try{
           conn.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader,new Class[]{daoInterfaceClass},new ProxyMapper(Config,Conn));
    }
}
```





* 编写DataSourceUtils类获取连接

```java
/**
 * @program: study-mybatis-day01
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-25 16:27
 **/
public class DataSourceUtils {

    public static Connection getConnection(Configuration configuration) {
        try {
			//获取驱动
            Class.forName(configuration.getDriver());
            //注册mysql
            return DriverManager.getConnection(configuration.getUrl(), configuration.getUsername(), configuration.getPassword());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
```



* 编写ProxyMapper类实现InvocationHandler类

```java
public class ProxyMapper implements InvocationHandler {

    Configuration configuration;
    Connection conn;

    public ProxyMapper(Configuration configuration, Connection conn) {
        this.configuration = configuration;
        this.conn = conn;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //获取方法名
        String methodName = method.getName();
        //获取类名
        String className = method.getDeclaringClass().getName();
        String truePath = className + "." + methodName;
        //获取mapper以接口的类名为key，mapper为value的map集合
        Map<String, Mapper> mappers = configuration.getMappers();
        //获取mapper对象
        Mapper mapper = mappers.get(truePath);
        if (mapper == null) {
            throw  new IllegalArgumentException("传入的参数有误");
        }

        return new Executor().selectList(mapper,conn);
    }
}

```



* Executor工具类的编写

```java
public class Executor {

    public <E> List<E> selectList(Mapper mapper, Connection conn) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            //1.取出mapper中的数据
            String queryString = mapper.getQueryString();//select * from user
            String resultType = mapper.getResultType();//com.itheima.domain.User
            Class domainClass = Class.forName(resultType);
            //2.获取PreparedStatement对象
            pstm = conn.prepareStatement(queryString);
            //3.执行SQL语句，获取结果集
            rs = pstm.executeQuery();
            //4.封装结果集
            List<E> list = new ArrayList<E>();//定义返回值
            while(rs.next()) {
                //实例化要封装的实体类对象
                E obj = (E)domainClass.newInstance();

                //取出结果集的元信息：ResultSetMetaData
                ResultSetMetaData rsmd = rs.getMetaData();
                //取出总列数
                int columnCount = rsmd.getColumnCount();
                //遍历总列数
                for (int i = 1; i <= columnCount; i++) {
                    //获取每列的名称，列名的序号是从1开始的
                    String columnName = rsmd.getColumnName(i);
                    //根据得到列名，获取每列的值
                    Object columnValue = rs.getObject(columnName);
                    //给obj赋值：使用Java内省机制（借助PropertyDescriptor实现属性的封装）
                    PropertyDescriptor pd = new PropertyDescriptor(columnName,domainClass);//要求：实体类的属性和数据库表的列名保持一种
                    //获取它的写入方法
                    Method writeMethod = pd.getWriteMethod();
                    //把获取的列的值，给对象赋值
                    writeMethod.invoke(obj,columnValue);
                }
                //把赋好值的对象加入到集合中
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            release(pstm,rs);
        }
    }


    private void release(PreparedStatement pstm,ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        if(pstm != null){
            try {
                pstm.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
```





注意必须把两个配置文件中的约束删掉，那是mybatis的约束，而mybatis依赖已经被删除了

然后再执行以下代码，任然可以实现数据库的查询

```java
/**
 * @program: study-mybatis-day01
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-25 13:03
 **/
public class testSelect {

    public static void main(String[] args) throws IOException {

        InputStream in  = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> users = userDao.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }
}
```

