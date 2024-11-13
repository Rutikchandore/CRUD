package com.stud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stud.entity.Student;
import com.stud.sevice.StudentService;

@RestController
@RequestMapping("/students")

public class StudentController {

	 @Autowired
	    private StudentService studentService;

	    @GetMapping
	    public List<Student> getAllStudents() { return studentService.findAll(); }

	    @GetMapping("/{id}")
	    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
	        return studentService.findById(id)
	            .map(ResponseEntity::ok)
	            .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public Student createStudent(@RequestBody Student student) { return studentService.save(student); }

	    @PutMapping("/{id}")
	    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
	        return studentService.findById(id).map(student -> {
	            student.setName(studentDetails.getName());
	            student.setAge(studentDetails.getAge());
	            student.setEmail(studentDetails.getEmail());
	            return ResponseEntity.ok(studentService.save(student));
	        }).orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
	        studentService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	}
