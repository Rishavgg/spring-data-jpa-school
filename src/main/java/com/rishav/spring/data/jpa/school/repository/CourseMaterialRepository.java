package com.rishav.spring.data.jpa.school.repository;

import com.rishav.spring.data.jpa.school.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {


}
