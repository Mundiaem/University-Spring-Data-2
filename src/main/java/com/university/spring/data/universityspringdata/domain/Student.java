package com.university.spring.data.universityspringdata.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//https://nullbeans.com/jpa-hibernate-accesstype-mappingexception/
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Long id;
    @Column(name = "student_name", nullable = false)
    private String name;
    @Column(name = "student_fulltime", nullable = false)

    private boolean fullTime;
    @Column(name = "student_age")
    private Integer age;
    @Embedded
    private Person attendee;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Enrollment", joinColumns = {@JoinColumn(name = "student_id")}, inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Course> courses = new ArrayList<Course>();

    public Student() {

    }


    public Student(boolean fullTime, Integer age, String name, Person attendee) {
        this.fullTime = fullTime;
        this.age = age;
        this.attendee = attendee;
        this.name = name;
    }
    public Student(Person attendee, boolean fullTime, Integer age) {
        this.attendee = attendee;
        this.fullTime = fullTime;
        this.age = age;
        courses = new ArrayList<>();
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullTime=" + fullTime +
                ", age=" + age +
                ", attendee=" + attendee +
                ", courses=" + courses +
                '}';
    }
}
