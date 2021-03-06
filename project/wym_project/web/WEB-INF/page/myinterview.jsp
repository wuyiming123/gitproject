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
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="tohello">上一层</a>
        </div>
    </div>
</nav>

<c:forEach items="${sessionScope.deliveries}" var="deliveries">
    <table class="table table-bordered">
        <tbody>
            <tr>
                <c:if test="${deliveries.d_state==2}">
                    <td><a style="color: red">被邀请面试！</a></td>
                </c:if>
                <c:if test="${deliveries.d_state==1}">
                    <td><a style="color: yellowgreen">对方暂未回复！</a></td>
                </c:if>
                <c:if test="${deliveries.d_state==3}">
                    <td><a style="color: black">对方拒绝了您！</a></td>
                </c:if>
                <c:if test="${deliveries.d_state==666}">
                    <td><a style="color: green">接受了面试，等待对方答复！</a></td>
                </c:if>
                <c:if test="${deliveries.d_state==555}">
                    <td><a style="color: red">您拒绝了这份面试！</a></td>
                </c:if>
                <c:if test="${deliveries.d_state==111}">
                    <td><a style="color: yellow">成为了员工！</a></td>
                </c:if>
            </tr>
            <tr>
                <td>面试岗位：
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
        </tbody>
    </table>
</c:forEach>
</body>
</html>
