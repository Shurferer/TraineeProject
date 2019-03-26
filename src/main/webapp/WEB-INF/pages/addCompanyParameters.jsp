
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CompanyParameters</title>
    </head>
    <body>
        <h1>Create</h1>
        <div class="form-container">

            <form:form method="POST" modelAttribute="company" class="form-horizontal">

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="name">Company label</label>
                        <div class="col-md-7">
                            <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="phone">Phone (numbers)</label>
                        <div class="col-md-7">
                            <form:input type="text" path="phone" id="phone" class="form-control input-sm"/>
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
