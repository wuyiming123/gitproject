<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/21
  Time: 10:48
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
<a href="updateMyDetail?sd_id=${mystaffdetail.sd_id}">个人信息修改</a></br>
<a href="myTrain?sd_id=${mystaffdetail.sd_id}">培训通知</a></br>
<form action="checkWorkRecord" method="post">
    <input type="number" name="month" required placeholder="输入要查询的月份">
    <input type="submit" value="提交">
    <input type="hidden" name="sd_id" value="${mystaffdetail.sd_id}">
</form>
<a>奖惩记录</a></br>

</body>
</html>
