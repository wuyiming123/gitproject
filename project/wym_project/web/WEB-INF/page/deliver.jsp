<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.iotek.model.Recruit" %><%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/16
  Time: 1:08
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
</head>
<body>
<form action="deliverynow" method="post">
    <table>
        <tr><td>招聘部门：</td><td><%=thisrecruit.getRi_department()%></td></tr>
        <tr><td>招聘职位：</td><td><%=thisrecruit.getRi_position()%></td></tr>
        <tr><td>薪资待遇：</td><td><%=thisrecruit.getRi_salary()%></td></tr>
        <tr><td>要求：</td><td><%=thisrecruit.getRi_requirement()%></td></tr>
        <tr><td>具体要求：</td><td><%=thisrecruit.getRi_information()%></td></tr>
    </table>
    <c:forEach items="${sessionScope.resums}" var="resums">
        简历ID：${resums.r_id}
        <input type="submit" value="选这份">
        <input type="hidden" value="${resums.r_id}" name="d_rid">
        <input type="hidden" value="${resums.r_tid}" name="d_tid">
        <input type="hidden" name="d_riid" value="<%=thisrecruit.getRi_id()%>">
    </c:forEach>
</form>
</body>
</html>
