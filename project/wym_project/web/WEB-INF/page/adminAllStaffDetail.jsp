<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/22
  Time: 10:06
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
            $("#nonono").click(function () {
                alert("无法拒绝")
            })
            $("#oldDePart").change(function () {
                $.get("querydepartmentbydeid",{"de_id":$(this).val()},function (obj) {
                    $("#oldPoSi option").remove();
                    $("#staffName option").remove();
                    $("#Month").remove();
                    for (var i in obj) {
                        $("#oldPoSi").append("<option value='"+obj[i]['po_id']+"'>"+obj[i]['po_name']+"</option>")
                    }
                })
            })
            $("#oldPoSi").change(function () {
                $.get("querystaffbypoid",{"po_id":$(this).val()},function(obj){
                    $("#staffName option").remove();
                    $("#Month").remove();
                    for(var i in obj){
                        $("#staffName").append("<option value='"+obj[i]['sd_id']+"'>"+obj[i]['sd_tname']+"</option>")
                    }
                })
            })
            $(".click").click(function () {
                $("#smallSmallBox").remove();
                var sd_tname = $(this).next().val();
                var sd_tsalary = $(this).next().next().val();
                var sd_taddress = $(this).next().next().next().val();
                var sd_tphone = $(this).next().next().next().next().val();
                var sd_tsex = $(this).next().next().next().next().next().val();
                var sd_time = $(this).next().next().next().next().next().next().val();
                var sd_card = $(this).next().next().next().next().next().next().next().val();
                $("#smallBox").append("<div id='smallSmallBox'><table class=\"table table-bordered\">" +
                    "<caption>员工详情</caption><tbody>" +
                    "<tr><td>姓　名　：</td><td><input type='text' readonly='readonly' id='sd_tname'></td></tr>" +
                    "<tr><td>薪　资　：</td><td><input type='text' readonly='readonly' id='sd_tsalary'></td></tr>" +
                    "<tr><td>地　址　：</td><td><input type='text' readonly='readonly' id='sd_taddress'></td></tr>" +
                    "<tr><td>电　话　：</td><td><input type='text' readonly='readonly' id='sd_tphone'></td></tr>" +
                    "<tr><td>性　别　：</td><td><input type='text' readonly='readonly' id='sd_tsex'></td></tr>" +
                    "<tr><td>入职时间：</td><td><input type='text' readonly='readonly' id='sd_time'></td></tr>" +
                    "<tr><td>卡　号　：</td><td><input type='text' readonly='readonly' id='sd_card'></td></tr>" +
                    "</tbody></table></br><a href='toadminallstaffdetail'>撤销</a></div>")
                $("#sd_tname").val(sd_tname);
                $("#sd_tsalary").val(sd_tsalary);
                $("#sd_taddress").val(sd_taddress);
                $("#sd_tphone").val(sd_tphone);
                $("#sd_tsex").val(sd_tsex);
                $("#sd_time").val(sd_time);
                $("#sd_card").val(sd_card);
            })

            $(".salary").click(function () {
                $.get("querySalaryBy_sd_id",{"sd_id":$(this).next().val()},function (obj) {
                    $("#smallBox").empty();
                    $("#smallBox").append("<table id='smallTable'  class=\"table table-bordered\"></table></br><a href='toadminallstaffdetail'>撤销</a>")
                    for (var i in obj) {
                        $("#smallTable").append("<tbody><tr>结算工资</tr><tr>" +
                            "<td>"+obj[i]['sa_date']+"</td>" +
                            "<td>基础工资："+obj[i]['sa_base']+"</td>" +
                            "<td>加班工资："+obj[i]['sa_overtime']+"</td>" +
                            "<td>奖惩："+obj[i]['sa_change']+"</td>" +
                            "<td>社保："+obj[i]['sa_social']+"</td>" +
                            "<td>总工资："+obj[i]['sa_money']+"</td>" +
                            "<td><a href='opt?id="+obj[i]['sa_id']+"'>"+obj[i]['sa_state']+"</a></td>" +
                            "<tr></tbody>")
                    }
                })
            })
            $(".thissalary").click(function () {
                $.get("queryThisSalaryBy_sd_id",{"sd_id":$(this).next().val()},function (obj) {
                    $("#smallBox").empty();
                    $("#smallBox").append("<table id='smallTable'  class=\"table table-bordered\"></table></br><a href='toadminallstaffdetail'>撤销</a>")
                    for (var i in obj) {
                        $("#smallTable").append("<tbody><tr><td>这个月工资</td></tr><tr>" +
                            "<td>"+obj[i]['sa_date']+"</td>" +
                            "<td>基础工资："+obj[i]['sa_base']+"</td>" +
                            "<td>加班工资："+obj[i]['sa_overtime']+"</td>" +
                            "<td>奖惩："+obj[i]['sa_change']+"</td>" +
                            "<td>社保："+obj[i]['sa_social']+"</td>" +
                            "<td>总工资："+obj[i]['sa_money']+"</td>" +
                            "<tr></tbody>")
                    }
                })
            })
            $(".this_staff_say_goodby").click(function () {
                var why = $(this).next().next().val();
                var sd_id = $(this).next().val();
                $("#smallBox").empty();
                $("#smallBox").append("<table id='smallTable' class=\"table table-bordered\"></table></br><a href='toadminallstaffdetail'>撤销</a>")
                $("#smallTable").append("<tbody><form action='iagree' method='post'><tr><td>离职原因</td></tr>" +
                    "<tr><td><input type='text' readonly='readonly' id='why'></td></tr>" + "<tr><input type='submit' value='同意'><input type='button' id='nonono' value='拒绝'>" +
                    "<input type='hidden' id='sad_id' name='sd_id'>" +
                    "</tr></form></tbody>")
                $("#sad_id").val(sd_id);
                $("#why").val(why);
            })
            $(".allsala").click(function () {
                $.get("query_AllSalary",{"sd_id":$(this).next().val()},function (obj) {
                    $("#smallBox").empty();
                    $("#smallBox").append("<table id='smallTable'  class=\"table table-bordered\"></table></br><a href='toadminallstaffdetail'>撤销</a>")
                    if(obj==""){
                        $("#smallTable").append("<tr><td>无历月工资</td></tr>")
                    }
                    for (var i in obj) {
                        $("#smallTable").append("<tbody><tr><td>历月工资</td></tr><tr>" +
                            "<td>"+obj[i]['sa_date']+"</td>" +
                            "<td>基础工资："+obj[i]['sa_base']+"</td>" +
                            "<td>加班工资："+obj[i]['sa_overtime']+"</td>" +
                            "<td>奖惩："+obj[i]['sa_change']+"</td>" +
                            "<td>社保："+obj[i]['sa_social']+"</td>" +
                            "<td>总工资："+obj[i]['sa_money']+"</td>" +
                            "<tr></tbody>")
                    }
                })
            })
        })
    </script>
    <style>
        #smallBox{
            position: absolute;
            right: 300px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="admin" class="navbar-brand">上一层</a>
        </div>
    </div>
