/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dao.SubjectDAO;
import java.util.ArrayList;
import model.Student;
import model.Subject;

/**
 *
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the student and subject.
 * 
 * @author John Garron
 */

@WebServlet("/")
public class ControllerServlet extends HttpServlet {

    private StudentDAO studentDAO;
    private SubjectDAO subjectDAO;

    public void init() {
        studentDAO = new StudentDAO();
        subjectDAO = new SubjectDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertStudent(request, response);
                    break;
                case "/delete":
                    deleteStudent(request, response);
                    break;
                case "/edit":
                    edit(request, response);
                    break;
                case "/update":
                    updateStudent(request, response);
                    break;
                case "/addSubjectToStudent":
                    addSubjectToStudent(request, response);
                    break;
                case "/saveStudentToSubject":
                    saveStudentToSubject(request, response);
                    break;
                case "/studentsBySubject":
                    studentBySubject(request, response);
                    break;
                case "/studentList":
                    listStudent(request, response);
                    break;
                case "/newSubject":
                    showNewFormSubject(request, response);
                    break;
                case "/insertSubject":
                    insertSubject(request, response);
                    break;
                case "/deleteSubject":
                    deleteSubject(request, response);
                    break;
                case "/editSubject":
                    editSubject(request, response);
                    break;
                case "/updateSubject":
                    updateSubject(request, response);
                    break;
                case "/searchStudentByAttribute":
                    searchStudentByAttribute(request, response);
                    break;
                default:
                    listSubject(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Student> listStudent = studentDAO.selectAllStudent();
        getServletContext().setAttribute("listStudent", listStudent);
        request.getRequestDispatcher("student-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create-student.jsp");
        dispatcher.forward(request, response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        response.sendRedirect("edit-student");
        Student student = studentDAO.selectStudent(Integer.parseInt(id));
        getServletContext().setAttribute("student", student);
        request.getRequestDispatcher("edit-student.jsp");
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Student newStudent = new Student(studentId, lastName, firstName);
        studentDAO.insertStudent(newStudent);
        request.getRequestDispatcher("student-list.jsp").forward(request, response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Student studentToUpdate = new Student(studentId, lastName, firstName);
        studentDAO.updateStudent(studentToUpdate);
        response.sendRedirect("student-list");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteStudent(id);
        response.sendRedirect("student-list");

    }

    private void addSubjectToStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int subjectCode = Integer.parseInt(request.getParameter("code"));
        List<Student> listStudent = studentDAO.selectAllStudent();
        getServletContext().setAttribute("subjectCode", subjectCode);
        getServletContext().setAttribute("listStudent", listStudent);
        request.getRequestDispatcher("add-student-to-subject.jsp").forward(request, response);
    }

    private void saveStudentToSubject(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int code = Integer.parseInt(request.getParameter("code"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        studentDAO.addSubjectToStudent(studentId, code);
        subjectDAO.addStudentToSubject(studentId, code);
        response.sendRedirect("/");
    }

    private void subjectByStudent(HttpServletRequest request, HttpServletResponse response) {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        List<Subject> subjects = studentDAO.selectAllSubjectByStudentId(studentId);
        getServletContext().setAttribute("subjects", subjects);
        request.getRequestDispatcher("subjects-by-student.jsp");
    }

    private void listSubject(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Subject> subjectList = subjectDAO.selectAllSubject();
        getServletContext().setAttribute("subjectList", subjectList);
        request.getRequestDispatcher("index.jsp");
    }

    private void showNewFormSubject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create-subject.jsp");
        dispatcher.forward(request, response);
    }

    private void editSubject(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String code = request.getParameter("code");
        response.sendRedirect("edit-subject");
        Subject subject = subjectDAO.selectSubject(Integer.parseInt(code));
        request.getSession().setAttribute("subject", subject);
    }

    private void insertSubject(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int code = Integer.parseInt(request.getParameter("code"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Subject newSubject = new Subject(code, title, description);
        subjectDAO.insertSubject(newSubject);
        response.sendRedirect("/");
    }

    private void updateSubject(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int code = Integer.parseInt(request.getParameter("code"));
        String title = request.getParameter("firstName");
        String description = request.getParameter("lastName");
        Subject subjectToUpdate = new Subject(code, title, description);
        subjectDAO.updateSubject(subjectToUpdate);
        response.sendRedirect("/");
    }

    private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int code = Integer.parseInt(request.getParameter("code"));
        subjectDAO.deleteSubject(code);
        response.sendRedirect("/");

    }

    private void studentBySubject(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int code = Integer.parseInt(request.getParameter("code"));
        //response.sendRedirect("subject-by-student");
        List<Student> students = subjectDAO.selectAllStudentbySubjectId(code);
        getServletContext().setAttribute("students", students);
        request.getRequestDispatcher("subject-by-student.jsp").forward(request, response);
    }

    private void searchStudentByAttribute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String attribute = request.getParameter("attribute");
        List<Student> listStudent = new ArrayList<Student>();
        switch (attribute) {
            case "studentId":
                //         found_students = studentDAO.searchById(Integer.parseInt(request.getParameter("value")));
                break;
            case "firstName":
                insertStudent(request, response);
                listStudent = studentDAO.searchByFirstName(request.getParameter("value"));
                break;
            case "lastName":
                deleteStudent(request, response);
                listStudent = studentDAO.searchByLastName(request.getParameter("value"));
                break;
        }
        getServletContext().setAttribute("listStudent", listStudent);
        request.getRequestDispatcher("student-list.jsp");
    }
}
