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
</head>
    <body>
        <form method="post" action="upStaffDetail">
            <table border="1px">
                <tr><td>姓　名　：</td><td><input type="text" required  name="sd_tname" value="${mystaffdetail.sd_tname}"></td></tr>
                <tr><td>部　门　：</td><td><input type="text" readonly="readonly"  name="sd_deid" value="${mystaffdetail.sd_deid}"></td></tr>
                <tr><td>职　位　：</td><td><input type="text" readonly="readonly" name="sd_poid" value="${mystaffdetail.sd_poid}"></td></tr>
                <tr><td>薪　资　：</td><td><input type="text" readonly="readonly" name="sd_tsalary" value="${mystaffdetail.sd_tsalary}"></td></tr>
                <tr><td>电　话　：</td><td><input type="text" required name="sd_tphone"   value="${mystaffdetail.sd_tphone}"></td></tr>
                <tr><td>地　址　：</td><td><input type="text" required name="sd_taddress"  value="${mystaffdetail.sd_taddress}"></td></tr>
                <tr><td>性　别　：</td><td><input type="text" readonly="readonly" name="sd_tsex" value="${mystaffdetail.sd_tsex}"></td></tr>
                <tr><td>入职时间：</td><td><input type="text" readonly="readonly" name="sd_time" value="${mystaffdetail.sd_time}"></td></tr>
                <tr><td>工资卡　：</td><td><input type="number" required  name="sd_card"  placeholder="${mystaffdetail.sd_card}"></td></tr>
                <tr><td><input type="submit" value="提交"><input type="hidden" name="sd_id" id="sd_id" value="${mystaffdetail.sd_id}"></td></tr>
            </table>
        </form>
        <a href="tostaffinformation">返回上一层</a>
    </body>
</html>
