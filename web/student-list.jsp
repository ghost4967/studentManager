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

                    <a href="<%=request.getContextPath()%>/create-student" class="btn btn-success">Add
                        New Student</a>
                </div>
                <br>
                <div>
                    <form>
                        <fieldset class="form-group">
                            <input type="text" value="" name="value" class="form-control" required="required">
                            <select name="attribute">
                                <option value="studentId">Id</option>
                                <option value="firstName">firstName</option>
                                <option value="lastName">lastName</option>
                            </select>
                            <button href="searchStudentByAttribute?attribute=attribute?value=value" type="submit" class="btn btn-success">search</button>
                        </fieldset>
                    </form>
                </div>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="student" items="${listStudent}" >
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
                                <td><a href="edit?id=<c:out value='${student.studentId}'/>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; 
                                    <a href="delete?id=<c:out value='${student.studentId}' />">Delete</a></td>
                            </tr>
                        </c:forEach>
                        <!-- } -->
                    </tbody>

                </table>
            </div>
        </div>
    </body>

</html>
