package com.university.spring.data.universityspringdata.repository;

import com.university.spring.data.universityspringdata.domain.Course;
import com.university.spring.data.universityspringdata.view.CourseView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course>
    findByName(String name);
    List<Course> findByDepartmentChairMemberLastName(String chair);
    @Query("select c from Course c where  c.department.chair.member.lastName=:chair")
    List<Course>findByChairLastName(@Param("chair")String chairLastName);
    @Query("select c from Course c join c.prerequisites p where p.id=?1")
    List<Course> findCourseByPrerequisites(Long id);
    @Query("select new com.university.spring.data.universityspringdata.view.CourseView  (c.name, c.instructor.member.lastName, c.department.name) from Course c where c.id=?1")
    CourseView getCourseView(long courseId);
    List<Course> findByCredits(@Param("credits") int credits);
    Page<Course> findByCredits(@Param("credits") int credits, Pageable pageable);

}
