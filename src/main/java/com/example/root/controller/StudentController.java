package com.example.root.controller;

import com.example.root.entities.Student;
import com.example.root.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

	@Autowired
	StudentRepository repository;

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	@Transactional(readOnly = true)
	@Cacheable("student-cache")
	public List<Student> getAllstudents() {
		LOGGER.info("Executing : getAllStudents()");
		return repository.findAll();
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public Optional<Student> getStudent(@PathVariable("id") int id) {
		LOGGER.info("Executing : getStudent(" + id + ")");
		return repository.findById(id);
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public Student createStudent(@RequestBody Student student) {
		LOGGER.info("Executing : createStudent() " + student.getName() + " created");
		return repository.save(student);
	}

	@RequestMapping(value = "/students", method = RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) {
		LOGGER.info("Executing : updateStudent(" + student.getId() + ")");
		return repository.save(student);
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	@CacheEvict("student-cache")
	public void deleteStudent(@PathVariable("id") int id) {
		LOGGER.info("Executing : deleteStudent(" + id + ")");
		repository.deleteById(id);
	}
}
