package workshop.spring.boot.workshopspringboot.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import workshop.spring.boot.workshopspringboot.models.Course;
import workshop.spring.boot.workshopspringboot.models.Student;

public interface CourseService {

	Page<Course> findAll(Pageable page);
	
	List<Course> findAll();
	
	Course findBy(Integer idCourse);
	
	Course create(Course course);
	
	Course update(Integer id, Course course); 
	
	void delete(Integer id);
	
//	Course addStudent(Integer idCourse, Integer idStudent);
	

}
