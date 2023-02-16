package com.saikumar.ManyToMany.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saikumar.ManyToMany.entity.Course;
import com.saikumar.ManyToMany.entity.Student;
import com.saikumar.ManyToMany.repository.CourseRepository;
import com.saikumar.ManyToMany.repository.StudentRepository;

@RestController
public class StudentCourseController {

	private StudentRepository studentRepository;
	private CourseRepository courseRepository;

	public StudentCourseController(StudentRepository studentRepository, CourseRepository courseRepository) {
		super();
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}
	
	@PostMapping("/saveStudent")
	public Student saveStudentWithCourse(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@GetMapping("/getStudents")
	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}
	
	@GetMapping("/getStudents/{studentId}")
	public Student findStudentById(@PathVariable Long studentId) {
		return studentRepository.findById(studentId).orElse(null);
	}
	
	@GetMapping("/search/{courseFee}")
	public List<Course> findCourseByPrice(@PathVariable Long courseFee) {
		return courseRepository.findByCourseFeeLessThan(courseFee);
	}
}
