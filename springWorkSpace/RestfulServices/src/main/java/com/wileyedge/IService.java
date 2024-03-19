package com.wileyedge;

import java.util.List;
import java.util.Optional;

public interface IService {
	public List<User> findAll();
	Optional<User> findById(int id);
	public User save(User user);
	public User deleteById(int id);
	List<User> findByName(String name);
}
