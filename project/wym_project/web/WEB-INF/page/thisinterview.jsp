<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.iotek.model.Recruit" %>
<%@ page import="com.iotek.model.Resume" %>
<%@ page import="com.iotek.model.InterView" %>
<%@ page import="com.iotek.model.Staff" %><%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/16
  Time: 21:47
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
    <%InterView interView = (InterView) session.getAttribute("thisinterview");%>
    <%Staff staff = (Staff) session.getAttribute("staff");%>
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
<table>
    <%
        if(interView.getI_state()==1){
    %>
    对方暂时还没回复您的面试请求，再等等吧！
    <%
    }else if(interView.getI_state()==2){
    %>
    <tr>联系电话：<%=interView.getI_phone()%></tr>
    <tr>面试地址：<%=interView.getI_address()%></tr>
    <tr>面试时间: <%=interView.getI_time()%></tr>
    <tr>面试状态: 对方通知您面试</tr>
    <tr>
        <td><a href="ido?iid=<%=interView.getI_id()%>">接受</a></td>
        <td><a href="donot?iid=<%=interView.getI_id()%>">拒绝</a></td>
    </tr>
    <%
    }else if(interView.getI_state()==3){
    %>
    对方拒绝了您！
    <%
    }else if(interView.getI_state()==111){
    %>
    <tr><td style="color: red;">员工账号：</td><td style="color: red;"><%=staff.getS_sid()%></td></tr>
    <tr><td style="color: red;">员工密码：</td><td style="color: red;"><%=staff.getS_spass()%></td></tr>
    <%
    }
    %>

</table>

</body>
</html>
