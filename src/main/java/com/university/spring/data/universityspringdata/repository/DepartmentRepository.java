package com.university.spring.data.universityspringdata.repository;

import com.university.spring.data.universityspringdata.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
