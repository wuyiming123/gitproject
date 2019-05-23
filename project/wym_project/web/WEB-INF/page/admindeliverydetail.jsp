<%@ page import="com.iotek.model.Resume" %>
<%@ page import="com.iotek.model.Tourist" %>
<%@ page import="com.iotek.model.Recruit" %><%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/16
  Time: 2:26
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
    <% Resume resume = (Resume) session.getAttribute("thisresume");%>
    <%Recruit thisrecruit = (Recruit) session.getAttribute("thisrecruit");%>

    <script>
        $(function () {
            $("#invitation").click(function () {
                var r_name = $(this).next().val();
                var ri_position = $(this).next().next().val();
                var r_id = $(this).next().next().next().val();
                var ri_id = $(this).next().next().next().next().val();
                $("body").append("<div id='smallbox'><form action='invitation' method='post'>" +
                    "<table><tr><td>招聘对象：</td><td><input type='text' name='r_name' id='r_name' style='border: 0px'></td>" +
                    "</tr><tr><td>面试岗位：</td><td><input type='text' name='ri_position' id='ri_position' style='border: 0px'></td></tr>" +
                    "<tr><td>面试地点：</td><td><input  style='border: 0px' required type='text' maxlength='50' placeholder='最多输入50个字' name='i_address'></td></tr>" +
                    "<tr><td>联系电话：</td><td><input type='number' name='i_phone' id='i_phone' style='border: 0px' required maxlength='11' ></td></tr>" +
                    "<tr><td>面试时间：</td><td><input type='datetime-local' name='i_time' id='i_time' style='border: 0px' required>" +
                    "<input type='hidden' name='r_id' id='r_id'>" +
                    "<input type='hidden' name='ri_id' id='ri_id'>" +
                    "</td></tr><tr><td><input type='submit' id='button3' value='确认'></td><td><a href='returnadmindeliverydetail'>取消</a></td></tr>" +
                    "</table>" +
                    "</form></div>")
                $("#i_phone").blur(function () {
                    var name = $("#i_phone").val();
                    if (!(/^.{11,20}$/.test(name))) {
                        alert("请输入正确手机号！");
                        $('#button3').attr('disabled',"true");
                    } else {
                        $('#button3').removeAttr("disabled");
                    }
                })
                $("#r_name").val(r_name);
                $("#ri_position").val(ri_position);
                $("#r_id").val(r_id);
                $("#ri_id").val(ri_id);
            })
        })
    </script>
    <style>
        #smallbox{
            border: 1px solid red;
            background-color: honeydew;
            width: 300px;
            height: 300px;
            position: absolute;
            right: 350px;
            top: 150px;
            bottom: 200px;
        }
    </style>
</head>
<body>

<table border="1">
        <tr><td colspan="4">我的简历（<%=resume.getR_id()%>）</td></tr>
        <tr><td>姓名：</td><td><%=resume.getR_name()%></td>
            <td>性别:</td><td><%=resume.getR_sex()%></tr>
        <tr><td>出生年月日：</td><td><%=resume.getR_birthday()%></td>
            <td>民族：</td><td><%=resume.getR_nation()%></td></tr>
        <tr><td>籍贯：</td><td><%=resume.getR_nativeplace()%></td>
            <td>毕业院校：</td><td><%=resume.getR_graduteschool()%></td></tr>
        <tr><td>政治面貌：</td><td><%=resume.getR_politics()%></td>
            <td>专业:</td><td><%=resume.getR_major()%></td>
        </tr>
        <tr><td>学历：</td><td><%=resume.getR_education()%></td>
            <td>邮政编码：</td><td><%=resume.getR_zipcode()%></td>
        </tr>
        <tr><td>电话号码：</td><td><%=resume.getR_phone()%></td>
            <td>E-MAIL</td><td><%=resume.getR_email()%></td>
        </tr>
        <tr><td>现住址：</td><td colspan='3'><%=resume.getR_address()%></td>
        </tr>
        <tr><td colspan='4' align='center'>自我描述</td></tr>
        <tr>
            <td colspan="4"><%=resume.getR_evaluation()%></td>
        </tr>
</table>
    <table>
        <tr><td>招聘部门：</td><td><%=thisrecruit.getRi_department()%></td></tr>
        <tr><td>招聘职位：</td><td><%=thisrecruit.getRi_position()%></td></tr>
        <tr><td>薪资待遇：</td><td><%=thisrecruit.getRi_salary()%></td></tr>
        <tr><td>要求：</td><td><%=thisrecruit.getRi_requirement()%></td></tr>
        <tr><td>具体要求：</td><td><%=thisrecruit.getRi_information()%></td></tr>
    </table>
<form action="refuse" method="post">
    <input type="submit" value="残忍拒绝">
    <input type="hidden" name="r_id" value="<%=resume.getR_id()%>">
    <input type="hidden" name="ri_id" value="<%=thisrecruit.getRi_id()%>">
</form>

<input type="button" value="发送面试邀请" id="invitation" name="invitation">
<input type="hidden" name="r_name<%=resume.getR_name()%>" value="<%=resume.getR_name()%>">
<input type="hidden" name="ri_position<%=thisrecruit.getRi_position()%>" value="<%=thisrecruit.getRi_position()%>">
<input type="hidden" name="r_id<%=resume.getR_id()%>" value="<%=resume.getR_id()%>">
<input type="hidden" name="ri_id<%=thisrecruit.getRi_id()%>" value="<%=thisrecruit.getRi_id()%>">

<a href="toadmindelivery">上一层</a>
</body>
</html>
