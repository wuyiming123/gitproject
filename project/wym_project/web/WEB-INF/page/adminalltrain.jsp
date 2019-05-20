<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/20
  Time: 15:30
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
<c:if test="${trains==null}">
    <a href="newtrain">发起一场新的培训</a>
</c:if>
<c:if test="${trains!=null}">
    <table>
        <tr>
            <td>发布状态</td>
            <td>标题</td>
            <td>内容</td>
            <td>培训时间</td>
            <td></td>
        </tr>
    <c:forEach items="${sessionScope.tarins}" var="trains">
        <tr>
            <td>
                <c:if test="${trains.tr_state==0}">
                    <a style="color:red;">待发布</a>
                </c:if>
                <c:if test="${trains.tr_state==1}">
                    <a style="color:red;">已发布</a>
                </c:if>
            </td>
            <td><a>${trains.tr_title}</a></td>
            <td><a>${trains.tr_message}</a></td>
            <td><a>${trains.tr_time}</a></td>
            <td><a>${trains.tr_sid}</a></td>
        </tr>
    </c:forEach>
    </table>
    <a href="newtrain">发起一场新的培训</a>
</c:if>
</body>
</html>
