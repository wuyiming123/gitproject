<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/22
  Time: 21:36
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
</head>
<body>
<table border="1px">
    <tr>
        <td>姓名</td>
        <td>部门</td>
        <td>职位</td>
        <td>银行卡</td>
        <td>基本工资</td>
        <td></td>
    </tr>
<c:forEach items="${sessionScope.staffDetails}" var="staffDetails">
    <tr>
        <td>${staffDetails.sd_tname}</td>
        <td>
            <c:forEach items="${sessionScope.departements}" var="departements">
                ${departements.de_name}
            </c:forEach>
        </td>
        <td>
            <c:forEach items="${sessionScope.positions}" var="positions">
                ${positions.po_name}
            </c:forEach>
        </td>
        <td>${staffDetails.sd_card}</td>
        <td>
            <c:if test="${staffDetails.sd_state==0}">
                ${staffDetails.sd_tsalary*0.5}
            </c:if>
            <c:if test="${staffDetails.sd_state==1}">
                ${staffDetails.sd_tsalary}
            </c:if>
        </td>
        <td><a id="click">查看工资单</a></td>
    </tr>
</c:forEach>
</table>
<div id="smallBox">
    <div id="smallSmallBox"></div>
</div>
</body>
</html>
