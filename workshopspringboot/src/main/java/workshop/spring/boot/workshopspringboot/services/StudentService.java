package workshop.spring.boot.workshopspringboot.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import workshop.spring.boot.workshopspringboot.models.Student;

 

public interface StudentService {
	
	Student create(Student student);
	
	Page<Student> findAll(Pageable page);
	
	List<Student> findAll();
	
	void delete(Integer id);
	
	Student findBy(Integer id);
	
	Student update(Integer id, Student student);
	
	List<Student> findByCourse(Integer idCourse);

	Student addCourse(Integer idCourse, Integer idStudent);

}
