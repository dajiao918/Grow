<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/15
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<script type="text/javascript" >
    $(function (){
        $(".logout").click(function (){

            return !confirm("亲，再逛一逛吧~~~");
        })
    })
</script>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">购物车</span>
    <div>
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>

        <a href="orderServlet?action=getOrder">我的订单</a>
        <c:if test="${not empty sessionScope.user}">
            <a class="logout" href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
        </c:if>
        <a href="index.jsp">返回</a>
    </div>
</div>

</body>
</html>
