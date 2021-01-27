# MyBatis

* [MyBatis](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md)
	* [概述](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#概述)
	* [搭建mybatis](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#搭建mybatis)
	* [分析mybatis程序过程](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#分析mybatis程序过程)
	* [自定义mybatis](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#自定义mybatis)
	* [mybatis的CRUD操作](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#mybatis的CRUD操作)
	  * [1、查询所有操作](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#1-查询所有操作)
	  * [2、插入数据操作](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#2-插入数据操作)
	  * [3、更新数据操作](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#3-更新数据操作)
	  * [4、删除数据操作](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#4-删除数据操作)
	  * [5、查询一个和模糊查询](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#5-查询一个和模糊查询)
	  * [6、查询单列（聚合函数）](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#6-查询单列)
	  * [7、获取插入数据的id](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#7-获取插入数据的id)
	* [OGNL表达式](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#OGNL表达式)
	* [数据库的列名和实体类的属性不一致处理](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#数据库的列名和实体类的属性不一致处理)
	  * [1、使用别名处理](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#1-使用别名处理)
	  * [2、使用resultMap标签](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#2-使用resultMap标签)
	* [SqlMapConfig.xml中配置的内容和顺序](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#SqlMapConfig.xml中配置的内容和顺序)
	  * [1、property属性](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#1-property属性)
	  * [2、typeAliases](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#2-typeAliases)
	  * [3、mappers](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#3-mappers)






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





## mybatis的CRUD操作



​		在测试类中添加如下代码，这样就能减少工作量，让我们专心操作于mybatis的crud，这里省略接口代码

```java
public class TestMybatisMapper {

    InputStream in;
    UserDao userDao;

    @Before//表示在测试方法执行之前执行
    public void init() throws IOException {

        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        Sqlession session =  factory.openSession();
        userDao = session.getMapper(UserDao.class);
    }

    @After//在测试方法执行之后执行
    public void destroy() throws IOException {
        //mybatis关闭了自动提交事务，所以需要手动提交，相当于connection.commit()，如果不手动提交事务就会回滚
        session.commit();
        //关闭session其实就是关闭connection
        session.close();
        in.close();
    }
}
```



### 1. 查询所有操作

​		在mapper映射文件添加select标签

```java
<!--namespace属性填写全限定接口名称-->
<mapper namespace="com.dajiao.dao.UserDao">
    <!--id是接口的方法名称，resulttype是返回类型,必须填写全限定类名，内容是sql语句-->
    <select id="selectUsers" resultType="com.dajiao.domain.user">
        select * from user
    </select>
</mapper>
```

​		测试类中编写测试代码

```java


@Test
    public void select(){
        List<User> users = userDao.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
```



### 2. 插入数据操作



​		mapper映射文件添加insert标签，id属性同样是接口的方法名，paratmterType属性是参数类型，同样要填写全限定名称，resultType不用填写全限定名称的原因是mybatis已经给常用的基本数据类型和一些其他类型注册了别名，并且不区分大小写，#{}表示占位符，里面需要填写传入**实体类的属性**

```xml
<insert id="insertUser" paratmterType="com.dajiao.domain.user" resultType="int">
	insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})
</insert>
```

​		测试类

```java
@Test
    public void testInsert(){
        User user = new User();
        user.setAddress("广东清远");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setUsername("mybatis insert user_name2");
        userDao.insertUser(user);
    }
```



### 3. 更新数据操作



​			mapper添加update标签

```xml
<update id="updateUser" paratmterType="com.dajiao.domain.user" resultType="int">
	update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}
</update>
```

​		测试类

````java
@Test
    public void testUpdate() {
        User user = new User();
        user.setId(65);
        user.setAddress("北京朝阳");
        user.setBirthday(new Date());
        user.setSex("g");
        user.setUsername("mybatis update user65");
        int i = userDao.updateUser(user);
        System.out.println("修改的用户影响行数" + i);
    }
````



### 4. 删除数据操作



​		mapper添加delete标签，这里的占位符可以随意填写，因为传入的参数是Integer类型，不是实体类，没有属性，mybatis可以直接识别

```xml
<delete id="deleteUser" paratmterType="int" resultType="int">
	delete from user where id=#{uid}
</delete>
```

​		测试类

```java
@Test
    public void testDelete() {

        int i = userDao.deleteUser(65);
        System.out.println("=====");
    }
```



### 5. 查询一个和模糊查询

* 查询一个

​		mapper添加select标签

```xml
<select id="selectOne" paratmterType="int" resultType="com.dajiao.domain.User">
	select * from user where id=#{uid}
</select>
```

​		测试类

```java
@Test
    public void testSelectOne() {

        User user = userDao.selectUser(51);
        System.out.println("查询到的用户时===" + user);
    }
```

* 模糊查询

  ​		mapper添加select标签

  ```xml
  <select id="selectUsersByDim" paratmterType="java.lang.String" resultType="com.dajiao.domain.User">
  	select * from user where username like#{username}
  </select>
  ```

  ​		测试类

  ```java
  @Test
      public void testSelectUserByDim() {
  		//当接口方法传入的参数没有拼接%时，执行方法时需要拼接
          List<User> users = userDao.selectUsersByDim("%王%");
          for (User user : users) {
              System.out.println(user);
          }
      }
  ```

  

### 6. 查询单列



​		mapper添加select标签

```xml
<select id="selectNumOfUser" resultType="int">
	select count(id) from user
</select>
```

​		测试类

```java
@Test
    public void testNumOfUser() {

        int numOfUser = userDao.selectNumOfUser();
        System.out.println("用户的数量==" + numOfUser);
    }
```



### 7. 获取插入数据的id

​		每次在我们插入数据后，返回地都是影响数据库的行数，但是并不知道现在是插入的第几个数据了，那么这样的需求就需要用到下面的sql语句

```sql
select last_insert_id()
```

​		我们只需要在mapper配置文件中的insert标签下加入selectKey标签

```xml
<insert id="insertUser" parameterType="com.dajiao.domain.User">
    <!--keyproperty表示实体类的属性，keycolumn表示mysql的列名，resulttype属性表示返回类型，order表示是在insert之前执行-，还是之后执行，AFTER之后，BEFORE之前->
   <selectKey keyProperty="userId" keyColumn="id" resultType="java.lang.Integer" order="AFTER">
        select last_insert_id()
   </selectKey>
   insert into user(`username`,`address`,`sex`,`birthday`) values(#{userName},#{userAddress},#{userSex},#{userBirthday})
</insert>
```





## OGNL表达式

​		它是通过对象的取值方法来获取数据。在写法上把get给省略了。比如：我们获取用户的名称类中的写法：user.getUsername();OGNL表达式写法：user.usernamemybatis中为什么能直接写username,而不用user.呢：因为在parameterType中已经提供了属性所属的类，所以此时不需要写对象名

​		当进行多表查询时，就不仅仅提供实体类信息了，可能还会提供商品信息，我们可以将两个实体类进行封装，就有了现在的需求

​		新建QueryVo类，将user实体类作为QueryVo类的属性，并提供get/set方法

```java
public class QueryVo {

    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
```



​		于是根据QueryVo对象进行模糊查询

```java
//UserDao接口方法
List<User> selectUsersForQueryVoByDim(QueryVo vo);
```

```xml
select id="selectUsersForQueryVoByDim" parameterType="com.dajiao.queryvo.QueryVo" resultType="com.dajiao.domain.User">
        select * from user where username like#{user.userName}
    </select>
```

```java
@Test
    public void testSelectUsersForQueryVoByDim() {

        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUserAddress("北京朝阳");
        user.setUserBirthday(new Date());
        user.setUserSex("g");
        user.setUserName("%王%");
        queryVo.setUser(user);
        List<User> users = userDao.selectUsersForQueryVoByDim(queryVo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
```



## 数据库的列名和实体类的属性不一致处理



​			当数据库的列名和实体类的属性不一致处理时，例如

```java
public class User {

    private Integer userId;
    private String userName;
    private String userAddress;
    private Date userBirthday;
    private String userSex;
}
```



​		我们先可以测试一下增删改方法，当测试增删改方法时，会报出异常

```java
Cause: org.apache.ibatis.reflection.ReflectionException: There is no getter for property named 'username' in 'class com.dajiao.domain.User'
```

​		这个异常说：在com.dajiao.domain.user类中没有名为username的属性getter，因为此时映射文件中的sql语句是

```java
<insert id="insertUser" paratmterType="com.dajiao.domain.user" resultType="int">
	insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})
</insert>
```

​		mybatis不认识占位符username，只能写成如下的语句

```xml
<insert id="insertUser" parameterType="com.dajiao.domain.User">
	insert into user(`username`,`address`,`sex`,`birthday`) values(#{userName},#{userAddress},#{userSex},#{userBirthday})
</insert>
```

​		这样的话mybatis才会认识实体类的属性，同理，更新也需要修改占位符，删除不需要更改，因为占位符是id，所以的出结论，增删改方法的占位符一定要与实体类的属性对应，这样mybatis才好进行识别，修改实体类属性和数据库的列名不一致对增删改方法影响不大

​		但是当我们执行查询方法时，会有如下的结果：

```java
User{userId=null, userName='老王', userAddress='null', userBirthday=null, userSex='null'}
User{userId=null, userName='小二王', userAddress='null', userBirthday=null, userSex='null'}
User{userId=null, userName='小二王', userAddress='null', userBirthday=null, userSex='null'}
User{userId=null, userName='传智播客', userAddress='null', userBirthday=null, userSex='null'}
User{userId=null, userName='老王', userAddress='null', userBirthday=null, userSex='null'}
```

​		此时是有结果的，但是因为mysql在windows系统下不区分大小写，所以username是有值的，而其他的属性名和实体类不一致，所以封装的时候就是空值，这个时候想要解决这个问题，就有两种方法

### 1. 使用别名处理

​			由于是mysql的列名和属性名不一致，所以我们只要在查询时将mysql的列名起一个和实体类属性一样的别名就行了，在xml件中编写如下语句

```xml
<select id="selectUsers" resultType="com.dajiao.domain.User">
   select id userId,username userName,birthday userBirthday,sex userSex,address userAddress from user
</select>
```

​		这种方式执行的效率高，但开发速度比较慢，所以mybatis还提供了其他方式

### 2. 使用resultMap标签

​			在mapper标签的里面配置resultMap标签，如下：

```xml
<!--id属性表示唯一标识，只要下面的select标签将id属性的值引用上，就可以使用resultMap标签的内容，解决列名不一致的问题
	type属性表示实体类的全限定名称，用于表示select标签返回地类型
-->
<resultMap id="userMap" type="com.dajiao.domain.User">
   <!--id标签配置主键，property属性表示实体类中的属性，column属性表示mysql的列名-->
   <id property="userId" column="id"></id>
   <!--result标签配置其他列名-->
   <result property="userName" column="username"></result>
   <result property="userAddress" column="address"></result>
   <result property="userBirthday" column="birthday"></result>
   <result property="userSex" column="sex"></result>
</resultMap>
```

​			在select标签中，这样引用resultMap标签的内容,不用再写返回类型的属性了

```xml
<select id="selectUsers" resultMap="userMap">
    select * from user
</select>
```

​			这种方式是大大的提高了可开发效率，是可取之道





## SqlMapConfig.xml中配置的内容和顺序



​			SqlMapConfig.xml文件的标签是不能乱放的，是有顺序的，其顺序如下：

```xml
<configuration>
    <properties>
        <property>
        </property>
    </properties>（属性）

    <settings>
        <setting></setting>
    </settings>（全局配置参数）

    <typeAliases>
        <typeAliase></typeAliase>
        <package/>
    </typeAliases>（类型别名）

    <typeHandlers>
    </typeHandlers>（类型处理器）

    <plugins>
    </plugins>（插件）

    <environments default="mysql">
        <environment id="mysql">
            <transactionManager type="JDBC"></transactionManager>
            <dataSource type="POOLED">
            </dataSource>
       </environment>
    </environments>

    <mappers>
        <mapper resource="com/dajiao/dao/UserDao.xml"/>
        <package/>
    </mappers>
</configuration>
```



### 1. property属性

​		

​			我们可以使用 property属性来指定mysql驱动、url、用户名和密码，例如：

```xml
<properties>
    <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC"/>
    <property name="username" value="root"/>
    <property name="password" value="qwer"/>
</properties>

<!--应用property属性-->
<environments default="mysql">
     <environment id="mysql">
     	<transactionManager type="JDBC"></transactionManager>
    	 <dataSource type="POOLED">
        	 <property name="driver" value="${driver}"/>
        	 <property name="url" value="${url}"/>
        	 <property name="username" value="${username}"/>
        	 <property name="password" value="${password}"/>
    	</dataSource>
	</environment>
</environments>
```

​		当然上面的做法是有那么一点重复性了，那我们可以使用property另一种方法，在资源目录的类路径下定义jdbcConfig.properties文件

```xml
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC
username=root
password=qwer
```

​		然后使用property的resource属性来获取文件，这样也可以使用上面的xml代码--**${driver}**--来实现mysql的各种资源获取

```xml
<properties resource="jdbcConfig.properties"></properties>
```

​		当然，还可以用property标签的url属性进行文件资源的获取，不过此时路径的值需要加上file协议，主机，端口号，以及URL（同一资源定位符），出现中文可能会导致乱码，尽量避免

```xml
<properties url="file:///F:\JavaProject\mybatis\study_mybatis_daoStudy\src\main\resources/jdbcConfig.properties">
</properties>
```



### 2. typeAliases

* typeAlias标签

​		在上面进行增删改查的过程中，编写xml代码时，基本数据类型和一些其他的类型是可以使用别名的，而我们写实体类名称却要写全限定类名，如果执行一些大型的项目，这是很不方便的，所以mybatis是支持我们自定义别名方式来进行开发，这就是用到了**typeAliases**标签，例如：

```xml
<typeAliases>
    <typeAlias type="com.dajiao.domain.User" alias="user"></typeAlias>-->
</typeAliases>
```

​		typeAlias标签用于配置实体类的别名，配好别名之后在接口的配置文件中的实体类信息就可以使用别名并且不再区分大小写，但这个标签一次只能配置一个实体类，是有那么一点局限的，所以还有另外一种方式

* package标签

```xml
<package name="com.dajiao.domain"/>
```

​		package标签的name属性只填写实体类的包名，这样就可以批量的对包下的实体类起别名，要求别名和实体类名一致，但不区分大小写

​		我们只需要在mapper映射文件下的比如说select标签的--**resultMap="user"**--即可，不需要再写权限定名称，也可以在insert标签的--**parameterType="user"**--即可，这样有助于开发



### 3. mappers

​	使用相对于类路径的资源，

```xml
<mapper resource="com/itheima/dao/IUserDao.xml" />
```

​	使用 mapper 接口类路径，使用**注解的方式开发**

```xml
 <mapper class="com.itheima.dao.UserDao"/>
注意：此种方法要求 mapper 接口名称和 mapper 映射文件名称相同，且放在同一个目录中。
```

​		当然这也可以使用package属性，标识所有mapper接口

```xml
<mappers>
    <!--dao路径下的资源接口都可以被标识，但要求dao下面的接口名称和mapper映射文件的namespace属性值相同-->
	 <package name="com.dajiao.dao"/>
</mappers>
```

