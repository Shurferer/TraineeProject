<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
         <div class="form-container">

            <h1>Enter parameters</h1>

            <form:form method="POST" modelAttribute="access" class="form-horizontal">

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="login">Login</label>
                        <div class="col-md-7">
                            <form:input type="text" path="login" id="login" class="form-control input-sm"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="password">Password</label>
                        <div class="col-md-7">
                            <form:input type="text" path="password" id="password" class="form-control input-sm"/>

                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="Login" class="btn btn-primary btn-sm">
                    </div>
                </div>

            </form:form>

        </div>
    </body>
</html>
