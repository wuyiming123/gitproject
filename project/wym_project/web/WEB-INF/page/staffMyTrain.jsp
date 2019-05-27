<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/21
  Time: 12:37
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

<c:forEach items="${sessionScope.staffids}" var="staffids">
    <c:forEach items="${sessionScope.trains}" var="trains">
        <c:if test="${trains.tr_id==staffids.sid_taid}">
            <table class="table">
                <thead>
                    <tr>
                        <td>培训标题</td>
                        <td>培训内容</td>
                        <td>培训时间</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${trains.tr_title}</td>
                        <td>${trains.tr_message}</td>
                        <td>${trains.tr_time}</td>
                    </tr>
                </tbody>
            </table>
        </c:if>
    </c:forEach>
</c:forEach>

</body>
</html>
