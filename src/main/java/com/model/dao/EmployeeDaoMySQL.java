package com.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

import com.model.entities.Employee;
import com.model.utils.UtilsImpl;

public class EmployeeDaoMySQL implements RequestDao, UtilsImpl {

	private EntityManagerFactory emf;

	public EmployeeDaoMySQL() {

	}

	public EmployeeDaoMySQL(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public Employee findByLogin(String name, Integer password) {
		EntityManager em = emf.createEntityManager();

		try {
			String jqpl = "SELECT e FROM Employee e WHERE e.name = :pName AND e.password = :pPassword";

			em.getTransaction().begin();
			List<Employee> listEmp = em.createQuery(jqpl, Employee.class).setParameter("pName", name)
					.setParameter("pPassword", password).getResultList();
			em.getTransaction().commit();

			return listEmp.get(0);
		} catch (javax.persistence.NoResultException e) {
			JOptionPane.showMessageDialog(null, "Login e/ou senha inválida", "Erro", JOptionPane.ERROR_MESSAGE);
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void insert(Object type) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(type);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			;
		} finally {
			em.close();
		}

	}

	@Override
	public Integer findById(Object type) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			Employee emp = em.find(Employee.class, type);
			em.getTransaction().commit();
			if (emp == null) {
				System.out.println("Id não encontrado");
				return null;
			}
			return emp.getId();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return null;
		} finally {
			em.close();
		}

	}

	@Override
	public List<Employee> findAll() {
		EntityManager em = emf.createEntityManager();

		try {
			String jpql = "SELECT e FROM Employee e";
			em.getTransaction().begin();
			List<Employee> empList = em.createQuery(jpql, Employee.class).getResultList();
			em.getTransaction().commit();
			return empList;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return null;
		} finally {
			em.close();
		}

	}

	@Override
	public void update(Object type) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.merge(type);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	@Override
	public void delete(Object type) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			Employee emp = em.find(Employee.class, type);

			if (emp != null) {
				em.remove(emp);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	@Override
	public boolean existName(String name) {
		EntityManager em = emf.createEntityManager();

		try {
			String jqpl = "SELECT COUNT(e) FROM Employee e WHERE e.name = :pName";

			Long count = em.createQuery(jqpl, Long.class).setParameter("pName", name).getSingleResult();

			return count > 0;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().begin();
			return false;
		} finally {
			em.close();
		}

	}
}
