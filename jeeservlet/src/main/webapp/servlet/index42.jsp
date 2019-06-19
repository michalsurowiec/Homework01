<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach begin="2" end="10" step="2" var="numbers">
    ${numbers}<br>
</c:forEach>
</body>
</html>
