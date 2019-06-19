<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Class aptent taciti sociosqu ad litora torquent per inceptos hymenaeos. Maecenas gravida, eros lacus, elementum velit. Nullam vulputate eu, tortor. Nullam fermentum turpis et odio. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per conubia nostra, per conubia nostra, per inceptos hymenaeos. Etiam at lectus varius justo. Suspendisse dolor sit amet, est. Nunc viverra consectetuer. Sed et ultrices sapien sed erat. Sed tristique senectus et quam. Phasellus ipsum dolor ullamcorper tellus pede nunc justo ipsum ac ligula. Cras tortor eros, varius nec, dignissim justo. Sed neque. Cras tempus enim vel nonummy sagittis. Nulla imperdiet neque. Maecenas semper feugiat. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Fusce convallis nec, bibendum leo, suscipit sit amet mauris. Nam quis ante. Pellentesque vel wisi. Donec in faucibus orci luctus nulla vitae ornare lobortis quis, pellentesque sagittis et, varius ac, sodales libero. Duis luctus et lacus vestibulum viverra sem nec diam elit, varius nec, sagittis libero. Duis vehicula ullamcorper. Nam mattis, mauris sit amet magna. Integer faucibus orci luctus diam eu auctor mi. Nullam volutpat, libero laoreet sit.
<br>
<c:if test="${empty cookie.unregistered.value}">
<form action="/newsletter" method="post">
    E-mail <input type="text" name="email"><br>
    Imię <input type="text" name="name"><br>
    <input type="submit" value="Wyślij">
    </c:if>
</form>
</body>
</html>
