package com.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.model.entities.Employee;
import com.model.entities.WorkingPeople;
import com.model.utils.UtilsImpl;

public class EmployeeDaoMySQL implements RequestDao, UtilsImpl {

	private EntityManager em;

	public EmployeeDaoMySQL() {

	}

	public EmployeeDaoMySQL(EntityManager em) {
		this.em = em;
	}

	public Employee findByLogin(String name, Integer password) {
		try {
			String jqpl = "SELECT e FROM Employee e WHERE e.name = :pName AND e.password = :pPassword";
			return em.createQuery(jqpl, Employee.class).setParameter("pName", name).setParameter("pPassword", password)
					.getSingleResult();
		} catch (javax.persistence.NoResultException e) {
			JOptionPane.showMessageDialog(null, "Login e/ou senha inválida", "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	@Override
	public void insert(Object type) {
		em.persist(type);

	}

	@Override
	public Integer findById(Object type) {
		Employee emp = em.find(Employee.class, type);
		
		if(emp == null) {
			System.out.println("Id não encontrado");
			return null;
		}
		
		return emp.getId();
	}

	@Override
	public List<Employee> findAll() {
		String jpql = "SELECT e FROM Employee e";

		List<Employee> empList = em.createQuery(jpql, Employee.class).getResultList();
		return empList;
	}

	@Override
	public void update(Object type) {
		em.merge(type);

	}

	@Override
	public void delete(Object type) {
		Employee emp = em.find(Employee.class, type);
		
		if(emp != null) {
			em.remove(emp);
		}
	}

	@Override
	public boolean existName(String name) {
		String jqpl = "SELECT COUNT(e) FROM Employee e WHERE e.name = :pName";

		Long count = em.createQuery(jqpl, Long.class).setParameter("pName", name).getSingleResult();

		return count > 0;
	}

}
