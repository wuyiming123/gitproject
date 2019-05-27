<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/21
  Time: 10:48
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
            $("#goodby").click(function () {
                var sd_id = $(this).next().val();
                $("#smallsmallbox").remove();
                $("#smallbox").append("<table><tbody><div id='smallsmallbox'><form method='post' action='hahahaGoodBy'>" +
                    "<textarea maxlength='1000'  placeholder='1000字以内' name='sd_why'/>" +
                    "<input type='hidden' name='sdid' id='sdid'></br>" +
                    "<input type='submit' value='提交'>" +
                    "</form></div></tbody></table>")
                $("#sdid").val(sd_id);
            })
        })
    </script>
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="tostaff" class="navbar-brand ">上一层</a>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand ">|||</a>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand ">输入月份查打卡记录</a>
        </div>
        <form class="navbar-form navbar-left" role="search" action="checkWorkRecord" method="post">
            <div class="form-group">
                <input type="number" class="form-control" name="month" required placeholder="输入要查询的月份">
                <input type="hidden" name="sd_id" value="${mystaffdetail.sd_id}">
            </div>
            <button type="submit" class="btn btn-default">提交</button>
        </form>
    </div>
</nav>
<ul class="nav nav-pills nav-stacked">
    <li><a href="updateMyDetail?sd_id=${mystaffdetail.sd_id}">个人信息修改</a></li>
    <li><a href="myTrain?sd_id=${mystaffdetail.sd_id}">培训通知</a></li>
    <li><a href="changeRecord?sd_id=${mystaffdetail.sd_id}">奖惩记录</a></li>
    <li><a href="Mysalary?sd_id=${mystaffdetail.sd_id}">薪资记录</a></li>
    <li>
        <c:if test="${mystaffdetail.sd_why==null}">
            <a id="goodby">我要离职</a>
            <input type="hidden" value="${mystaffdetail.sd_id}"></br>
        </c:if>
        <c:if test="${mystaffdetail.sd_why!=null}">
            <a >离职申请已提交，等管理员审核！</a>
        </c:if>
    </li>
</ul>

<div id="smallbox">
    <div id="smallsmallbox">
    </div>
</div>

</body>
</html>
