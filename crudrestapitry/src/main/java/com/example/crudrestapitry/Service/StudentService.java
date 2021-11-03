package com.example.crudrestapitry.Service;

import com.example.crudrestapitry.Exception.ResourceNotFound;
import com.example.crudrestapitry.Model.Student;
import com.example.crudrestapitry.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService implements StudentServiceInterface {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student CreateService(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student UpdateService(Student student) {
        Optional<Student> studentdb=this.studentRepository.findById(student.getId());

        if(studentdb.isPresent()){
            Student studentUpdate = studentdb.get();
            studentUpdate.setId(student.getId());
            studentUpdate.setName(student.getName());
            studentUpdate.setClassNum(student.getClassNum());
            return studentUpdate;
        }
        else{
            throw new ResourceNotFound("Record not found with id"+ student.getId());
         }
    }

    @Override
    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> studentdb=this.studentRepository.findById(id);
        if(studentdb.isPresent()){
            return studentdb.get();
        }
        else{
            throw new ResourceNotFound("Record not found with id"+ id);
        }
    }

    @Override
    public void DeleteStudent(long id) {
        Optional<Student> studentdb=this.studentRepository.findById(id);
        if(studentdb.isPresent()){
            this.studentRepository.delete(studentdb.get());
        }
        else{
            throw new ResourceNotFound("Record not found with id"+ id);
        }
    }
}
