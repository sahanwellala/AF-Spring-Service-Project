package com.af.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.af.project.model.Courses;
import com.af.project.service.CourseService;

@CrossOrigin
@RequestMapping("/courses")
@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Map<String, String> createCourse(@RequestBody Map<String, String> payload) {
		Courses c = courseService.createCourse(payload.get("name"), payload.get("description"), payload.get("status"),
				new ObjectId(payload.get("instructor")), payload.get("isApproved"));
		HashMap<String, String> courseMap = new HashMap<>();
		courseMap.put("name", c.getName());
		courseMap.put("description", c.getDescription());
		courseMap.put("instructor", c.getInstructor().toString());
		courseMap.put("success", "true");
		courseMap.put("status", c.getStatus().toString());
		courseMap.put("isApproved", c.isApproved().toString());
		return courseMap;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Map<String, String> updateCourse(@RequestBody Map<String, String> payload, @RequestParam String id) {
		Courses c = courseService.updateCourse(new ObjectId(id), payload.get("name"), payload.get("description"),
				new ObjectId(payload.get("instructor")));
		HashMap<String, String> courseMap = new HashMap<>();
		courseMap.put("name", c.getName());
		courseMap.put("description", c.getDescription());
		courseMap.put("instructor", c.getInstructor().toString());
		courseMap.put("success", "true");
		return courseMap;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Courses> getAll() {
		return courseService.getAll();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public Map<String, String> deleteCourse(@RequestParam String id) {
		HashMap<String, String> courseMap = new HashMap<>();
		courseService.deleteByID(id);
		courseMap.put("success", "true");
		return courseMap;
	}
}
