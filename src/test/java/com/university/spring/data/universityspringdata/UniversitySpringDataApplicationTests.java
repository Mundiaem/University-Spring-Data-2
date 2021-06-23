package com.university.spring.data.universityspringdata;

import com.university.spring.data.universityspringdata.domain.Person;
import com.university.spring.data.universityspringdata.domain.Student;
import com.university.spring.data.universityspringdata.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UniversitySpringDataApplicationTests {

    @Autowired
    StudentService studentService;

    @Test
    public void simpleStudentCrudExample() {
        boolean fullTime = true;
        studentService.saveStudent(new Student(fullTime, 20, "John", new Person("Jane", "Doe")));
        studentService.saveStudent(new Student(fullTime, 22, "Jane", new Person("John", "Doe")));
        studentService.saveStudent(new Student(fullTime, 18, "Michael", new Person("Mike", "Smith")));
        studentService.saveStudent(new Student(fullTime, 19, "Moore", new Person("Ally", "Kim")));
        System.out.println("\n ************ Original Students ****************");
        studentService.findAll().forEach(System.out::println);

        //age up the students
        studentService.findAll().forEach(student -> {
            student.setAge(student.getAge() + 1);
            studentService.saveStudent(student);
        });
        System.out.println("\n ******************** Student a year older *********************");
        studentService.findAll().forEach(System.out::println);
        studentService.deleteAll();
        System.out.println(" \n **************** Student removed *************************** ");
        studentService.findAll().forEach(System.out::println);


    }

}
