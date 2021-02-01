/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Student;

import java.util.List;
import model.Subject;

/**
 *
 * This DAO class provides CRUD database operations for the
 * table students in the database.
 * 
 * @author John Garron
 */
public class StudentDAO {

    private List<Student> mock_students;

    public StudentDAO() {
        mock_students = new ArrayList<Student>();
        Student carlos = new Student(123456, "Perez", "Carlos");
        Student juan = new Student(123457, "Centellas", "Juan");
        Student andy = new Student(123458, "Camacho", "Andy");
        mock_students.add(carlos);
        mock_students.add(juan);
        mock_students.add(andy);
    }

    public void insertStudent(Student student) {
        mock_students.add(student);
    }

    public Student selectStudent(int id) {
        for (Student mock_student : mock_students) {
            if (mock_student.getStudentId() == id) {
                return mock_student;
            }
        }
        Student andy = new Student(123458, "Camacho", "Andy");
        return andy;
    }

    public List<Student> selectAllStudent() {
        return mock_students;
    }

    public boolean deleteStudent(int id) {
        boolean rowDeleted = false;
        Student studentToRemove = null;
        for (Student mock_student : mock_students) {
            if (mock_student.getStudentId() == id) {
                studentToRemove = mock_student;
                break;
            }
        }
        if (studentToRemove != null) {
            mock_students.remove(studentToRemove);
            rowDeleted = true;
        }
        return rowDeleted;
    }

    public boolean updateStudent(Student student) {
        boolean rowUpdated = false;
        for (Student mock_student : mock_students) {
            if (mock_student.getStudentId() == student.getStudentId()) {
                mock_student.setFirstName(student.getFirstName());
                mock_student.setLastName(student.getLastName());
                rowUpdated = true;
            }
        }
        return rowUpdated;
    }

    public boolean addSubjectToStudent(int id, int subject_code) {
        boolean rowUpdated = false;
        SubjectDAO subjectDAO = new SubjectDAO();
        Subject subject = subjectDAO.selectSubject(subject_code);
        for (Student mock_student : mock_students) {
            if (mock_student.getStudentId() == id) {
                mock_student.getSubjects().add(subject);
            }
        }
        return rowUpdated;
    }

    public List<Subject> selectAllSubjectByStudentId(int id) {
        List<Subject> subjects = new ArrayList<Subject>();
        for (Student mock_student : mock_students) {
            if (mock_student.getStudentId() == id) {
                subjects = mock_student.getSubjects();
            }
        }
        return subjects;
    }

    public List<Student> searchById(int studentId) {
        List<Student> students = new ArrayList<Student>();
        for (Student mock_student : mock_students) {
            if (mock_student.getStudentId() == studentId) {
                students.add(mock_student);
            }
        }
        return students;
    }

    public List<Student> searchByFirstName(String firstName) {
        List<Student> students = new ArrayList<Student>();
        for (Student mock_student : mock_students) {
            if (mock_student.getFirstName().contains(firstName)) {
                students.add(mock_student);
            }
        }
        return students;
    }

    public List<Student> searchByLastName(String lastName) {
        List<Student> students = new ArrayList<Student>();
        for (Student mock_student : mock_students) {
            if (mock_student.getLastName().contains(lastName)) {
                students.add(mock_student);
            }
        }
        return students;
    }
}
