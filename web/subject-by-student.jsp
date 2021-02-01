<%-- 
    Document   : StudentList
    Created on : 31 ene. de 2021, 16:55:37
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
                    <a class="navbar-brand"> Student
                        Management App </a>
                </div>


            </nav>
        </header>
        <br>

        <div class="row">
            <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

            <div class="container">
                <h3 class="text-center">List of Student</h3>
                <hr>
                <div style="display: inline;" class="container text-left">

                </div>
                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="student" items="${students}" >
                            <tr>
                                <td>
                                    <c:out value="${student.studentId}" />
                                </td>
                                <td>
                                    <c:out value="${student.firstName}" />
                                </td>
                                <td>
                                    <c:out value="${student.lastName}" />
                                </td>
                            </tr>
                        </c:forEach>
                        <!-- } -->
                    </tbody>

                </table>
            </div>
        </div>
    </body>

</html>
