<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/24
  Time: 10:57
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
<h3>您好！${staffDetail.sd_tname}</h3>
<hr>
<table class="table table-bordered">
    <thead>
        <tr>
            <td>日期</td>
            <td>人员</td>
            <td>基础工资</td>
            <td>加班工资</td>
            <td>奖惩</td>
            <td>社保</td>
            <td>总金额</td>
            <td></td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${requestScope.salaries}" var="salaries">
            <tr>
                <td>${salaries.sa_date}</td>
                <td>${staffDetail.sd_tname}</td>
                <td>${salaries.sa_base}</td>
                <td>${salaries.sa_overtime}</td>
                <td>${salaries.sa_change}</td>
                <td>${salaries.sa_social}</td>
                <td>${salaries.sa_money}</td>
                <td>${salaries.sa_state}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
