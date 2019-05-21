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
    <script>
        $(function () {
            $("#no").click(function () {
                alert("请在未发布的时候修改")
            })
            $("#hahah").click(function () {
                alert("发布之后不得撤回！")
            })

            $("#yes").click(function () {
                $("#smallSmallBox").remove();
                var tr_title = $(this).next().val();
                var tr_message = $(this).next().next().val();
                var tr_id = $(this).next().next().next().val();
                $("#smallBox").append("<form action='updatetrain' method='post'><div id='smallSmallBox'><table>" +
                    "<tr><td>培训标题：</td><td><input required type='text' name='title' id='title'></td><tr>" +
                    "<tr><td>培训内容：</td><td><input required type='text' name='message' id='message'></td><tr>" +
                    "<tr><td>培训时间：</td><td><input required type='datetime-local' name='datetime' id='datetime'></td><tr>" +
                    "<tr><td><input type='submit' value='提交'><input type='hidden' name='sid' id='sid'></td><td></td><tr>" +
                    "</table></div></form>")
                $("#title").val(tr_title);
                $("#message").val(tr_message);
                $("#sid").val(tr_id);
            })

            $("#newtrain").click(function () {
                $("#smallSmallBox").remove();
                $("#smallBox").append("<form action='newtrain' method='post' ><div id='smallSmallBox'><table>" +
                    "<tr><td>标题：</td><td><input type='text' required name='tr_title'></td></tr>" +
                    "<tr><td>内容：</td><td><input type='text' required name='tr_message'></td></tr>" +
                    "<tr><td>时间：</td><td><input type='datetime-local' required name='tr_time'>" +
                    "<input type='hidden' name='tr_state' value='0'></td></tr>" +
                    "<tr><input type='submit' value='提交'></tr>" +
                    "</table></div></form>")
            })
        })
    </script>
</head>
<body>
<c:if test="${trains==null}">
    <a href="newtrain">发起新的培训</a>
</c:if>
<c:if test="${trains!=null}">
    <table>
        <tr>
            <td>发布状态</td>
            <td>标题</td>
            <td>内容</td>
            <td>培训时间</td>
            <td width="200px" align="center">培训人员</td>
        </tr>
    <c:forEach items="${sessionScope.trains}" var="trains">
        <tr>
            <td>
                <c:if test="${trains.tr_state==0}">
                    <a style="color:red;" href="changeState?tr_state=1&tr_id=${trains.tr_id}">待发布</a>
                </c:if>
                <c:if test="${trains.tr_state==1}">
                    <a style="color:green;" id="hahah" >已发布</a>
                </c:if>
            </td>
            <td>${trains.tr_title}</td>
            <td>${trains.tr_message}</td>
            <td>${trains.tr_time}</td>
            <td width="200px" align="center">
                <a href="addtrainstaff?tr_id=${trains.tr_id}">增删人员\</a>
                <c:if test="${trains.tr_state==1}">
                    <a id="no">修改\</a>
                    <a href="delTrain?tr_id=${trains.tr_id}">删除</a>
                </c:if>
                <c:if test="${trains.tr_state==0}">
                    <a id="yes">修改\</a>
                    <input type="hidden" value="${trains.tr_title}">
                    <input type="hidden" value="${trains.tr_message}">
                    <input type="hidden" value="${trains.tr_id}">
                    <a href="NOWdelTrain?tr_id=${trains.tr_id}">删除</a>
                </c:if>

            </td>
        </tr>
    </c:forEach>
    </table>
    <a id="newtrain">发起一场新的培训</a>
</c:if>
<div id="smallBox">
    <div id="smallSmallBox"></div>
</div>
</body>
</html>
