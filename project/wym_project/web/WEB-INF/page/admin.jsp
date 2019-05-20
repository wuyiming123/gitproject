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

</head>
<body>
<%
    if(alldeli==null){
%>
<a href="lookdeli">暂未有人投递简历！</a></br>
<%
    }else{
%>
<a href="lookdeli">收到<%=alldeli.size()%>条新的简历投递</a></br>
<%
    }
%>
<%
    if(interViews==null){
%>
<a href="lookInter">还没有发起任何面试！</a>
<%
    }else {
%>
<a href="lookInter">查看面试邀请</a>
<%
    }
%>
<a href="review">检阅部门</a></br>
<a href="allrecruit">招聘信息</a></br>

</body>
</html>
