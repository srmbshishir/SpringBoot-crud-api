package com.example.crudrestapitry.Repository;

import com.example.crudrestapitry.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
