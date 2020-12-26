<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>

	<%@include file="/pages/common/head.jsp"%>

<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
<script type="text/javascript">
	$(function (){
		$(".sureGetItem").click(function (){
			return confirm("您确定收到货了？");
		})

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

		<c:if test="${not empty sessionScope.user}">
			<a class="logout" href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
		</c:if>
		<a href="index.jsp">返回</a>
	</div>
</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td></td>
				<td>订单号</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
				<td>操作</td>
			</tr>
			<c:if test="${sessionScope.orders.size() > 0}">
				<c:forEach items="${sessionScope.orders}" var="order">
					<tr>
						<td colspan="2">${order.orderTime}</td>
						<td>${order.orderId}</td>
						<td>${order.price}</td>
						<td>未发货</td>
						<td><a href="orderServlet?action=checkOrder">查看详情</a></td>
						<td><a class="sureGetItem" href="orderServlet?action=deleteOrder&orderId=${order.orderId}">确认收货</a></td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${sessionScope.orders.size() == 0}">
				<tr>
					<td colspan="7">您当前还没有订单哦，请<a href="index.jsp">前往首页</a>挑选商品吧~~</td>
				</tr>
			</c:if>

		</table>
		
	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>