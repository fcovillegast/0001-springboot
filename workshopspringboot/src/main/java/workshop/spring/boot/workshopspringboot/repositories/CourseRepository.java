package workshop.spring.boot.workshopspringboot.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import workshop.spring.boot.workshopspringboot.models.Course;
import workshop.spring.boot.workshopspringboot.models.Student;

public interface CourseRepository extends PagingAndSortingRepository<Course, Integer>{

	List<Course> findAll(); 
	

}
