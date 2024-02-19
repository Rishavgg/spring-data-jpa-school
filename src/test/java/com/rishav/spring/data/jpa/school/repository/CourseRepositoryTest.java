package com.rishav.spring.data.jpa.school.repository;

import com.rishav.spring.data.jpa.school.entity.Course;
import com.rishav.spring.data.jpa.school.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Rahul")
                .lastName("Shrivastva")
                .build();

        Course course = Course.builder()
                .title("Python")
                .teacher(teacher)
                .credit(84)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 1);

        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();

        long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();

        long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();


        System.out.println("totalElements " + totalElements);
        System.out.println("totalPages " + totalPages);
        System.out.println("Courses" + courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 1, Sort.by("title"));

        Pageable sortByCreditDescending = PageRequest.of(0, 1, Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 1, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println(courses);
//        System.out.println("sortByTitle " + sortByTitle);
//        System.out.println("sortByCreditDescending " + sortByCreditDescending);
//        System.out.println("sortByTitleAndCreditDesc " + sortByTitleAndCreditDesc);

    }


}