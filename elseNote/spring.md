# spring



* [spring](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md)
  * [概述](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md#概述)
  * [降低依赖的实验](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md#降低依赖的实验)
  * [使用spring的IOC解决程序耦合](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md#使用spring的IOC解决程序耦合)
    * [IOC中bean标签和管理对象的细节](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md#IOC中bean标签和管理对象的细节)
    * [实例化Bean对象的三种方式](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md#实例化Bean对象的三种方式)
  * [spring的依赖注入](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md#spring的依赖注入)
    * [1. 构造器注入](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md#1-构造器注入)
    * [2. set方法注入](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md#2-set方法注入)
  * [spring注解开发](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md#spring注解开发)
    * [基于xml方式IOC的CRUD](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md#基于xml方式IOC的CRUD)
  * [注解方式实现案例](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md#注解方式实现案例)
    * [1. 注解的作用和细节](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md#1-注解的作用和细节)
    * [2. 在CRUD中使用注解](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md#2-在CRUD中使用注解)
      * [2.1 @Autowired注解的细节](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md#2.1-@Autowired注解的细节)
    * [3. spring新注解](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md#3-spring新注解)
  * [整合junit和spring](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md#整合junit和spring)

## 概述

​		

​			通过spring提供的ioc容器，可以将对象间的依赖关系交由spring进行控制，避免编码所造成的的过度耦合。用户也不用再为单例模式类属性文件解析类这些很底层的代码烦恼，可以更加专注于上层的开发

​			通过spring的AOP功能，方便进行面向切面的编程，许多不容易用传统OOP实现的都可以用AOP轻松应对



<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210130225510049.png" alt="image-20210130225510049" style="zoom: 67%;" />

## 降低依赖的实验



​			在学习javaWeb中，没有用到框架，只是纯粹的用javaEE的只是和JDBC知识去进行功能的开发，有操作数据库的dao层，处理前台数据的servlet，用于交互servlet和dao层的service，这三个层面息息相关，每个类都有着其它类的对象实例，用于调用其它类的方法

```java
public inteface AccountDao{
    void saveMoney();
}

public class AccountDaoImpl implements AccountDao{
    
    @Override
    public void saveMoney(){
        System.out.println("存入1000元");
    }
}
```

```java
public inteface AccountService{
    void saveMoney();
}

public class AccountServiceImpl implements AccountService{
    
    AccountDao accountDao = new AccountDaoImpl();
    
    @Override
    public void saveMoney(){
        accountDao.saveMoney();
    }
}
```

```java
public class serlvet{
    
    public static void main(String[] args) {
        
        AccountService service = new AccountServiceImpl();
        service.saveMoney();
    }
}
```



​		可以清晰的感受到，一个类关联着一个类，如果dao层的构造器想要改变，那么接下来后面的构造器也要跟着改变，这样一来，导致很难去维护，不容易增加功能或是更改需求，这就是依赖太强，每个类的独立性不高，也就是耦合性太高，那么怎么去解决这种问题呢

​		那么我们就要改变一下传统的思路了，不用new关键字去创建对象，我们使用反射的方式去创建我们要想的对象，使用反射我们要知道这个类的全限定类名，然后得到Class类，调用newInstance()方法创建对象，可以将我们想要的类路径放在一个配置文件中，然后用一个工厂类读取路径在生产我们想要的对象

```properties
accountService=com.dajiao.service.impl.AccountServiceImpl
accountDao=com.dajiao.dao.impl.AccountDaoImpl
```



```java
public class BeanFactory{
    
    //用properties类读取文件
    private static properties pros;
    
    static {
        try{
            //利用静态代码块初始化pros
            pros = new properties();
            //获取配置文件的流
            InputStream in = BeanFactory.Class.getClassLoader().getResourceAsStream("bean.properties");
            //读取配置文件
            pros.load(in);
        }catch(Exception e) {
            e.printStackTrace();
        }
    } 
    
    //根据配置的类名获取对象
    public static Object getBean(String className) {
        
        Object obj = null;
        try{
            //获取配置的全限定类名
            String className = pros.getKey(className);
            //利用反射创建对象
            Object obj = Class.forName(className).newInstance();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
    
}
```



​		用了上面的方式之后，我们就可以不再使用new关键字来创建对象了，我们将创建对象的事情交给了工厂，只关注返回地是不是我们想要的对象，当一个类进行改变之后，我们只需要更改配置文件的配置，而不再去将关联着的类一个一个的改变

```java
public inteface AccountService{
    void saveMoney();
}

public class AccountServiceImpl implements AccountService{
    
    AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");
    
    @Override
    public void saveMoney(){
        accountDao.saveMoney();
    }
}
```

```java
public class serlvet{
    
    public static void main(String[] args) {
        
        AccountService service = (AccountService) BeanFactory.getBean("accountService");
        service.saveMoney();
    }
}
```



​		这样的代码依然可以运行，但是我们可以发现，每次创建的对象都是调用反射创建的，每调用一次方法，就创建一个新的对象回来，那我们要是想要单例的对象呢，因为在开发中，单例对象往往更加高效，占用资源少，那么我们应该怎么做呢？

​		其实我们可以在静态代码块中就将对象初始化了，这样的话当类加载完之后对象也就加载出来了，那么怎么才能让我们想要对象的时候都是同一个对象呢，其实只需要一个容器装起来就行了，只要在类中定义一个静态的成员变量Map，创建一个对象就将对象加入Map中，然后想要对象的时候就从Map中取就好了

```java
public class BeanFactory{
    
    private static properties pros;
    private static Map<String,Object> map;
    
    static {
        //利用静态代码块初始化pros
        pros = new properties();
        //获取配置文件的流
        InputStream in = BeanFactory.Class.getClassLoader().getResourceAsStream("bean.properties");
        //读取配置文件
        pros.load(in);
        //初始化Map
        map = new HashMap<>();
        //获取全部的key值
        Enumeration keys = pros.keys();
        //判断是否还有
        while (keys.hasMoreElements()) {
            String element = keys.nextElement().toString();
            String classpath = pros.getProperty(element);
            Object obj = Class.forName(classpath).newInstance();
            map.put(element,obj);
        }
    }
    
    public static Object getbBean(String className ){
        return map.get(className);
    }
}
```



​		每个类都在第一时间加载了对象，每次取的对象都是一个对象，三层之间不再用new 的方式去创建彼此的对象，每个类的独立性更高，耦合性变低，我们将编译期的依赖转移到了运行期，这样就方便我们在增加类的功能时不会一改全改，因为往往开发中都是几百上千个类联合在一起，那样就不要想对类进行修改了，所以现在我们只需要对配置文件进行修改就行了，每个类不再去主动地new其它类的对象而是交给工厂去生产，这样的操作就叫控制反转(Inversion of control)，把创建对象的权利交给框架，它包括依赖注入和依赖查找。



## 使用spring的IOC解决程序耦合



​		导入依赖，用spring5以上的版本

```java
<dependency>
   <groupId>org.springframework</groupId>
   <artifactId>spring-context</artifactId>
   <version>5.0.1.RELEASE</version>
</dependency>
```

​		创建service层接口和dao层接口并实现

```java
//dao层
public inteface AccountDao{
    void saveMoney();
}

public class AccountDaoImpl implements AccountDao{
    
    @Override
    public void saveMoney(){
        System.out.println("存入1000元");
    }
}

//service层
public inteface AccountService{
    void saveMoney();
}

public class AccountServiceImpl implements AccountService{
    
    AccountDao accountDao = new AccountDaoImpl();
    
    @Override
    public void saveMoney(){
        accountDao.saveMoney();
    }
}
```



​		接下来就是对上面两个类进行文件的配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--id标签表示自定义获取对象的标识符，class标签表示想要获取的对象的类的全限定类名-->
    <bean id="accountDao" class="com.dajiao.dao.impl.AccountDaoImpl"></bean>
    <bean id="accountService" class="com.dajiao.dao.impl.AccountServiceImpl"></bean>
</beans>
```



​		使用spring的IOC获取对象

```java
public class Client{
    
    public static void main(String[] args) {
        
        //首先获取容器，利用配置文件的文件路径
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取对象
        AcountService service = (AccountService)context.getBean("accountService");
        service.saveAccount();
    }
}
```



​			ApplicationContext接口有三个常用的类，其中classPathXmlApplicationContext是利用相对路径获取配置文件，主要使用这种。FileSystemXmlApplicationContext类是利用绝对路劲获取配置文件，AnnotationConfigApplicationContext类它是用于读取注解创建容器的。

​			ApplicationContext类是的机制是立即加载对象，当将配置文件解析完之后，对象就已经被创建出来了，而BeanFactory类是延迟加载对象，只有当要用到对象的时候才会加载对象，但是BeanFactory是顶层接口，方法功能方面没有ApplicationContext类完善，所以一般使用的是ApplicationContext类



### IOC中bean标签和管理对象的细节



​			bean标签是用于配置获取对象的标签

```xml
<bean id="" class=""></bean>
其中id属性是用于获取对象的时候传入的参数
class属性填写想要获取对象的全限定类名
scope属性表示对象的作用范围
	singleton：默认值，表示获取单例对象
	protoType：多例对象
	request：web项目中，spring创建一个对象，将对象存入到request域中
	session：web项目中，spring创建一个对象，将对象存入到session域中
	global session：...
	init-method：指定类中的容器初始化后的方法
	destroy-method：指定类中容器销毁后方法名称
```

​		bean的生命周期，bean标签可以指定生产出来的对象是单例对象或者是多例对象，所以这其中对象的生命周期是不同的

|      | 单例对象                   | 多例对象                                    |
| ---- | -------------------------- | ------------------------------------------- |
| 出生 | 容器创建对象就创建         | 需要使用时才创建                            |
| 活着 | 只要容器在，对象就一直活着 | 对象在使用中，就活着                        |
| 死亡 | 容器消亡，对象消亡         | 当对象长时间不用的时候，被jvm当做垃圾清理掉 |



### 实例化Bean对象的三种方式

​			

* 第一种方式，根据默认构造器实例化对象，此时bean标签只需要传入id属性和class属性

```xml
<bean id="accountDao" class="com.dajiao.dao.impl.AccountDaoImpl"></bean>
```

​			

* 第二种方式，spring管理工厂，使用工厂创建对象

​		当我们只是想要使用一个类中的方法返回一个对象时，spring框架也为我们提供了bean标签的方式进行获取对象，不再用new的方式去获取

```java
public class BeanFactory{
    
    public AccountService getAccountService(){
        return new AccountService();
    }
}
```

​		bean标签需要使用两次

```xml
<bean id="beanfactory" class="com.dajiao.factory.BeanFactory"></bean>
<bean id="accountService" factory-method="getAccountService" fatory-bean="beanfactory"></bean>
```

​	

​	想要调用BeanFactory中的工厂类获取accountService对象，就需要先指定BeanFactory，然后再用一个bean标签指定BeanFactory的获取方法

```xml
factory-bean属性表示工厂类的id，指向了工厂类的路径
factory-mehtod属性表示获取对象的方法
id都是用以获取对象的唯一标识
```





* 第三种方式，利用工厂类的静态方法获取对象

  ​		此时就只需要知道类的全限定名称和方法名就可以了，因为静态方法只需要用类来调用

  ```java
  public class BeanFactory{
      
      public static AccountService getAccountService(){
          return new AccountService();
      }
  }
  ```

  

  ```xml
  <bean id="accountService" factory-method="getAccountService" class="com.dajiao.factory.BeanFactory"></bean>
  ```



## spring的依赖注入



```java
//dao层
public inteface AccountDao{
    void saveMoney();
}

public class AccountDaoImpl implements AccountDao{
    
    @Override
    public void saveMoney(){
        System.out.println("存入1000元");
    }
}

//service层
public inteface AccountService{
    void saveMoney();
}

public class AccountServiceImpl implements AccountService{
    
    AccountDao accountDao = new AccountDaoImpl();
    
    @Override
    public void saveMoney(){
        accountDao.saveMoney();
    }
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--id标签表示自定义获取对象的标识符，class标签表示想要获取的对象的类的全限定类名-->
    <bean id="accountDao" class="com.dajiao.dao.impl.AccountDaoImpl"></bean>
    <bean id="accountService" class="com.dajiao.dao.impl.AccountServiceImpl"></bean>
</beans>
```



```java
public class Client{
    
    public static void main(String[] args) {
        
        //首先获取容器，利用配置文件的文件路径
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取对象
        AcountService service = (AccountService)context.getBean("accountService");
        service.saveAccount();
    }
}
```

​		这个时候其实可以清晰的看到，我们在service层中的impl里面还是使用了new关键字来创建AccountDao对象，如果不进行实例化的话是不能调用器方法的，而这个时候AccountDao是AccountServiceImpl的属性，想要不使用new关键字的方法来创建AccountDao对象，这就涉及到了spring的核心：依赖注入：Dependency Injection

​			它是spring框架核心IOC的具体实现，我们在编写程序时，将创建对象的控制反转，交给spring 来创建，控制反转是一种思想，是一个能解决问题的一种可能的结果，而依赖注入是一种最典型的实现方法，由第三方来控制依赖，把他通过构造函数，属性或者工厂模式等方法，注入到类中，上方我们都是创建了一个对象，并没有什么实例化属性的情况，一般类中有属性是很常见的，所以依赖注入就是用于对类进行属性赋值操作

​		而属性可以分几种类型

* 基本类型和String类型
* bean对象类型
* 集合类型



### 1. 构造器注入

```java
public class AccountServiceImpl implements AccountService {
	
    private String name;//String类型
    private int age;//基本类型
    private AccountDao accountDao;//bean对象类型
    
    public AccountServiceImpl(String name, int age, AccountDao accountDao) {
        this.name = name;
        this.age = age;
        this.accountDao = accountDao;
    }
    
}
```



​			此时AccountServiceImpl中没有创建默认的构造器，而是提供了带参的构造器，这个时候就需要在配置文件中指定这些属性，并实例化

```xml
<bean id="accountService" class="com.dajiao.service.impl.AccountServiceImpl">
	<constructor-arg name="name" value="张三"></constructor-arg>
    <constructor-arg name="age" value="18"></constructor-arg>
    <constructor-arg name="accountDao" ref="accountDao"></constructor-arg>
    <!--<constructor-arg index=0 value="张三"></constructor-arg>
    <constructor-arg index=1 value="18"></constructor-arg>
    <constructor-arg index=2 ref="accountDao"></constructor-arg>
    <constructor-arg type="java.lang.String" value="张三"></constructor-ard>
    <constructor-arg type="java.lang.Integer" value="18"></constructor-arg>
    <constructor-arg type="com.dajiao.dao.impl.AccountDaoImpl" ref="now"></constructor-arg>-->
</bean>
<bean id="now" class="com.dajiao.dao.impl.AccountDaoImpl"></bean>
```



```xml
constructor-arg标签用于配置构造器中的参数
	其中有三个属性可以表示构造器的参数
		name：直接指定参数名表示参数来进行赋值，如上
		index：指定参数的位置表示参数来进行赋值，从0开始，如上
		type：指定参数的类型表示参数来进行赋值，如上
	---------------
		value：对基本类型和String参数进行赋值，如上
		ref：对bean对象的参数进行赋值，引用其他bean标签的id属性，进行赋值，如上
```



  			运用以上的方式之后就不用再使用new关键字了，spring框架直接帮我们创建了对象，并且依赖注入，每个属性直接被赋值，不需要我们关心，我们只需要关心如何使用即可

------



### 2. set方法注入

```java
public class AccountServiceImpl implements AccountService {
	
    private String name;//String类型
    private int age;//基本类型
    private Date date;//bean对象类型
 	
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age=age;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
}
```

```xml
<bean id="accountService" class="com.dajiao.service.impl.AccountServiceImpl">
	<property name="name" value="战三"></property>
    <property name="age" value="84"></property>
    <property name="date" ref="now"></property>
</bean>
<bean id="now" class="java.util.Date"></bean>
```

​			其中name属性用于指定set方发set后面的字符串，第一个字母小写



* 注入集合属性

```java
public class AccountServiceImpl implements AccountService {

    private String[] strings;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties pro;

        public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setPro(Properties pro) {
        this.pro = pro;
    }
}
```



```xml
<bean id="accountService" class="com.dajiao.service.impl.AccountServiceImpl">
	<property name="strings">
    	<list>
        	<value>AAA</value>
            <value>BBB</value>
            <value>CCC</value>
        </list>
    </property>
    <properoty name="set">
        <list>
        	<value>AAA</value>
            <value>BBB</value>
            <value>CCC</value>
        </list>
    </properoty>
    <properoty name="list">
        <list>
        	<value>AAA</value>
            <value>BBB</value>
            <value>CCC</value>
        </list>
    </properoty>
    <properoty name="map">
        <map>
        	<entry key="aa" value="AA"></entry>
            <entry key="bb">
            	<value>BB</value>
            </entry>
        </map>
    </properoty>
</bean>    
```

​		其中list，array，set类型的注入可以混合使用标签，map和properties可以混合使用标签



## spring注解开发



​			spring中也提供了直接开发模式，xml的IOC和注解的IOC都是为了降低程序的耦合，但两种方法都是需要掌握的

​			首先，我们先用xml的IOC做一个数据库CRUD小案例，先建立库和表



### 基于xml方式IOC的CRUD

```sql
#创建库
create database spring;
#使用库
use spring
#创建表
create table account(
	id int primary key auto_increment,
    name varchar(20) unique,
    money double
)
#插入数据
insert into account (name,money) values('alan',100),('bob',200),('cici',300)
```



在Maven工程中导入spring,mysql驱动,dbutils，c3p0，junit依赖

```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.0.1.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.21</version>
        </dependency>

        <dependency>
            <groupId>commons-dbutils</groupId>
            <artifactId>commons-dbutils</artifactId>
            <version>1.4</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>com.mchange</groupId>
            <artifactId>c3p0</artifactId>
            <version>0.9.2</version>
        </dependency>
</dependencies>
```





创建实体类

```java
package com.dajiao.domain;

/**
 * @author: Mr.Yu
 * @create: 2021-01-31 20:31
 **/
public class Account {

    private Integer id;
    private String name;
    private Double money;
	
    get/set/tostring
}
```



创建持久层接口

```java
public interface AccountDao {

    //获取全部账户信息
    List<Account> findAccounts();

    //插入账户信息
    int insertAccount(Account account);

    //修改账户信息
    int  updateAccount(Account account);

    //删除账户信息
    int deleteAccount(Integer id);

    //获取一个账户信息
    Account findAAccountById(Integer id);
}
```



实现持久层接口

```java
public class AccountDaoImpl implements AccountDao{

    //dbutils提供的查询类，提供了各种方法
    QueryRunner queryRunner;

    //set方法方便注入依赖
    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public List<Account> findAccounts() {
        try {
            return (List<Account>) queryRunner.query("select * from account", new BeanListHandler(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public int insertAccount(Account account) {
        try {
            int update = queryRunner.update("insert into account (name,money) values(?,?)", account.getName(),account.getMoney());
            return update;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public int updateAccount(Account account) {
        try {
            int update = queryRunner.update("update account set name=?,money=? where id = ?",
                    account.getName(),account.getMoney(),account.getId());
            return update;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public int deleteAccount(Integer id) {
        try {
            int update = queryRunner.update("delete from account where id = ?",id);
            return update;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Account findAAccountById(Integer id) {
        try {
            return queryRunner.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
```



创建业务层接口

```java
public interface AccountService {

    /**
     * 获取全部账户信息
     * @param
     * @return 返回全部账户
     * */
    List<Account> findAccounts();

    /**
     * 插入账户
     * @param account 传入账户对象
     * @return 返回影响的行数
     * */
    int insertAccount(Account account);

    /**
     * 修改账户信息
     * @param account 传入账户对象
     * @return 返回影响的行数
     * */
    int  updateAccount(Account account);

    /**
     * 删除账户信息
     * @param id 传入删除的账户id
     * @return 返回影响行数
     * */
    int deleteAccount(Integer id);

    /**
     * 根据id查询账户信息
     * @param id 传入账户的id
     * @return 返回一个账户信息
     * */
    Account findAAccountById(Integer id);
}
```



实现业务层接口

```java
public class AccountServiceImpl implements AccountService {

    //持有持久层的引用，调用其方法
    private AccountDao dao;

    //set方法方便注入依赖
    public void setDao(AccountDao dao) {
        this.dao = dao;
    }

    public List<Account> findAccounts() {
        return dao.findAccounts();
    }

    public int insertAccount(Account account) {
        return dao.insertAccount(account);
    }

    public int updateAccount(Account account) {
        return dao.updateAccount(account);
    }

    public int deleteAccount(Integer id) {
        return dao.deleteAccount(id);
    }

    public Account findAAccountById(Integer id) {
        return dao.findAAccountById(id);
    }
}

```



​			上方的类基本都持有其他类的引用，所以这时候spring的依赖注入就可以大展身手了，配置bean的xml文件，文件名为：bean.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    
    <!--配置AccountServiceImpl类，并且根据set方法依赖注入-->
    <bean id="accountService" class="com.dajiao.service.impl.AccountServiceImpl">
    	<property name="dao" ref="accountDao"></property>
    </bean>
    <bean id="accountDao" class="com.dajiao.dao.impl.AccountDaoImpl">
    	<property name="queryRunner" ref="runner"></property>
    </bean>
    
    <!--queryrunner类中没有set方法注入数据源，只有构造器方法，此对象可能会出现线程安全问题，故使用多例对象-->
    <bean id="runner" class="org.apache.commons.dbutils.QueryRunner" scope="prototype">
    	<constructor-arg name="ds" ref="datasource"></constructor-arg>
    </bean>
    
    <!--配置queryrunner类的ds数据源，使用的是c3p0数据源-->
    <bean id="datasource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="com.mysql.cj.jdbc.Driver"></proerty>
        <property name="jdbcurl" value="jdbc:mysql://localhost:3306/spring?serverTimezone=UTC"></property> 
        <property name="user" value="root"></property>
        <property name="password" value="qwer"></property>
    </bean>
      
</beans>
```



​			当bean文件配置好以后，spring已经为我们把每个类都加入到了容器之中，并且注入依赖，我们只需要获取容器，再从容器中获取bean对象进行调用就可以了，测试代码

```java
public class AccountServiceTest {

    //读取文件，获取容器
    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    //获取bean对象
    AccountService service = (AccountService) ac.getBean("accountService");


    @Test
    public void testFindAA(){
        List<Account> accounts = service.findAccounts();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
```

测试结果：

```java
Account{id=1, name='alan', money=100.0}
Account{id=2, name='bob', money=200.0}
Account{id=3, name='cici', money=900.0}
```



​		可以看到上面的代码，我们并没有运用new关键字去实例化对象，而是让spring为我们创建了对象，这样一来当我们对类的属性或者构造器进行更改时，就不会将有所关联的类全部都改，而是只需要去更改配置文件的属性就行了，大大的增加了代码的可维护性





## 注解方式实现案例

​	

### 1. 注解的作用和细节

> * @component：把当前类对象存入spring容器中value：用于指定bean对象的id，默认是当前首字母小写类名
>   * @Service：同上，可以用于业务层的类上
>   * @Repository：同上，可以用于持久层的类上
>   * @Controller：同上，可以用于表面层的类上
> * @Autowired：自动按照类型注入，但是需要spring容器中有一个唯 一对应的且类型相同的bean对象，可以用于在变量上，也可以用于方法上
> * @Qualifier：和@Autowired注解一起使用，当spring容器中有多个同类型的bean对象和@Autowired注解作用的变量匹配时，可以用@Qualifier注解的value属性指定bean对象的id，这样就可以让@Autowired注入依赖，不然@Autowired是不会知道要注入容器中同类型bean对象的哪一个
> * @Resource：可以代替@Qualifier注解，并且可以不和@Autowired一起使用，直接用@Resource的name属性指定bean对象，name属性不能省略
> * @Value：用于注入基本类型和String类型数据，@Value的value属性可用spring的EL表达式指定数据的值
> * @Scope：用于指定bean的作用范围，value属性指定范围的值
> * @PreDestroy：用于指定销毁方法
> * @PreConstruct：用于指定初始化方法



### 2. 在CRUD中使用注解

```java
//使用Repository注解将AccountDaoImpl加入容器中，id为accountDao，Repository注解一般使用于持久层
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao{

    //使用Autowired给属性queryRunner注解注入QueryRunner类型的bean对象，前提是容器中有类型相同且唯一的bean对象，此时可以不要set方法
    @Autowired
    QueryRunner queryRunner;
    
    ....
}
```

```java
//使用Service注解将AccountServiceImpl加入到容器中，id为accountService，Service注解一般使用于业务层
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao dao;
}
```



当我们为类配好了注解之后，必须指定在哪里配置了注解，让spring框架扫描，约束不是bean约束，而是context约束，文件名为annoBean.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
    
    <!--这样spring就会扫描com.dajiao下面的所有的类，此时的约束要使用context空间约束-->
    <context:component-scan base-package="com.dajiao"></context:component-scan>
	
    <!--用于我们需要容器中有数据源和queryrunner对象，所以还需要一下配置-->
    <bean id="runner" class="org.apache.commons.dbutils.QueryRunner">
        <constructor-arg name="ds" ref="datasource"></constructor-arg>
    </bean>

    <bean id="datasource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="password" value="qwer"></property>
        <property name="user" value="root"></property>
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/spring?serverTimezone=UTC"></property>
        <property name="driverClass" value="com.mysql.cj.jdbc.Driver"></property>
    </bean>
    
</beans>
```



测试类

```java
/**
 * @author: Mr.Yu
 * @create: 2021-02-01 12:41
 **/
public class TestSpring {

    //读取annoBean.xml文件，获取容器
    ApplicationContext ac = new ClassPathXmlApplicationContext("annoBean.xml");
    //获取bean对象，由于junit和spring没有整合，不能使用@AutoWired标签注入依赖
    AccountService service = (AccountService) ac.getBean("accountService");

    @Test
    public void testFindAA(){
        List<Account> accounts = service.findAccounts();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
```



测试结果：

```java
Account{id=1, name='alan', money=100.0}
Account{id=2, name='bob', money=200.0}
Account{id=3, name='cici', money=900.0}
```



#### 2.1 @Autowired注解的细节

```java
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao{
}

@Repository("accountDao2")
public class AccountDaoImpl2 implements AccountDao {
}

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao dao;
}
```

​			可以看到AccountDaoImpl类AccountDaoImpl2都实现了AccountDao类，并且都加入到了spring容器中，此时spring容器中就有两个AccountDao类型的bean对象，@Autowired就不知道要注入那个bean对象才好，当我们将AccountServiceImpl的dao属性名改为accountDao或者是accountDao2时，spring才能找到，因为此时属性名和id是相同的，当然也可以保持原有的属性名，用@Qualifier或者时@Resource注解指定id即可

```java
@Autowired
@Qualifier("accountDao")
private AccountDao dao;

//或者是
@Resource(name = "accountDao")
private AccountDao dao;
```





### 3. spring新注解

​			

​			当然在上面我们还是没有避免xml文件来指定和获取注解的位置和bean对象的容器加入，那么接下来就是将上面的配置文件改成注解方式获取

> * @Configuration：指定当前类是一个配置类，当配置类作为AnnotationConfigApplicationContext的参数时，可以不写次注解
> * @componentSan：替代<context:component-scan base-package="com.dajiao"></context:component-scan>标签，value[]属性可以指定要spring扫描的包
> * @Bean：将方法返回的bean对象加入到容器中，如果方法有参数，spring框架会去容器中找有无bean对象，找的方式跟@Autowired注解一样
> * @Import：可以导入其他的配置类，value属性指定导入配置类的字节码
> * @PropertySource：可以指定properties文件的位置，value属性用于指定文件的路径，classpath表示类路径，有包名就写包名



​			编写配置类，替代xml文件

```java
@Configuration//表示此类是一个配置类
@ComponentScan("com.dajiao")//指定spring要扫描的注解路径
public class SpringConfiguration{
    
    @Bean("runner")//将方法返回地参数加入到容器中
    public QueryRunner getQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }
    
    @Bean("dataSource")
    public DataSource getDataSource(){
        
        ComboPooledDataSource dataSource = null;
        try {
            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("qwer");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
```



​			在测试类中使用AnnotationConfigApplicationContext注解类解析配置类

```java
public class TestSpring {

    //解析配置类
    ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    AccountService service = (AccountService) ac.getBean("accountService");

    @Test
    public void testFindAA(){
        List<Account> accounts = service.findAccounts();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
```

​			当然，在一些大的项目中，可能有各种配置文件，然后将这些配置文件加入到一个总的配置文件进行解析，那么此时就可以使用Import注解

​			例如：将SpringConfiguration类中的内容抽取到别的类中

```java
public class JDBCConfig {
    @Bean("runner")
    public QueryRunner getQueryRunner( DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean("dataSource")
    public DataSource getDataSource(){
        
        ComboPooledDataSource dataSource = null;
        try {
            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("qwer");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}

```



​		此时进行运行的话肯定是要报错的，那么有三种方式可以解决这个问题

1. 更改JDBCConfig类为配置类，加@Configuration注解，然后在SpringConfiguration类中的@ComponentScan中加入JDBCConfig类的路径
2. 直接在AnnotationConfigApplicationContext类中传入JDBCConfig类 的字节码类
3. 在SpringConfiguration中使用@Import(JDBCConfig.class)，就可以进行解析了



​	在JDBCConfig类中如果出现了以下情况

```java
public class JDBCConfig {
    @Bean("runner")
    public QueryRunner getQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean("dataSource1")
    public DataSource getDataSource1(){
        
        ComboPooledDataSource dataSource = null;
        try {
            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("qwer");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
    
     @Bean("dataSource2")
    public DataSource getDataSource2(){
        
        ComboPooledDataSource dataSource = null;
        try {
            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("qwer");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}

```

此时有两个方法的参数为DataSource类型都使用@Bean注解加入到了容器中，而getQueryRunner方法的参数就是DataSource类型，这是spring框架又会找不着北，不知道给参数注入那个DataSource，那么此时和@Autowired注解是一样的，可以把参数名改为和@Bean的id一样，亦可以在参数前加@Qualifier注解指定想要的那个Bean对象

```java
@Bean("runner")
    public QueryRunner getQueryRunner(@Qualifier("dataSource2") DataSource dataSource) {
        return new QueryRunner(dataSource);
    }
```



## 整合junit和spring



​			当我们在junit中测试程序时，还是用AnnotationConfigApplicationContext类获取容器，然后在获取bean对象作为整个测试类的属性，调用方法，但是并没有使用spring的注解注入依赖，当我们这样做的话，肯定是不对的，此时会抛出一个空指针异常，这是因为junit测试的时候不会帮我们自动创建容器，想要使用注解的方式进行测试，就需要将junit和spring进行整合

1. 导入spring整合junit的坐标

```xml
<dependency>
     <groupId>org.springframework</groupId>
     <artifactId>spring-test</artifactId>
     version>5.0.1.RELEASE</version>
     <scope>test</scope>
</dependency>
```

2. 将junit原来的main方法替换成spring提供的main方法，使用@Runwith注解

```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class TestSpring {

//    ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//    AccountService service = (AccountService) ac.getBean("accountService");
//    @Qualifier("accountService")
    @Autowired
    AccountService service = null;

    @Test
    public void testFindAA(){
        List<Account> accounts = service.findAccounts();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
```

3. 告知spring的运行器，容器的创建时基于xml还是基于注解方式，并说明位置，使用@ContexeConfiguration注解指定容器的创建方式
   1. classes表示是注解方式，指定注解类所在的位置
   2. locations：指定xml文件的位置，加上classpath关键字，表示在类路径下



## spring的AOP

​			

				### 实现转账案例

​			根据用户的名字进行转出账户，实现步骤：获取转出账户的用户，获取转入账户的用户，更新装出账户的余额，更新转入账户的余额，代码实现

```java
public interface AccountDao {
    Account findAccountByName(String AccountName);
}

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao{
    
    @Autowired
    private QueryRunner queryRunner;
    
    //根据名字获取账户
    public Account findAccountByName(String AccountName) {
        try {
            List<Account> accounts = queryRunner.query("select * from account where name = ?", new BeanListHandler<Account>(Account.class), AccountName);
            //如果没有，就返回空
            if (accounts == null || accounts.size() == 0) {
                return null;
            }
            //如果有多个，抛出异常
            if (accounts.size()>1) {
                throw new RuntimeException("数据有误");
            }
            return accounts.get(0);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

public interface AccountService {
    
   /**
     * 用于账户转出金额
     * @param sourceName 转出账户的name
     * @param targetName 转入账户的name
     * @param money 转账的金额
     * @return 无
     * */
    void transferAccount(String sourceName, String targetName, double money);
}

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    
    @Resource(name = "accountDao")
    private AccountDao dao;
    
        public void transferAccount(String sourceName, String targetName, double money) {

            //获取转出钱 的账户
            Account sourceAccount = dao.findAccountByName(sourceName);
            //获取转入钱 的账户
            Account targetAccount = dao.findAccountByName(targetName);
            //转出账户的余额更新
            sourceAccount.setMoney(sourceAccount.getMoney() - money);
            //转入账户的余额更新
            targetAccount.setMoney(targetAccount.getMoney() + money);
            //更新账户
            dao.updateAccount(sourceAccount);
            dao.updateAccount(targetAccount);
    }
}

```



注入依赖：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <!--告知spring在创建容器时要扫描的包，配置所需要的标签不是在beans的约束中，而是一个名称为
    context名称空间和约束中-->
    <context:component-scan base-package="com.dajiao"></context:component-scan>

    <bean id="runner" class="org.apache.commons.dbutils.QueryRunner" >
    	<property name="ds" ref="dataSource"></property>
    </bean>

    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="com.mysql.cj.jdbc.Driver"></property>
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/spring?serverTimezone=UTC"></property>
        <property name="user" value="root"></property>
        <property name="password" value="qwer"></property>
    </bean>
</beans>
```



执行测试方法：

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class TestProxy {

    @Autowired
    AccountService service = null;
    
    @Test
    public void testTransfer(){
        service.transferAccount("bob","alan",50);
    }

}
```



上方就是一个转入账户的基本实现，但是这种执行了多次事务的代码是非常不靠谱的，当重剑有那么一句代码发生了错误，那么就会导致上方的数据库交互成功，下方的失败，这是一件很糟糕的事情，往往导致我们的执行结果牛头不对马嘴，所以这种代码必须只能有一个事务来管理，要么全部成功，要么全部失败

​		

### 事务管理

​		想要只有一个事务，必须保证是一个连接，那么这就得用到ThreadLocal类

```java
/**
 * 获取connection
 * @author: Mr.Yu
 * @create: 2021-02-02 12:45
 **/
public class DataSourceUtils {

    //连接池获取连接
    private DataSource dataSource;
	//ThreadLocal保存连接
    private ThreadLocal<Connection> threadLocal;

    //提供set方法方便注入依赖
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setThreadLocal(ThreadLocal<Connection> threadLocal) {
        this.threadLocal = threadLocal;
    }

    public Connection getConnection(){

        Connection connection = null;
        try {
            //从ThreadLocal中获取连接
            connection = threadLocal.get();
            if (connection == null) {
                //如果没有，利用dataSource数据连接池获取
                connection = dataSource.getConnection();
                //存入ThreadLocal中
                threadLocal.set(connection);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    //接触线程绑定的connection
    public void remove() {
        threadLocal.remove();
    }
}
```



​		创建事务管理工具的类

```java
public class TransManager {

    DataSourceUtils dataSourceUtils;

    public void setDataSourceUtils(DataSourceUtils dataSourceUtils) {
        this.dataSourceUtils = dataSourceUtils;
    }

    /**
     * 关闭自动提交事务
     * */
    public void closeAutoCommit() {
        try {
            dataSourceUtils.getConnection().setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 提交事务
     * */
    public void commit(){
        try {
            dataSourceUtils.getConnection().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 回滚事务
     * */
    public void rollback(){
        try {
            dataSourceUtils.getConnection().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 关闭资源
     * */
    public void close() {
        try {
            dataSourceUtils.getConnection().close();
            dataSourceUtils.remove();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
```

​			

​		修改dao层的方法，在sql语句前利用DataSourceUtils获取连接和修改业务层代码，进行事务管理

```java
public void transferAccount(String sourceName, String targetName, double money) {

        try {
            //关闭自动提交
            manager.closeAutoCommit();
            //获取转出钱 的账户
            Account sourceAccount = dao.findAccountByName(sourceName);
            //获取转入钱 的账户
            Account targetAccount = dao.findAccountByName(targetName);
            //转出账户的余额更新
            sourceAccount.setMoney(sourceAccount.getMoney() - money);
            //转入账户的余额更新
            targetAccount.setMoney(targetAccount.getMoney() + money);
//            int i = 1/0;
            //更新账户
            dao.updateAccount(sourceAccount);
            dao.updateAccount(targetAccount);
            //提交事务
            manager.commit();
        }catch (Exception e){
            //回滚事务
            manager.rollback();
            throw new RuntimeException(e);
        }finally {
            //关闭资源
            manager.close();
        }
    }
```

​			

配置bean文件注入依赖

```xml
<beans>
<context:component-scan base-package="com.dajiao"></context:component-scan>

    <!--queryrunner中不再有数据源，我们根据工具类获取连接-->
    <bean id="runner" class="org.apache.commons.dbutils.QueryRunner" ></bean>

    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="com.mysql.cj.jdbc.Driver"></property>
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/spring?serverTimezone=UTC"></property>
        <property name="user" value="root"></property>
        <property name="password" value="qwer"></property>
    </bean>

    <!--配置DataSourceUtils工具类，注入依赖-->
    <bean id="utils" class="com.dajiao.utils.DataSourceUtils">
        <property name="dataSource" ref="dataSource"></property>
        <property name="threadLocal" ref="tl"></property>
    </bean>

    <!--将ThreadLocal加入容器，方便注入依赖-->
    <bean id="tl" class="java.lang.ThreadLocal"></bean>

    <!--配置TransManager事务管理类，并注入依赖-->
    <bean id="manager" class="com.dajiao.utils.TransManager">
        <property name="dataSourceUtils" ref="utils"></property>
    </bean>
</beans>
```





​			这样就能保证上面的代码由同一个connection进行连接，同一个事务管理，这样才能一荣俱荣，一瞬俱损，就算中间 的代码处理毛病，也会进行事务的回滚，而不会造成异常上面的代码执行，下面的代码不执行，但是我们也发现了，这样的代码是在是太过于臃肿，而且这只是一个功能，在开发中有着大量功能难道都要这样去写嘛，这样的代价是在太高，但是又不得不对这些功能进行处理，所以要是有一个一劳永逸的方法就好了，那么其实java还是由这种功能的-----动态代理



### 动态代理解决事务管理

​			动态代理的特点就是在不修改源码的基础上进行方法的增强，并且可以随时根据字节码的创建而创建代理对象，当代理对象调用了其功能方法之后，就会经过InvocationHandler类的invoke方法，也就是增强方法，我们可以利用代理模式来做一个事务管理器，同一对AccountServiceImpl中的方法进行事务拦截

```java
/**
 * @author: Mr.Yu
 * @create: 2021-02-02 13:12
 **/
public class BeanFactory{
    
    
    @Resource(name = "accountService")
    AccountService service;
    
    TransManager manager;

    public void setManager(TransManager manager) {
        this.manager = manager;
    }

    public AccountService doProxy() {
        //获取动态代理对象，通过获取被代理对象的类加载器，接口，当代理对象调用相应方法时，也就调用了被代理对象的相应方法，在调用的前后可以对方法进行增强代码的添加
        return (AccountService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
            //增强方法
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object reValue = null;
                try{
                    //事务自动提交关闭
                    manager.closeAutoCommit();
                    //执行被代理类的方法
                    reValue = method.invoke(service, args);
                    //提交事务
                    manager.commit();
                }catch (Exception e){
                    System.out.println("有错误");
                    //回滚事务
                    manager.rollback();
                    e.printStackTrace();
                }finally {
                    //关闭资源
                    manager.close();
                }
                return reValue;
            }
        });
    }
}
```



配置bean文件，在bean文件的后面追加BeanFactory的配置，此时是根据工厂获取代理对象

```java
<bean id="factory" class="com.dajiao.factory.BeanFactory" >
    <property name="manager" ref="manager"></property>
</bean>
<bean id="factoryService" factory-bean="factory" factory-method="doProxy"></bean>
```



那么此时在IOC的容器中就有了两个AccountService的bean对象，一个的id是accountService，一个id是factoryService，我们在测试类中要获取的对象是代理对象，通过代理对象调用方法进行事物的拦截，测试类如下

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class TestProxy {

    //指定service对象是代理对象
    @Resource(name = "factoryService")
    AccountService service = null;

    @Test
    public void testFindAA(){
        List<Account> accounts = service.findAccounts();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testTransfer(){
        service.transferAccount("bob","alan",50);
    }

}
```

通过代理模式的事务管理，我们大大增加了代码的可读性，简洁性，减少了许多的工作量



## spring的AOP

​			

​			AOP，被称为面向切面编程，它的主要作用是将程序中重复的代码抽取出来，在需要执行的时候，利用动态代理的技术，再不改变源码的情况下，对我们的已有方法进行增强，也就是说我们可以通过配置的方式，将上面的事务管理进行成功

​		

### spring的官方术语



* Joinpoint(连接点)：通俗的将，连接点被称为方法，因为spring只支持方法类型为连接点
* PointCut(切入点)：所谓切入点就是我们进行拦截的方法
* Advice(通知)：所谓通知是拦截到PointCut要做的事情，一般分为前置通知，后置通知，最终通知，异常通知，环绕通知
* Introduction(引介)：引介是一种在不修改代码的前提下，Introduction可以在运行期为类动态地添加一些方法或Field
* Target(目标对象)：代理的目标对象（被代理对象）
* Weaving(织入)：指把增强应用到目标对象来创建新的代理对象的过程。
* Proxy(代理)：一个类被 AOP 织入增强后，就产生一个结果代理类。
* Aspect(切面)：是切入点和通知的结合



### 利用AOP添加代码



​			首先，我们创建一个service类，用于模拟账户的保存，修改，插入

```java
/**
 * @author: Mr.Yu
 * @create: 2021-02-02 21:17
 **/
public interface AccountService {

    void saveAccount();

    void insertAccount();

    void updateAccount(int i);
}

/**
 * @author: Mr.Yu
 * @create: 2021-02-02 21:19
 **/
public class AccountServiceImpl implements AccountService {
    
    public void saveAccount() {
        System.out.println("保存用户账户信息");
    }

    public void insertAccount() {
        System.out.println("插入用户信息");
    }

    public void updateAccount(int i) {
        System.out.println("修改用户信息");
    }
}
```



模拟一个日志类，将日志类方法插入到service类中的所有方法下

```java
/**
 * @author: Mr.Yu
 * @create: 2021-02-02 21:21
 **/
public class Logger {

    public void printLog(){
        System.out.println("打印日志printLog·····前置代码");
    }

    public void afterReturn(){
        System.out.println("打印日志afterReturn·····后置代码");
    }

    public void afterThrow(){
        System.out.println("打印日志afterThrow·····异常代码");
    }

    public void after(){
        System.out.println("打印日志after·····最终代码");
    }
}
```



要想在service类的方法前插入Logger的printLog方法，需要配置xml文件，命名为：bean.xml

此时需要导入依赖，用于解析切点表达式

```xml
<dependency>
     <groupId>org.aspectj</groupId>
     <artifactId>aspectjweaver</artifactId>
     <version>1.9.5</version>
</dependency>
```





```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd">

	<!--此时的约束有aop约束，context约束-->
	<!--配置AccountServiceImpl类的配置-->
    <bean id="service" class="com.dajiao.service.impl.AccountServiceImpl"></bean>
	
    <!--配置Logger类-->
    <bean id="logger" class="com.dajiao.utils.Logger"> </bean>
    
    <!--1、用aop:config标签表明开始AOP的配置
        2、使用aop:aspect标签表明配置切面
                id属性：是给切面提供一个唯一标识
                ref属性：是指定通知类bean的Id。
		3、aop:before：表示配置前置通知
			method：表示那个方法是前置通知
			pointcut：切入点表达式，用于指定对那些方法增强
				关键字：execution()
				写法：访问修饰符 返回类型 包名.包名.包名...类名.方法名(参数...)
				例如：public void com.dajiao.service.impl.AccountServiceImpl.saveAccount()
				访问修饰符可以省略，返回类型可以用通配符表示所有类型，包名可以用 *..表示包及其子包
				类可以用通配符表示包下的所有类，方法可以用通配符表示所有方法，方法参数可以用..表示所有类型参数
			所以上面的写法可以改成：*(void) *..(com.dajiao.service.impl)*(AccountServiceImpl).*(saveAccount)(..)
			但是一般都是这样的：* com.dajiao.service.impl.*.*(..)，将业务层下面的方法都变成切入点
	-->
    
        <!--配置AOP-->
    <aop:config>
    	<!--配置切面-->
        <aop:aspect id="logAdvice" ref="logger">
            <!--配置通知类型，并和所要切入的方法建立联系-->
        	<aop:before method="printLog" pointcut="execution(* com.dajiao.service.impl.*.*())"></aop:before>
        </aop:aspect>
    </aop:config>
</beans>
```



测试方法：

```java
/**
 * @author: Mr.Yu
 * @create: 2021-02-02 21:33
 **/
public class TestAop {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aopBean.xml");
        AccountService service = (AccountService) context.getBean("service");
        service.saveAccount();
        service.insertAccount();
        service.updateAccount(1);
    }
}
```



配置后置代码，异常代码，最终代码

```xml
<aop:config>-->
    <aop:aspect id="logAspect" ref="log">-->
        <!--配置前置代码，相当于关闭自动提交事务-->
         <aop:before method="printLog" pointcut="execution(* com.dajiao.service.impl.*.*())"></aop:before>
        <!--配置后置代码，相当于提交事务-->
       <aop:after-returning method="afterReturn" pointcut="execution(* com.dajiao.service.impl.*.*())"</aop:after-returning>
        <!--配置异常代码，相当于回滚事务-->
        <aop:after-throwing method="afterThrow" pointcut="execution(* com.dajiao.service.impl.*.*())"</aop:after-throwing>
        <!--配置最终代码，相当于关闭资源-->
         <aop:after method="after" pointcut="execution(* com.dajiao.service.impl.*.*())"></aop:after>
        <!--配置环绕代码，可以手动的添加自己想要添加的代码-->
         <aop:around method="aroundPrintLog" pointcut="execution(* com.dajiao.service.impl.*.*())"</aop:around>
     </aop:aspect>
</aop:config>
```



```java
public class Logger {
     
     /**
     * 环绕通知
     * 问题：
     *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
     * 分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有。
     * 解决：
     *      Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     *      该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
     *
     * spring中的环绕通知：
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){

        Object[] args = pjp.getArgs();
        Object reValue = null;
        try {
            System.out.println("around的前置代码");
            reValue = pjp.proceed(args);
            System.out.println("around后置代码");
            return reValue;
        } catch (Throwable throwable) {
            System.out.println("around异常代码");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("around追中代码");
        }
    }
}
```



这样就可以一次性的将前置，后置，异常，最终代码，经过手动编写去实现，这样又是另一种方式来实现动态代理了



### 注解实现AOP



1. 在xml文件开启注解AOP的支持和开启扫描的包

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 配置spring创建容器时要扫描的包-->
    <context:component-scan base-package="com.itheima"></context:component-scan>

    <!-- 配置spring开启注解AOP的支持 -->
    <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
</beans>
```

2. 在类上添加注解，加入到IOC容器中

```java
@Service("service")
public class AccountServiceImpl implements AccountService {
...
}

@Component("logger")
@Aspect//将Logger配置成切面类
public class Logger {

    //配置切入表达式
    @Pointcut("execution(* com.dajiao.service.impl.*.*())")
    public void pf(){}

    //配置前置代码，并加入切入表达式
//    @Before("pf()")
    public void printLog(){
        System.out.println("打印日志printLog·····前置代码");
    }

    //配置后置代码，并加入切入表达式
//    @AfterReturning("pf()")
    public void afterReturn(){
        System.out.println("打印日志afterReturn·····后置代码");
    }

    //配置异常代码，并加入切入表达式
//    @AfterThrowing("pf()")
    public void afterThrow(){
        System.out.println("打印日志afterThrow·····异常代码");
    }

    //配置最终代码，并加入切入表达式
//    @After("pf()")
    public void after(){
        System.out.println("打印日志after·····最终代码");
    }

    //配置环绕代码，并加入切入表达式
    @Around("pf()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){

        Object[] args = pjp.getArgs();
        Object reValue = null;
        try {
            System.out.println("around的前置代码");
            reValue = pjp.proceed(args);
            System.out.println("around后置代码");
            return reValue;
        } catch (Throwable throwable) {
            System.out.println("around异常代码");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("around追中代码");
        }
    }
}
```

3. 读取bean.xml文件生成service对象，调用方法即可