</nav>

<table  class="table table-bordered">
    <caption>员工详情</caption>
    <c:forEach items="${sessionScope.staffDetails}" var="staffdetails">
        <tbody>
        <tr>
            <td>
                <a class="click">${staffdetails.sd_tname}</a>
                <input type="hidden" value="${staffdetails.sd_tname}">
                <input type="hidden" value="${staffdetails.sd_tsalary}">
                <input type="hidden" value="${staffdetails.sd_taddress}">
                <input type="hidden" value="${staffdetails.sd_tphone}">
                <input type="hidden" value="${staffdetails.sd_tsex}">
                <input type="hidden" value="${staffdetails.sd_time}">
                <input type="hidden" value="${staffdetails.sd_card}">
            </td>
            <c:forEach items="${sessionScope.departements}" var="departements">
                <c:if test="${staffdetails.sd_deid==departements.de_id}">
                    <td>${departements.de_name}</td>
                </c:if>
            </c:forEach>
            <c:forEach items="${sessionScope.positions}" var="positions">
                <c:if test="${staffdetails.sd_poid==positions.po_id}">
                    <td>${positions.po_name}</td>
                </c:if>
            </c:forEach>
            <c:if test="${staffdetails.sd_state==0}">
                <td><a href="become_Wegular_Worker?sd_id=${staffdetails.sd_id}">实习生</a></td>
                <td><input type="button" class="salary" value="结算上个月工资">
                    <input type="hidden" value="${staffdetails.sd_id}">
                </td>
                <td><input class="thissalary" value="核算这月工资" type="button">
                    <input type="hidden" value="${staffdetails.sd_id}">
                </td>
                <td>
                    <input type="button" class="allsala" value="以往工资记录">
                    <input type="hidden" value="${staffdetails.sd_id}">
                </td>
                <c:if test="${staffdetails.sd_why!=null}">
                    <td>
                        <input type="button" class="this_staff_say_goodby" value="离职原因">
                        <input type="hidden" value="${staffdetails.sd_id}">
                        <input type="hidden" value="${staffdetails.sd_why}">
                    </td>
                </c:if>
            </c:if>
            <c:if test="${staffdetails.sd_state==1}">
                <td><a>正式工</a></td>
                <td>
                    <input type="button" class="salary" value="结算上个月工资">
                    <input type="hidden" value="${staffdetails.sd_id}">
                </td>
                <td>
                    <input class="thissalary" value="核算这月工资" type="button">
                    <input type="hidden" value="${staffdetails.sd_id}">
                </td>
                <td>
                    <input type="button" class="allsala" value="以往工资记录">
                    <input type="hidden" value="${staffdetails.sd_id}">
                </td>
                <c:if test="${staffdetails.sd_why!=null}">
                    <td>
                        <input type="button" class="this_staff_say_goodby" value="离职原因">
                        <input type="hidden" value="${staffdetails.sd_id}">
                        <input type="hidden" value="${staffdetails.sd_why}">
                    </td>
                </c:if>
            </c:if>
            <c:if test="${staffdetails.sd_state==2}">
                <td colspan="3" align="center"><a style="color:red;">已离职</a></td>
                <td colspan="3" align="center">
                    <input type="button" class="allsala" value="以往工资记录" style="border: 0px">
                    <input type="hidden" value="${staffdetails.sd_id}">
                </td>
            </c:if>
        </tr>
    </c:forEach>
        </tbody>
</table>

<table class="table table-striped">
    <tbody>
    <tr id="smalltr">
        <select id="oldDePart" required>
            <option>-----</option>
            <c:forEach items="${sessionScope.departements}" var="alldepart">
                <option value="${alldepart.de_id}">${alldepart.de_name}</option>
            </c:forEach>
        </select>
        <select id="oldPoSi" required>
            <option>-----</option>
        </select>
        <form method="post" action="foundRecord">
            <select id="staffName" name="staffName" required>
                <option>-----</option>
            </select>
            <input type="number" name="month" placeholder="请输入月份">
            <input type="submit" id="daka" value="check">
        </form>
    </tr>
    </tbody>
</table>

<div id="smallBox">
    <div id="smallSmallBox"></div>
</div>

</body>
</html>
