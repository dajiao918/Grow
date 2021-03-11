# SSM-CRM系统



## 项目搭建

1. 创建Maven项目，勾选web骨架
2. 导入依赖

```xml
  <dependencies>

    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>compile</scope>
    </dependency>

    <!--springmvc-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.2.5.RELEASE</version>
    </dependency>

    <!--spring-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>5.2.5.RELEASE</version>
    </dependency>

    <!--mysql-->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.21</version>
    </dependency>

    <!--mybatis和spring整合-->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>1.3.1</version>
    </dependency>

    <!--mybatis-->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.1</version>
    </dependency>

    <!--jdbc和事务相关-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>5.2.5.RELEASE</version>
    </dependency>
      <!--事务相关-->
    <dependency>
      <groupId>org.aspectj</groupId>
      <artifactId>aspectjweaver</artifactId>
      <version>1.9.5</version>
    </dependency>

    <!--servlet和jsp和jstl库-->
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>jsp-api</artifactId>
      <version>2.2.1-b03</version>
    </dependency>

    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>2.5</version>
    </dependency>

    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>

    <!--json-->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.9.8</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.9.8</version>
    </dependency>

    <!--数据源-->
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.1.20</version>
    </dependency>

    <!--spring和junit整合-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>5.0.1.RELEASE</version>
    </dependency>

    <!--pagehelper分页-->
    <dependency>
      <groupId>com.github.pagehelper</groupId>
      <artifactId>pagehelper</artifactId>
      <version>5.1.10</version>
    </dependency>

    <!--mybatis逆向工程-->
    <dependency>
      <groupId>org.mybatis.generator</groupId>
      <artifactId>mybatis-generator-core</artifactId>
      <version>1.3.5</version>
    </dependency>

    <!--日志相关-->
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>1.7.25</version>
    </dependency>
    <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-classic</artifactId>
      <version>1.2.3</version>
    </dependency>
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>jcl-over-slf4j</artifactId>
      <version>1.7.25</version>
    </dependency>

  </dependencies>

  <build>
	<plugins>

        <!--逆向工程插件-->
        <plugin>
          <groupId>org.mybatis.generator</groupId>
          <artifactId>mybatis-generator-maven-plugin</artifactId>
          <version>1.3.7</version>
          <dependencies>
            <dependency>
              <groupId>mysql</groupId>
              <artifactId>mysql-connector-java</artifactId>
              <version>8.0.21</version>
            </dependency>
          </dependencies>
        </plugin>
        
        
     </plugins>
  </build>
```

3. 创建包

   1. com.dajiao.crm.workbench.dao&service&controller
   2. com.dajiao.crm.util
   3. com.dajiao.crm.exception
   4. com.dajiao.crm.exceptionHandler
   5. com.dajiao.crm.inteceptor

