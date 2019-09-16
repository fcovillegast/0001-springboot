package workshop.spring.boot.workshopspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import workshop.spring.boot.workshopspringboot.models.Course;
import workshop.spring.boot.workshopspringboot.repositories.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;

	public CourseServiceImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	@Override
	public Page<Course> findAll(Pageable page) {
		return courseRepository.findAll(page);
	}

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course findBy(Integer idCourse) {
		Optional<Course> courseSaved = courseRepository.findById(idCourse);

		checkExistCourse(idCourse, courseSaved);

		return courseSaved.get();
	}

	@Override
	public Course create(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course update(Integer id, Course course) {

		Course courseSaved = this.findBy(id);

		courseSaved.setName(course.getName());

		return courseRepository.save(courseSaved);
	}

	private void checkExistCourse(Integer id, Optional<Course> course) {
		if (course == null || !course.isPresent()) {
			throw new CourseNotFoundException("Doesnt not exist the course with id:" + id);
		}
	}

	@Override
	public void delete(Integer id) {
		Course courseSaved = this.findBy(id);

		courseRepository.delete(courseSaved);
	}

}
