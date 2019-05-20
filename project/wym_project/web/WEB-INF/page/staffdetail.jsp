<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/19
  Time: 19:25
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
            $(".change").change(function () {
                $.get("querystaffbysd_id",{"sd_id":$(this).val()},function (obj) {
                    $("#smallsmallbox").remove();
                    $("#smallbox").append("<div id='smallsmallbox'><table>" +
                        "<tr><td>员工姓名：</td><td>"+ obj['sd_tname']+"</td><tr>" +
                        "<tr><td>联系电话：</td><td>"+ obj['sd_tphone']+"</td><tr>" +
                        "<tr><td>性　别　：</td><td>"+ obj['sd_tsex']+"</td><tr>" +
                        "</table></div>")
                })
            })
        })
    </script>
    <style>
        #smallbox{
            position: absolute;
            right: 300px;
        }
    </style>
</head>
<body>
<div id="smallbox" name="smallbox">
    <h3>员工详情</h3>
    <div id="smallsmallbox"></div>
</div>
<c:forEach items="${sessionScope.alldepartment}" var="departments">
<table border="1px">
    <tr>
        <td align="center">${departments.de_name}</td>
    </tr>
    <tr>
        <c:forEach items="${sessionScope.allposition}" var="position">
            <c:if test="${position.po_deid==departments.de_id}">
                <td width="90px">
                    <a>${position.po_name}</a></br>
                    <select class="change">
                        <option>------</option>
                        <c:forEach items="${sessionScope.allstaffdetail}" var="staffdetail">
                            <c:if test="${staffdetail.sd_poid==position.po_id}">
                                <option value="${staffdetail.sd_id}">${staffdetail.sd_tname}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </c:if>
        </c:forEach>
    </tr>
</table>
</c:forEach>
</body>
</html>
