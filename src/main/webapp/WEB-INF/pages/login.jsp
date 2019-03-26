
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>${login}</h1>
        <nav>
            <ul id="menu">
                <li><a href="${pageContext.request.contextPath}/login/addRequest">Add request</a></li>
                <li><a href="${pageContext.request.contextPath}/login/deleteAccount">Delete your account</a></li>
                <li><a href="${pageContext.request.contextPath}/login/findResultNow">Complete request and take result immediately</a></li>
                <li><a href="${pageContext.request.contextPath}/login/distributeRequests">Start program to distribution requests type 4 (needs to be admin)</a></li>
            </ul>
        </nav> 
    </body>
</html>
