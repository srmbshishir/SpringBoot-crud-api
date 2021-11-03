package com.example.crudrestapitry.Controller;

import com.example.crudrestapitry.Model.Student;
import com.example.crudrestapitry.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok().body(studentService.getStudents());
    }
    @GetMapping("/students/{id}")
    ResponseEntity<Student> getStudentById(@PathVariable long id){
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.ok().body(this.studentService.CreateService(student));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student student){
        student.setId(id);
        return ResponseEntity.ok().body(this.studentService.UpdateService(student));
    }

    @DeleteMapping("/students/{id}")
    public  HttpStatus deleteStudent(@PathVariable long id){
        this.studentService.DeleteStudent(id);
        return HttpStatus.OK;
    }

}
