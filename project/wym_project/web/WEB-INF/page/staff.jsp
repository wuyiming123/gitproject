<%@ page import="com.iotek.model.Staff" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/19
  Time: 18:39
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
    <%Integer time = (Integer) session.getAttribute("time");%>
    <%Integer ready_to_work = (Integer) session.getAttribute("ready_to_work");%>
    <%Integer ready_to_home = (Integer) session.getAttribute("ready_to_home");%>
    <%Integer WTF = (Integer) session.getAttribute("WTF");%>
    <%Staff staff = (Staff) session.getAttribute("staff");%>

</head>
<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a  class="navbar-brand" style="color:black;">${dename}部门的${poname},${staffDetail.sd_tname}同志,你好啊！</a>
        </div>
        <div class="navbar-header">
            <a href="toindex" class="navbar-brand">返回首页</a>
        </div>

    </div>
</nav>
<div id="time">
    <script>
        document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());
        setInterval("document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
    </script>
</div>
<ul class="nav nav-pills nav-stacked">
    <li >
        <c:if test="${time==0}">
            <%if(ready_to_work==null){%>
            <a href="helloCheckWork?sdid=${staffDetail.sd_id}">上班打卡</a>
            <%}else {%><a>已打上班卡</a><%}%>
        </c:if>
        <c:if test="${time==1}">
            <%if(ready_to_home==null){%>
            <a href="bybyCheckWork?sdid=${staffDetail.sd_id}">下班打卡</a>
            <%}else if(ready_to_home==999){%>
            <a>今日已迟到三小时，旷工！</a>
            <%}else if(ready_to_home==1){%><a>已打下班卡</a><%}%>
        </c:if>
        <c:if test="${time==2}">

            <%if(ready_to_home==null){%>
            <a href="bybyCheckWork?sdid=${staffDetail.sd_id}">早退打卡</a>
            <%}else if(ready_to_home==999){%>
            <a>今日已迟到三小时，旷工！</a>
            <%}else if(ready_to_home==1){%><a>已打早退卡</a><%}%>
        </c:if>
        <c:if test="${time==666}">
            <%if(WTF==null){%>
            <a href="fuckCheckWork?sdid=${staffDetail.sd_id}">迟到打卡</a>
            <%}else {%><a>已打迟到卡</a><%}%>
        </c:if>
    </li>
    <li >
        <a href="myDetail?sdid=${staffDetail.sd_id}">个人信息</a>
    </li>
    <li >
        <a href="staffdetail">通讯录</a>
    </li>
</ul>

</body>
</html>
