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
                $("#regi").attr('disabled', 'disabled');
                $("#log").attr('disabled', 'disabled');
                $("body").append("<div id='changeID'><h3>游客注册</h3>" +
                    "<form action='regiest' method='post'>" +
                    "用户名　:<input type=\"text\" name=\"name\" id=\"name1\" required>" +
                    "<span id=\"spanname\"></span><br/>" +
                    "用户密码:<input type=\"password\" name=\"pass\" id=\"password1\" required>" +
                    "<span id=\"spanpassword\"></span><br/>" +
                    "<input type=\"submit\" value=\"注册\" id='button'>" +
                    "<a href=\"index.jsp\">关闭</a>" +
                    "</form></div>")
                $("#name1").blur(function () {
                    var name = $("#name1").val();
                    if (!(/^[A-Za-z][A-Za-z0-9_]{4,10}$/.test(name))) {
                        $("#spanname").html("<font color='red' face='仿宋'>用户名必须为英文加数字的组合</font>");
                    } else {
                        $("#spanname").html("");
                    }
                })
            })

            $("#log").click(function () {
                $("body").append("<div id='Login'><h3>游客登录</h3>" +
                    "<form action='login' method='post'>" +
                    "用户名　:<input type=\"text\" name=\"name\" id=\"name1\" required>" +
                    "<span id=\"spanname\"></span><br/>" +
                    "用户密码:<input type=\"password\" name=\"pass\" id=\"password1\" required>" +
                    "<span id=\"spanpassword\"></span><br/>" +
                    "<input type=\"submit\" value=\"登录\" id='button'>" +
                    "<a href=\"index.jsp\">关闭</a>" +
                    "</form></div>")
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
<a id="regi" href="#">注册</a>
<a id="log" href="#">登录</a>
</body>
</html>
