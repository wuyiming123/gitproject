<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/22
  Time: 0:10
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
    <script>
        $(function () {
            $("#oldDePart").change(function () {
                $.get("querydepartmentbydeid",{"de_id":$(this).val()},function (obj) {
                    $("#oldPoSi option").remove();
                    for (var i in obj) {
                        $("#oldPoSi").append("<option value='"+obj[i]['po_id']+"'>"+obj[i]['po_name']+"</option>")
                    }
                })
            })
            $("#oldPoSi").change(function () {
                $.get("querystaffbypoid",{"po_id":$(this).val()},function(obj){
                    $("#staffName option").remove();
                    for(var i in obj){
                        $("#staffName").append("<option value='"+obj[i]['sd_id']+"'>"+obj[i]['sd_tname']+"</option>")
                    }
                })
            })
            $("#newDePart").change(function () {
                $.get("querydepartmentbydeid",{"de_id":$(this).val()},function (obj) {
                    $("#newPoSi option").remove();
                    for (var i in obj) {
                        $("#newPoSi").append("<option value='"+obj[i]['po_id']+"'>"+obj[i]['po_name']+"</option>")
                    }
                })
            })
        })
    </script>
</head>
<body>
<form action="update_de_po" method="post" >
    <select id="oldDePart" required>
        <option>-----</option>
        <c:forEach items="${sessionScope.alldepartment}" var="alldepart">
            <option value="${alldepart.de_id}">${alldepart.de_name}</option>
        </c:forEach>
    </select>
    <select id="oldPoSi" required>
        <option>-----</option>
    </select>

    <select id="staffName" name="staffName" required>
        <option>-----</option>
    </select>

    ==调==换==>

    <select id="newDePart" name="newDePart" required>
        <option>-----</option>
        <c:forEach items="${sessionScope.alldepartment}" var="alldepart">
            <option value="${alldepart.de_id}">${alldepart.de_name}</option>
        </c:forEach>
    </select>

    <select id="newPoSi" name="newPoSi" required>
        <option>-----</option>
    </select>
    </br>
    <input type="submit" value="提交" >
</form>
</body>
</html>
