package com.springcrm.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springcrm.entity.Customer;
import com.springcrm.service.CustomerService;





@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/register")
	public String registerCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@RequestMapping("/update")
	public String updateCustomer(@RequestParam("id") int id, Model model) {
		Customer customer = customerService.findById(id);
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@RequestMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("email") String email) {

		if (!firstname.equals("") || !lastname.equals("") || !email.equals("")) {
			Customer customer = null;
			if (id != 0) {
				customer = customerService.findById(id);
				customer.setFirstName(firstname);
				customer.setLastName(lastname);
				customer.setEmail(email);
			} else {
				customer = new Customer(firstname, lastname, email);
			}
			customerService.save(customer);
			return "redirect:./registeredCustomers";
		} else {
			return "redirect:./register";
		}
	}

	@RequestMapping("/delete")
	public String updateCustomer(@RequestParam("id") int id) {
		customerService.deleteById(id);
		return "redirect:./registeredCustomers";
	}

	@RequestMapping("/registeredCustomers")
	public String listCustomers(Model model) {
		System.out.println(">> in list customer");
		List<Customer> customer = customerService.findAll();
		System.out.println(customer);
		model.addAttribute("registeredCustomers", customer);
		return "list-customer";
	}
}