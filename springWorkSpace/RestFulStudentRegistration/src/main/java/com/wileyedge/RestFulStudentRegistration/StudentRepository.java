package com.wileyedge.RestFulStudentRegistration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("dataJpaDao")
public interface StudentRepository extends JpaRepository<Student, Integer> {
//	List<Student> findByAge(int id);
	Student findByEmail(String email);
	
}
