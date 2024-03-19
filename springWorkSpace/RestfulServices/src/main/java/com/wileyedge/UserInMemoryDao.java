package com.wileyedge;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository(value="memoryDao")
public class UserInMemoryDao implements IDao {

	private static List<User> users;
	private static int userCount;
	
	static {
		users = new ArrayList<User>();
		userCount=3;
		users.add(new User(1,"Deepika",new Date()));
		users.add(new User(2,"Sara",new Date()));
		users.add(new User(3,"Dharani",new Date()));
	}
	
	@Override
	public List<User> findAll() {
		System.out.println("Inside findAll() method of UserInMemoryDao");
		return users;
	}

	@Override
	public Optional<User> findById(int id) {
		System.out.println("Inside findById() method of UserInMemoryDao");
		User user = users.stream().filter((u)-> u.getId()==id).findAny().orElse(null);
		Optional<User> opt = Optional.ofNullable(user);
		return opt;
	}

	@Override
	public User save(User user) {
		System.out.println("inside save() of UserInMemoryDao");
		users.add(user);
		return user;
	}

	@Override
	public User deleteById(int id) {
		System.out.println("inside deleteById() of UserInMemoryDao");
		Iterator<User> iter = users.iterator();
		while(iter.hasNext()) {
			User user = iter.next();
			if(user.getId()==id) {
				iter.remove();
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
