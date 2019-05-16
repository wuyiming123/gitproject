<%@ page import="com.iotek.model.Resume" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/15
  Time: 19:14
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
</head>
<body>
<table border="1">
    <form action="updateresume">
        <tr><td colspan="4">我的简历（<%=resume.getR_id()%>）</td></tr>
        <tr><td>姓名：</td><td><input type="text" maxlength="8" value="<%=resume.getR_name()%>" name="r_name" required style="border: 0px"></td>
            <td>性别:</td><td><input type="text" maxlength="1" value="<%=resume.getR_sex()%>" name="r_sex" required></td></tr>
        <tr><td>出生年月日：</td><td><input required style="border: 0px" type="text" name="r_birthday" value="<%=resume.getR_birthday()%>" required></td>
            <td>民族：</td><td><input required style="border: 0px" type="text" name="r_nation" maxlength="8" value="<%=resume.getR_nation()%>" required></td></tr>
        <tr><td>籍贯：</td><td><input required style="border: 0px" type="text" maxlength="8" value="<%=resume.getR_nativeplace()%>" name="r_nativeplace" required></td>
            <td>毕业院校：</td><td><input required style="border: 0px" type="text" name="r_graduteschool" maxlength="20" value="<%=resume.getR_graduteschool()%>" required></td></tr>
        <tr><td>政治面貌：</td><td><input required style="border: 0px" type="text" name="r_politics" maxlength="10" value="<%=resume.getR_politics()%>" required></td>
            <td>专业:</td><td><input required style="border: 0px" type="text" name="r_major" maxlength="20" value="<%=resume.getR_major()%>" required></td>
        </tr>
        <tr><td>学历：</td><td><input required style="border: 0px" type="text" name="r_education" maxlength="10" value="<%=resume.getR_education()%>" required></td>
            <td>邮政编码：</td><td><input required style="border: 0px" type="text" maxlength="6" value="<%=resume.getR_zipcode()%>" name="r_zipcode" required></td>
        </tr>
        <tr><td>电话号码：</td><td><input required style="border: 0px" type="text" maxlength="11"  name="r_phone" value="<%=resume.getR_phone()%>" required></td>
            <td>E-MAIL</td><td><input required style="border: 0px" type="text" name="r_email" value="<%=resume.getR_email()%>" required></td>
        </tr>
        <tr><td>现住址：</td><td colspan='3'><input required style="border: 0px" required type="text" maxlength="50" value="<%=resume.getR_address()%>" name='r_address'></td>
        </tr>
        <tr><td colspan='4' align='center'>自我描述</td></tr>
        <tr>
            <td colspan="4"><input required type="text" style="border: 0px"  maxlength="225" value="<%=resume.getR_evaluation()%>" name='r_evaluation'></td>
            <input type="hidden" value="<%=resume.getR_id()%>" name="r_id">
            <input type="hidden" value="<%=resume.getR_tid()%>" name="r_tid">
        </tr>
        <tr>
            <td colspan="4" align="center"><input type="submit" value="修改"></td>

        </tr>
    </form>
</table>

</body>
</html>