4. 创建mybatis逆向工程

   1. 在资源目录resources下创建gengeratorConfig.xml文件，生成接口，实体类，以及mapper文件

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE generatorConfiguration
           PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
           "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
   
   <generatorConfiguration>
       <context id="MySQLTables" targetRuntime="MyBatis3">
   
           <!-- 抑制注释生成 -->
           <commentGenerator>
               <property name="suppressAllComments" value="true"/>
           </commentGenerator>
   
           <!-- mvn mybatis-generator:generate 配置数据库位置 ，配置虚拟机上的mysql ip地址；不采用安全协议连接，否则无法逆向生成 -->
           <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                           connectionURL="jdbc:mysql://localhost:3306/crm?serverTimezone=UTC"
                           userId="root" password="qwer">
               <property name="nullCatalogMeansCurrent" value="true" />
           </jdbcConnection>
   
           <javaTypeResolver>
               <property name="forceBigDecimals" value="false"/>
           </javaTypeResolver>
   
           <!-- javaBean生成在哪里 -->
           <javaModelGenerator
                   targetPackage="com.dajiao.crm.workbench.domain"
                   targetProject=".\src\main\java">
               <property name="enableSubPackages" value="false"/>
               <property name="trimStrings" value="true"/>
           </javaModelGenerator>
   
           <!-- sqlMap sql映射文件（xml mapper文件） -->
           <sqlMapGenerator targetPackage="mapper"
                            targetProject=".\src\main\resources">
               <property name="enableSubPackages" value="false"/>
           </sqlMapGenerator>
   
           <!-- javaClient：java接口生成的地方 -->
           <javaClientGenerator type="XMLMAPPER"
                                targetPackage="com.dajiao.crm.workbench.dao"
                                targetProject=".\src\main\java">
               <property name="enableSubPackages" value="false"/>
           </javaClientGenerator>
   
           <!--要创建逆向工程的表-->
           <table tableName="tbl_activity" domainObjectName="Activity"/>
           <table tableName="tbl_activity_remark" domainObjectName="ActivityRemark"/>
           <table tableName="tbl_clue" domainObjectName="Clue"/>
           <table tableName="tbl_clue_activity_relation" domainObjectName="ClueActivityRelation"/>
           <table tableName="tbl_clue_remark" domainObjectName="ClueRemark"/>
           <table tableName="tbl_contacts" domainObjectName="Contacts"/>
           <table tableName="tbl_contacts_activity_relation" domainObjectName="ContactsActivityRelation"/>
           <table tableName="tbl_contacts_remark" domainObjectName="ContactsRemark"/>
           <table tableName="tbl_customer" domainObjectName="Customer"/>
           <table tableName="tbl_customer_remark" domainObjectName="CustomerRemark"/>
           <table tableName="tbl_dic_type" domainObjectName="DicType"/>
           <table tableName="tbl_dic_value" domainObjectName="DicValue"/>
           <table tableName="tbl_tran" domainObjectName="Tran"/>
           <table tableName="tbl_tran_history" domainObjectName="TranHistory"/>
           <table tableName="tbl_tran_remark" domainObjectName="TranRemark"/>
       </context>
   </generatorConfiguration>
   
   ```

   点击idea的maven中crm项目里面的plugins，点击generator，逆向生成工程所需的类和接口



3. 整合spring和mybatis
   1. 在资源目录resources下创建spring-dao文件，整合spring和mybatis

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

    <!--properties文件扫描器，用于扫描jdbc配置文件-->
    <context:property-placeholder location="classpath:jdbc.properties"/>

    <!--dataSource配置-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="username" value="${jdbc.user}"/>
        <property name="password" value="${jdbc.password}"/>
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="url" value="${jdbc.url}"/>
    </bean>

    <!--SQLSessionFactory的bean配置-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <!--配置mapper文件的位置-->
        <property name="mapperLocations" value="classpath:mapper/*Mapper.xml"/>
        <!--配置pagehelper插件-->
        <property name="plugins">
            <array>
                <bean class="com.github.pagehelper.PageInterceptor">
                    <property name="properties">
                        <props>
                            <!--配置数据库方言，告诉插件是什么数据库-->
                            <prop key="helperDialect">mysql</prop>
                            <!--配置页码的合理修正-->
                            <prop key="reasonable">true</prop>
                        </props>
                    </property>
                </bean>
            </array>
        </property>
    </bean>

    <!--生成动态代理dao的配置-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!--指定dao接口的位置-->
        <property name="basePackage" value="com.dajiao.crm.workbench.dao"/>
    </bean>


</beans>

```

2. 配置事务相关，创建spring-service文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!--注解配置：组件扫描器，用于扫描service层-->
    <context:component-scan base-package="com.dajiao.crm.workbench.service"/>
    
    <!--事务管理器的bean-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>
    
    <!--事务的通知-->
    <tx:advice id="advice" transaction-manager="transactionManager">
        <tx:attributes>
            <tx:method name="get*" propagation="SUPPORTS" read-only="true"/>
            <tx:method name="find*" propagation="SUPPORTS" read-only="true"/>
            <tx:method name="select*" propagation="SUPPORTS" read-only="true"/>
            <!--优先级低，首先执行的是上面三种方法的配置-->
            <tx:method name="*" propagation="REQUIRED" read-only="false"/>
        </tx:attributes>
    </tx:advice>
    
    <aop:config>
        <aop:pointcut id="pf" expression="execution(* com.dajiao.crm.workbench.service.*.*(..))"/>
        <aop:advisor advice-ref="advice" pointcut-ref="pf"/>
    </aop:config>
    
