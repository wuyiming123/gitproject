<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/21
  Time: 21:42
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
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="tostaffinformation" class="navbar-brand">上一层</a>
        </div>
    </div>
</nav>
<table class="table table-bordered">
    <thead>
        <tr>
            <td>对象</td>
            <td>奖惩记录日期</td>
            <td>金额</td>
            <td>原因</td>
            <td>奖惩类型</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${changs}" var="changs">
            <tr>
                <td>${name}</td>
                <td>${changs.c_time}</td>
                <td>${changs.c_money}</td>
                <td>${changs.c_why}</td>
                <td>
                    <c:if test="${changs.c_state==-1}">
                        <p style="color: darkred">激励</p>
                    </c:if>
                    <c:if test="${changs.c_state==1}">
                        物质奖励
                    </c:if>
                    <c:if test="${changs.c_state==666}">
                        非物质精神奖励
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
