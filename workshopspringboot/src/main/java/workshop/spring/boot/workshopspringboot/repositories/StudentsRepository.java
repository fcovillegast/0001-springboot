package workshop.spring.boot.workshopspringboot.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import workshop.spring.boot.workshopspringboot.models.Course;
import workshop.spring.boot.workshopspringboot.models.Student;

@Repository
public interface StudentsRepository extends PagingAndSortingRepository<Student, Integer>{

	List<Student> findAll();

	List<Student> findAllByCourse(Course course);
}
