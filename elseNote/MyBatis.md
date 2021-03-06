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
	* [mybatis的连接池](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#mybatis的连接池)
	  * [1. UNPOOLED连接方式](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#1-UNPOOLED连接方式)
	  * [2. POOLED连接方式](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#2-POOLED连接方式)
	* [mybatis的事务管理](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#mybatis的事务管理)
	* [mybatis的动态SQL语句](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#mybatis的动态SQL语句)
	* [mybatis的多表查询](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#mybatis的多表查询)
	  * [1. 一对一查询](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#1-一对一查询)
	  * [2. 一对多查询](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#2-一对多查询)
	  * [3. 多对多查询](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#3-多对多查询)
	* [mybatis的延迟加载](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#mybatis的延迟加载)
	* [mybatis的缓存](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#mybatis的缓存)
	  * [1. mybatis中的一级缓存](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#1-mybatis中的一级缓存)
	  * [2. mybatis的二级缓存](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#2-mybatis的二级缓存)
	* [Mybatis的注解开发](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#Mybatis的注解开发)
	* [注解开发处理实体类属性和数据库列名不一致](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#注解开发处理实体类属性和数据库列名不一致)
	* [注解开发实现多表查询](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#注解开发实现多表查询)
	  * [1. 一对一查询](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#1-一对一查询)
	  * [2. 一对多查询](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#2-一对多查询)
	  * [3. 多对多查询](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#3-多对多查询)
	* [mybatis注解开启二级缓存](https://github.com/dajiao918/Grow/blob/main/elseNote/MyBatis.md#mybatis注解开启二级缓存)





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



## mybatis的连接池



​		mybatis的连接池技术是通过主配置文件SqlMapConfig.xml文件设置的

```xml
<dataSource type="POOLED"></dataSource>
```

​		type类型指定连接池技术，mybatis中有三种连接池技术



### 1. UNPOOLED连接方式

​		

​				UNPOOLED其实就是UnpooledDataSource类的简写，这个类实现了DataSource接口，它不是从mybatis定义的连接池中取出连接，而是每次要用的时候自己去创建一个连接，当以POOLED的方式去获取链接的时候，没有空闲的连接的话，就会通过UnpooledDataSource去创建新的连接

```java
public class UnpooledDataSource implements DataSource {
    
    @Override
    public Connection getConnection() throws SQLException {
        //调用dogetconnection方法，将username和password存储在properties对象中
      return doGetConnection(username, password);
    }
    
    private Connection doGetConnection(String username, String password) throws SQLException {
        Properties props = new Properties();
        if (driverProperties != null) {
          props.putAll(driverProperties);
        }
        if (username != null) {
          props.setProperty("user", username);
        }
        if (password != null) {
          props.setProperty("password", password);
        }
        //调用重载的doGETConnection方法，注册驱动并且获取连接
        return doGetConnection(props);
    }
    
    private Connection doGetConnection(Properties properties) throws SQLException {
        //，调用下面的initializeDriver()方法注册驱动
        initializeDriver();
        //获取连接
        Connection connection = DriverManager.getConnection(url, properties);
        configureConnection(connection);
        return connection;
    }
    
    private synchronized void initializeDriver() throws SQLException {
        if (!registeredDrivers.containsKey(driver)) {
          Class<?> driverType;
          try {
            if (driverClassLoader != null) {
                //注册驱动
              driverType = Class.forName(driver, true, driverClassLoader);
            } else {
              driverType = Resources.classForName(driver);
            }
            // DriverManager requires the driver to be loaded via the system ClassLoader.
            // http://www.kfu.com/~nsayer/Java/dyn-jdbc.html
            Driver driverInstance = (Driver)driverType.newInstance();
            DriverManager.registerDriver(new DriverProxy(driverInstance));
            registeredDrivers.put(driver, driverInstance);
          } catch (Exception e) {
            throw new SQLException("Error setting driver on UnpooledDataSource. Cause: " + e);
          }
    }
}
```





### 2. POOLED连接方式



​				POOLED类型的连接方式是通过mybatis创建的连接池技术，它是一个线程安全的连接池技术，用同步代码快将获取连接的代码包起来，不会出现两个线程拿到同一个连接的情况，同时也采用了当要获取连接时，首先会判断空闲连接池中还有没有空闲的连接，有的会就会从空闲的连接池找到休息的最久的connection拿去用，当没有空闲的连接池中没有空闲的连接的时候，就会判段活跃的连接池中的连接是否达到了设定的最大上限，如果没有就会通过UNPOOLED去创建一个连接，如果已经超过了，那么mybatis就会通过获取最老的活跃的连接，进行相关的处理，然后去用

```java
public class PooledDataSource implements DataSource {
    
    //连接池
    private final PoolState state = new PoolState(this);
    //持有UNpool额的DataedSource的引用
    private final UnpooledDataSource dataSource;

    // OPTIONAL CONFIGURATION FIELDS
    //活跃连接池的连接上限
    protected int poolMaximumActiveConnections = 10;
    //空闲连接池的连接上限
    protected int poolMaximumIdleConnections = 5;
    
    @Override
    public Connection getConnection() throws SQLException {
   		 return popConnection(dataSource.getUsername(), dataSource.getPassword()).getProxyConnection();
    }
    
    private PooledConnection popConnection(String username, String password) throws SQLException {
    boolean countedWait = false;
    PooledConnection conn = null;
    long t = System.currentTimeMillis();
    int localBadConnectionCount = 0;

    while (conn == null) {
        //这是一个线程安全的，不会出现两个线程同时拿到同一个连接的情况
      synchronized (state) {
          //如果还有空闲的连接
        if (!state.idleConnections.isEmpty()) {
          // Pool has available connection
            //拿出休息的最久的连接，也就是拿出最先进入连接池的
          conn = state.idleConnections.remove(0);
          if (log.isDebugEnabled()) {
            log.debug("Checked out connection " + conn.getRealHashCode() + " from pool.");
          }
        } else {
          // Pool does not have available connection
            //如果没有空闲的连接，但是活跃连接池的连接数没有达到上限
          if (state.activeConnections.size() < poolMaximumActiveConnections) {
            // Can create new connection
              //就是用unpooledDataSource创健一个连接
            conn = new PooledConnection(dataSource.getConnection(), this);
            if (log.isDebugEnabled()) {
              log.debug("Created connection " + conn.getRealHashCode() + ".");
            }
          } else {
              //将最老的活跃连接连接经过特殊处理，再拿去用
              PooledConnection oldestActiveConnection = state.activeConnections.get(0);
          }
        }
      }
}
```



​		

## mybatis的事务管理



​			mybatis每次从UnpooledDataSource创建连接的时候，都会调用connection.setAutoCommit(false)，将自动提交事务关闭，所以每次增删改之后，都需要使用sqlSession.commit()，来进行事务的提交，其实也就是connection.commit()，那当然，mybatis其实也提供了，自动提交事务的方法，只要在获取sqlSession的时候，将openSession方法传入参数true就行了

```java
//自动提交事务
@Override
  public SqlSession openSession(boolean autoCommit) {
    return openSessionFromDataSource(configuration.getDefaultExecutorType(), null, autoCommit);
  }

//关闭连接
public class JdbcTransaction implements Transaction {
     @Override
  	 public void commit() throws SQLException {
      	if (connection != null && !connection.getAutoCommit()) {
      		if (log.isDebugEnabled()) {
       			 log.debug("Committing JDBC Connection [" + connection + "]");
     		 }
     		 connection.commit();
    	}
 	  }
}

//关闭自动提交事务
public class UnpooledDataSource implements DataSource {
    private void configureConnection(Connection conn) throws SQLException {
        if (autoCommit != null && autoCommit != conn.getAutoCommit()) {
          conn.setAutoCommit(autoCommit);
        }
        if (defaultTransactionIsolationLevel != null) {
          conn.setTransactionIsolation(defaultTransactionIsolationLevel);
        }
      }
}
```





## mybatis的动态SQL语句



​		前面我们仅仅只是做了一些简单的查询，有些时候可能遇到各种条件都要满足的时候的查询，这个时候就需要运用mybatis提供的特殊标签了

1. if标签

   ​	我们根据实体类的不同取值，使用不同的 SQL 语句来进行查询。比如在 id 如果不为空时可以根据 id 查询，如果 username 不同空时还要加入用户名作为条件。这种情况在我们的多条件组合查询中经常会碰到

```java
//接口
List<User> selectUsersByIf(User user);
```

​		映射配置文件

```xml
<select id="selectUsersByIf" resultType="user" parameterType="user">
    <!--where 1=1并不是没有作用的，当下面的if条件不满足时，where后面就没有语句，造成语句错误，所以where 1=1的作用是更好的连接sql语句-->
    select * from user where 1=1
        <!--不能用&&连接条件，test属性表示判断条件，条件中写的是方法传入参数的属性名-->
        <if test="username != null and username != ''">
            and username like #{username}
        </if>
        <if test="address != null and address != ''">
            and address like #{address}
        </if>
</select>
```



2. where标签

   ​		为了简化where 1=1 的条件拼装，可以采用where标签来简化开发

   ```xml
   <select id="selectUsersByIf" resultMap="userMap" parameterType="user">
           select * from user
           <where >
               <!--不能用&&连接条件，test条件中写的是方法传入参数的属性名-->
               <if test="username != null and username != ''">
                    u.username like #{username}
               </if>
               <if test="address != null and address != ''">
                    u.address like #{address}
               </if>
           </where>
       </select>
   ```



3. froeach标签

   ​	有些时候我们可能会在一个范围类查询，比如说在id为41,45,50中是否有对应的用户，那么变成SQL语句就是

   ```sql
   select * from user where username like ('%余%') id in(41,45,50)
   ```

   在user下创建一个id的集合类型，并且提供get/set方法

   ```java
    List<Integer> ids;
   
       public List<Integer> getIds() {
           return ids;
       }
   
       public void setIds(List<Integer> ids) {
           this.ids = ids;
       }
   ```

   

   所以在mybatis的映射文件中就是

   ```xml
   <select id="selectUsersByIds" parameterType="user" resultType="user">
           select * from user
           <where>
               <!--判断ids是否有数据-->
               <if test="ids != null and ids.size() > 0">
                   <!--collection表示数据源，也就是遍历的集合，open表示连接的sql语句的开始，close表示连接的sql语句的结				束，separator表示分隔符，item就表示遍历的每个数据，相当于for(Integer id : ids)中的id，所以下方的					#{里面的字符和item相同}-->
                   <foreach collection="ids" open="and id in(" close=")" separator="," item="id">
                       #{id}
                   </foreach>
               </if>
           </where>
       </select>
   ```



4. sql标签

   ​	这个标签可以将重复的sql语句提取出来，然后在标签中用include标签饮用即可

   ```xml
   <sql id="mysql">
   	select * from user
   </sql>
   
   <select id="finAll" resultType="user">
       <!--引用sql语句-->
   	<include refid="mysql"></include>
   </select>
   ```

   

## mybatis的多表查询



### 1. 一对一查询

​		其实一对一查询有时候也可以看成多对一的查询，比如说一个用户可以拥有多个订单，多个订单可以拥有一个用户，但是呢，就那一个订单出来的话，和用户的关系也就是一对一的关系

​		首先，第一件事就是建立数据库表，用户和账户的关系是一对多，那么账户表就是从表，用户表就是主表，从表有着一个来自主表的外键约束

```sql
create table `account`(
	id int primary key auto_increment,
    uid int,
    money double,
    foreign key (uid) references user (id) #外键约束
)

INSERT  INTO `account`(`id`,`UID`,`MONEY`) VALUES (1,46,1000),(2,45,1000),(3,46,2000)

```

​		建立实体类

```java
package com.dajiao.domain;

/**
 * @program: study-mybatis-createMybatis
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-27 21:49
 **/
public class Account {

    private Integer id;
    private Integer uid;
    private Double money;

 	get/set/tostring....
}

```

​		创建接口

```xml
package com.dajiao.dao;

import com.dajiao.domain.Account;
import com.dajiao.domain.AccountUser;

import java.util.List;

public interface AccountDao {

	//利用继承的方式一对一查询
    List<AccountUser> selectAccounts();
	//利用resultMap的方式查询
    List<Account> findAll();
}
```

​		然后呢，就是怎样查询每个订单和订单所拥有的的用户了，第一件事就是sql语句的编写了，这里呢只查询了用户的姓名和地址，目的是为了运用继承的方式去实现sql语句的查询

```sql
select a.*,u.username,u.address from account a, user u where a.uid=u.id
```

​		建立AccountUser类，继承于Account类，并新增两个String属性

```java
package com.dajiao.domain;

import com.dajiao.dao.AccountDao;

/**
 * @program: study-mybatis-createMybatis
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-27 21:59
 **/
public class AccountUser extends Account {

    private String username;
    private String address;
}

```

​		然后就是编写AccountDao的mapper映射文件了

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.com.dajiao.dao.AccountDao">
    <!--利用继承account类的方式实现一对一查询-->
    <select id="selectAccounts" resultType="accountUser">
        select a.*,u.username,u.address from account a, user u where a.uid=u.id
    </select>
</mapper>
```

```java
//测试类
@Test
    public void testAll(){
        List<AccountUser> accountUsers = accountDao.selectAccounts();
        for (AccountUser accountUser : accountUsers) {
            System.out.println(accountUser);
        }
    }
```

​		这样呢就巧妙的实现类一对一的查询了，当然如果每次一对一都要用继承的方式来做的话，效率太低，所以可以使用mybatis的resultMap标签来查询

​		当然了，首先是要在Account类中定义一个user类的属性，这样才能查到Account对应的user

```java
 private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
```

​		然后就是sql语句的编写了

```sql
select a.id aid, a.uid, a.money,u.* from account a, user u where a.uid=u.id
```

​		此时需要注意一个问题，由于account和user都有一个id属性，如果不使用别名将其中一个id变为其他，那么在进行数据封装的时候，两个id混乱，比如说将Account的id封装到了user里面，所以此时最好起一个别名，下面就是mapper映射文件的配置了

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.dajiao.dao.AccountDao">
    <resultMap id="accountMap" type="account">
        <!--注意数据库中起了别名，column属性必须使用别名，不然白起别名了-->
        <id property="id" column="aid"></id>
        <result property="uid" column="uid"></result>
        <result property="money" column="money"></result>
        <!--association标签用于指定从表方的引用主表方的实体类属性的，javaType表示java的类型property表示属性名-->
        <association property="user" javaType="user">
            <!--主表的属性和数据库列名-->
            <id property="id" column="id"></id>
            <result property="username" column="username"></result>
            <result property="sex" column="sex"></result>
            <result property="birthday" column="birthday"></result>
            <result property="address" column="address"></result>
        </association>
    </resultMap>
    <!--利用继承account类的方式实现一对一查询-->
    <select id="selectAccounts" resultType="accountUser">
        SELECT a.id aid,a.uid,a.money,u.username,u.address FROM `account` a,`user` u WHERE a.uid=u.id
    </select>

    <select id="findAll" resultMap="accountMap">
        SELECT a.id aid,a.uid,a.money,u.* FROM `account` a,`user` u WHERE a.uid=u.id
    </select>
</mapper>
```



### 2. 一对多查询



​			经过了上面的一对一查询，相信已经对多对一查询有了思路，只要在主表的实体类中封装一个从表的集合就行了

```java
private List<Account> accounts;

public List<Account> getAccounts() {
    return accounts;
 }

public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
}
```

​			sql语句，这时呢，我们要查的是一个用户和对应的所有账户，那么这时候就需要将所有的用户都查出来，不管有没有账户，那就需要用到左外连接或者是右外连接了

```sql
select u.*,a.id aid,a.uid,a.money from account a
right outer join user u
on u.id=a.uid
```

​			然后就是mapper映射文件了

```xml
<mapper namespace="com.dajiao.dao.UserDao">

    <resultMap id="userMap" type="user">
        <id property="id" column="id"></id>
        <result property="username" column="username"></result>
        <result property="address" column="address"></result>
        <result property="sex" column="sex"></result>
        <result property="birthday" column="birthday"></result>
        <!--collection属性表示一对多，从表实体类集合，ofType表示集合的泛型类型-->
        <collection property="accounts" ofType="account">
            <!--配置从表的属性和数据库列名，注意起了别名需要写上别名-->
            <id property="id" column="aid"></id>
            <result property="uid" column="uid"></result>
            <result property="money" column="money"></result>
        </collection>
    </resultMap>

    <select id="selectUsers" resultMap="userMap">
        SELECT a.id aid,a.uid,a.money,u.* FROM `account` a
        RIGHT OUTER JOIN `user` u ON a.uid=u.id
    </select>
</mapper>
```



### 3. 多对多查询

​		

​			那么多对多的查询在mybatis其实已经不是难题了，跟上面的一对多是差不多的，因为多对多细致的讲其实可以说成一对多，但是在mybatis查询多对多不难，就是建表的过程需要慎重

​			首先，要想实现多对多那么就需要建立一个中间表，例如用户和角色的关系就是一个多对多的关系，我们可以在王者峡谷里面使用各种英雄，各种英雄也不是一个人的专属，用对应着许多用户，这就是多对多的关系了，那么中间表呢就同时有着来自这两个表中的外键约束，首先，我们可以建立角色表

```sql
create table role(
	id int primary key auto_increment,
    role_name varchar(20),
    role_desc varchar(100)
)

INSERT  INTO `role`(`ID`,`ROLE_NAME`,`ROLE_DESC`) 
VALUES (1,'院长','管理整个学院'),(2,'总裁','管理整个公司'),(3,'校长','管理整个学校');
```

​		然后建立中间表

```sql
create table user_role(
	rid int,
    uid int,
    primary key(rid,uid),
    foreign key rid references role (id)
    foreign key uid feferences user (id)
)

INSERT  INTO `user_role`(`UID`,`RID`) VALUES (41,1),(45,1),(41,2);
```

​		在之后就是怎么查询了，我们可以查出角色表和中间表对应的用户表，然后使用左外连接获取所有的角色

```sql
SELECT u.*,r.id rid,r.role_name,r.role_desc FROM `role` r
LEFT OUTER JOIN user_role ur
ON r.id=ur.rid
LEFT OUTER JOIN `user` u
ON ur.uid=u.id
```

​	然后建立角色的实体类

```java
public class Role {

    private Integer id;
    private String roleName;
    private String roleDesc;

    List<User> users;
    
    get/set/toString.....
}
```

​		然后就是mapper映射文件

```xml
<mapper namespace="com.dajiao.dao.RoleDao">

    <resultMap id="roleMap" type="role">
        <id property="id" column="rid"></id>
        <result property="roleName" column="role_name"></result>
        <result property="roleDesc" column="role_desc"></result>
        <collection property="users" ofType="user">
            <id property="id" column="id"></id>
            <result property="username" column="username"></result>
            <result property="address" column="address"></result>
            <result property="sex" column="sex"></result>
            <result property="birthday" column="birthday"></result>
        </collection>
    </resultMap>

    <select id="findAll" resultMap="roleMap">
        SELECT u.*,r.id rid,r.role_name,r.role_desc FROM `role` r
        LEFT OUTER JOIN user_role ur
        ON r.id=ur.rid
        LEFT OUTER JOIN `user` u
        ON ur.uid=u.id
    </select>

</mapper>
```



​			其实查询用户所对应的角色也是差不多的做法，就不再编写了



## mybatis的延迟加载



​				延迟加载：就是需要数据的时候才加载，不需要用到数据的时候就不进行加载。延迟加载也称为懒加载（lazyLoading），这样做的好处是先查询单表，如果有需要的话再去关联表进行关联查询，这样就能大大提高数据库的性能，因为查询单表要比查询多表的效率快得多。

​				那什么时候需要用到延迟加载呢：当查询一对多的时候，这个时候可以使用延迟加载，比如说，我们要查询用户信息，用户又包含着多个账户，那么我们可以先查询用户信息，如果有需要的话再去查询账户信息

​			在一对多的查询中，查询的结果是：

```java
Opening JDBC Connection
Created connection 1976870338.
Setting autocommit to false on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@75d4a5c2]
==>  Preparing: select * from user 
==> Parameters: 
<==    Columns: id, username, birthday, sex, address
<==        Row: 41, hello，myWorld, 2021-01-29 04:01:20, 男, null
====>  Preparing: select * from role where id in (select rid from user_role where uid=?) 
====> Parameters: 41(Integer)
<====    Columns: id, role_name, role_desc
<====        Row: 1, 院长, 管理整个学院
<====        Row: 2, 总裁, 管理整个公司
<====      Total: 2
    ......
```

​		可以看到，我们是把用户信息和账户信息同时查询出来的

​		想要开启延迟加载，首先需要在主配置文件SqlMapConfig.xml文件中设置settings属性

```xml
 <!--延迟加载的全局开关。当开启时，所有关联对象都会延迟加载。 
	特定关联关系中可通过设置 fetchType 属性来覆盖该项的开关状态。
-->
<setting name="lazyLoadingEnabled" value="true" />
<!--开启时，任一方法的调用都会加载该对象的所有延迟加载属性。
 	否则，每个延迟加载属性会按需加载,默认是false,可以不写
-->
<setting name="aggressiveLazyLoading" value="false"/>
```

​	

```java
//Account类
/**
 * @program: study-mybatis-createMybatis
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-28 21:49
 **/
private Integer id;
    private Integer uid;
    private Double money;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

	get/set/toString
}

//AccountDao接口
public interface AccountDao {
    List<Account> findAll();
}

//User类
public class User {

    private Integer id;
    private String username;
    private String address;
    private Date birthday;
    private String sex;
    ...
}
```



​		这个时候就不能再用左外连接去同时查询双表了，因为我们不想同时查询两张表，所以需要在我们的映射mapper文件中修改

```xml
<mapper namespace="com.dajiao.dao.UserDao">

    <resultMap id="userMap" type="user">
        <id property="id" column="id"></id>
        <result property="username" column="username"></result>
        <result property="address" column="address"></result>
        <result property="sex" column="sex"></result>
        <result property="birthday" column="birthday"></result>
        <!--select属性表示想要查询的关联对象的接口中的方法，ofType表示关联属性的类型，property表示关联属性名
			column属性表示用当前实体类的什么属性去查询关联属性	
		-->
        <collection property="accounts" ofType="account" column="id"                                                             select="com.dajiao.dao.AccountDao.findAccountByUid"></collection>             
    </resultMap>

    <select id="selectUsers" resultMap="userMap">
        SELECT * FROM user
    </select>

    <select id="findUserById" parameterType="int" resultType="user" >
        select * from user where id=#{id}
    </select>

</mapper>
```

​			

​		然后就是accountDao接口的配置文件修改

```xml
<!--添加select属性指定的方法，这个时候可以不在accountDao接口中编写此方法，因为不需要代理对象去获取全限定方法名称-->  
<select id="findAccountByUid" resultType="account" parameterType="int">
    select * from account where uid=#{id}
</select>
```

​	*  测试类

```java
@Test
    public void select(){
        List<User> users = userDao.selectUsers();
        for (User user : users) {
            System.out.println("-----------用户信息----------");
            System.out.println("用户：" + user);
            for (Account account : user.getAccounts()) {
                System.out.println("账户：" + account);
            }
        }
    }
```



​		测试结果：

```java
==>  Preparing: SELECT * FROM user 
==> Parameters: 
<==    Columns: id, username, birthday, sex, address
    .......
<==      Total: 16
-----------用户信息----------
==>  Preparing: select * from account where uid=? 
==> Parameters: 41(Integer)
<==      Total: 0
用户：User{id=41, username='hello，myWorld', address='null', birthday=Fri Jan 29 12:01:20 CST 2021, sex='男'}
-----------用户信息----------
==>  Preparing: select * from account where uid=? 
==> Parameters: 42(Integer)
<==      Total: 0
用户：User{id=42, username='小二王', address='北京金燕龙', birthday=Mon Jan 01 08:00:00 CST 2018, sex='女'}
-----------用户信息----------
```

​		可以看到，当我们执行输出方法时结果才会去现查询，不会在一开始就查询，当我们把输出的语句注释后，查询结果是：

```java
==>  Preparing: SELECT * FROM user 
==> Parameters: 
<==    Columns: id, username, birthday, sex, address
...
<==      Total: 16
Resetting autocommit to true on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@7817fd62]
Closing JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@7817fd62]
```

​		只会查询user类的数据，而不会查询关联数据accounts



## mybatis的缓存



​			缓存：缓存就是存在于内存中的临时数据

​			使用缓存的好处是减少和数据库交互的次数，提高执行的效率，但缓存也是有针对性的，对于不经常修改的数据且数据的正确性和结果关联性不大的，就适用于缓存，那么经常改变的数据和数据和结果关联性特别大的，不适用于缓存

​			

### 1. mybatis中的一级缓存

​			mybatis 的一级缓存，指的是SqlSession对象中的缓存，当我们查询到了结果后，查询的结果会存入一个sqlSession为我们提供的一个区域中，这个区域是Map集合，当我们想要再次拿出来用的时候，mybatis会在SqlSession中查询，有的话直接拿出来用

```java
public class DefaultSqlSession implements SqlSession {
    
    //查询的时候进行一些列操作
	@Override
  public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
    try {
      	  MappedStatement ms = configuration.getMappedStatement(statement);
        //跳转到BaseExeCutor类
    	  return executor.query(ms, wrapCollection(parameter), rowBounds, Executor.NO_RESULT_HANDLER);
    } catch (Exception e) {
     		 throw ExceptionFactory.wrapException("Error querying database.  Cause: " + e, e);
    } 	 finally {
     		 ErrorContext.instance().reset();
   		 }
    }
    
    
        @Override
      public void commit() {
        commit(false);
      }

    //sqlsession的commit方法
      @Override
      public void commit(boolean force) {
        try {
          executor.commit(isCommitOrRollbackRequired(force));
          dirty = false;
        } catch (Exception e) {
          throw ExceptionFactory.wrapException("Error committing transaction.  Cause: " + e, e);
        } finally {
          ErrorContext.instance().reset();
        }
      }
    
    //SqlSession的清理缓存方法
	@Override
 	public void clearCache() {
 	   executor.clearLocalCache();
    }
}

public abstract class BaseExecutor implements Executor {
    
    //缓存属性
	protected PerpetualCache localCache;
  	protected PerpetualCache localOutputParameterCache;
    
    //查询方法执行
    @Override
  public <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler) throws SQLException {
      BoundSql boundSql = ms.getBoundSql(parameter);
      //存储临时数据
      CacheKey key = createCacheKey(ms, parameter, rowBounds, boundSql);
      return query(ms, parameter, rowBounds, resultHandler, key, boundSql);
  }

    //关闭sqlsession的方法
    @Override
  public void commit(boolean required) throws SQLException {
    if (closed) {
      throw new ExecutorException("Cannot commit, transaction is already closed");
    }
      //清理缓存
      clearLocalCache();
      flushStatements();
      if (required) {
        transaction.commit();
      }
   }
    
    //清理缓存
    @Override
  	public void clearLocalCache() {
    if (!closed) {
      localCache.clear();
      localOutputParameterCache.clear();
    }
  }
}

//缓存类
public class PerpetualCache implements Cache {

 	 private final String id;
	//缓存实现类型Map集合
 	 private Map<Object, Object> cache = new HashMap<>();
	
    //清理缓存
    @Override
 	public void clear() {
  	  cache.clear();
 	}
}
```



​		可以测试一下查询一个user数据的时候

```java
SqlSession sqlSession;
    InputStream in;
    UserDao userDao;
    SqlSessionFactory factory;

    @Before//表示在测试方法执行之前执行
    public void init() throws IOException {

        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    @After//在测试方法执行之后执行
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void select(){
        sqlSession = factory.openSession();
        //获取代理对象
        userDao = sqlSession.getMapper(UserDao.class);
        //查询41号用户
        User user = userDao.selectUser(41);
        //没有实现toString方法，输出地址
        System.out.println("我是user-------"+user);
        //继续查询41号用户
        User user1 = userDao.selectUser(41);
        ystem.out.println("我是user1------"+user1);
         //判断变量是否是一个地址
        System.out.println(user==user1?"我们指的是一个对象":"我们指的不是一个对象");
      
    }
```

测试结果：

```java
Created connection 565881091.
Setting autocommit to false on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@21baa903]
    //只查询一次
==>  Preparing: SELECT * FROM user where id=? 
==> Parameters: 41(Integer)
<==    Columns: id, username, birthday, sex, address
<==        Row: 41, hello，myWorld, 2021-01-29 04:01:20, 男, null
<==      Total: 1
我是user-------com.dajiao.domain.User@2b95e48b
Cache Hit Ratio [com.dajiao.dao.UserDao]: 0.0
我是user1------com.dajiao.domain.User@2b95e48b
我们指的是一个对象
Resetting autocommit to true on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@21baa903]
```

​		

​		上面的源码已经给出sqlSession的实现类DefaultSession有一个clearCache方法可以清理缓存，所以这里依然可以测试一下

```java
@Test
    public void testClearCache(){

        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.selectUser(41);
        System.out.println("我是user-------"+user);

        //清理缓存
        sqlSession.clearCache();

        userDao = sqlSession.getMapper(UserDao.class);
        User user1 = userDao.selectUser(41);
        System.out.println("我是user1-------"+user1);
        System.out.println(user==user1?"我们指的是一个对象":"我们指的不是一个对象");
    }
```

测试结果：

```java
Opening JDBC Connection
Created connection 1101184763.
Setting autocommit to false on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@41a2befb]
    //查询第一次*/*/
==>  Preparing: SELECT * FROM user where id=? 
==> Parameters: 41(Integer)
<==    Columns: id, username, birthday, sex, address
<==        Row: 41, hello，myWorld, 2021-01-29 04:01:20, 男, null
<==      Total: 1
我是user-------com.dajiao.domain.User@21b2e768
Cache Hit Ratio [com.dajiao.dao.UserDao]: 0.0
    //查询第二次/*/*
==>  Preparing: SELECT * FROM user where id=? 
==> Parameters: 41(Integer)
<==    Columns: id, username, birthday, sex, address
<==        Row: 41, hello，myWorld, 2021-01-29 04:01:20, 男, null
<==      Total: 1
我是user1-------com.dajiao.domain.User@5609159b
我们指的不是一个对象
Resetting autocommit to true on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@41a2befb]

```



当我们关闭sqlsession（commit），执行update，insert，delete方法时，都会清理缓存.......



### 2. mybatis的二级缓存



​		二级缓存是 mapper 映射级别的缓存，多个 SqlSession 去操作同一个 Mapper 映射的 sql 语句，多个

SqlSession 可以共用二级缓存，二级缓存是跨 SqlSession 的。

​		想要获取二级缓存，首先需要在SqlMapConfig,xml文件配置settings

```java
<!--全局性地开启或关闭所有映射器配置文件中已配置的任何缓存。默认是true，其实可以不写-->
<setting name="cacheEnabled" value="true"/>
```

​		然后去对应的dao接口的配置文件修改配置

```xml
<mapper namespace="com.dajiao.dao.UserDao">
    <!--设置cahce标签-->
    <cache></cache>
    <!--对user 的usercache属性改为true-->
    <select id="selectUser" resultType="user" parameterType="int" useCache="true">
        SELECT * FROM user where id=#{id}
    </select>
</mapper>
```

​		测试：

```java
 @Test
    public void testCache(){

       sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.selectUser(41);
        System.out.println("我是user-------"+user);

        sqlSession.close();

        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
        User user1 = userDao.selectUser(41);
        System.out.println("我是user1-------"+user1);
        System.out.println(user==user1?"我们指的是一个对象":"我们指的不是一个对象");
    }
```

结果：

```java
Opening JDBC Connection
Created connection 1101184763.
Setting autocommit to false on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@41a2befb]
==>  Preparing: SELECT * FROM user where id=? 
==> Parameters: 41(Integer)
<==    Columns: id, username, birthday, sex, address
<==        Row: 41, hello，myWorld, 2021-01-29 04:01:20, 男, null
<==      Total: 1
我是user-------com.dajiao.domain.User@21b2e768
Resetting autocommit to true on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@41a2befb]
Closing JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@41a2befb]
Returned connection 1101184763 to pool.
Cache Hit Ratio [com.dajiao.dao.UserDao]: 0.5
我是user1-------com.dajiao.domain.User@5ab9e72c
我们指的不是一个对象
```

可以看到sql语句只查询一次，但是两个变量确实不相等的，这是因为，二级缓存是将user 的数据拿出来以序列化的形式去存储的，所以此时我们的实体类需要实现Serializable序列化接口，每次都会将这数据重新封装为一个新的user对象，因此两个变量指的不是同一个对象



## Mybatis的注解开发



​		这几年来注解开发越来越流行，Mybatis 也可以使用注解开发方式，这样我们就可以减少编写 Mapper 映射文件了，开发效率非常的高

​		mybatis 的常用注解说明：

```xml
@Insert:实现新增
@Update:实现更新
@Delete:实现删除
@Select:实现查询
@Result:实现结果集封装
@Results:可以与@Result 一起使用，封装多个结果集
@ResultMap:实现引用@Results 定义的封装
@One:实现一对一结果集封装
@Many:实现一对多结果集封装
@SelectProvider: 实现动态 SQL 映射
@CacheNamespace:实现注解二级缓存的使用
```



### 1. 注解实现基本的CURD

建立新的Maven工程，建立user实体类

```java
/**
 * @program: study-mybatis-createMybatis
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-29 11:39
 **/
public class User {

    private Integer id;
    private String username;
    private String address;
    private Date birthday;
    private String sex;
    
    get/set/toString...
}
```



主配置文件SqlMapConfig.xml文件的配置

```xml
<configuration>

    <settings>
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>

    <typeAliases>
        <package name="com.dajiao.domain"/>
    </typeAliases>

    <environments default="mydb">
        <environment id="mydb">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC"/>
                <property name="username" value="root"/>
                <property name="password" value="qwer"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
       <package name="com.dajiao.dao"/>
    </mappers>

</configuration>
```



dao接口的编写

```java
public interface UserDao {

    //使用select注解查询user
    @Select("select * from user")
    List<User> findAll();
    
    //使用insert注解插入user
     @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void insertUser(User user);

    //使用update注解修改user
    @Update("update user set username=#{username},sex=#{sex},address=#{address},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    //使用delete注解删除user
    @Delete("delete from user where id=#{uid}")
    void deleteUser(Integer id);

    //使用select注解查询一个
    @Select("select * from user where id=#{uid}")
    User findUserById(Integer id);

    //使用select注解模糊查询
    @Select("select * from user where username like #{username}")
//    @Select("select * from user where username like '%${value}%'")
    List<User> findUsersByName(String name);

    //使用select注解进行聚合函数
    @Select("select count(*) from user")
    int findTotal();
}
```



​			当我们使用注解开发时，使用了注解就不能配置每个接口的配置文件了，不然的话mybatis不能识别你到底是想用哪种方式进行查询，测试类还是一如既往的，获取sqlSession对象，并且获取代理对象，执行相应的方法



## 注解开发处理实体类属性和数据库列名不一致



​		实体类

```java
/**
 * @program: study-mybatis-createMybatis
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-29 12:17
 **/
public class User {

    private Integer userId;
    private String userName;
    private String userAddress;
    private String userSex;
    private String userBirthday;
    
    ....
}
```



dao接口

```java
import com.dajiao.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    
    
    @Select("select * from user")
    //id表示唯一标识，其他的方法可以使用@ResultMap注解引用此结果集
    @Results(id = "userMap",value = {
        //id指定是否是主键，默认为false，property表示属性名，column表示数据库列名
        @Result(id = true,property = "userId", column="id"),
        @Result(property = "userName", column = "username"),
        @Result(property = "userAddress", column = "address"),
        @Result(property = "userSex", column = "sex"),
        @Result(property = "userBirthday", column = "birthday")
    })
    List<User> findAll();
    
   @Select("select * from user where id=#{id}")
    @resultMap(value="userMap")
    User findUserById();
    
    @Select("select * from user where username like #{username}")
//    @Select("select * from user where username like '%${value}%'")
    @ResultMap(value = "userMap")
    List<User> findUsersByName(String name);
}
```

​	

​		其实和配置映射文件时大同小异的



### 注解开发实现多表查询



### 1. 一对一查询

​		

​		实现复杂关系映射之前我们可以在映射文件中通过配置<resultMap>来实现，在使用注解开发时我们需要借

助@Results 注解，@Result 注解，@One 注解，@Many 注解

```java
/**
 * @program: study-mybatis-createMybatis
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-29 12:38
 **/
public interface AccountDao {

    @Select("select * from account")
    //@Results注解代替了<resultMap>标签
    /*
    id表示唯一标识，就是resultMap中的id属性
    value是一个Result注解的数组类型
    id表示是否是主键，默认为false
    property表示属性名
    column表示数据库列名
    one表示一对一查询，里面添加@one注解，@one注解里面有两个属性
    	这里的column属性表示查询关联数据的数据源
        select表示<association>标签的select属性，用于指定关联表的接口的相应全限定方法名称，这个时候关联的接口内需要定义此方法
        fetchType表示是否开启延迟加载，默认是不开启，有三个值:DEFAULT（默认）,LAZY(延迟),EAGER（立即加载）
    */
    @Results(id="accountMap", value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "money",column = "money"),
            @Result(property = "user",column = "uid",one = @One(select = "com.dajiao.dao.UserDao.findUserById",fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    @Select("select * from account where uid=#{uid}")
    List<Account> findAccountsByUid(Integer uid);
}
```



```java
@Select("select * from user where id=#{uid}")
User findUserById(Integer uid);
```



​		以上就实现了注解的一对一查询



### 2. 一对多查询

​		

​			一对多查询需要使用Result注解里面的many属性，many属性定义了，@many注解，用于多对多的查询

```java
 @Select("select * from user")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "address",column = "address"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "sex",column = "sex"),
        //多对多需要延迟加载古fetchType=FetchType.LAZY，select和一对一是一样的
            @Result(property = "accounts",column = "id" ,many = @Many(select = "com.dajiao.dao.AccountDao.findAccountsByUid",fetchType = FetchType.LAZY))
    })
```

```java
/**
 * @program: study-mybatis-createMybatis
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-29 12:38
 **/
public interface AccountDao {

    @Select("select * from account where uid=#{uid}")
    List<Account> findAccountsByUid(Integer uid);
}
```



​		以上就实现了一对多的查询



### 3. 多对多查询

​	

​			其实多对多查询根一对多查询时差不太多的，不一样的部分就是sql语句的编写

那我们需要在最后一个@Result注解传入查询关联属性的数据源，也就是user 的id，我们此时不可能再去建立一个中间表的实体类，那么我们就需要先获取user的id，用user的id和中间表的uid进行双表查询，获取了若干个role的rid，这时候皆就可以利用in关键字查询user所对应的角色了，所以这里我们要用子查询

```sql
select * from role where id in (select rid from user_role where uid=#{uid})
#uid就是从userDao接口的@Result注解传来的数据源，在数据库里面是不能执行的，需要通过mybatis执行
```

```java
/**
 * @program: study-mybatis-createMybatis
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-29 13:13
 **/
public interface UserDao {
    @Select("select * from user")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "address",column = "address"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "roles",column = "id",
                    many = @Many(select = "com.dajiao.dao.RoleDao.selectRoleByUid",
                                 fetchType = FetchType.LAZY ))
    })
    List<User> findAll();
}
```

```java
public interface RoleDao {
    
    @Select("select * from role where id in (select rid from user_role where uid=#{uid})")
    @ResultMap(value = "roleMap")
    List<Role> selectRoleByUid(Integer Uid);
}

```



## mybatis注解开启二级缓存



​		在SqlMapConfig.xml主配置文件中

```xml
<settings>
<!-- 开启二级缓存的支持 --> <setting name="cacheEnabled" value="true"/>
</settings>
```



​			在持久层dao接口中

```java
@CacheNamespace(blocking=true)//mybatis 基于注解方式实现配置二级缓存
public interface IUserDao {}
```

