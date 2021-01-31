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
  * * [](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md)
    * [](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md)
    * [](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md)
    * [](https://github.com/dajiao918/Grow/blob/main/elseNote/spring.md)



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



​			依赖注入：Dependency Injection

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
    private Date date;//bean对象类型
    
    public AccountServiceImpl(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }
    
}
```



​			此时AccountServiceImpl中没有创建默认的构造器，而是提供了带参的构造器，这个时候就需要在配置文件中指定这些属性，并实例化

```xml
<bean id="accountService" class="com.dajiao.service.impl.AccountServiceImpl">
	<constructor-arg name="name" value="张三"></constructor-arg>
    <constructor-arg name="age" value="18"></constructor-arg>
    <constructor-arg name="date" ref="now"></constructor-arg>
    <!--<constructor-arg index=0 value="张三"></constructor-arg>
    <constructor-arg index=1 value="18"></constructor-arg>
    <constructor-arg index=2 ref="now"></constructor-arg>
    <constructor-arg type="java.lang.String" value="张三"></constructor-ard>
    <constructor-arg type="java.lang.Integer" value="18"></constructor-arg>
    <constructor-arg type="java.util.Date" ref="now"></constructor-arg>-->
</bean>
<bean id="now" class="java.util.Date"></bean>
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