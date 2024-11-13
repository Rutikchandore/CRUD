package com.stud.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.stud.entity.Student;
import com.stud.repo.StudentRepo;

public class StudentService {

	  @Autowired
	    private StudentRepo studentRepository;

	    // CRUD methods
	    public List<Student> findAll() {
	    	return studentRepository.findAll();
	    	}
	    public Optional<Student> findById(Long id) { 
	    	return studentRepository.findById(id);
	    	}
	    public Student save(Student student) {
	    	
	    	return studentRepository.save(student);
	    	}
	    public void deleteById(Long id) 
	    { studentRepository.deleteById(id); }
	}