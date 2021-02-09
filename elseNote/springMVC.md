# springMVC



* [概述](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#概述)
* [springMVC的大概流程](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#springMVC的大概流程)
* [springMVC入门案例](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#springMVC入门案例)
  * [创建前端控制器](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#创建前端控制器)
  * [创建处理器](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#创建处理器)
  * [视图解析器](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#视图解析器)
* [springMVC的基本流程](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#springMVC的基本流程)
* [springMVC的常用注解](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#springMVC的常用注解)
  * [1. @RequestMapping](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#1-@RequestMapping)
  * [2.处理器方法的参数](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#2-处理器方法的参数)
  * [3. @RequestParam](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#3-@RequestParam)
  * [4. 使用对象接收参数](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#4-使用对象接收参数)
  * [5. 处理器方法的返回值](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#5-处理器方法的返回值)
    * [1. 返回ModelAndView](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#1-返回ModelAndView)
    * [2. 返回String](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#2-返回String)
    * [3. 返回void](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#3-返回void)
    * [4. 返回对象Object](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#4-返回对象Object)
    * [5. 返回List集合](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#5-返回List集合)
    * [6. 返回字符串对象](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#6-返回字符串对象)
* [url-pattern](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#url-pattern)
* [SSM整合](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#SSM整合)
  * [1. 导入相关依赖](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#1-导入相关依赖)
  * [2. 配置web.xml](https://github.com/dajiao918/Grow/blob/main/elseNote/springMVC.md#2-配置web.xml)



## 概述

​			SpringMVc是spring框架的一部分，基于MVc架构的，功能分工明确，能解耦合，作为spring的一部分，能够使用spring的ioc和aop，方便整合Strtus，Mybatis，Hiberate，JPA等其他框架



## springMVC的大概流程

​		

​			springMVC用一个前端控制器（DispatcherServlet）接受用户的请求，DispatcherServlet将请求解析到对应的Controller控制器（代替了servlet）处理请求，当业务处理完成后，会返回一个ModelAndView对象，Model相当于request域，携带着数据，View相当于jsp的地址，是一个逻辑上的View，视图解析器（ViewResolver）根据逻辑视图查找实际的视图，Dispatcherservlet会将Model中的数据传给View（视图渲染），将View返回给请求者

​			这上面中最重要的一个东西就是DispatcherServlet前端控制器，它可以接受并分配请求，最后将结果传递，所以它是springMVC中最关键的一个组件了，想要使用springMVC进行web开发，第一件事就是对前端控制器的配置

​			

## springMVC入门案例

​			

### 创建前端控制器

​			创建Maven工程，勾选webapp骨架，导入servlet，spring-webmvc，jsp依赖，在web.xml文件中配置前端控制器

```xml
<servlet>
	<servlet-name>dispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
</servlet>

<serlet-mapping>
	<servlet-name>dispatcherServlet</servlet-name>
    <url-pattern>*.do</url-pattern>
</serlet-mapping>
```

​		

​			在<servlet>中加入load-on-startup的作用是：标记是否在tomcat服务器启动后就创建这个servlet实例，及是否在服务器启动时调用改servlet的init()方法，而不是在真正访问时才创建该对象，它的值必须是一个整数，当值大于0时，表示在服务器启动后就创建该对象，数值越小，优先级越高，创建的时机也就越早，当值小于0时，就表示在需要的时候才去创建

```xml
	url-pattern标签可以写为" / "，表示拦截接受一切请求，写为*.do的形式就表示值接收URI后缀为.do的访问地址，这里涉及到了静态资源的问题，建议写为*.do
```

​			当配置好了之后，就可以启动服务器了，当我们启动服务器之后，就会出现一个异常

```java
java.io.FileNotFoundException: Could not open ServletContext resource [/WEB-INF/dispatcherServlet-servlet.xml]
```

​			当我们把<servlet-name>标签的值改为‘springMVC’之后，服务器汇报这样的异常

```java
java.io.FileNotFoundException: Could not open ServletContext resource [/WEB-INF/springMVC-servlet.xml]
```

​			每次都是不能找到servletContext中的resource，路径都是/WEB-INF/，文件名跟随<servlet-name>标签的name值，也就是说，服务器启动之后，会找一个xml的配置文件，这个配置文件是用来配置springMVC的一些驱动，控制器的路径，和解决静态资源的配置文件，但是配置文件一般都是放在resources资源目录下的，所以这个时候我们就要使用init-param标签来初始化文件

```java
<servlet>
	<servlet-name>dispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:springMVC.xml</param-value>
    </init-param>
</servlet>
```

​			这个配置文件必须在类路径下，也就是resources资源目录下即可，这个contextConfigLocation来自于DispatcherServlet的父类FrameworkServlet属性，用于设置springMVC的配置文件路径和文件名



### 创建处理器

​	

​			处理器的类一般放在controller包下，在类上添加@Controller注解就表示当前类是处理器，在类中的方法上添加@RequestMapping注解后这些方法就相当于servlet中的doGet()或者是doPost()方法，@RequestMapping注解的属性值value可以指定URI，方法根据这个URI处理业务，value是一个String数组类型的属性，表示可以写多个URI，方法被多个请求路径调动

```java
/**
 * @author: Mr.Yu
 * @create: 2021-02-08 22:38
 **/
@Controller
public class MyController {

    @RequestMapping("/test.do")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用springMVC");
        mv.setViewName("/show.jsp");
        return mv;
    }
}
```



​		ModelAndView表示数据和视图，Model用于存储数据，View用于指定视图资源，其中addObject方法就相当于request的setAttribute()方法，addObject的底层就是将request域中，而setViewName就相当于request的请求转发，最后返回数据视图

​		当我们将处理器创建好之后，还有一件必须做的事，就是编写配置文件springMVC.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

    <!--用于扫描处理器-->
    <context:component-scan base-package="com.dajiao.controller"></context:component-scan>
</beans>
```



编写index.jsp

```jsp
<a href="test.do">springMVC入门案例</a>
```

在webapp目录下创建show.jsp编写接收数据的内容

```jsp
<h3>欢迎来到德莱联盟</h3>
msg：${requestScope.msg}
```



### 视图解析器



​			上面的访问资源是有一定的问题的，当一些有经验的老手就会知道show.jsp在webapp下，是可以跳过处理器的，这样就会造成request域中没有值的情况，所以为了避免这种情况的发生，我们需要将show.jsp页面放在WEB-Inf目录下，这时候就不能直接访问show.jsp页面了，这个时候我们就需要改变ModelAndView的地址了

```java
mv.setViewName("/WEB-INF/pages/show.jsp");
```

​			这个时候写的地址就稍微有点长了，spring框架为了避免请求资源和扩展名的冗余，在视图解析器InternalResourceViewResolver中引入了前缀和后缀，而ModelAndView只需要给出jsp页面的文件名就行了，具体的路径和后缀名，视图解析器会拼接完成

```xml
<bean id="internalResourceViewResolver"                                       		                         			class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<property name="prefix" value="/WEB-INF/pages"/>
    <property name="suffix" value=".jsp" />
</bean>             
```



这样之后，只要是在/WEB-INF/pages下面的资源都只需要写文件名，而不需要关心路径和扩展名



## springMVC的基本流程



* 浏览器提交请求到中央调度器

* 中央调度器直接将请求转给处理器映射器。

* 处理器映射器会根据请求，找到处理该请求的处理器，并将其封装为处理器执行链后返回给中央调度器。

* 中央调度器根据处理器执行链中的处理器，找到能够执行该处理器的处理器适配器。

* 处理器适配器调用执行处理器。

* 处理器将处理结果及要跳转的视图封装到一个对象 ModelAndView 中，并将其返回给处理器适配器。

* 处理器适配器直接将结果返回给中央调度器。

* 中央调度器调用视图解析器，将 ModelAndView 中的视图名称封装为视图对象。

* 视图解析器将封装了的视图对象返回给中央调度器

* 中央调度器调用视图对象，让其自己进行渲染，即进行数据填充，形成响应对象。

* 中央调度器响应浏览器。





## springMVC的常用注解



### 1. @RequestMapping

​				通过@RequestMapping注解可以定义处理器对于请求的映射规则。该注解可以注解在方法上，也可以注解在类上，但意义是不同的。value属性一般都是以"/"开始

​				@RequestMapping的value属性用于定义所匹配请求的URI，但对于注解在方法上与类上，意义是不同的，当定义在类上时，想要根据方法上的路径处理请求就必须在路径前添加类上的value属性，这样其实也方便了每个模块的分类，当不同的类的方法上定义的访问路径相同时，此时就可以在类上定义一个@requestMapping注解，因为在controller层中定义的类名都是不同的，这样就避免了不同方法有相同的访问路径

```java
@Controller
@RequestMapping("/myController")
public class MyController {

    @RequestMapping("/test.do")
    public ModelAndView test(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用springMVC");
        mv.setViewName("/show.jsp");
        return mv;
    }

}
```

index.jsp的访问路径就是

```jsp
<a href="myController/test.do">springMVC入门案例</a>
```



​			@RequestMapping注解还有一个属性method，用于对被注解方法所处理请求的提交方式进行限制，即只有满足该method属性指定的提交方式的请求，才能执行该方法

```java
@RequestMapping(value = "/test.do",method = RequestMethod.POST)
    public ModelAndView test(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用springMVC");
        mv.setViewName("/show.jsp");
        return mv;
    }
```

那么此时index.jsp就不能对此方法进行访问了，因为此时index.jsp是get请求。post请求只有表单方式和ajax请求才能设置，其他方式都不行

​			当然，也可以不指定method属性，那么此时无论是post请求还是get请求方式，都可以进行匹配



### 2. 处理器方法的参数

​		

​			处理器方法可以包含以下四类参数，这些参数会在系统调用时由系统自动赋值，不需要再自己new出来

* HttpServletRequest
* HttpServletResponse
* HttpSession
* 请求中所携带的请求参数



​		当在请求中有参数时，可以在处理器方法中声明相同的参数名，springMVC框架就可以直接将请求参数的值封装在方法参数中，不需要我们手动获取，但前提条件是请求参数的名称和方法参数的名称必须相同

```java
@RequestMapping("/testParam.do")
public void test(String name, int age){
    System.out.println(name + age);
}
```

```jsp
<form action="myController/testParam.do" method="post">
   姓名:<input type="text" name="name"><br>
   年龄:<input type="text" name="age"><br>
   <input type="submit" value="提交">
</form>
```



​			此时springMVC就会根据数据类型自动帮我们进行封装数据，当然如果此时没有对年龄的input标签进行限制的话，输入一些字符串或者是不输入时，就会出现404错误，也就是客户端错误，因为spring会识别类型进行数据的转换，age定义的是int类型，springMVC会将参数从string类型转换成integer类型，数据输入不合适的话就会出现转换错误



​			对于我们接受的参数post请求时，会出现中文乱码问题，springMVC对于这种情况，也为我们提供了专门的字符集过滤其在spring-web-5.2.5.RELEASE.jar下的org.springframeword.web.filter包下的CharacterEncodingFilter类

​			我们需要在web.xml文件配置过滤器



```xml
 <filter>
        <filter-name>characterEncodingFilter</filter-name>
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
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```



​		在CharacterEncodingFilter类中做了如下操作

```java
public class CharacterEncodingFilter extends OncePerRequestFilter {
    @Nullable
    private String encoding;
    private boolean forceRequestEncoding;
    private boolean forceResponseEncoding;
    
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
     	//当前字符集为UTF-8
        String encoding = this.getEncoding();
        if (encoding != null) {
            //判断forceRequestEncoding属性是否为真
            if (this.isForceRequestEncoding() || request.getCharacterEncoding() == null) {
                //设置request使用字符集UTF-8
                request.setCharacterEncoding(encoding);
            }

            if (this.isForceResponseEncoding()) {
                response.setCharacterEncoding(encoding);
            }
        }

        filterChain.doFilter(request, response);
    }
}
```



### 3. @RequestParam

​		

​			前面我们说了，如果要获取请求参数的数据，那么必须在处理器方法中定义和请求参数相同的参数名，如果方法中参数名不一样就不能对数据进行获取，那么此时可以用@RequestParam注解来指定请求参数的名称，将次注解添加到方法参数前，就可以对请求参数的数据进行获取了

```xml
<form action="myController/testParam.do" method="post">
   姓名:<input type="text" name="name"><br>
   年龄:<input type="text" name="age"><br>
   <input type="submit" value="提交">
</form>
```

```java
@RequestMapping("/testParam.do")
public void test(@RequestParam("name") String uname, @RequestParam("age") int 																			uage){
    System.out.println(name + age);
}
```

value属性用于指定请求参数的名称，这样就可以对请求参数的数据进行获取了，这个注解还有一个required属性，boolean类型，设置为true时表示请求中必须有这个参数，false可以没有这个参数，默认是true



### 4. 使用对象接收参数



​			可以将处理器方法的参数定义成一个对象，只要保证对象的属性名和请求的参数名相同，springMVC就可以自动将参数的值封装到对象中





### 5. 处理器方法的返回值



* 返回ModelAndView
* 返回String
* 无返回值void
* 返回自定义类型的对象



#### 1. 返回ModelAndView

​	

​		若处理器方法处理完后，需要跳转页面，同时要传输数据，此时放回ModelAndView比较好，那么如果指向跳转页面而不传输数据，又或者是指向传输数据而不跳转页面，那么此时返回ModelAndView将不合适，要不mode多余，要不view多余



#### 2. 返回String



​			处理器方法返回字符串时，可以通过视图解析器解析将其转换为物理视图地址，通过配置的前缀和后缀拼接想要跳转的页面资源

​			当然也可以直接返回资源页面的路径名，此时就不能再配置视图解析器了

```java
@RequestMapping("/testReturnString.do")
public String testReturnString(){
    //有视图解析器
   return "show";
}
```

```java
@RequestMapping("/testReturnString2.do")
public String testReturnString2(){
   //没有视图解析器
   return "/WEB-INF/pages/show.jsp";
}
```



#### 3. 返回void



​		对于处理器返回void的时候，也就是不需要跳转资源页面的时候，例如对于ajax的异步请求的响应，我们可以接收ajax的请求参数，并对参数进行处理，可以转换为json对象，运用HttpServletResponse响应请求。

```jsp
<script src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#btn").click(function (){

                $.ajax({
                    url:"getVoid.do",
                    data:{
                        name:"alan",
                        age:"20"
                    }
                    type:"GET",
                    dataType:"json",
                    success:function (data){
                        alert(data.name + "->" +data.age)
                    }
                })
            })
        })
    </script>
```

```java
@RequestMapping("/getVoid.do")
public void getVoid(int age, String name,HttpServletResponse resp){
    
    Student student = new Student();
    student.setName(name);
    student.setAge(age);
    //将student转为json
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(student);
    
    //获取响应流
    PrintWriter pw = response.getWriter();
    pw.print(json);
    //刷新响应流
    pw.flush();
    pw.close();
}
```



#### 4. 返回对象Object



​			返回对象时，需要将对象转为json，作为页面显示的数据，上方将对象转为json是很麻烦的，但是springMVC框架却可以帮我们自动转为json对象，需要以下几个条件

* 需要导入json的相关jar包

```xml
<dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.9.8</version>
    </dependency>

    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.9.8</version>
    </dependency>
```



* 声明注解驱动，在springMVC.xml文件中声明

```xml
<mvc:annotation-driven/>
```

​		声明了注解驱动后，springMVC会创建七个HttpMessageConverter对象，其中一个对象就是这个类的实现类MappingJackson2HttpMessageConverter ，用于读取和写入json格式的数据，利用jackson的ObjectMapper读写json数据，操作Object类型数据，可以读取请求头为application/json格式，响应的也是application/json格式



* 使用注解@ResponseBody

只有在方法的上面加了这个注解后，才能将转换后的json数据加入到响应体中



```java
<script src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#btn").click(function (){
                $.ajax({
                    url:"myController/testAjax.do",
                    success:function (data){
                        alert(data.name + "  " + data.age)
                    }
                })
            })
        })
```

```xml
<context:component-scan base-package="com.dajiao.controller"></context:component-scan>
<mvc:annotation-driven/>
```

```java
@RequestMapping("testAjax.do")
    @ResponseBody
    public Student testAjax(){

        Student student = new Student();
        student.setAge(20);
        student.setName("alan");
        System.out.println(student);
        return student;
    }
```

这样就可以在页面上接收到ajax数据



#### 5. 返回List集合



```java
@RequestMapping("testAjaxList.do")
    @ResponseBody
    public List<Student> testAjaxList(){
        Student student = new Student();
        student.setAge(20);
        student.setName("alan");

        Student student1 = new Student();
        student1.setName("bob");
        student1.setAge(21);

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        return students;
    }
```

```xml
$(function (){
            $("#btn").click(function (){
                $.ajax({
                    url:"myController/testAjaxList.do",
                    success:function (data){
                        // alert(data.name + "  " + data.age)
						//利用JavaScript的循环函数遍历输出
                        $.each(data,function (i,n){
                            alert(n.name + "->>" + n.age)
                        })
                    }
                })
            })
        })
```



#### 6. 返回字符串对象



​			当接收的类型是string类型时，此时的String类型并不是返回视图，而是返回String类型的字符串到请求页面，但是当输入中文时，会出现乱码的情况，因为此时响应头的字符格式是*ISO*-8859-1，需要改为UTF-8才能正确输出中文字符，这时候就需要@ResponseBody的produces属性了，指定produces属性为UTF-8即可



## url-pattern



​			web.xml的配置文件中前端控制器的地址在没有特殊的情况下，一般设置为*.do / *.mvc等，但是也可以写为/，但在此时如果页面中有静态资源的话，前端控制器会调用处理器映射器为其查找响应的处理器，当然这是找不到的，所以就会出现404错误，当我们将前端控制器的拦截地址设置为 *.do时，静态资源会被tomcat的一个defaultServlet所处理，而如果我们将期地址设为/之后，前端控制器就会拦截所有请求，但没有处理静态资源的能力，导致静态资源加载不出来，所这时候就需要在springMVC.xml中配置

> <<mvc:default-servlet-handler/>>

声明了上述标签后，springMVC框架会在容器中创建DefaultServletHttpRequestHandler 处理器对象，如果发现是静态资源的请求，DefaultServletHttpRequestHandler类就会将此请求转发给DefaultServlet处理

​		当然，这种情况还有另外的处理方法，我们可以使用

> <<mvc:resources/>>

标签，专门用于解决静态资源无法访问问题，需要在springMVC配置文件中添加如下形式的配置：

```xml
<mvc:resources location="/img/" mapping="/img/**"/>
```

* location属性表示静态资源所在的目录
* mapping属性表示对该静态资源的请求

此时必须在springMVC配置文件中声明注解驱动，解决动态资源和静态资源冲突的问题

> <<mvc:annotation-driven/>>



## SSM整合



### 1. 导入相关依赖

```xml
<!--servlet依赖-->
<dependency> 
    <groupId>javax.servlet</groupId> 
    <artifactId>javax.servlet-api</artifactId> <version>3.1.0</version> 			<scope>provided</scope>
</dependency>

<!--jsp依赖-->
<dependency> 
 	<groupId>javax.servlet.jsp</groupId> 
 	<artifactId>jsp-api</artifactId> 
 	<version>2.2.1-b03</version> 
 	<scope>provided</scope>
</dependency>

<!--springMVC依赖-->
<dependency> 
    <groupId>org.springframework</groupId> 
    <artifactId>spring-webmvc</artifactId> 
    <version>5.2.5.RELEASE</version>
</dependency>

<!--spring事务的依赖-->
<dependency> 
    <groupId>org.springframework</groupId> 
    <artifactId>spring-tx</artifactId> 
    <version>5.2.5.RELEASE</version>
</dependency>

<!--springjdbc的依赖-->
<dependency> 
    <groupId>org.springframework</groupId> 
    <artifactId>spring-jdbc</artifactId> 
    <version>5.2.5.RELEASE</version>
</dependency>

<!--json依赖-->
<dependency> 
    <groupId>com.fasterxml.jackson.core</groupId> 
    <artifactId>jackson-core</artifactId> 
    <version>2.9.0</version>
</dependency> 
<dependency> 
    <groupId>com.fasterxml.jackson.core</groupId> 
    <artifactId>jackson-databind</artifactId> 
    <version>2.9.0</version>
</dependency>

<!--mybatis整合spring依赖-->
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

<!--mysql依赖-->
<dependency> 
    <groupId>mysql</groupId> 
    <artifactId>mysql-connector-java</artifactId> 
    <version>5.1.9</version>
</dependency>

<!--连接池依赖-->
<dependency> 
    <groupId>com.alibaba</groupId> 
    <artifactId>druid</artifactId> 
    <version>1.1.12</version>
</dependency>

<!--spring依赖-->
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <version>5.2.5.RELEASE</version>
</dependency>

<!--spring整合springMVC依赖-->
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-web</artifactId>
  <version>5.2.5.RELEASE</version>
</dependency>
```



### 2. 配置web.xml



​		整合spring和springMVC，首先需要一个连接点，我们知道在前端控制器被创建的时候，springMVC的配置文件已经被读取，并且创建了容器，那么我们也需要在tomcat启动的时候，读取spring的配置文件，将spring的容器创建出来，配置监听器ContextLoaderListener，当我们创建了这个监听器后，监听器就可以完成两项很重要的任务，创建spring的容器对象，并且将对象放在ServletContext的空间中，这样spring容器就可以保证具有全局性，只要web服务不停止spring容器就依然存在

```xml
<!--监听器-->
<listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
<!--指定spring的配置文件位置-->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:applicationContext.xml</param-value>
    </context-param>

<!--前端控制器-->
    <servlet>
        <servlet-name>springMVC_test</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>springMVC_test</servlet-name>
        <url-pattern>*.do</url-pattern>
    </servlet-mapping>

<!--字符集过滤器-->
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
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
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```



在resources资源目录下配置springMVC的配置文件，注意需要的约束空间

```xml
 <context:component-scan base-package="com.dajiao.controller">
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>

    <!--视图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/pages/"/>
        <property name="suffix" value=".jsp"/>
    </bean>

    <!--开启mvc的驱动-->
    <mvc:annotation-driven/>
```

随后配置spring的xml文件

```xml
 <context:component-scan base-package="com.dajiao.service">      
 </context:component-scan>
```

这样就可以在加载web.xml配置文件后，将spring容器创建出来，接下来就是spring和mybatis的整合了，而mybatis最主要的一个对象就是SqlSession对象，要想获取这个对象就需要SqlSessionFactory工厂对象，我们只需要使用mybatis-spring依赖中的一个SqlSessionFactoryBean类注册到spring容器中，并且赋予其数据源的属性，和mybatis 的主配置文件注入进去，解决SqlSession对象的问题了，mybatis还需要一个重要的东西，那就是dao接口的动态代理对象，用来调用dao接口的方法，所以需要在配置文件中定义一个MapperScannerConfigurer扫描器，用来扫描dao接口所在的包，这样不需要id属性也可以生成动态代理对象

修改spring的配置文件

```xml
<context:component-scan base-package="com.dajiao.service">
</context:component-scan>

<!--扫描properties配置文件-->
<context:property-placeholder location="classpath:jdbc.properties"/>

    <!--获取sqlSessionFactory工厂-->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
   <property name="dataSource" ref="dataSource"></property>
   <property name="configLocation" value="classpath:SqlMapConfig.xml"/>
</bean>
<!--druid数据源-->
<bean class="com.alibaba.druid.pool.DruidDataSource" id="dataSource"
        init-method="init" destroy-method="close">
    <property name="url" value="${jdbc.url}"/>
    <property name="username" value="${jdbc.user}"/>
    <property name="password" value="${jdbc.password}"/>
    <property name="maxActive" value="20"/>
</bean>

<!--mapper的扫描器-->
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
   <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory" />
   <property name="basePackage" value="com.dajiao.dao"/>
</bean>
```

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/spring?serverTimezone=UTC
jdbc.user=root
jdbc.password=qwer
```

当配置好了spring文件之后，在spring的容器之中就有了sqlSessionFactory对象和dao所有的dao接口动态代理对象了，此时我们不需要在dao接口使用注解，将dao接口中的对象加入到spring容器中

最后配置mybatis的主配置文件即可

```xml
<typeAliases>
    <package name="com.dajiao.domain"/>
</typeAliases>
```

这个文件可要可不要，因为所有的信息都在spring的配置文件中了，这里只是对所有实体类设置了别名



接下来就可以使用注解和xm的方式进行具体的开发了

