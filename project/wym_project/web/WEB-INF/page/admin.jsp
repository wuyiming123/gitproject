<%@ page import="com.iotek.model.Delivery" %>
<%@ page import="java.util.List" %><%--
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
</head>
<body>
<%
    if(alldeli==null){
%>
<a href="lookdeli">暂未有人投递简历！</a>
<%
    }else{
%>
<a href="lookdeli">收到<%=alldeli.size()%>条新的简历投递</a>
<%
    }
%>
</body>
</html>
