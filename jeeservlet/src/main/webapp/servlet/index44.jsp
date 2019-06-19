<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${greeting}<br>
<form action="/servlet412" method="post">
    <select name="selectedLang">
        <option value="pl">Polski</option>
        <option value="en">English</option>
        <option value="de">Deutsch</option>
        <option value="es">Espaniol</option>
        <option value="fr">Francoise</option>
    </select><br>
    <input type="submit" value="Wyślij">
</form>
</body>
</html>
