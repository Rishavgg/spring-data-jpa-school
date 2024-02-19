package com.rishav.spring.data.jpa.school.repository;

import com.rishav.spring.data.jpa.school.entity.Course;
import com.rishav.spring.data.jpa.school.entity.Teacher;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;
//
//    @Test
//    public void saveTeacherWithCourse() {
////        List<Course> coursesList = getCourseForTeacher();
//
//        Course course = Course.builder()
//                .credit(99)
//                .title("GO")
//                .build();
//
//        Teacher teacher = Teacher.builder()
//                .courses(List.of(course))
//                .firstName("Deepak")
//                .lastName("Gupta")
//                .build();
//
//        teacherRepository.save(teacher);
//    }

//    public List<Course> getCourseForTeacher() {
//        List<Course> list = courseRepository.findAllById(List.of(2L));
//        System.out.println(list);
//        return list;
//    }

}