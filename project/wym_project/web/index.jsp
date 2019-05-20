<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/15
  Time: 6:01
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
            $("#regi").click(function () {
                $("body").append("<div id='changeID'><h3>游客注册</h3>" +
                    "<form action='regiest' method='post'>" +
                    "用户名　:<input type=\"text\" name=\"name\" id=\"name1\" required>" +
                    "<span id=\"spanname\"></span><br/>" +
                    "用户密码:<input type=\"password\" name=\"pass\" id=\"password1\" required>" +
                    "<span id=\"spanpassword\"></span><br/>" +
                    "<input type=\"submit\" value=\"注册\" id='button'>" +
                    "<a href=\"index.jsp\">关闭</a>" +
                    "</form></div>")
            })

            $("#log").click(function () {
                $("body").append("<div id='Login'><h3>登录</h3>" +
                    "<form action='login' method='post'>" +
                    "用户名　:<input type=\"text\" name=\"name\" id=\"name1\" required>" +
                    "用户密码:<input type=\"password\" name=\"pass\" id=\"password1\" required>" +
                    "<input type='radio' name='who' value='游客' required>游客" +
                    "<input type='radio' name='who' value='员工' required>员工" +
                    "<input type=\"submit\" value=\"登录\" id='button'>" +
                    "<a href=\"index.jsp\">关闭</a>" +
                    "</form></div>")
            })

        })

        $(function () {
            $("#button").click(function () {
                alert("亲,请先登录哦！")
            })
        })
    </script>
    <style>
        #changeID{
            border: 1px solid red;
            background-color: honeydew;
            width: 600px;
            height: 400px;
            position: absolute;
            right: 450px;
            top: 150px;
            bottom: 200px;
        }
        #Login{
            border: 1px solid red;
            background-color: honeydew;
            width: 600px;
            height: 400px;
            position: absolute;
            right: 450px;
            top: 150px;
            bottom: 200px;
        }
    </style>
</head>
<body>
<a id="regi" >注册 </a>
<a id="log"> 登录 </a>
<a href="admin"> 我是管理员</a>
<table border="1px">
    <tr>
        <td width="90px">发布者</td>
        <td width="90px">招聘职位</td>
        <td width="90px">预估薪资</td>
        <td width="130px">要求</td>
        <td width="90px"></td>
        <td width="90px"></td>
    </tr>
    <c:forEach items="${sessionScope.recruit}" var="recruit">
        <tr>
            <td width="90px">admin</td>
            <td width="90px">
                ${recruit.ri_position}
            </td>
            <td width="90px">
                <c:if test="${recruit.ri_salary==null}">
                    工资面议
                </c:if>
                <c:if test="${recruit.ri_salary!=null}">
                    ${recruit.ri_salary}
                </c:if>
            </td>
            <td width="130px">
                ${recruit.ri_requirement}
            </td>
            <td width="90px">
                <form action="lookRecruit" method="post">
                    <input type="submit" value="查看该招聘信息详情">
                    <input type="hidden" value="${recruit.ri_id}" name="ri_id">
                </form>
            </td>
            <td  width="90px">
                <input type="button" id="button" value="投递">
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
