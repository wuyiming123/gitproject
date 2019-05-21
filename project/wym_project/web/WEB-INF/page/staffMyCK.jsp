<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/21
  Time: 22:19
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
<h3>${montn}月</h3>
<table>
    <c:forEach items="${ck}" var="ck">
        <tr>
            <td>打卡时间：</td><td>${ck.cw_date}^${ck.cw_time}</td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
