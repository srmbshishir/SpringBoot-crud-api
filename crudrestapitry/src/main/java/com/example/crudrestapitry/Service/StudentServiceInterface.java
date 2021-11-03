package com.example.crudrestapitry.Service;

import com.example.crudrestapitry.Model.Student;

import java.util.List;

public interface StudentServiceInterface {
    Student CreateService(Student student);
    Student UpdateService(Student student);
    List<Student> getStudents();
    Student getStudentById(long id);
    void DeleteStudent(long id);
}
