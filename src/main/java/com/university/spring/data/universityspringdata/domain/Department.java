package com.university.spring.data.universityspringdata.domain;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
