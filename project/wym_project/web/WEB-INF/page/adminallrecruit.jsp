<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/17
  Time: 15:27
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
            $(".thisrecrits").click(function () {
                var ri_id = $(this).next().val();
                var ri_department = $(this).next().next().val();
                var ri_position = $(this).next().next().next().val();
                var ri_salary = $(this).next().next().next().next().val();
                var ri_requirement = $(this).next().next().next().next().next().val();
                var ri_information = $(this).next().next().next().next().next().next().val();
                $("body").append("<form action='update_this_recrits' method='post'><table class=\"table table-hover\">" +
                    "<caption>全新的招聘信息</caption><tbody>" +
                    "<input type='hidden' name='ri_id' id='ri_id'>" +
                    "<tr><td>招聘部门：</td><td><input required type='text' readonly=\"readonly\" name='ri_department' id='ri_department'></td><tr>" +
                    "<tr><td>招聘职位：</td><td><input required type='text' readonly=\"readonly\" name='ri_position' id='ri_position'></td><tr>" +
                    "<tr><td>薪　资　：</td><td><input required type='number' name='ri_salary' id='ri_salary'></td><tr>" +
                    "<tr><td>职位要求：</td><td><input required type='text' name='ri_requirement' id='ri_requirement'></td><tr>" +
                    "<tr><td>详细要求：</td><td><input required type='text' name='ri_information' id='ri_information'></td><tr>" +
                    "<tr><td><input type='submit' value='提交更改'></td><td><a href='allrecruit'>取消</a></td><tr><tbody>" +
                    "</table><form>")
                $("#ri_id").val(ri_id);
                $("#ri_department").val(ri_department);
                $("#ri_position").val(ri_position);
                $("#ri_salary").val(ri_salary);
                $("#ri_requirement").val(ri_requirement);
                $("#ri_information").val(ri_information);
            })
        })
    </script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="addnewrecruit" class="navbar-brand">发布新的招聘信息</a>
        </div>
        <div class="navbar-header">
            <a href="admin" class="navbar-brand">上一层</a>
        </div>
    </div>
</nav>


<table class="table table-bordered">
    <caption>招聘信息</caption>
    <thead>
        <tr>
            <td width="90px"></td>
            <td width="90px">招聘部门</td>
            <td width="90px">招聘职位</td>
            <td width="90px">发布状态</td>
            <td width="90px"></td>
        </tr>
    </thead>
    <tbody>
<c:forEach items="${sessionScope.recruits}" var="recruits">
    <c:if test="${recruits.ri_ison eq'on'}">
        <tr>
            <td>${recruits.ri_id}</td>
            <td>${recruits.ri_department}</td>
            <td>${recruits.ri_position}</td>
            <td>
                <c:if test="${recruits.ri_ison eq'on'}">
                    <a href="isoff?id=${recruits.ri_id}" style="color:green;">正在招募员工</a>
                </c:if>
                <c:if test="${recruits.ri_ison eq'off'}">
                    <a href="ison?id=${recruits.ri_id}" style="color:red;">尚未发布</a>
                </c:if>
            </td>
            <td><a class="thisrecrits">查看详情</a>
                <input type="hidden" name="ri_id" value="${recruits.ri_id}">
                <input type="hidden" name="ri_department" value="${recruits.ri_department}">
                <input type="hidden" name="ri_position" value="${recruits.ri_position}">
                <input type="hidden" name="ri_salary" value="${recruits.ri_salary}">
                <input type="hidden" name="ri_requirement" value="${recruits.ri_requirement}">
                <input type="hidden" name="ri_information" value="${recruits.ri_information}">
                <input type="hidden" name="ri_ison" value="${recruits.ri_ison}">
            </td>
            <td><a href="delthisrecrits?riid=${recruits.ri_id}">删除</a></td>
        </tr>
    </c:if>
    <c:if test="${recruits.ri_ison eq'off'}">
        <tr>
            <td>${recruits.ri_id}</td>
            <td>${recruits.ri_department}</td>
            <td>${recruits.ri_position}</td>
            <td>
                <c:if test="${recruits.ri_ison eq'on'}">
                    <a href="isoff?id=${recruits.ri_id}" style="color:green;">正在招募员工</a>
                </c:if>
                <c:if test="${recruits.ri_ison eq'off'}">
                    <a href="ison?id=${recruits.ri_id}" style="color:red;">尚未发布</a>
                </c:if>
            </td>
            <td><a class="thisrecrits">查看详情</a>
                <input type="hidden" name="ri_id" value="${recruits.ri_id}">
                <input type="hidden" name="ri_department" value="${recruits.ri_department}">
                <input type="hidden" name="ri_position" value="${recruits.ri_position}">
                <input type="hidden" name="ri_salary" value="${recruits.ri_salary}">
                <input type="hidden" name="ri_requirement" value="${recruits.ri_requirement}">
                <input type="hidden" name="ri_information" value="${recruits.ri_information}">
                <input type="hidden" name="ri_ison" value="${recruits.ri_ison}">
            </td>
            <td><a href="delthisrecrits?riid=${recruits.ri_id}">删除</a></td>
        </tr>
    </c:if>
</c:forEach>
    </tbody>
</table>

</body>
</html>
