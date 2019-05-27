<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.iotek.model.Departement" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/17
  Time: 9:33
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
            $("#adddepart").click(function () {
                $("#smallsmallbox").remove();
                $("#smallbox").append("<form action='adddepart' method='post' ><div id='smallsmallbox'><table class=\"table table-striped\">" +
                    "<tbody><tr><td>部门名称:</td>" +
                    "<td><input type='text' maxlength='30' placeholder='最多30字符' name='de_name' id='de_name' required></td>" +
                    "<td><input type='submit' value='提交' ></td></tr></tbody>" +
                    "</table></div><form>")
            })
        })
    </script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <%
                if(alldepartment.size()==0){
            %>
            <a id="adddepart" style="color: #333333" href="javascript:void(0)" class="navbar-brand">该公司还没有部门哦，请先添加部门</a>
            <a href="admin" class="navbar-brand">上一层</a>
            <%
            }else if(alldepartment.size()!=0){
            %>
            <a id="adddepart" style="color: #333333" href="javascript:void(0)" class="navbar-brand">添加新的部门</a>
            <a href="admin" class="navbar-brand">上一层</a>
            <table border="1px" class="table">
                <caption><h2>部门</h2></caption>
                <thead>
                <tr>
                    <td width="190px" align="center">部门</td>
                    <td width="190px" align="center"></td>
                    <td width="190px" align="center"></td>
                </tr>
                </thead>
                <c:forEach items="${sessionScope.alldepartment}" var="alldepart">
                <tbody>
                    <tr>
                        <td width="190px" align="center">${alldepart.de_name}</td>
                        <td width="190px" align="center"><a href="thisdepart?id=${alldepart.de_id}" style="color: #2c774b">查看该部门详情</a></td>
                        <td width="190px" align="center"><a href="deldepart?id=${alldepart.de_id}" style="color: #2c774b">删除该部门</a></td>
                        <form action="renamedepart" method="post">
                            <td width="190px" align="center">
                                <input required type="text" maxlength="10" name="newdename">
                                <input type="hidden" value="${alldepart.de_id}" name="deid" >
                                <input type="submit" value="修改部门名">
                            </td>
                        </form>
                    </tr>
                </tbody>
                </c:forEach>
            </table>
            <%
                }
            %>
        </div>
    </div>
</nav>

<div id="smallbox"><div id="smallsmallbox"></div></div>
</body>
</html>
