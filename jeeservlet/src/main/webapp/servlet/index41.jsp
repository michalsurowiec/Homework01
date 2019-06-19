<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
if (request.getParameter("author") != null) {
    if (!(request.getParameter("author").equals(""))) {
        request.setAttribute("result", request.getParameter("author"));
    } else {
        request.setAttribute("result", "Ten parametr jest pusty");
    }
} else {
    request.setAttribute("result", "Ten parametr nie istnieje");
}
%>
<p>Wybrany autor - ${result}</p>
</body>
</html>
