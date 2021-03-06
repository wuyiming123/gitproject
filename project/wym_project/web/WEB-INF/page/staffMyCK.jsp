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

<table  class="table">
    <caption>${Number}</caption>
    <tbody>
        <c:forEach items="${CK}" var="ck">
            <tr>
                <td>打卡时间：</td><td>${ck.cw_date}^${ck.cw_time}</td>
                <td>
                    <c:if test="${ck.cw_state==666}">
                        迟到卡
                    </c:if>
                    <c:if test="${ck.cw_state==1}">
                        下班卡
                    </c:if>
                    <c:if test="${ck.cw_state==0}">
                        上班卡
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
