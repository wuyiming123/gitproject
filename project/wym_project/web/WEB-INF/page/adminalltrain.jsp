<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/20
  Time: 15:30
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
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%Integer size = (Integer) session.getAttribute("size");%>
    <script>
        $(function () {
            $(".no").click(function () {
                alert("请在未发布的时候修改")
            })
            // $("#hahah").click(function () {
            //     alert("发布之后不得撤回！")
            // })

            $("#yes").click(function () {
                $("#smallSmallBox").remove();
                var tr_title = $(this).next().val();
                var tr_message = $(this).next().next().val();
                var tr_id = $(this).next().next().next().val();
                $("#smallBox").append("<form action='updatetrain' method='post'><div id='smallSmallBox'><table class=\"table\"><tbody>" +
                    "<tr><td>培训标题：</td><td><input required type='text' name='title' id='title'></td><tr>" +
                    "<tr><td>培训内容：</td><td><input required type='text' name='message' id='message'></td><tr>" +
                    "<tr><td>培训时间：</td><td><input required type='datetime-local' name='datetime' id='datetime'></td><tr>" +
                    "<tr><td><input type='submit' value='提交'><input type='hidden' name='sid' id='sid'></td><td></td><tr>" +
                    "</tbody></table></div></form>")
                $("#title").val(tr_title);
                $("#message").val(tr_message);
                $("#sid").val(tr_id);
            })

            $("#newtrain").click(function () {
                $("#smallSmallBox").remove();
                $("#smallBox").append("<form action='newtrain' method='post' ><div id='smallSmallBox'><table class=\"table\"><tbody>" +
                    "<tr><td>标题：</td><td><input type='text' required name='tr_title'></td></tr>" +
                    "<tr><td>内容：</td><td><input type='text' required name='tr_message'></td></tr>" +
                    "<tr><td>时间：</td><td><input type='datetime-local' required name='tr_time'>" +
                    "<input type='hidden' name='tr_state' value='0'></td></tr>" +
                    "<tr><td><input type='submit' value='提交'></td></tr>" +
                    "</tbody></table></div></form>")
            })
        })
    </script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="admin" class="navbar-brand">上一层</a>
        </div>
        <div class="navbar-header">
            <a id="newtrain" class="navbar-brand">发起新的培训</a>
        </div>
    </div>
</nav>

<c:if test="${trains!=null}">
    <table class="table">
        <caption>培训</caption>
        <thead>
        <tr>
            <td>发布状态</td>
            <td>标题</td>
            <td>内容</td>
            <td>培训时间</td>
            <td width="200px" align="center">培训人员</td>
        </tr>
        </thead>
        <tbody>
    <c:forEach items="${sessionScope.trains}" var="trains">
        <tr>
            <td>
                <c:if test="${trains.tr_state==0}">
                    <a style="color:red;" href="changeState?tr_state=1&tr_id=${trains.tr_id}">待发布</a>
                </c:if>
                <c:if test="${trains.tr_state==1}">
                    <a style="color:green;" href="changeState?tr_state=0&tr_id=${trains.tr_id}" >已发布</a>
                </c:if>
            </td>
            <td>${trains.tr_title}</td>
            <td>${trains.tr_message}</td>
            <td>${trains.tr_time}</td>
            <td width="200px" align="center">
                <c:if test="${trains.tr_state==1}">
                    <a class="no">增删人员\</a>
                    <a class="no">修改\</a>
                    <a href="delTrain?tr_id=${trains.tr_id}">删除</a>
                </c:if>
                <c:if test="${trains.tr_state==0}">
                    <a href="addtrainstaff?tr_id=${trains.tr_id}">增删人员\</a>
                    <a id="yes">修改\</a>
                    <input type="hidden" value="${trains.tr_title}">
                    <input type="hidden" value="${trains.tr_message}">
                    <input type="hidden" value="${trains.tr_id}">
                    <a href="NOWdelTrain?tr_id=${trains.tr_id}">删除</a>
                </c:if>

            </td>
        </tr>
    </c:forEach>
        <tr>
            <%
                for (int i = 1; i <=size ; i++) {
             %>
            <a href="currentpage?size=<%=i%>"><-<%=i%>-></a>
            <%
                }
            %>
        </tr>
        </tbody>
    </table>
</c:if>
<div id="smallBox">
    <div id="smallSmallBox"></div>
</div>

</body>
</html>
