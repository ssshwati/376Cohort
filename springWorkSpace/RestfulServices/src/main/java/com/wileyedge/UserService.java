package com.wileyedge;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value="service")
public class UserService implements IService {
	
	@Autowired
//	@Qualifier(value="memoryDao")
	@Qualifier("dataJpaDao")
	private IDao dao;

	@Override
	public List<User> findAll() {
		System.out.println("Inside findAll() of UserService");
		return dao.findAll();
	}

	@Override
	public Optional<User> findById(int id) {
		System.out.println("Inside findById() method of UserService");
		return dao.findById(id);
	}

	@Override
	public User save(User user) {
		return dao.save(user);
	}

	@Override
	public User deleteById(int id) {
		
		return dao.deleteById(id);
	}
	
	@Override
	public List<User> findByName(String name) {
		System.out.println("inside findByName() of UserService.");
		return dao.findByName(name);
	}

}
