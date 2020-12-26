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

<%@include file="/pages/common/welcome.jsp"%>

<div id="main">

    <table>
        <tr>
            <td>名称</td>
            <td>单价</td>
            <td>数量</td>
            <td>总价</td>
        </tr>
        <c:if test="${sessionScope.orderItems.size() > 0}">
            <c:forEach items="${sessionScope.orderItems}" var="orderItem">
                <tr>
                    <td>${orderItem.name}</td>
                    <td>${orderItem.price}</td>
                    <td>${orderItem.count}</td>
                    <td>${orderItem.toTalPrice}</td>
                </tr>
            </c:forEach>
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