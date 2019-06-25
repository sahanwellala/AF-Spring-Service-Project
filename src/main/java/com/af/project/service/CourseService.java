package com.af.project.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.af.project.model.Courses;
import com.af.project.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

	public Courses createCourse(String name, String description, String status, ObjectId instructor,
			String isApproved) {
		return courseRepository
				.save(new Courses(name, description, status, instructor, Boolean.parseBoolean(isApproved)));
	}

	public List<Courses> getAll() {
		return courseRepository.findAll();
	}

	public Optional<Courses> getById(String id) {
		return courseRepository.findById(id);
	}

	public Courses updateCourse(ObjectId id, String name, String description, ObjectId instructor) {
		Courses c = courseRepository.findById(id).get();
		c.setName(name);
		c.setDescription(description);
		c.setInstructor(instructor);
		return courseRepository.save(c);
	}

	public void deleteByID(String id) {
		Courses c = courseRepository.findById(new ObjectId(id)).get();
		courseRepository.delete(c);
	}

	public void deleteByName(String name) {
		Courses c = courseRepository.findByName(name);
		courseRepository.delete(c);
	}

	public void deleteAll() {
		courseRepository.deleteAll();
	}
}
