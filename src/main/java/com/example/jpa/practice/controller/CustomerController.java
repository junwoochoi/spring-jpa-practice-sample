package com.example.jpa.practice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.practice.entity.Customer;
import com.example.jpa.practice.repository.CustomerRepository;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@PostMapping("/")
	public @ResponseBody List<Customer> createCustomer(@RequestBody Map<String,String> param){
		String name = param.get("name");
		String phone = param.get("phone");
		Customer customer = Customer.builder().name(name).phone(phone).build();
		customerRepository.save(customer);
		
		return customerRepository.findAll();
	}
}
