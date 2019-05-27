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
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%Tourist tourist = (Tourist) session.getAttribute("tourist");%>

    <script>
        $(function () {
            $(".addres").click(function () {
                var r_tid = $(this).next().val();
                $("#smallsmallbox").remove();
                $("#smallbox").append(
                    "<div id='smallsmallbox'><form action='addresume' method='post'><table class=\"table table-bordered\"><tbody>" +
                    "<tr><td colspan='4' align='center'><input type='text' value='我的个人简历'></td></tr>" +
                    "<tr><td>姓名:</td><td><input type='text' maxlength='8' placeholder='最多输入八个字符' name='r_name' required style='border: 0px' ></td><td>性别:</td><td>" +
                    "<input type='radio' name='r_sex' value='男' required>男<input type='radio' name='r_sex' value='女' required>女</td></tr>" +
                    "<tr><td>电话号码：</td><td><input required style='border: 0px' type='text' maxlength='11' placeholder='最高输入11位数字' name='r_phone' id='r_phon' ></td>" +
                    "<td>民族：</td><td><input required style='border: 0px' type='text' name='r_nation' maxlength='8' placeholder='最多输入八个字符' ></td></tr>" +
                    "<tr><td>籍贯：</td><td><input required style='border: 0px' type='text' maxlength='8' placeholder='最多输入八个字符' name='r_nativeplace' ></td>" +
                    "<td>毕业院校：</td><td><input required style='border: 0px' type='text' name='r_graduteschool' maxlength='20' placeholder='最多输入20个字符' ></td></tr>" +
                    "<tr><td>政治面貌：</td><td><input required style='border: 0px' type='text' name='r_politics' maxlength='10' placeholder='最多输十个字符' ></td>" +
                    "<td>专业:</td><td><input required style='border: 0px' type='text' name='r_major' maxlength='20' placeholder='最多输入20个字符' ></td></tr>" +
                    "<tr><td>学历：</td><td><input required style='border: 0px' type='text' name='r_education' maxlength='10' placeholder='最多输入十个字符' ></td>" +
                    "<td>邮政编码：</td><td><input required style='border: 0px' type='text' maxlength='6' placeholder='最高输入6位数' name='r_zipcode' id='r_zipcod' >" +
                    "<tr><td>出生年月日：</td><td><input required style='border: 0px' type='date' name='r_birthday' ></td>" +
                    "<td>E-MAIL</td><td><input required style='border: 0px' type='text' name='r_email' id='r_emai' placeholder='' ></td></tr>" +
                    "<tr><td>现住址：</td><td colspan='3'><input required style='border: 0px' width='500px' type='text' maxlength='50' placeholder='最多输入50个字' name='r_address'></td></tr>" +
                    "<tr><td colspan='4' align='center'>自我描述(300字以内)</td></tr>" +
                    "<tr><td colspan='4'><textarea name='r_evaluation' maxlength='300'/><input type='hidden' id='r_tid' name='r_tid'></td></tr>" +
                    "<tr><td colspan='4' align='center' ><input type='submit' name='button3' id='button3' value='提交'></td></tr>" +
                    "</tbody></table></form></div>")
                $("#r_tid").val(r_tid);
                $("#r_zipcod").blur(function () {
                    var r_zipcodenam = $("#r_zipcod").val();
                    if (!(/[1-9]\d{5}(?!\d)/.test(r_zipcodenam))) {
                        alert("请输入中国的邮政编码");
                        $('#button3').attr('disabled',"true");
                    } else {
                        $('#button3').removeAttr("disabled");
                    }
                })
                $("#r_phon").blur(function () {
                    var r_phoneenam = $("#r_phon").val();
                    if (!(/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/.test(r_phoneenam))) {
                        alert("请输入正常的手机号");
                        $('#button3').attr('disabled',"true");
                    } else {
                        $('#button3').removeAttr("disabled");
                    }
                })
                $("#r_emai").blur(function () {
                    var r_emailenam = $("#r_emai").val();
                    if (!(/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(r_emailenam))) {
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

    <%
        if(resumes==null){
    %>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a  class="navbar-brand addres">还没有简历哦？添加一份简历</a>
                <input type="hidden" name="tid<%=tourist.getT_id()%>" value="<%=tourist.getT_id()%>" >
            </div>
        </div>
    </nav>
    <%
        }
        if(resumes!=null ){
    %>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand addres" >添加一份简历</a>
                <input type="hidden" name="tid<%=tourist.getT_id()%>" value="<%=tourist.getT_id()%>">
            </div>
        </div>
    </nav>

    <table class="table">
        <tbody>
        <c:forEach items="${sessionScope.myresum}" var="myresum">
            <c:if test="${myresum.r_state==null}">
                <tr><td>简历编号:<td><td>${myresum.r_id}</td><td><a href="sumdetail?rid=${myresum.r_id}">查看简历详情</a></td>
                    <td><a href="delthisresume?rid=${myresum.r_id}">删除这条简历</a></td></tr><hr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
    <%
        }
    %>
    <div id="smallbox"><div id="smallsmallbox"></div></div>
</body>
</html>
