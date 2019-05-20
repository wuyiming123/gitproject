<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.iotek.model.Departement" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iotek.model.Position" %><%--
  Created by IntelliJ IDEA.
  User: Maibenben
  Date: 2019/5/17
  Time: 12:29
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
    <%Departement thisdepartment = (Departement) session.getAttribute("thisdepartment");%>
    <%List<Position> positions = (List<Position>) session.getAttribute("positions");%>
    <script>
        $(function () {
            $(".addposition").click(function () {
                var po_deid = $(this).next().val();
                $("body").append("<form action='addPosition' method='post'><table>" +
                    "<tr><td>职位名称：</td>" +
                    "<td><input type='text' maxlength='30' placeholder='最多30字符' name='po_name' id='po_name' required>" +
                    "<input type='hidden' id='po_deid' name='po_deid'></td></tr>" +
                    "<tr><input type='submit' value='提交'></tr>" +
                    "</table></form>")
                $("#po_deid").val(po_deid);
            })
        })
    </script>
</head>
<body>
<table>
    <tr><td>部门号：</td><td><%=thisdepartment.getDe_id()%></td></tr>
    <tr><td>部门名：</td><td><%=thisdepartment.getDe_name()%></td></tr>
    <tr><td>部门职工人数：</td><td><%=thisdepartment.getDe_stcount()%></td></tr>
    <%if(positions.size()==0){
    %>
    <tr>
        <td><a class="addposition">请先添加一下职位吧！</a>
        <input type="hidden" name="po_deid<%=thisdepartment.getDe_id()%>" value="<%=thisdepartment.getDe_id()%>"></td><td></td>
    </tr>
    <%
    }else {
    %>
    <form action="delpositi" method="post">
    <tr>
        <td>
            <select name="po_id">
                <c:forEach items="${sessionScope.positions}"  var="positions">
                    <option value="${positions.po_id}">${positions.po_name}</option>
                </c:forEach>
            </select>
        </td>
        <td>
            <input type="submit" value="删除该职位">
        </td>
    </tr>
    </form>
    <%
    }
    %>
</table>
<a class="addposition">添加职位</a>
<input type="hidden" name="po_deid<%=thisdepartment.getDe_id()%>" value="<%=thisdepartment.getDe_id()%>">
</body>
</html>
