package com.university.spring.data.universityspringdata.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private Long id;
    @Column(name = "course_name")
    private String name;
    @Column
    private Integer credits;
    @ManyToOne
    @JoinColumn(name = "course_dept_id")
    private Department department;
    @OneToOne
    private Staff instructor;
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Course> prerequisites = new ArrayList<>();

    public Course(String name, Integer credits, Staff instructor, Department department) {
        this.name = name;
        this.credits = credits;
        this.instructor = instructor;
        this.department = department;
    }

    protected Course() {

    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Staff getInstructor() {
        return instructor;
    }

    public Department getDepartment() {
        return department;
    }

    public Course addPrerequisite(Course prerequisite) {
        prerequisites.add(prerequisite);
        return this;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", department=" + department.getName() +
                ", instructor=" + instructor.toString() +
                ", prerequisites=" + prerequisites.toString() +
                '}';
    }
}
