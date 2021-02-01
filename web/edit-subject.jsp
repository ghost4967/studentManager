<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Student Management Application</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                <div>
                    <a class="navbar-brand"> Subject Management App </a>
                </div>
            </nav>
        </header>
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <form action="update" method="post">
                        <caption>
                            <h2>
                                Edit subject
                            </h2>
                        </caption>
                        <fieldset class="form-group">
                            <label>Code</label> <input type="number" value="<c:out value='${subject.code}' />" class="form-control" name="studentId" required="required" readonly="readonly">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Title</label> <input type="text" value="<c:out value='${subject.title}' />" class="form-control" name="firstName" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Description</label> <input type="text" value="<c:out value='${subject.description}' />" class="form-control" name="lastName">
                        </fieldset>
                        <button type="submit" class="btn btn-success">Save</button>
                    </form>
                </div>
            </div>
        </div>
    </body>

</html>