package com.af.project.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Courses {
	@Id
	String id;
	String name, description, status;
	ObjectId instructor;
	Boolean isApproved;

	public Courses(String name, String description, String status, ObjectId instructor, Boolean isApproved) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
		this.instructor = instructor;
		this.isApproved = isApproved;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ObjectId getInstructor() {
		return instructor;
	}

	public void setInstructor(ObjectId instructor) {
		this.instructor = instructor;
	}

	public Boolean isApproved() {
		return isApproved;
	}

	public void setApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

}