</beans>
```



4. 整合spring和spring-mvc

   1. 首先配置spring-mvc的配置文件

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:context="http://www.springframework.org/schema/context"
          xmlns:mvc="http://www.springframework.org/schema/mvc"
          xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd">
   
       <!--组件扫描器-->
       <context:component-scan base-package="com.dajiao.crm.workbench.web"/>
       
       <!--视图解析器-->
       <bean id="view" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
           <!--配置视图的前缀和后缀-->
           <property name="prefix" value="/WEB-INF/workbench"/>
           <property name="suffix" value=".jsp"/>
       </bean>
       
       <!--mvc驱动注解-->
       <mvc:annotation-driven/>
       
       
   </beans>
   ```

   

   2. 配置web.xml文件，整合spring-springmvc

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
            version="4.0">
   
       <!--配置上下文监听器，加载配置文件-->
       <listener>
           <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
       </listener>
       <context-param>
           <param-name>contextConfigLocation</param-name>
           <param-value>classpath:spring-*.xml</param-value>
       </context-param>
   
       <!--字符过滤器-->
       <filter>
           <filter-name>CharacterEncodingFilter</filter-name>
           <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
           <init-param>
               <param-name>encoding</param-name>
               <param-value>utf-8</param-value>
           </init-param>
           <init-param>
               <param-name>forceRequestEncoding</param-name>
               <param-value>true</param-value>
           </init-param>
           <init-param>
               <param-name>forceResponseEncoding</param-name>
               <param-value>true</param-value>
           </init-param>
       </filter>
       <filter-mapping>
           <filter-name>CharacterEncodingFilter</filter-name>
           <url-pattern>/*</url-pattern>
       </filter-mapping>
   
       <!--dispatcherservlet-->
       <servlet>
           <servlet-name>DispatcherServlet</servlet-name>
           <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
       </servlet>
       <servlet-mapping>
           <servlet-name>DispatcherServlet</servlet-name>
           <url-pattern>*.do</url-pattern>
       </servlet-mapping>
   
   </web-app>
   ```

   3. 配置日志文件

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <configuration debug="true">
   	<!-- 指定日志输出的位置 -->
   	<appender name="STDOUT"
   		class="ch.qos.logback.core.ConsoleAppender">
   		<encoder>
   			<!-- 日志输出的格式 -->
   			<!-- 按照顺序分别是：时间、日志级别、线程名称、打印日志的类、日志主体内容、换行 -->
   			<pattern>[%d{HH:mm:ss.SSS}] [%-5level] [%thread] [%logger] [%msg]%n</pattern>
   		</encoder>
   	</appender>
   	
   	<!-- 设置全局日志级别。日志级别按顺序分别是：DEBUG、INFO、WARN、ERROR -->
   	<!-- 指定任何一个日志级别都只打印当前级别和后面级别的日志。 -->
   	<root level="INFO">
   		<!-- 指定打印日志的appender，这里通过“STDOUT”引用了前面配置的appender -->
   		<appender-ref ref="STDOUT" />
   	</root>
   
   	<!-- 根据特殊需求指定局部日志级别 -->
   	<logger name="com.dajiao.crm.workbench.dao" level="DEBUG"/>
   	
   </configuration>
   ```

5. 配置tomcat服务器即可启动
6. 引入静态资源

7. 工具类

```java
package com.dajiao.crm.util;

import java.text.SimpleDateFormat;
import java.util.Date;
//获取系统时间
public class DateTimeUtil {
	public static String getSysTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String dateStr = sdf.format(date);
		return dateStr;
		
	}
	
}

/**
 * 获取是否是ajax请求 
 @author: Mr.Yu
 * @create: 2021-03-11 13:23
 **/
public class GetRequest {

    public static boolean isAjax(HttpServletRequest request) {

        return request.getHeader("x-requested-with") != null
                && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest");
    }

}

//md5加密密码
public class MD5Util {
	
	public static String getMD5(String password) {
		try {
			// 得到一个信息摘要器
			MessageDigest digest = MessageDigest.getInstance("md5");
			byte[] result = digest.digest(password.getBytes());
			StringBuffer buffer = new StringBuffer();
			// 把每一个byte 做一个与运算 0xff;
			for (byte b : result) {
				// 与运算
				int number = b & 0xff;// 加盐
				String str = Integer.toHexString(number);
				if (str.length() == 1) {
					buffer.append("0");
				}
				buffer.append(str);
			}

			// 标准的md5加密后的结果
			return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
	}
	
}

//获取随机的32位id
public class UUIDUtil {
	
