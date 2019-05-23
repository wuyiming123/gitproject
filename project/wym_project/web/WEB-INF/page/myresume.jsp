<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%--var r_tid = $(this).next().val();--%>
<%--$("#r_tid").val(r_tid);--%>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
    <script src="js/jquery-3.1.0.js"></script>
    <%Tourist tourist = (Tourist) session.getAttribute("tourist");%>

    <script>
        $(function () {
            $("#addres").click(function () {
                var r_tid = $(this).next().val();
                $("#smallsmallbox").remove();
                $("#smallbox").append(
                    "<div id='smallsmallbox'><form action='addresume' method='post'><table border='1'>" +
                    "<tr><td colspan='4' align='center'><input type='text' value='我的个人简历'></td></tr>" +
                    "<tr><td>姓名:</td><td><input type='text' maxlength='8' placeholder='最多输入八个字符' name='r_name' required style='border: 0px' ></td><td>性别:</td><td>" +
                    "<input type='radio' name='r_sex' value='男' required>男<input type='radio' name='r_sex' value='女' required>女</td></tr>" +
                    "<tr><td>出生年月日：</td><td><input required style='border: 0px' type='date' name='r_birthday' ></td><td>民族：</td>" +
                    "<td><input required style='border: 0px' type='text' name='r_nation' maxlength='8' placeholder='最多输入八个字符' ></td></tr>" +
                    "<tr><td>籍贯：</td><td><input required style='border: 0px' type='text' maxlength='8' placeholder='最多输入八个字符' name='r_nativeplace' ></td>" +
                    "<td>毕业院校：</td><td><input required style='border: 0px' type='text' name='r_graduteschool' maxlength='20' placeholder='最多输入20个字符' ></td></tr>" +
                    "<tr><td>政治面貌：</td><td><input required style='border: 0px' type='text' name='r_politics' maxlength='10' placeholder='最多输十个字符' ></td>" +
                    "<td>专业:</td><td><input required style='border: 0px' type='text' name='r_major' maxlength='20' placeholder='最多输入20个字符' ></td></tr>" +
                    "<tr><td>学历：</td><td><input required style='border: 0px' type='text' name='r_education' maxlength='10' placeholder='最多输入十个字符' ></td>" +
                    "<td>邮政编码：</td><td><input required style='border: 0px' type='text' maxlength='6' placeholder='最高输入6位数' name='r_zipcode' id='r_zipcode' >" +
                    "<tr><td>电话号码：</td><td><input required style='border: 0px' type='text' maxlength='11' placeholder='最高输入11位数字' name='r_phone' id='r_phone' ></td>" +
                    "<td>E-MAIL</td><td><input required style='border: 0px' type='text' name='r_email' id='r_email' placeholder='' ></td></tr>" +
                    "<tr><td>现住址：</td><td colspan='3'><input required style='border: 0px' width='500px' type='text' maxlength='50' placeholder='最多输入50个字' name='r_address'></td></tr>" +
                    "<tr><td colspan='4' align='center'>自我描述(300字以内)</td></tr>" +
                    "<tr><td colspan='4'><textarea name='r_evaluation' maxlength='300'/><input type='hidden' id='r_tid' name='r_tid'></td></tr>" +
                    "<tr><td colspan='4' align='center' ><input type='submit' name='button3' id='button3' value='提交'></td></tr>" +
                    "</table></form></div>")
                $("#r_tid").val(r_tid);
                $("#r_zipcode").blur(function () {
                    var r_zipcodename = $("#r_zipcode").val();
                    if (!(/[1-9]\d{5}(?!\d)/.test(r_zipcodename))) {
                        alert("请输入中国的邮政编码");
                        $('#button3').attr('disabled',"true");
                    } else {
                        $('#button3').removeAttr("disabled");
                    }
                })
                $("#r_phone").blur(function () {
                    var r_phoneename = $("#r_phone").val();
                    if (!(/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/.test(r_phoneename))) {
                        alert("请输入正常的手机号");
                        $('#button3').attr('disabled',"true");
                    } else {
                        $('#button3').removeAttr("disabled");
                    }
                })
                $("#r_email").blur(function () {
                    var r_emailename = $("#r_email").val();
                    if (!(/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(r_emailename))) {
                        alert("请输入正常的E_MAIL");
                        $('#button3').attr('disabled',"true");
                    } else {
                        $('#button3').removeAttr("disabled");
                    }
                })

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
<a id="addres">还没有简历哦？添加一份简历</a>
<input type="hidden" name="tid<%=tourist.getT_id()%>" value="<%=tourist.getT_id()%>" >
<%
    }
    if(resumes!=null){
%>
<a id="addres">添加一份简历</a>
<input type="hidden" name="tid<%=tourist.getT_id()%>" value="<%=tourist.getT_id()%>">
<table>
    <c:forEach items="${sessionScope.myresum}" var="myresum">
        <tr><td>简历编号:<td><td>${myresum.r_id}</td><td><a href="sumdetail?rid=${myresum.r_id}">查看简历详情</a></td>
            <td><a href="delthisresume?rid=${myresum.r_id}">删除这条简历</a></td></tr>
    </c:forEach>
</table>
<%
    }
%>
<div id="smallbox"><div id="smallsmallbox"></div></div>
</html>
