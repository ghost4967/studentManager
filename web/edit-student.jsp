<%-- 
    Document   : edit-student
    Created on : 30 ene. de 2021, 21:34:15
    Author     : John Garron
--%>



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
                    <a class="navbar-brand"> Student Management App </a>
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
                                Edit student
                            </h2>
                        </caption>
                        <input type="hidden" name="id" value="<c:out value='${student.studentId}' />" />
                        <fieldset class="form-group">
                            <label>Student Id</label> <input type="number" value="<c:out value='${student.studentId}' />" class="form-control" name="studentId" required="required" readonly="readonly">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Student First Name</label> <input type="text" value="<c:out value='${student.firstName}' />" class="form-control" name="firstName" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Student Last Name</label> <input type="text" value="<c:out value='${student.lastName}' />" class="form-control" name="lastName">
                        </fieldset>
                        <button type="submit" class="btn btn-success">Save</button>
                    </form>
                </div>
            </div>
        </div>
    </body>

</html>