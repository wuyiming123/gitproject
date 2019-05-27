<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.Departement" %><%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/17
  Time: 18:31
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
    <%List<Departement> alldepartment = (List<Departement>) session.getAttribute("alldepartment");%>
    <script>
        $(function () {
            $("#change").change(function () {
                $.get("querydepartmentbydeid",{"de_id":$(this).val()},function (obj) {
                    $("#select2 option").remove();
                    for (var i in obj) {
                        $("#select2").append("<option value='"+obj[i]['po_id']+"'>"+obj[i]['po_name']+"</option>")
                    }
                })
            })
        })
    </script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="allrecruit" class="navbar-brand">上一层</a>
        </div>
    </div>
</nav>

<form action="addthisrecruit" method="post">
    <table class="table">
        <tbody>
        <tr><td>招聘部门：</td>
            <td>
                <select required name="select" id="change">
                    <option></option>
                    <c:forEach items="${sessionScope.alldepartment}" var="alldepartment">
                        <option value="${alldepartment.de_id}">${alldepartment.de_name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr><td>招聘职位：</td><td><select required name="select2" id="select2"><option></option></select></td></tr>
        <tr><td>薪　资　：</td><td><input required type="number" name="ri_salary" style="border: 0px" autocomplete="off" style="outline: none"></td></tr>
        <tr><td>招聘要求：</td><td><input type="text" name="ri_requirement" style="border: 0px" required autocomplete="off" style="outline: none"></td></tr>
        <tr><td>详细要求：</td><td><input type="text" name="ri_information" style="border: 0px" required autocomplete="off" style="outline: none"></td></tr>
        <tr><td><input type="submit" value="保存"></td></tr>
        </tbody>
    </table>
</form>

</body>
</html>
