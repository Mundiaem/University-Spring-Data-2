package com.university.spring.data.universityspringdata.repository;

import com.university.spring.data.universityspringdata.domain.Person;
import com.university.spring.data.universityspringdata.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    //Simple Query Methods
    List<Student> findByFullTime(boolean fullTime);

    List<Student> findByAge(Integer age);

    List<Student> findByAttendeeLastName(String last);


    //Query Methods with Clauses and Expressions

    Student findByAttendeeFirstNameAndAttendeeLastName(String firstName, String lastName);

    Student findByAttendee(Person person);

    List<Student> findByAgeGreaterThan(int minimumAge);

    List<Student> findByAttendeeLastNameIgnoreCase(String lastName);

    List<Student> findByAgeLessThan(int maximumAge);

    List<Student> findByAttendeeLastNameLike(String lastName);

    Student findFirstByOrderByAttendeeLastNameAsc();

    Student findTopByOrderByAgeDesc();

    List<Student> findTop3ByOrderByAgeDesc();

}
