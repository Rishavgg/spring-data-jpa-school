package com.rishav.spring.data.jpa.school.repository;

import com.rishav.spring.data.jpa.school.entity.Course;
import com.rishav.spring.data.jpa.school.entity.CourseMaterial;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterialWithCourse() {
        Course course = Course.builder()
                .title("DSA")
                .credit(99)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(course)
                .url("dsa.io")
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void fetchAllCourseMaterial() {
        List<CourseMaterial> list = repository.findAll();

        System.out.println(list);
    }

}