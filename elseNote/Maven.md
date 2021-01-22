# Maven



## Maven下的目录结构



​		maven下的公认的目录结构，当有一个maven项目时，例如（Spring），那么其目录结构为：

```java
Spring/
   ---/src			
   ------/main			//放置主程序java代码和配置文件
   ---------java/		//放置程序包和包中的java文件
   ---------resources	//放置java程序中要使用的配置文件
   
   ------/test			//放置测试程序和代码文件
   ---------/java		//放置测试程序包和包中的java文件
   ---------/resources	//放置测试程序中要使用的配置文件
    
   ---/pom.xml			//maven的核心文件（maven项目必有）
```





## 在Maven中执行java项目



​		首先，在maven的同级目录下创建一个项目（Hello），在Hello下创建src目录，并导入pom.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	
	<groupId>com.bjpowernode</groupId>
	<artifactId>ch01-maven</artifactId>
	<version>1.0-SNAPSHOT</version>
</project>
```

​		导入之后，在src目录下创建main目录和test目录，在main目录下创建java和resources目录，同理在test下创建java和resources目录，在java下创建一个包路径com.dajiao.power，在此包下创建一个HelloMaven.java文件，随意编写一个输出语句即可

​		然后在Hello目录下执行命令-----mvn compile

​		此时不出意外命令行界面会下载一系列东西，这是在下载maven工具需要的一些插件，也就是jar包，这些下载的文件被放在了C:\Users\Administrator\.m2\repository中，而当文件下载完毕之后，在maven的同级目录下会出现一个target目录，maven编译的java程序就在target下的class目录下

咋

## 修改Maven的本地仓库地址



​		在Maven安装目录下的conf下修改settings.xml，首先将其备份，然后打开此文件，将注释标签<localRepository>复制在注释下面处，修改/path/to/local/repo，换成自己新建的本地仓库，我的本地仓库是：F:\java\Maven\maven_repository

​		每次执行的项目需要的资源都会在本地仓库里面找，当仓库里面没有的时候，就会到中央仓库的镜像地址下载，镜像地址没有的话就会到中央仓库下载：http://repo.apache.maven.org

​	仓库分为本地仓库和中央仓库，本地仓库的资源是用来执行项目的，当本地没有所需要的资源时，就得要去中央仓库下载...



## pom项目对象模型



​		这是一个pom.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	
	<groupId>com.bjpowernode</groupId>
	<artifactId>ch01-maven</artifactId>
	<version>1.0-SNAPSHOT</version>
</project>
```

* 坐标

  ​	唯一值，在互联网中唯一标识一个项目的，

  ```xml
  <groupId>公司域名的倒写</groupId>
  <artifactId>自定义项目名称</artifactId>
  <version>自定义版本号</version>
  ```

  https://mvnrepository.com/搜索使用的中央仓库，搜索需要的jar包资源，比如说junit测试包，可以直接搜索获取资源坐标，然后编译后就可以根据坐标进行下载资源



* packaging：打包后压缩文件的扩展名，默认是jar，web应用是war

* 依赖：dependencies和dependency，相当于是java代码中import，项目中的各种资源说明，比如说需要mysql驱动

```xml
<dependencies>
	<dependency>
    	<groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.21</version>
    </dependency>
</dependencies>
```

​	这个时候就会去仓库中的mysql下的mysql-connector-java下的8.0.21下找到相应的资源，如果没有的话就会到中央仓库去下载

* properties：设置属性
* build：maven在进行项目的构建时，配置信息，例如指定编译java代码使用的jdk的版本等



## Maven的生命周期

​	

* Maven的生命周期：就是maven构建项目过程中，清理、编译、测试、报告、打包、安装、部署
* Maven的命令：maven可以独立使用，通过命令对maven的生命周期的执行，maven可以使用命令，进行清理、编译测试等 
* maven的插件：maven命令执行时，真正完成功能的是插件，插件就是jar文件



## Maven的命令



* mvn clean命令，会将以前执行的项目target文件目录删除，但不会删除jar包资源

下面我们开始编译和运行test下的程序，首先，在test目录下创建一个和main下相同的包路径，建立一个TestHelloMaven类，并且写入相关测试程序，在pom.xml文件中加入依赖，导入测试的相关资源，这个前提是本地仓库中下junit/junit/4.11/有这个jar包，不然就得慢慢下载

```xml
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.11</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```



