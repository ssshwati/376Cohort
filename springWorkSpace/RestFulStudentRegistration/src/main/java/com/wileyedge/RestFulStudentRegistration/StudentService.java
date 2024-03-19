package com.wileyedge.RestFulStudentRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


	@Autowired
	StudentRepository studRepo;

	public String registerStudent(Student stud) {
//		Optional<Student> existingStud = Optional.ofNullable(studRepo.findByEmail(stud.getEmail()));
//		if (existingStud.isPresent()) {
//			return "user already exists with same id";
//		} else {
			try {
				System.out.println(stud.toString());
				studRepo.save(stud);
				return "Student Saved";
			} catch (Exception e) {
				return "invalid data";
			}
//		}
	}

	public List<Student> findAll() {
		return studRepo.findAll();
	}

	public Optional<Student> findById(int id) {
		return studRepo.findById(id);
	}

	public String deleteById(int id) {
		Optional<Student> existingStud = studRepo.findById(id);
		if (existingStud.isPresent()) {
			studRepo.deleteById(id);
			return "deleted one user";
		} else {
			return "user not found";
		}
	}

	public String UpdateById(Student stud, int id) {
		Optional<Student> existingStud = studRepo.findById(id);
		if (existingStud.isPresent()) {
			Student result = existingStud.get();
			result.setSname(stud.getSname());
			result.setAge(stud.getAge());
			result.setMobile(stud.getMobile());
			result.setEmail(stud.getEmail());
			result.setAddress(stud.getAddress());
			studRepo.save(result);
			return "data updated";
		} else {
			return "user not found";
		}

	}

}
