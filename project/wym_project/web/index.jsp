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
                $("body").append("<div id='changeID'><h3>游客注册</h3><hr>" +
                    "<form action='regiest' method='post'>" +
                    "用户名　:<input type=\"text\" name=\"name\" id=\"name1\" required>" +
                    "<span id=\"spanname\"></span><br/>" +
                    "用户密码:<input type=\"password\" name=\"pass\" id=\"password1\" required>" +
                    "<span id=\"spanpassword\"></span><br/>" +
                    "<input type=\"submit\" value=\"注册\" id='button3'>" +
                    "<a href=\"index.jsp\" id='regiestclose'>关闭</a>" +
                    "</form></div>")
                $("#password1").blur(function () {
                    var name = $("#password1").val();
                    if (!(/^.{11,20}$/.test(name))) {
                        $("#spanpassword").html("<font color='red' face='仿宋'>密码得11-20位之内</font>");
                        $('#button3').attr('disabled',"true");
                    } else {
                        $("#spanpassword").html("");
                        $('#button3').removeAttr("disabled");
                    }
                })
                $("#name1").blur(function () {
                    var name = $("#name1").val();
                    if (!(/^.{11,20}$/.test(name))) {
                        $("#spanname").html("<font color='red' face='仿宋'>用户名得11-20位之内</font>");
                        $('#button3').attr('disabled',"true");
                    } else {
                        $("#spanname").html("");
                        $('#button3').removeAttr("disabled");
                    }
                })
            })

            $("#log").click(function () {
                $("body").append("<div id='Login'><h3 id='h3'>登录</h3><hr>" +
                    "<form action='login' method='post'>" +
                    "用户名　:<input type=\"text\" name=\"name\" id=\"name1\" required></br>" +
                    "用户密码:<input type=\"password\" name=\"pass\" id=\"password1\" required></br>" +
                    "<input type='radio' name='who' value='游客' required>游客" +
                    "<input type='radio' name='who' value='员工' required>员工" +
                    "<input type=\"submit\" value=\"登录\" id='button'>" +
                    "<a href=\"index.jsp\" id='loginclose'>关闭</a>" +
                    "</form></div>")
            })

        })

        $(function () {
            $(".button").click(function () {
                alert("亲,请先登录哦！")
            })
        })
    </script>
    <%Integer sizeindex = (Integer) session.getAttribute("sizeindex");%>
    <style>
        td {
            text-align:center; /*设置水平居中*/
            vertical-align:middle;/*设置垂直居中*/
        }
        #loginclose{
            position: absolute;
            margin: 200px 0px 0px 79px;
        }
        #regiestclose{
            position: absolute;
            margin: 200px 0px 0px 79px;
        }
        #changeID{
            border: 1px solid red;
            background-color: honeydew;
            width: 290px;
            height: 344px;
            position: absolute;
           left: 355px;
            top: 150px;
            bottom: 200px;
        }
        #Login{
            border: 1px solid red;
            background-color: honeydew;
            width: 290px;
            height: 344px;
            position: absolute;
            left: 355px;
            top: 150px;
            bottom: 200px;
        }

    </style>

</head>
<body>
<a id="regi" href="javascript:void(0)">注册 </a>
<a id="log" href="javascript:void(0)"> 登录 </a>
<a href="admin" > 我是管理员</a>
<hr >
<table border="1px" style="width: 70%;height: 50%;position: absolute;left: 285px;top: 70px;" >
    <tr>
        <td width="90px" >发布者</td>
        <td width="90px">招聘职位</td>
        <td width="90px">预估薪资</td>
        <td width="130px">要求</td>
        <td width="90px"></td>
        <td width="90px"></td>
    </tr>
    <c:forEach items="${sessionScope.recruit}" var="recruit">
        <c:if test="${recruit.ri_ison eq'on'}">
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
                    <input type="button" class="button" value="投递">
                </td>
            </tr>
        </c:if>
    </c:forEach>
    <tr>
        <td colspan="6" align="center">
            <%
                for (int i = 1; i <=sizeindex ; i++) {
            %>
            <a href="indexdopage?size=<%=i%>"><-<%=i%>-></a>
            <%
                }
            %>
        </td>
    </tr>
</table>
</body>
</html>
