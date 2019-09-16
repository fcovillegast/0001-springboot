package workshop.spring.boot.workshopspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import workshop.spring.boot.workshopspringboot.models.Course;
import workshop.spring.boot.workshopspringboot.models.Student;
import workshop.spring.boot.workshopspringboot.repositories.StudentsRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentsRepository studentRepository;
	private CourseService courseService;
	
	@Autowired
	public StudentServiceImpl(StudentsRepository studentRepository, CourseService courseService) {
		super();
		this.studentRepository = studentRepository;
		this.courseService = courseService;
	}

	@Override
	public Student create(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Page<Student> findAll(Pageable page) {
		return studentRepository.findAll(page);
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		Student student = this.findBy(id);
		
		studentRepository.delete(student);
	}

	@Override
	public Student findBy(Integer id) {
		Optional<Student> student = studentRepository.findById(id);
		
		checkStudentExist(id, student);
		
		return student.get();
	}

	@Override
	public Student update(Integer id, Student student) {
		Optional<Student> toSave= studentRepository.findById(id);
		
		checkStudentExist(id, toSave);
		toSave.get().setName(student.getName());
		toSave.get().setRut(student.getRut());
		
		studentRepository.save(toSave.get());
		
		return toSave.get();
	}
	
	private void checkStudentExist(Integer id, Optional<Student> student) {
		if(!student.isPresent()) {
			throw new StudentNotFoundException("No se ha encontrado el id:"+id);
		}
	}
	
	@Override
	public List<Student> findByCourse(Integer idCourse) {
		Course courseSaved = courseService.findBy(idCourse);
		
		return studentRepository.findAllByCourse(courseSaved);
	}
	
	@Override
	public Student addCourse(Integer idCourse, Integer idStudent) {
		Student studentSaved  = this.findBy(idStudent);
		Course courseSaved = courseService.findBy(idCourse);
		
		studentSaved.setCourse(courseSaved);
		
		studentRepository.save(studentSaved);
		
		return studentSaved;
	}


}
