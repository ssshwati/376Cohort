package com.wileyedge;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("dataJpaDao")
public interface UserJPARepository extends JpaRepository<User, Integer>, IDao {
	@Query
	public List<User> findByName(String name);
	
	@Query
	public User findByNameAndId(String name, int id);
}

/*
 * findById : Retrieves one 
 * object based on the ID you pass it
 * findAll  :	Retrieves a list of all the 
 * objects of the type
 * save  :	Used for both creating and updating an object
 * deleteById : Deletes the object with the passed ID from the database
 */
/*
The Java Standard Library class Optional. JPA uses Optional<> as the return type for 
any built-in method that returns just one object, like findById. Optional exists to avoid 
returning null; instead, an Optional is returned that may or may not contain an object. 
You can then check the Optional to see if it has an object and pull it out.
*/

/*
 * JPA 
 * JPA uses query methods to handle anything past simple CRUD operations. The idea is that you 
 create interface method signatures in a specific format that the system can interpret and 
 convert to SQL queries behind the scenes.
 *
 *These method names always start with findBy, followed by the filters we want to apply 
 to the query
 eg List<Store> findByManager(String manager); internally is converted to
    SELECT * FROM store WHERE manager = ? 
 The question mark will be filled in by the parameter of the method.
 
 public List<User> findByName(String name);
 findByName(String name)
 */

