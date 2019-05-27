<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/19
  Time: 13:10
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
            <a href="admin" id="aasa" class="navbar-brand">上一层</a>
        </div>
    </div>
</nav>
<table class="table">
    <caption>面试单</caption>
    <thead>
    <tr>
        <td width="120px">面试人</td>
        <td width="120px">面试岗位</td>
        <td width="120px">面试部门</td>
        <td width="120px">联系电话</td>
        <td width="120px">面试地址</td>
        <td width="120px">面试时间</td>
        <td width="120px"></td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.interViews}" var="interViews">
    <tr>
        <c:forEach items="${sessionScope.alldeli}" var="alldeli">
            <c:if test="${interViews.i_did==alldeli.d_id}">
                <c:forEach items="${sessionScope.resumes}" var="resums">
                    <c:if test="${resums.r_id==alldeli.d_rid}">
                        <td width="120px">${resums.r_name}</td>
                    </c:if>
                </c:forEach>
                <c:forEach items="${sessionScope.allRecruit}" var="recruits">
                    <c:if test="${recruits.ri_id==alldeli.d_riid}">
                        <td width="120px">${recruits.ri_department}</td>
                        <td width="120px">${recruits.ri_position}</td>
                    </c:if>
                </c:forEach>
            </c:if>
        </c:forEach>
        <td width="120px">${interViews.i_phone}</td>
        <td width="120px">${interViews.i_address}</td>
        <td width="120px">${interViews.i_time}</td>
        <c:if test="${interViews.i_state==3}">
            <td width="120px">您拒绝了对方的面试请求</td>
        </c:if>
        <c:if test="${interViews.i_state==2}">
            <td width="120px">等待对方回复</td>
        </c:if>
        <c:if test="${interViews.i_state==666}">
            <td width="120px"><form action="Employment" method="post">
                <input type="radio" name="isok" value="yes">接受
                <input type="radio" name="isok" value="no">不接受
                <input type="hidden" name="i_id" value="${interViews.i_id}">
                <input type="submit" name="提交">
            </form>
            </td>
        </c:if>
        <c:if test="${interViews.i_state==555}">
            <td width="120px">对方拒绝了您的面试</td>
        </c:if>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
