package com.rishav.spring.data.jpa.school.repository;

import com.rishav.spring.data.jpa.school.entity.Gaurdian;
import com.rishav.spring.data.jpa.school.entity.Student;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Disabled
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("rishavdadwal1@gmail.com")
                .firstName("Rishav")
                .lastName("Dadwal")
//                .gaurdianName("Rajesh")
//                .gaurdianEmail("rajudadwal1@gamil.com")
//                .gaurdianMobile("1919192929")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println(studentList);
    }

    @Test
    @Disabled
    public void saveByGaurdian() {
        Gaurdian gaurdian = Gaurdian.builder()
                .name("KokilaMom")
                .mobile("8583948908")
                .email("kokilamom@gmail.com")
                .build();

        Student student = Student.builder()
                .firstName("Kokila")
                .lastName("Ramaunjan")
                .emailId("kokila123@gmail.com")
                .gaurdian(gaurdian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void findByName() {
        List<Student> studentList = studentRepository.findByFirstName("Kokila");

        System.out.println(studentList);
    }

    @Test
    public void findByNameCharacters() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("is");

        System.out.println(studentList);
    }

    @Test
    @Disabled
    public void printStudentByLastName() {
        List<Student> studentList = studentRepository.findByLastName("Dadwal");

        System.out.println(studentList);
    }

    @Test
    public void findByNameBasedOnGaurdiansName() {
        List<Student> studentList = studentRepository.findByGaurdianName("Rajesh");

        System.out.println(studentList);
    }

    @Test
    public void printGetStudentByEmailId() {
        List<Student> studentList = studentRepository.getStudentByEmailAddress("rishavdadwal1@gmail.com");

        System.out.println(studentList);

    }

    @Test
    public void printGetStudentFirstNameByEmailId() {
        String studentName = studentRepository.getStudentFirstNameByEmailAddress("rishavdadwal1@gmail.com");

        System.out.println(studentName);

    }

    @Test
    public void printGetStudentByEmailIdNative() {
        List<Student> studentList = studentRepository.getStudentByEmailAddressNative("kokila123@gmail.com");

        System.out.println(studentList);
    }

    @Test
    public void printGetStudentFirstNameByEmailIdParams() {
        String studentName = studentRepository.getStudentFirstNameByEmailAddressParams("rishavdadwal1@gmail.com");

        System.out.println(studentName);
    }

    @Test
    public void updateStudentNameByEmailTest() {
        int student = studentRepository.updateStudentNameByEmail("Bavra", "kokila123@gmail.com");

        System.out.println(student);
    }


}