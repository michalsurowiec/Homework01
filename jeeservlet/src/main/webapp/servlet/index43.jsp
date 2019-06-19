<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="someName" value="Witaj w coderslab."/>
<c:choose>
    <c:when test="${fn:contains(someName, 'test')}">
        <p>OK<p>
    </c:when>
    <c:otherwise>
        <p>NOT OK</p>
        </c:otherwise>
</c:choose>
</body>
</html>
