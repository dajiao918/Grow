<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>

	<%@include file="/pages/common/head.jsp"%>

	<script type="text/javascript">
		$(function (){

			$(".deleteCartItem").click(function (){

				let name = $(this).parent().parent().find("td:first").text();
				return confirm("您确定要删除商品" + name + "吗？");
			})

			$(".clearCart").click(function (){

				return confirm("您确定要清空购物车嘛？");
			})

			$(".itemCount").change(function (){

				let bookId = $(this).attr("bookId");
				let itemCount = this.value;
				let sure = confirm("您确定修改商品数量为[" + itemCount + "]吗？");
				if (sure){
					location.href = "${requestScope.basePath}cartServlet?action=update&bookId=" + bookId + "&itemCount=" + itemCount;
				} else {
					this.value = this.defaultValue;
				}
			})
		})
	</script>
</head>
<body>

<%@include file="/pages/common/welcome.jsp"%>


<div id="main">

		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${not empty sessionScope.cart.map}">
				<c:forEach items="${sessionScope.cart.map}" var="cartItem">
					<tr>
						<td>${cartItem.value.name}</td>
						<td><input style="width: 40px" type="text" class="itemCount"
								   bookId="${cartItem.value.id}" value="${cartItem.value.toTalCount}" /></td>
						<td>${cartItem.value.price}</td>
						<td>${cartItem.value.totalPrice}</td>
						<td><a class="deleteCartItem" href="cartServlet?action=delete&bookId=${cartItem.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty sessionScope.cart.map}">
					<tr>
						<td colspan="5">亲，你当前还没有添加商品哦，请前往<a href="index.jsp">首页</a>添加</td>
					</tr>
			</c:if>

		</table>
	<c:if test="${not empty sessionScope.cart.map}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a class="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
		</div>
	</c:if>
</div>


<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
</div>
</body>
</html>