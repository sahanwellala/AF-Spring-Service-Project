package com.af.project.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.af.project.model.Courses;

@Repository
public interface CourseRepository extends MongoRepository<Courses, String> {
	public Courses findByName(String name);

	public Optional<Courses> findById(ObjectId id);

	public Courses findByInstructor(ObjectId instructor);
}
