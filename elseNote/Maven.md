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

  https://mvnrepository.com/搜索使用的中央仓库，使用groupId或者artifactId作为搜索关键字搜索资源



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



## Maven的常用命令

