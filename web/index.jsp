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
                <h3 class="text-center">List of Subject</h3>
                <hr>
                <div style="display: inline" class="container text-left">

                    <a href="<%=request.getContextPath()%>/create-subject" class="btn btn-success">
                        Add Subject</a>
                </div>
                <div style="display: inline; padding-left: 60%;" class="container text-right">

                    <a href="/studentList" class="btn btn-success">
                        Student List</a>
                </div>
                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Code</th>
                            <th>Title</th>
                            <th>Description</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="subject" items="${subjectList}" >
                            <tr>
                                <td>
                                    <a href="studentsBySubject?code=<c:out value='${subject.code}'/>">${subject.code}</a>
                                </td>
                                <td>
                                    <c:out value="${subject.title}" />
                                </td>
                                <td>
                                    <c:out value="${subject.description}" />
                                </td>
                                <td><a href="editSubject?code=<c:out value='${subject.code}'/>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; 
                                    <a href="deleteSubject?code=<c:out value='${subject.code}' />">Delete</a>
                                    <a href="addSubjectToStudent?code=<c:out value='${subject.code}' />" >
                                        Add Student</a></td>
                            </tr>
                        </c:forEach>
                        <!-- } -->
                    </tbody>

                </table>
            </div>
        </div>
    </body>

</html>