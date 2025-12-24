package com.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.model.entities.Employee;

public class EmployeeDaoMySQL implements RequestDao {

	private EntityManager em;

	public EmployeeDaoMySQL() {

	}

	public EmployeeDaoMySQL(EntityManager em) {
		this.em = em;
	}

	public Employee findByLogin(String name, Integer password) {
		try {
			String jqpl = "SELECT e FROM Employee e WHERE e.name = :pName AND e.password = :pPassword";
			return em.createQuery(jqpl, Employee.class)
					.setParameter("pName", name)
					.setParameter("pPassword", password)
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findName(Object type) {
		String name = (String) type;
		return name;
	}

	@Override
	public void update(Object type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object type) {
		// TODO Auto-generated method stub

	}

}
