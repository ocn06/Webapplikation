<%--
  Created by IntelliJ IDEA.
  User: NyBruger
  Date: 22-10-2016
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
Good job!
<table>
    <c:forEach items="${contentList}" var="element">
    <tr>
        <td>${element.content}</td>
    </tr>
    </c:forEach>
</body>
</html>
