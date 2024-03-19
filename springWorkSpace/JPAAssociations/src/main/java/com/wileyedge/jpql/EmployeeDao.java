package com.wileyedge.jpql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.wileyedge.utility.EntityManagerHelper;

public class EmployeeDao implements IDao {

	@Override
	public List<Employee> getEmployees() {
		System.out.println("inside getEmployees");
		EntityManager em =  EntityManagerHelper.getEntityManager();
		List<Employee> list = em.createQuery("from Employee").getResultList();
		return list;
	}

	@Override
	public List<Employee> getEmployeesWithIdGrX(int x) {
		System.out.println("inside getEmployeesWithIdGrX");
		EntityManager em =  EntityManagerHelper.getEntityManager();
		Query q = em.createQuery("FROM Employee where id >= :id order by id");
		q.setParameter("id", x);
		List<Employee> list= q.getResultList();
		return list;

	}

	@Override
	public List<String> getEmployeeNames() {
		System.out.println("inside getEmployeeNames");
		EntityManager em =  EntityManagerHelper.getEntityManager();
		Query q = em.createQuery("select fname FROM Employee");
		List<String> list= q.getResultList();
		return list;
	}

	@Override
	public List<Employee> getXEmployees(int startindex, int number) {
		System.out.println("inside getXEmployees");
		EntityManager em =  EntityManagerHelper.getEntityManager();
		Query q = em.createQuery("FROM Employee ");
		q.setFirstResult(startindex);
		q.setMaxResults(number);
		List<Employee> list= q.getResultList();
		return list;
	}

	@Override
	public List<Employee> getEmployeesUsingNamedQuery() {
		System.out.println("inside getEmployeesUsingNamedQuery");
		EntityManager em =  EntityManagerHelper.getEntityManager();
		Query q = em.createNamedQuery("get.all");
		List<Employee> list= q.getResultList();
		return list;
	}

	@Override
	public List<Employee> getEmployeesUsingNativeNamedQuery() {
		System.out.println("inside getEmployeesUsingNativeNamedQuery");
		EntityManager em =  EntityManagerHelper.getEntityManager();
		Query q = em.createNamedQuery("get.all.native");
		List<Object[]> objlist= q.getResultList();
		List<Employee> list = new ArrayList<>();
		for(Object[] objArr:objlist) {
			int id = new Integer(objArr[0].toString());
			String fname = objArr[1].toString();
			String lname = objArr[2].toString();
			list.add(new Employee(id,fname,lname));
		}
		return list;
	}

	@Override
	public void displayEmployeesByIdFnameUsingCriteria(int id, String fname) {
		System.out.println("inside displayEmployeesByIdFnameUsingCriteria");
		EntityManager em =  EntityManagerHelper.getEntityManager();
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> cq =  cb.createQuery(Employee.class);
		Root<Employee> from = cq.from(Employee.class);
		Predicate predicate1 = cb.equal(from.get("id"), id);
		Predicate predicate2 = cb.equal(from.get("id"), id);
		cq.select(from);
		cq.where(cb.and(predicate1));
		cq.where(cb.and(predicate2));
		TypedQuery<Employee> q = em.createQuery(cq);
		List<Employee> list = q.getResultList();
		list.stream().forEach(System.out::println);
		tx.commit();
	}

	@Override
	public void createEmployee(String fname, String lname) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Employee e = new Employee(fname, lname);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e);
		tx.commit();
	}

}
