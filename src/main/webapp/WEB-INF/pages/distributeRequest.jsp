<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DistribRequest</title>
    </head>
    <body>
        <h1>Result of working program:</h1>
        <c:forEach items="${map}" var="map">
            out value="${map}" <br>
        </c:forEach>   
    </body>
</html>
