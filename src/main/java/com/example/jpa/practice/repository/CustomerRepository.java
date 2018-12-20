package com.example.jpa.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.practice.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	public List<Customer> findByName(String name);
	public List<Customer> findByPhone(String phone);
	//like검색도 가능
	public List<Customer> findByNameLike(String keyword);
}
