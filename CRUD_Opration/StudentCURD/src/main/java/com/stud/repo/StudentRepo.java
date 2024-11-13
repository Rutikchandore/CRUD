package com.stud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stud.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
