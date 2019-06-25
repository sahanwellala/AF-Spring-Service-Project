package com.af.project;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.af.project.model.Courses;
import com.af.project.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AfProjectApplicationTests {

	@Autowired
	private CourseRepository repo;

	@Test
	public void contextLoads() {

		// Unit testing done for the Courses
		Optional<Courses> courses = repo.findById("5d0e57dac78b28053ca2490d");
		Courses course = courses.get();

		assertThat(course.getName()).isEqualTo("Application Frameworks");

//		assertThat(course.getDescription()).isEqualTo("For 2nd Year");
//
//		assertThat(course.getStatus()).isEqualTo("Approved");

	}

}