然后在项目目录下启动cmd窗口，开始执行命令

* 使用mvn  compile命令可以编译main下的java程序
  * 编译主程序，会在当前目录下生成一个target目录，里面存放编译后的生成的字节码文件
* 使用mvn  test-compile可以编译test下的java程序
  * 编译测试程序，会在当前目录下生成一个target目录，存放编译后的字节码文件

当编译成功后，在执行  ----  mvn   test ----，就可以看到test程序的结果了，这个会在target目录下生成一个surefire-reports文件，保存测试结果

* mvn package
  * 打包主程序（会编译，编译测试，测试，并且按照pom.xml配置把主程序打包生成jar包或者war包）
* mvn  install
  * 安装主程序（会把本工程打包，并且按照本工程的坐标打包到本地仓库）
* mvn deploy
  * 部署主程序，会把本工程打包，并且按照本工程的坐标打包到本地仓库，还保存到私服中，还会自动把项目部署到web容器中
* 执行以上命令必须在pom.xml所在目录中执行



## 在idea中使用Maven



* 在idea中配置Maven，在   **file---settings----Build，Execution，Deployment------Maven**修改

* Maven home  directory：**配置Maven的安装目录**

* User  setting  file：**找到Maven安装目录下的conf文件下的settings.xml**

* Local repository：**本地仓库地址**

* 修改在Maven下的Runner目录，JRE：**改成1.8版本**，VM Options：**-DarchetypeCatalog=internal**（加快项目构建速度）

* 然后在New Project Settings---settings  for New Project---进行上面的操作



用maven和idea创建普通的javase，新建项目，选择maven，在右边界面选择create from archetype，选择下面的maven-archetype-quickstart

用maven和idea创建web项目，新建项目，选择maven，在右边界面选择create from archetype，选择下面的maven-archetype-webapp，此时main目录下是没有java源目录和resources配置文件目录的，需要手动的添加，并且没有test目录，也需要手动添加，在Maven中要是用servlet和jsp的话，直接在pom.xml加入以下依赖：

```xml
<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
    <scope>provided</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/javax.servlet.jsp/javax.servlet.jsp-api -->
<dependency>
    <groupId>javax.servlet.jsp</groupId>
    <artifactId>jsp-api</artifactId>
    <version>2.1</version>
    <scope>provided</scope>
</dependency>
```

打开右边的Maven进行刷新，此时就可以进行web项目的编写了，不要忘记配置一个Tomcat服务器！！

将web项目写好之后，打开右边的Maven进行打包，然后在target文件中就会生成一个war文件，然后复制放在Tomcat的webapps下，然后在Tomcat的bin目录下双击start.bat进行启动Tomcat服务器，就可以在本地直接访问此项目了！！





## 依赖的范围



​		使用scope标签表示，一般有三个值：compile，test，provided默认是compile

​		scope表示的依赖使用的范围，也就是在Maven构建项目的哪些阶段中起到作用

​		maven构建项目过程中，清理、编译、测试、报告、打包、安装、部署，例如junit的依赖范围是test

|                    | compile | test | provided |
| ------------------ | ------- | ---- | -------- |
| 对主程序是否有效   | 是      | 否   | 是       |
| 对测试程序是否有效 | 是      | 是   | 是       |
| 是否参与打包       | 是      | 否   | 否       |
| 是否部署参与       | 是      | 否   | 否       |

​	



## Maven的常用设置



```xml
<properties>
    <!--字符编码-->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <!--java代码编译的jdk版本-->
    <maven.compiler.source>1.7</maven.compiler.source>
     <!--java代码运行的的jdk版本-->
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>
```



* 设置全局变量

```xml
<!--在properties标签可以直接设置全局变量-->
<properties>
    <!--字符编码-->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <!--java代码编译的jdk版本-->
    <maven.compiler.source>1.7</maven.compiler.source>
     <!--java代码运行的的jdk版本-->
    <maven.compiler.target>1.7</maven.compiler.target>
    <!--设置全局变量，spring.version表示spring的版本-->
    <spring.version>5.2.0</spring.version>
    <!--设置全局变量，junit.version表示junit的版本-->
    <junit.version>4.13</junit.version>
</properties>
```



* 引用全局变量

```xml

<dependency>
   <groupId>org.springframework</groupId>
   <artifactId>spring-jcl</artifactId>
    <!--引用spring.version全局变量-->
   <version>${spring.version}</version>
</dependency>
```

