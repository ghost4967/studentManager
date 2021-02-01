/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Student;
import model.Subject;

/**
 *
 * This DAO class provides CRUD database operations for the table subjects in
 * the database.
 *
 * @author John Garron
 */
public class SubjectDAO {

    private List<Subject> mock_subjects;
    public Object searchById;

    public SubjectDAO() {
        mock_subjects = new ArrayList<Subject>();
        Subject physical = new Subject(789654, "Physical", "Science that studies"
                + " the properties of matter and energy.");
        Subject math = new Subject(987458, "Math", "Science that studies the "
                + "properties of numbers and the relationships that are "
                + "established between them.");
        Subject literature = new Subject(864476, "Literature", "Theory of the "
                + "composition of works written in prose or verse.");
        Student andy = new Student(123458, "Camacho", "Andy");
        math.getStudents().add(andy);
        mock_subjects.add(physical);
        mock_subjects.add(math);
        mock_subjects.add(literature);
    }

    public void insertSubject(Subject subject) {
        mock_subjects.add(subject);
    }

    public Subject selectSubject(int id) {
        for (Subject mock_subject : mock_subjects) {
            if (mock_subject.getCode() == id) {
                return mock_subject;
            }
        }
        return null;
    }

    public List<Subject> selectAllSubject() {
        return mock_subjects;
    }

    public boolean deleteSubject(int id) {
        boolean rowDeleted = false;
        Subject subjectToRemove = null;
        for (Subject mock_subject : mock_subjects) {
            if (mock_subject.getCode() == id) {
                subjectToRemove = mock_subject;
                break;
            }
        }
        if (subjectToRemove != null) {
            mock_subjects.remove(subjectToRemove);
            rowDeleted = true;
        }
        return rowDeleted;
    }

    public boolean updateSubject(Subject subject) {
        boolean rowUpdated = false;
        for (Subject mock_subject : mock_subjects) {
            if (mock_subject.getCode() == subject.getCode()) {
                mock_subject.setTitle(subject.getTitle());
                mock_subject.setDescription(subject.getDescription());
                rowUpdated = true;
            }
        }
        return rowUpdated;
    }

    public boolean addStudentToSubject(int id, int subject_code) {
        boolean rowUpdated = false;
        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.selectStudent(id);
        for (Subject mock_subject : mock_subjects) {
            if (mock_subject.getCode() == subject_code) {
                mock_subject.getStudents().add(student);
            }
        }
        return rowUpdated;
    }

    public List<Student> selectAllStudentbySubjectId(int code) {
        List<Student> students = new ArrayList<Student>();
        for (Subject mock_subject : mock_subjects) {
            if (mock_subject.getCode() == code) {
                students = mock_subject.getStudents();
            }
        }
        return students;
    }

}
