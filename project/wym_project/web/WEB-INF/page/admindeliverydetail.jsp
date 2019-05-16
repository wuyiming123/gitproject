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
<form>
    <input type="submit" value="发送面试邀请">
    <input type="hidden" name="r_id" value="<%=resume.getR_id()%>">
    <input type="hidden" name="ri_id" value="<%=thisrecruit.getRi_id()%>">
</form>
</body>
</html>
