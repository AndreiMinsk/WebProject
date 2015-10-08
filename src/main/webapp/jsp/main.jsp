<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body style="background: url('/images/background.jpg')">
<jsp:include page="header.jsp"/><br/>
<jsp:include page="menu.jsp"/><br/>
<jsp:include page="${content}"/><br/>
<jsp:include page="footer.jsp"/>
</body>
</html>
