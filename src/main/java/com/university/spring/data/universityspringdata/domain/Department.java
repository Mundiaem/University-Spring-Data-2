package com.university.spring.data.universityspringdata.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dept_id")
    private Long id;
    @Column(name = "dept_name")
    private String name;
    @OneToMany(targetEntity = Course.class, mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Course> courses = new ArrayList<Course>();
    @OneToOne
    private Staff chair;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public Department(String name, Staff chair) {
        this.name = name;
        this.chair = chair;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void addCourse(Course course) {
//        courses.add(course);
//    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}
