<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <body>
<jsp:forward page="/controller">
    <jsp:param name="commandName" value="toPage"/>
    <jsp:param name="forwardPage" value="cont.greetings"/>
</jsp:forward>
</body>
</head>
</html>
