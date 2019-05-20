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
    <%List<Departement> alldepartment = (List<Departement>) session.getAttribute("alldepartment");%>
    <script>
        $(function () {
            $("#adddepart").click(function () {
                $("body").append("<form action='adddepart' method='post' ><div id='smallbox'><table>" +
                    "<tr><td>部门名称:</td>" +
                    "<td><input type='text' maxlength='30' placeholder='最多30字符' name='de_name' id='de_name' required></td>" +
                    "<td><input type='submit' value='提交' ></td></tr>" +
                    "</table></div><form>")
            })
        })
    </script>
</head>
<body>
<%
    if(alldepartment.size()==0){
%>
<a id="adddepart" style="color: #333333">该公司还没有部门哦，请先添加部门</a>
<%
    }else if(alldepartment.size()!=0){
%>
<table border="1px" style="color: black">
    <tr>
        <td width="190px" align="center">部门</td>
        <td width="190px" align="center"></td>
        <td width="190px" align="center"></td>
    </tr>
    <c:forEach items="${sessionScope.alldepartment}" var="alldepart">
        <tr>
            <td width="190px" align="center">${alldepart.de_name}</td>
            <td width="190px" align="center"><a href="thisdepart?id=${alldepart.de_id}" style="color: #2c774b">查看该部门详情</a></td>
            <td width="190px" align="center"><a href="deldepart?id=${alldepart.de_id}" style="color: #2c774b">删除该部门</a></td>
        </tr>
    </c:forEach>
</table>
<a id="adddepart" style="color: #333333">添加新的部门</a>
<%
    }
%>
</body>
</html>
