<%@ page import="com.dajiao.pojo.Page" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/14
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div id="page_nav">

    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>
    <c:if test="${requestScope.page.pageTotal <= 5}">
        <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
            <c:if test="${i == requestScope.page.pageNo}">
                【${i}】
            </c:if>
            <c:if test="${i != requestScope.page.pageNo}">
                <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
            </c:if>
        </c:forEach>
    </c:if>
    <c:if test="${requestScope.page.pageTotal > 5}">
        <c:choose>
            <c:when test="${requestScope.page.pageNo <= 3}">
                <c:forEach begin="1" end="5" var="i" >
                    <c:if test="${i == requestScope.page.pageNo}">
                        【${i}】
                    </c:if>
                    <c:if test="${i != requestScope.page.pageNo}">
                        <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                    </c:if>
                </c:forEach>
            </c:when>
            <c:when test="${requestScope.page.pageNo > (requestScope.page.pageTotal - 3)}">
                <c:forEach begin="${requestScope.page.pageTotal - 4}" end="${requestScope.page.pageTotal}" var="i">
                    <c:if test="${i == requestScope.page.pageNo}">
                        【${i}】
                    </c:if>
                    <c:if test="${i != requestScope.page.pageNo}">
                        <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                    </c:if>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <c:forEach begin="${requestScope.page.pageNo - 2}" end="${requestScope.page.pageNo + 2}" var="i">
                    <c:if test="${i == requestScope.page.pageNo}">
                        【${i}】
                    </c:if>
                    <c:if test="${i != requestScope.page.pageNo}">
                        <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                    </c:if>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </c:if>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
    <input type="button" class="btn_page" value="确定">
</div>

    <script type="text/javascript">

        $(function (){
            $(".btn_page").click(function (){
                let pageNo = $("#pn_input").val();
                // alert(pageNo);
                if (pageNo > ${requestScope.page.pageTotal}) {
                    pageNo = ${requestScope.page.pageTotal};
                } else if (pageNo < 1){
                    pageNo = 1;
                }
                location.href= "${requestScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;
            })
        })

    </script>

</body>
</html>
