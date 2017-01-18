<%@ page import="jdk.nashorn.internal.ir.RuntimeNode" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2016/12/26
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%

//  java.util.HashMap map2 =(java.util.HashMap) request.getAttribute("p");
    //out.println(map2);
   // java.util.Map<String,Object> map2 =(java.util.Map<String,Object>) request.getParameter("p");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
show
<c:forEach items="${p}" var="mymap" >
    <c:out value="${mymap.key}" />
    <c:out value="${mymap.value.username}" />

</c:forEach>

</body>
</html>
