package edu.miu.cs.cs425.eregistrar.service;

import edu.miu.cs.cs425.eregistrar.model.entity.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    Student updateStudent(Student student);

    void delete(Long id);

    List<Student> getAllStudent();

    Student getStudentById(Long id);
}
