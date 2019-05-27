<%@ page import="com.iotek.model.Tourist" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.Delivery" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/14
  Time: 0:46
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
    <% Tourist tourist = (Tourist) session.getAttribute("tourist");%>
    <% List<Delivery> deliveries = (List<Delivery>) session.getAttribute("deliveries");%>
    <% List<Delivery> deliveries1 = (List<Delivery>) session.getAttribute("deliveries1");%>
    <%Integer sizeindex = (Integer) session.getAttribute("sizeindex");%>
</head>
    <body>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="myresume?tid=<%=tourist.getT_id()%>">我的简历</a><br>
            </div>
            <%
                if(deliveries!=null){
            %>
            <div class="navbar-header">
                <a class="navbar-brand" href="myinterview" style="color: red">您有<%=deliveries.size()%>条面试信息，其中有<%=deliveries1.size()%>条面试邀请,赶紧点击查看吧！</a>
            </div>

            <%
            }else if(deliveries==null){
            %>
            <div class="navbar-header">
                <a class="navbar-brand">您还没有投递过简历哦，赶紧去看一看吧！</a>
            </div>

            <%
                }
            %>
            <div class="navbar-header">
                <a class="navbar-brand" href="toindex">返回首页</a>
            </div>
        </div>
    </nav>


        <table class="table table-bordered" id="smalltable">
            <thead>
                <tr>
                    <td width="90px">发布者</td>
                    <td width="90px">招聘职位</td>
                    <td width="90px">预估薪资</td>
                    <td width="130px">要求</td>
                    <td width="90px"></td>
                    <td width="90px"></td>
                </tr>
            </thead>
            <tbody>
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
                            <form action="lookRecruit1" method="post">
                                <input type="submit" value="查看该招聘信息详情">
                                <input type="hidden" value="${recruit.ri_id}" name="ri_id">
                                <input type="hidden" value="<%=tourist.getT_id()%>" name="t_id">
                            </form>
                        </td>
                        <td  width="90px">
                            <form action="delivery" method="post">
                                <input type="submit" id="button" value="投递">
                                <input type="hidden" value="${recruit.ri_id}" name="ri_id">
                                <input type="hidden" value="<%=tourist.getT_id()%>" name="t_id">
                            </form>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
            <tr>
                <td colspan="6" align="center">
                    <%
                        for (int i = 1; i <=sizeindex ; i++) {
                    %>
                    <a href="indexdopage1?size=<%=i%>"><-<%=i%>-></a>
                    <%
                        }
                    %>
                </td>
            </tr>
            </tbody>
        </table>

    </body>
</html>
