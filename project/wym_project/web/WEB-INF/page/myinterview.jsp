<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/16
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
    <script src="js/jquery-3.1.0.js"></script>
</head>
<body>
<c:forEach items="${sessionScope.deliveries}" var="deliveries">
    <table border="1">
        <tr>
            <c:if test="${deliveries.d_state==2}">
                <td><a style="color: red">被邀请面试！</a></td>
            </c:if>
            <c:if test="${deliveries.d_state==1}">
                <td><a style="color: yellowgreen">对方暂未回复！</a></td>
            </c:if>
            <c:if test="${deliveries.d_state==3}">
                <td><a style="color: black">对方拒绝了您的面试请求！</a></td>
            </c:if>
        </tr>
        <tr>
            <td>
                <c:forEach items="${sessionScope.allrecruit}" var="recruit">
                    <c:if test="${recruit.ri_id==deliveries.d_riid}">
                     ${recruit.ri_position}
                    </c:if>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td><a href="thisinterview?id=${deliveries.d_id}">查看详情</a></td>
        </tr>
    </table>
</c:forEach>
</body>
</html>
