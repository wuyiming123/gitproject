<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.Resume" %>
<%@ page import="com.iotek.model.Tourist" %><%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/15
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<%--<td></td>--%>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
    <script src="js/jquery-3.1.0.js"></script>
    <%Tourist tourist = (Tourist) session.getAttribute("tourist");%>

    <script>
        $(function () {
            $("#addres").click(function () {
                var r_tid = $(this).next().val();
                $("body").append(
                    "<form action='addresume' method='post'><table border='1'>" +
                    "<tr><td colspan='4' align='center'><input type='text' value='我的个人简历'></td></tr>" +
                    "<tr><td>姓名:</td><td><input type='text' maxlength='8' placeholder='最多输入八个字符' name='r_name' required style='border: 0px' ></td><td>性别:</td><td>" +
                    "<input type='radio' name='r_sex' value='男' required>男<input type='radio' name='r_sex' value='女' required>女</td></tr>" +
                    "<tr><td>出生年月日：</td><td><input required style='border: 0px' type='date' name='r_birthday' required></td><td>民族：</td>" +
                    "<td><input required style='border: 0px' type='text' name='r_nation' maxlength='8' value='最多输入八个字符' required></td></tr>" +
                    "<tr><td>籍贯：</td><td><input required style='border: 0px' type='text' maxlength='8' value='最多输入八个字符' name='r_nativeplace' required></td>" +
                    "<td>毕业院校：</td><td><input required style='border: 0px' type='text' maxlength='20' value='最多输入20个字符' required></td></tr>" +
                    "<tr><td>政治面貌：</td><td><input required style='border: 0px' type='text' name='r_politics' maxlength='10' value='最多输十个字符' required></td>" +
                    "<td>专业:</td><td><input required style='border: 0px' type='text' name='r_major' maxlength='20' value='最多输入20个字符' required></td></tr>" +
                    "<tr><td>学历：</td><td><input required style='border: 0px' type='text' name='r_education' maxlength='10' value='最多输入十个字符' required></td>" +
                    "<td>邮政编码：</td><td><input required style='border: 0px' type='text' maxlength='6' value='最高输入6位数' name='r_zipcode' required></td></tr>" +
                    "<tr><td>电话号码：</td><td><input required style='border: 0px' type='text' maxlength='11' value='最高输入11位数字' name='r_phone' required></td>" +
                    "<td>E-MAIL</td><td><input required style='border: 0px' type='text' name='r_email' value='' required></td></tr>" +
                    "<tr><td>现住址：</td><td colspan='3'><input required style='border: 0px' required type='text' maxlength='50' value='最多输入50个字' name='r_address'></td></tr>" +
                    "<tr><td colspan='4' align='center'>自我描述</td></tr>" +
                    "<tr><td colspan='4'><textarea name='r_evaluation' maxlength='225'/><input type='hidden' id='r_tid' name='r_tid'></td></tr>" +
                    "<tr><td colspan='4' align='center' ><input type='submit' value='提交'></td></tr>" +
                    "</table></form>")
                $("#r_tid").val(r_tid);
            })
        })
    </script>
</head>
<body>
<% List<Resume> resumes = (List<Resume>) session.getAttribute("myresum");%>
</body>
<%
    if(resumes==null){
%>
<a id="addres">请先添加一份简历</a>
<input type="hidden" name="tid<%=tourist.getT_id()%>" value="<%=tourist.getT_id()%>" >
<%
    }
    if(resumes!=null){

    }
%>

</html>
