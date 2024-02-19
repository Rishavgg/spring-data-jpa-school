package com.rishav.spring.data.jpa.school.repository;

import com.rishav.spring.data.jpa.school.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String name);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastName(String name);

    public List<Student> findByGaurdianName(String name);

//    JPQL (based on classes we have created not table in the DB)
    @Query("SELECT s FROM Student s WHERE s.emailId = ?1")
    public List<Student> getStudentByEmailAddress(String email);

    @Query("SELECT s.firstName FROM Student s WHERE s.emailId = ?1")
    public String getStudentFirstNameByEmailAddress(String email);

    // Native query
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    public List<Student> getStudentByEmailAddressNative(String email);

    @Query("SELECT s.firstName FROM Student s WHERE s.emailId = :emailId")
    public String getStudentFirstNameByEmailAddressParams(@Param("emailId") String email);


    // as it is a modifying query so there should be transactional in it (a translation will be created delete update and all
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student SET first_name = ?1 WHERE email_address = ?2",
            nativeQuery = true
    )
    public int updateStudentNameByEmail(String FirstName, String email);

}
