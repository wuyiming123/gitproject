<%@ page import="com.iotek.model.Delivery" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.InterView" %><%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/16
  Time: 1:54
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
    <%List<Delivery> alldeli = (List<Delivery>) session.getAttribute("state2deli");%>
    <%List<InterView> interViews = (List<InterView>) session.getAttribute("interViews");%>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .imgsrc{
            opacity: 0.3;
            position: absolute;
            height: 680px;
            width: 1530px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <%
                if(alldeli==null){
            %>
            <a  class="navbar-brand" href="lookdeli">暂未有人投递简历！</a></br>
            <%
            }else{
            %>
            <a  class="navbar-brand" href="lookdeli" style="color: red">收到<%=alldeli.size()%>条新的简历投递</a></br>
            <%
                }
            %>
        </div>
        <div class="navbar-header">
            <%
                if(interViews==null){
            %>
            <a  class="navbar-brand" href="lookInter">还没有发起任何面试！</a></br>
            <%
            }else {
            %>
            <a  class="navbar-brand" href="lookInter" style="color: red">查看面试邀请</a></br>
            <%
                }
            %>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" >|</a></br>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" href="review">检阅部门</a></br>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" >|</a></br>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" href="allrecruit">招聘信息</a></br>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" >|</a></br>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" href="alltrain">员工培训</a><br>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" >|</a></br>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" href="toRelieveGuard">员工换岗</a></br>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" >|</a></br>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" href="allStaff">员工查询</a></br>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" >|</a></br>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" href="toindex" >返回首页</a>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand" >|</a></br>
        </div>
    </div>
</nav>
<hr>
<img src="picturess/630a7e9e73ff6824ddd3a7ae44b_p24_mk24.png"  class="imgsrc">
</body>
</html>
