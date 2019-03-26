
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AddRequest</title>
    </head>
    <body>
        <h1>Please enter request parameters:</h1>

        <div class="form-container">

            <form:form method="POST" modelAttribute="request" class="form-horizontal">

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="job">Job</label>
                        <div class="col-md-7">
                            <form:input type="text" path="job" id="job" class="form-control input-sm"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="payment">Payment (1..1000)</label>
                        <div class="col-md-7">
                            <form:input type="text" path="payment" id="payment" class="form-control input-sm"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="hoursinWeek">HoursinWeek (8..40)</label>
                        <div class="col-md-7">
                            <form:input type="text" path="hoursinWeek" id="hoursinWeek" class="form-control input-sm"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="role">Choose your role</label>
                        <div class="col-md-7" class="form-control input-sm">
                            <form:radiobutton path="role" value="Worker" />Worker 
                            <form:radiobutton path="role" value="Employee" />Employee
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="Submit" class="btn btn-primary btn-sm">
                    </div>
                </div>

            </form:form>

        </div>
    </body>
</html>
