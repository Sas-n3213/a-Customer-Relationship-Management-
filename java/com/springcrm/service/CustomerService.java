package com.springcrm.service;
import java.util.List;

import com.springcrm.entity.Customer;

public interface CustomerService {
	

		public List<Customer> findAll();

		public void save(Customer Customer);

		public Customer findById(int id);

		public void deleteById(int id);

			
	}
	

	
