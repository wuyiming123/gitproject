<%@ page import="com.iotek.model.Recruit" %>
<%@ page import="com.iotek.model.Tourist" %><%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/16
  Time: 0:51
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
    <%Recruit thisrecruit = (Recruit) session.getAttribute("thisrecruit");%>
    <% Tourist tourist = (Tourist) session.getAttribute("tourist");%>
</head>
<body>
<table>
    <tr><td>招聘部门：</td><td><%=thisrecruit.getRi_department()%></td></tr>
    <tr><td>招聘职位：</td><td><%=thisrecruit.getRi_position()%></td></tr>
    <tr><td>薪资待遇：</td><td><%=thisrecruit.getRi_salary()%></td></tr>
    <tr><td>要求：</td><td><%=thisrecruit.getRi_requirement()%></td></tr>
    <tr><td>具体要求：</td><td><%=thisrecruit.getRi_information()%></td></tr>
</table>
<form action="delivery" method="post">
    <input type="submit" id="button" value="投递">
    <input type="hidden" value="<%=thisrecruit.getRi_id()%>" name="ri_id">
    <input type="hidden" value="<%=tourist.getT_id()%>" name="t_id">
</form>
<a href="tohello">返回</a>
</body>
</html>
