package com.wileyedge.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wileyedge.model.Student;

@Repository(value="dao")
public class StudentDao implements IDao {
	
	@Autowired
	private JdbcTemplate template;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveStudent(Student stud) {
		String sql = "insert into student (sname,age,mobile,email,address) values(?,?,?,?,?)";
		template.update(sql, stud.getName(), stud.getAge(), stud.getMobile(),stud.getEmail(), stud.getAddress());
	}

}
