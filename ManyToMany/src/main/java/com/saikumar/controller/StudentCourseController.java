package com.saikumar.controller;

import com.saikumar.entity.Course;
import com.saikumar.entity.Student;
import com.saikumar.respository.CourseRepository;
import com.saikumar.respository.StudentRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {

    private StudentRepository studentRepository;

    private CourseRepository courseRepository;

    public StudentCourseController(StudentRepository studentRepository,
                                   CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public Student saveStudentWithCourse(@RequestBody Student student){
      return   studentRepository.save(student);
    }

    @GetMapping
    public List<Student> findALlStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("student/{studentId}")
    public Student findStudent(@PathVariable Long studentId){
        return studentRepository.findById(studentId).orElse(null);
    }
    
    @GetMapping("/find/{name}")
    public List<Student> findStudentsContainingByName(@PathVariable String name){
        return studentRepository.findByNameContaining(name);
    }

    @GetMapping("/search/{price}")
    public List<Course> findCourseLessThanPrice(@PathVariable double price){
        return courseRepository.findByFeeLessThan(price);
    }
    
    @GetMapping("course/{courseId}")
    public Course findCourse(@PathVariable Long courseId){
        return courseRepository.findById(courseId).orElse(null);
    }

}
