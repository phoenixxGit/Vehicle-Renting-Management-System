package com.project.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Customer;
import com.project.model.Vehicle;
import com.project.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("vehicles/{id}")
	public Vehicle getVehicleById(@PathVariable String id) {   
		   return adminService.getVehicleById(id);           
	}
	
	
	@GetMapping("/vehicles")
	public List<Vehicle> getAllVehicle(){
		return adminService.showAllVehicle();
	}
	
	@PostMapping("/vehicles")
	public Vehicle createVehicle(@RequestBody Vehicle vehicle) {  
		return adminService.addVehicle(vehicle);
	}
	
	@DeleteMapping("/vehicles/{id}")
	public String deleteVehicle(@PathVariable String id)
	{
		return adminService.deleteVehicleById(id);
	}
	
	@GetMapping("/customers")
	public List<Customer> viewAll()
	{
	  return adminService.viewAllCustomers();
	}
	
	
	
	@PutMapping("/vehicles/updatePrice/{id}")
	public Vehicle updateVehiclePrice(@PathVariable String id, @RequestBody Vehicle toUpdate) {
		return adminService.updateVehiclePrice(id,toUpdate);
	}
	
	@PutMapping("/vehicles/updateStatus/{id}")
	public Vehicle updateVehicleStatus(@PathVariable String id, @RequestBody Vehicle toUpdate)
	{
		return adminService.updateVehicleStatus(id, toUpdate);
	}
 
	@PostMapping("/customers")
	public String addCustomer(@RequestBody Customer c)
	{
		return adminService.addCustomer(c);
	}
	

}
