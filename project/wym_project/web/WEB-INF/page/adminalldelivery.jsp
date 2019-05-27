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
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>

    /*.jumbotron{*/
        /*background: url("picturess/630a7e9e73ff6824ddd3a7ae44b_p24_mk24.png");*/
        /*background-size: 100% 100%;*/
        /*opacity: 0.7;*/
    /*}*/
    /*.container{*/
        /*opacity: 1;*/
    /*}*/

</style>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="admin" id="aasa" class="navbar-brand">上一层</a>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <c:forEach items="${sessionScope.state2deli}" var="deli">
            <table class="table table-bordered">
                <tbody>
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
                </tbody>
            </table>
            <hr>
        </c:forEach>

    </div>
</div>

</body>
</html>
