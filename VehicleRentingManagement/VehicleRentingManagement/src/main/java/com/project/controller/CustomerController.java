package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Customer;
import com.project.model.Vehicle;
import com.project.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
   CustomerService customerService;
	
	
	
	@GetMapping("/vehicles")
	public List<Vehicle> viewAllVehicles()
	{
		return customerService.view();
	}
	
	@PostMapping("/release-vehicles/{vid}")
	public String release(@PathVariable String vid, @RequestBody Customer c)
	{
		return customerService.release(vid,c);
	}
	
	@GetMapping("/booking-status/{id}")
	public Customer bookingStatus(@PathVariable String id)
	{
	   return customerService.bookingStatus(id);	
	}
	
	@PostMapping("/book-vehicles/{id}")
	public String bookVehicle(@PathVariable String id, @RequestBody Customer c)
	{
		
		return customerService.bookVehicle(id,c);
	}
	
}
