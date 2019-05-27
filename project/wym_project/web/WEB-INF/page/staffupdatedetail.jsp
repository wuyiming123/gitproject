<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/21
  Time: 10:58
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
</head>
    <body>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="tostaffinformation" class="navbar-brand">返回上一层</a>
            </div>
        </div>
    </nav>
        <form method="post" action="upStaffDetail">
            <table class="table table-bordered">
                <tbody>
                    <tr><td>姓　名　：</td><td><input type="text" required  name="sd_tname" value="${mystaffdetail.sd_tname}"></td></tr>
                    <c:forEach items="${sessionScope.departments}" var="de">
                        <c:if test="${requestScope.mystaffdetail.sd_deid==de.de_id}">
                            <tr><td>部　门　：</td><td><input type="text" readonly="readonly"  name="sd_deid" value="${mystaffdetail.sd_deid}"></td></tr>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${sessionScope.position}" var="po">
                        <c:if test="${requestScope.mystaffdetail.sd_poid==po.de_id}">
                            <tr><td>职　位　：</td><td><input type="text" readonly="readonly" name="sd_poid" value="${mystaffdetail.sd_poid}"></td></tr>                    </c:if>
                    </c:forEach>
                    <tr><td>薪　资　：</td><td><input type="text" readonly="readonly" name="sd_tsalary" value="${mystaffdetail.sd_tsalary}"></td></tr>
                    <tr><td>电　话　：</td><td><input type="text" required name="sd_tphone"   value="${mystaffdetail.sd_tphone}"></td></tr>
                    <tr><td>地　址　：</td><td><input type="text" required name="sd_taddress"  value="${mystaffdetail.sd_taddress}"></td></tr>
                    <tr><td>性　别　：</td><td><input type="text" readonly="readonly" name="sd_tsex" value="${mystaffdetail.sd_tsex}"></td></tr>
                    <tr><td>入职时间：</td><td><input type="text" readonly="readonly" name="sd_time" value="${mystaffdetail.sd_time}"></td></tr>
                    <tr><td>工资卡　：</td><td><input type="number" required  name="sd_card"  value="${mystaffdetail.sd_card}"></td></tr>
                    <tr><td><input type="submit" value="提交"><input type="hidden" name="sd_id" id="sd_id" value="${mystaffdetail.sd_id}"></td></tr>
                </tbody>
            </table>
        </form>

    </body>
</html>
