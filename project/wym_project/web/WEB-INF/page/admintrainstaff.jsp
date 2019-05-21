<%@ page import="com.iotek.model.Train" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/20
  Time: 16:49
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
    <%Train train = (Train) session.getAttribute("train");%>
    <%--<script>--%>
        <%--$(function () {--%>
            <%--$(".click").click(function () {--%>
                <%--$("#smallSmallBox").append("<input readonly='readonly' class='sd_tname'></br>")--%>
            <%--})--%>
        <%--})--%>
    <%--</script>--%>
</head>
<body>
<c:forEach items="${sessionScope.departments}" var="departments">
    <table border="1px">
        <tr>
            <td><a style="color: #2c774b">${departments.de_name}</a></td>
        </tr>
        <tr>
            <c:forEach items="${sessionScope.positions}" var="position">
                <td width="90px">${position.po_name}</td>
            </c:forEach>
        </tr>
        <tr>
            <c:forEach items="${sessionScope.positions}" var="position">
                <td valign="top" width="90px">
                <c:forEach items="${sessionScope.staffDetails}" var="staff">
                    <c:if test="${staff.sd_poid==position.po_id}">
                        <a href="addStaffToTrain?sd_id=${staff.sd_id}&tr_id=<%=train.getTr_id()%>">${staff.sd_tname}</a>
                        <input type="hidden" value="${staff.sd_id}"></br>
                    </c:if>
                </c:forEach>
                </td>
            </c:forEach>
        </tr>
    </table>
</c:forEach>

<table border="1px">
    <tr><td>标　题　：</td><td><%=train.getTr_title()%></td></tr>
    <tr><td>内　容　：</td><td><%=train.getTr_message()%></td></tr>
    <tr><td>培训时间：</td><td><%=train.getTr_time()%></td></tr>
    <tr><td>培训人员：</td>
        <td>
            <div id="smallBox">
                <c:forEach items="${sessionScope.staffDetails}" var="staff">
                    <c:forEach items="${sessionScope.staffIds}" var="staffid">
                        <c:if test="${staffid.sid_sdid==staff.sd_id}">
                            <a href="delStaffToTrain?sid_id=${staffid.sid_id}">${staff.sd_tname}</a></br>
                        </c:if>
                    </c:forEach>
                </c:forEach>
                <div id="smallSmallBox"></div>
            </div>
        </td>
    </tr>
</table>
</body>
</html>
