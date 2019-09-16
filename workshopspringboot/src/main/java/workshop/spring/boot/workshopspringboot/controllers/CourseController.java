package workshop.spring.boot.workshopspringboot.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import workshop.spring.boot.workshopspringboot.log.LogExecutionTime;
import workshop.spring.boot.workshopspringboot.models.Course;
import workshop.spring.boot.workshopspringboot.services.CourseService;


@RestController
@RequestMapping("courses")
public class CourseController {

	private CourseService courseService;

	@Autowired
	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	@RequestMapping
	@ResponseBody
	@LogExecutionTime
	public Page<Course> findAll(Pageable page) {
		return courseService.findAll(page);
	}
	
	@RequestMapping("/all")
	@ResponseBody
	public List<Course> findAll(){
		return courseService.findAll();
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Course> create(@Valid @RequestBody Course course ) {
		Course courseCreate = courseService.create(course);
		
		return new ResponseEntity<Course>(courseCreate, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Course> update(@PathVariable(value="id") Integer id , @RequestBody Course course) {
		Course courseSaved = courseService.update(id, course);
		
		return new ResponseEntity<Course>(courseSaved, HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Course> delete(@PathVariable(value="id") Integer id) {
		courseService.delete(id);
		
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}
	
	
}
