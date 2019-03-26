<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration form</title>
    </head>
    <body>
        <h1>Please enter your name and phone</h1>
        <div class="form-container">

            <form:form method="POST" modelAttribute="client" class="form-horizontal">

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="name">Name</label>
                        <div class="col-md-7">
                            <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="phone">Phone (Numbers)</label>
                        <div class="col-md-7">
                            <form:input type="text" path="phone" id="phone" class="form-control input-sm"/>

                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="Save" class="btn btn-primary btn-sm">
                    </div>
                </div>
            </form:form>
        </form>
</body>
</html>