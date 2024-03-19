package com.wileyedge.RestFulStudentRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {

	private final StudentService studService;

	@Autowired
	public StudentController(StudentService studService) {
		this.studService = studService;
	}

	@PostMapping("/save")
	public String registerStudent(@RequestBody Student stud) {
		return studService.registerStudent(stud);

	}

	@GetMapping("/findAll")
	public List<Student> findAll() {
		return studService.findAll();
	}

	@GetMapping("/findById/{id}")
	public Optional<Student> findById(@PathVariable int id) {
		return studService.findById(id);
	}

	
	@PutMapping("/UpdateById/{id}")
	public String UpdateById(@RequestBody Student stud,@PathVariable int id) {
		return studService.UpdateById(stud, id);
	}
	
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id) {
		studService.deleteById(id);
		return "deleted one user";
	}
	
}
