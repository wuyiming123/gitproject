<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/19
  Time: 18:39
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
<h3>${dename}部门的${poname},${staffDetail.sd_tname}同志,你好啊！</h3>
<ul>
    <li><a>考勤打卡</a></li>
    <li><a>个人信息</a></li>
    <li><a href="staffdetail">通讯录</a></li>
</ul>

</body>
</html>
