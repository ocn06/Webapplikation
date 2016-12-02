<%--
  Created by IntelliJ IDEA.
  User: NyBruger
  Date: 22-10-2016
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>loginAdmin</title>
</head>
<body>
you're an admin.
<table>
    <c:forEach items="${contentList}" var="element">
        <tr>
            <td>${element.content}</td>
        </tr>
    </c:forEach>
</table>


<form class="form-signin" method="POST" action="ContentController">

        <textarea rows="4" cols="50" name="newContent">
</textarea>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit text</button>
</form>


</body>
</html>
