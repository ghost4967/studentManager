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
                    <form action="saveStudentToSubject" method="post">
                        <caption>
                            <h2>
                                Add student to subject
                            </h2>
                        </caption>
                        <fieldset class="form-group">
                            <label>Code</label> 
                            <input type="text" value="<c:out value='${subjectCode}'/>" name="code" class="form-control" readonly="readonly">
                        </fieldset>
                        <fieldset class="form-group">
                        <select name="studentId">
                            <c:forEach items="${listStudent}" var="student">
                                <option value="${student.studentId}">${student.firstName} - ${student.lastName}</option>
                            </c:forEach>
                        </select>
                        </fieldset>
                        <button type="submit" class="btn btn-success">Save</button>
                    </form>
                </div>
            </div>
        </div>
    </body>

</html>