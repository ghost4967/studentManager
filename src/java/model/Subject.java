package model;


import java.util.ArrayList;
import model.Student;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * This is a model class represents a Subject entity
 * 
 * @author John Garron
 */
public class Subject {

    private int code;
    private String title;
    private String description;
    private List<Student> students;

    
    public Subject(int code, String titule, String description) {
        this.code = code;
        this.title = titule;
        this.description = description;
        this.students = new ArrayList<Student>();
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    
    public void setCode(int code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
}
