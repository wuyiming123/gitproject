<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/16
  Time: 2:02
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
<c:forEach items="${sessionScope.state2deli}" var="deli">
<table>
    <tr>
        <td>投递人：</td>
        <td>
            <c:forEach items="${sessionScope.allresume}" var="allt">
                <c:if test="${deli.d_rid==allt.r_id}">
                    ${allt.r_name}
                </c:if>
            </c:forEach>
        </td>
    </tr>
    <tr>
        <td>投递岗位：</td>
        <td>
            <c:forEach items="${sessionScope.allrecruit}" var="recruit">
                <c:if test="${deli.d_riid==recruit.ri_id}">
                    ${recruit.ri_position}
                </c:if>
            </c:forEach>
        </td>
    </tr>
    <tr>
        <td>
            <form action="delidetail" method="post">
                <input type="submit" value="查看下详细信息">
                <input type="hidden" value="${deli.d_riid}" name="d_riid">
                <input type="hidden" value="${deli.d_rid}" name="d_rid">
            </form>
        </td>
    </tr>
</table>
</c:forEach>
</body>
</html>
