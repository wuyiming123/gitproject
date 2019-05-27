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
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $(".click").click(function () {
                var c_time=$(this).next().val();
                var c_money=$(this).next().next().val();
                var c_why=$(this).next().next().next().val();
                var c_id=$(this).next().next().next().next().val();
                var c_sid=$(this).next().next().next().next().next().val();
                var month1=$(this).next().next().next().next().next().next().val();
                $("#smallsmallbox").remove();
                $("#smallbox").append("<div id='smallsmallbox'><table class=\"table\"><tbody><form action='updThisChange' method='post'>" +
                    "<tr><td>时间：</td><td><input type='text' readonly='readonly' name='c_time' id='c_time'></td></tr>" +
                    "<tr><td>金额：</td><td><input required type='number' name='c_money' id='c_money'></td></tr>" +
                    "<tr><td>原因：</td><td><input required type='text' name='c_why' id='c_why'></td></tr>" +
                    "<input type='hidden' name='c_id' id='c_id'>" +
                    "<input type='hidden' name='c_sid' id='c_sid'>" +
                    "<input type='hidden' name='month1' id='month1'>" +
                    "<input type='submit' value='check!'>" +
                    "</form></tbody><table></div>")
                $("#c_time").val(c_time)
                $("#c_money").val(c_money)
                $("#c_why").val(c_why)
                $("#c_id").val(c_id)
                $("#c_sid").val(c_sid)
                $("#month1").val(month1)
            })
        })
    </script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="toadminallstaffdetail" class="navbar-brand">上一层</a>
        </div>
    </div>
</nav>
<table class="table">
    <tbody>
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
    </tbody>
</table>
<table class="table">
    <tbody>
    <tr><h3>${staffname}${MONTH}月的${sss}</h3></tr>
    <tr>
        <form action="addNewChange" method="post">
            <td><input name="day" type="number" placeholder="输入日期" required></td>
            <td><input type="number" name="c_state" placeholder="1是奖励，-1是惩罚" required></td>
            <td><input type="number" name="c_money" type="number" placeholder="金额" required></td>
            <td><input type="text" name="c_why" type="text" placeholder="原因" required></td>
            <input type="hidden" name="c_sid" value="${sdid}">
            <input type="hidden" name="month" value="${MONTH}">
            <input type="submit" value="check">
        </form>
    </tr>
    <tr>
        <td>日期</td>
        <td></td>
        <td>金额</td>
        <td>原因</td>
        <td></td>
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
            <td >
                <form action="delThisChange" method="post">
                    <input type="submit" value="删除">
                    <input type="hidden" value="${changs.c_id}" name="c_id">
                    <input type="hidden" value="${changs.c_sid}" name="c_sid">
                    <input type="hidden" value="${MONTH}" name="month">
                </form>
                <input type="button" class="click" value="修改">
                <input type="hidden" value="${changs.c_time}">
                <input type="hidden" value="${changs.c_money}">
                <input type="hidden" value="${changs.c_why}">
                <input type="hidden" value="${changs.c_id}">
                <input type="hidden" value="${changs.c_sid}">
                <input type="hidden" value="${MONTH}">
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div id="smallbox"><div id="smallsmallbox"></div></div>

</body>
</html>
