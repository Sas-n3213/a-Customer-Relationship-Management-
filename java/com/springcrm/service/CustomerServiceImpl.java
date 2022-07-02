package com.springcrm.service;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springcrm.entity.Customer;




	@Repository
	@Service
	public class CustomerServiceImpl implements CustomerService {
		@Autowired
		private SessionFactory factory;
		private Session session;
		

		
		
		public CustomerServiceImpl(SessionFactory factory) {
			this.factory = factory;
		    setSession();
		}
		private void setSession() {
			
			try {
				session = factory.getCurrentSession();
				
		}catch (Exception ex) {
			session = factory.openSession();
		}
		}
		
		
		@Override
		
		public List<Customer> findAll() {
		        session.beginTransaction();
		        List<Customer> customers = session.createQuery("from Customer").getResultList();
		        session.getTransaction().commit();
		        return customers;
		}

		@Override
		public Customer findById(int id) {
			session.beginTransaction();
			Customer customer = session.get(Customer.class,id);
			session.getTransaction().commit();
			return customer;
		}

		@Override
		public void save (Customer customer) {
			session.beginTransaction();
			session.save(customer);
			session.getTransaction().commit();
		}

		@Override
		public void deleteById (int id) {
			session.beginTransaction();
			Customer customer = session.get(Customer.class,id);
			session.delete(customer);
			session.getTransaction().commit();
		}
		
		}
		

