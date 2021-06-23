package com.university.spring.data.universityspringdata.service;

import com.university.spring.data.universityspringdata.domain.Student;
import com.university.spring.data.universityspringdata.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Iterable<Student> findAll() {
        return studentRepository.findAll();

    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }
}
