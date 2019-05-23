<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/23
  Time: 15:26
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
<table>
<tr><h3>${staffname}${MONTH}月的${ooo}</h3></tr>
    <tr>
        <td>日期</td>
        <td>时间</td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach items="${requestScope.checkWorks}" var="checkworks">
        <tr>
        <td>${checkworks.cw_date}</td>
        <td>${checkworks.cw_time}</td>
        <c:if test="${checkworks.cw_state==0}">
            <td>上班卡</td>
            <c:if test="${checkworks.cw_smalltime>0}">
                <td>早到：${checkworks.cw_smalltime}</td>
            </c:if>
            <c:if test="${checkworks.cw_smalltime<0}">
                <td>迟到：${checkworks.cw_smalltime}</td>
            </c:if>
        </c:if>
        <c:if test="${checkworks.cw_state==1}">
            <td>下班卡</td>
            <c:if test="${checkworks.cw_smalltime>0}">
                <td>加班：${checkworks.cw_smalltime}</td>
            </c:if>
            <c:if test="${checkworks.cw_smalltime<0}">
                <td>早退：${checkworks.cw_smalltime}</td>
            </c:if>
        </c:if>
        <c:if test="${checkworks.cw_state==6}">
            <td>迟到卡</td>
            <td>迟到：${checkworks.cw_smalltime}</td>
        </c:if>
        </tr>
    </c:forEach>
</table>
<table>
    <tr><h3>${staffname}${MONTH}月的${sss}</h3></tr>
    <tr>
        <td>日期</td>
        <td></td>
        <td>金额</td>
        <td>原因</td>
    </tr>
    <c:forEach items="${changs}" var="changs">
        <tr>
            <td>${changs.c_time}</td>
            <td>
                <c:if test="${changs.c_state==-1}">
                    惩罚
                </c:if>
                <c:if test="${changs.c_state==1}">
                    奖励
                </c:if>
            </td>
            <td>${changs.c_money}</td>
            <td>${changs.c_why}</td>
        </tr>
    </c:forEach>
</table>
<a href="toadminallstaffdetail">上一层</a>
</body>
</html>