	public static String getUUID(){
		
		return UUID.randomUUID().toString().replaceAll("-","");
		
	}
	
}
```





## 登录操作



​		user表的建立

```sql
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` char(32) NOT NULL COMMENT 'uuid\r\n            ',
  `loginAct` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `loginPwd` varchar(255) DEFAULT NULL COMMENT '密码不能采用明文存储，采用密文，MD5加密之后的数据',
  `email` varchar(255) DEFAULT NULL,
  `expireTime` char(19) DEFAULT NULL COMMENT '失效时间为空的时候表示永不失效，失效时间为2018-10-10 10:10:10，则表示在该时间之前该账户可用。',
  `lockState` char(1) DEFAULT NULL COMMENT '锁定状态为空时表示启用，为0时表示锁定，为1时表示启用。',
  `deptno` char(4) DEFAULT NULL,
  `allowIps` varchar(255) DEFAULT NULL COMMENT '允许访问的IP为空时表示IP地址永不受限，允许访问的IP可以是一个，也可以是多个，当多个IP地址的时候，采用半角逗号分隔。允许IP是192.168.100.2，表示该用户只能在IP地址为192.168.100.2的机器上使用。',
  `createTime` char(19) DEFAULT NULL,
  `createBy` varchar(255) DEFAULT NULL,
  `editTime` char(19) DEFAULT NULL,
  `editBy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `tbl_user` VALUES ('06f5fc056eac41558a964f96daa7f27c', 'ls', '李四', '202cb962ac59075b964b07152d234b70', 'ls@163.com', '2018-11-27 21:50:05', '1', 'A001', '192.168.1.1', '2018-11-22 12:11:40', '李四', null, null);
INSERT INTO `tbl_user` VALUES ('40f6cdea0bd34aceb77492a1656d9fb3', 'zs', '张三', '202cb962ac59075b964b07152d234b70', 'zs@qq.com', '2018-11-30 23:50:55', '1', 'A001', '192.168.1.1,192.168.1.2,127.0.0.1', '2018-11-22 11:37:34', '张三', null, null);

```





​		首先就是对输入框的账号和密码进行验证，不能为空，验证完毕之后就可以将数据发送到controller控制器，在转交给业务层，让业务层返回一个user对象，存入session中，然后返回true，当然，在业务层中如果出现了比如说账号错误，密码错误等，都需要抛出异常，让springmvc的异常处理机制来进行处理

​	前端编写

```javascript
<script type="text/javascript">

		$(function (){

    		//支持回车键进行登录事件
			$("#password").keydown(function (event){
				if (event.keyCode == 13) {
					login();
				}
			})

    		//点击事件进行登录
			$("#loginBtn").click(function (){
				login();
			})

		})

		function login(){

            //获取用户名和密码的值
			var username = $.trim($("#username").val());
			var password = $.trim($("#password").val());

            //不能为空
			if (username == null || username == "" || password == null || password == "") {
				layer.msg("用户密码不能为空！",{
					offset : ['200px','1300px']
				});
			} else {

				$.ajax({

					url: "admin/login.do",
					type: "post",
					data: {
						"loginact": username,
						"loginpwd": password
					},
					success : function (data) {
                        //如果传输为true，可以跳转页面
						if (data == true) {
							window.location.href = "workbench/index.do";
						} else {
                            //否则就打印异常处理的异常信息
							layer.msg(data,{
								offset : ['200px','1300px']
							});
						}
					}

				})
			}
		}

	</script>
```



controller控制层

```java
/**
 * @author: Mr.Yu
 * @create: 2021-03-11 12:49
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping("/login.do")
    @ResponseBody
    public boolean login(User user, HttpSession session){

        User user1 = userService.login(user);
        session.setAttribute("user",user1);
        //返回true的原因是有错误都在业务层处理，只要代码进行到这里就证明没有异常
        return true;
    }

}
```

service业务层

```java
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(User user) {

        User user1 = userMapper.selectByLoginAct(user.getLoginact());

        if (user1 == null) {
            throw new LoginException("用户名不正确");
        }

        //将密码加密，与数据库中的密码对比
        String md5Pwd = MD5Util.getMD5(user.getLoginpwd());
//        202cb962ac59075b964b07152d234b70
        System.out.println(user.getLoginpwd());
        if (!Objects.equals(user1.getLoginpwd(),md5Pwd)) {
            throw new LoginException("密码不正确");
        }

        if (user1.getExpiretime().compareTo(DateTimeUtil.getSysTime()) < 0) {
            throw new LoginException("账户已经失效");
        }
        if ("0".equals(user1.getLockstate())){
            throw new LoginException("账户被锁定");
        }
        return user1;
    }
}
```

sql语句

```sql
select id, loginAct, name, loginPwd, email, expireTime, lockState, deptno, allowIps, createTime,
    createBy, editTime, editBy from user where loginAct=#{loginact}
```

异常建立。。。

异常处理机制

```java
/**
 * @author: Mr.Yu
 * @create: 2021-03-11 13:21
 **/
@ControllerAdvice
public class DoExceptionHandler {

      @ExceptionHandler(value = LoginException.class)
      public ModelAndView doLoginException(HttpServletRequest request, Exception e,
                                           HttpServletResponse response) throws IOException {

          //判断是否是ajax请求
          if (GetRequest.isAjax(request)) {
              String message = e.getMessage();
              Gson gson = new Gson();
              String toJson = gson.toJson(message);
              response.getWriter().write(toJson);
              return null;
          }

          ModelAndView mv = new ModelAndView();

          //普通请求
          mv.setViewName("error/system-error");
          mv.addObject("exception",e);
          return mv;
      }

}
```

