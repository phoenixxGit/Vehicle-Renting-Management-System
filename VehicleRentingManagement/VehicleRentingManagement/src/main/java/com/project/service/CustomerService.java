package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.CustomerRepository;
import com.project.dao.VehicleRepository;
import com.project.model.Customer;
import com.project.model.Vehicle;


@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	AdminService adminService;
	
	public String bookVehicle(String id, Customer c)
	{    
		 Vehicle v = vehicleRepository.findById(id).get();
		 if(v.getStatus().equals("available"))
		 {   
			 v.setStatus("booked");
			 vehicleRepository.save(v);
			 c.setVehicle(v);
			 customerRepository.save(c);
		     return "booked successfully";
		 }
		 else
		     return "already booked";
	}
	
	
	
	public List<Vehicle> view()
	{
	   List<Vehicle> vehicleList = vehicleRepository.findAllByStatus("available");
	   return vehicleList;
	}
	
	public String release(String vid, Customer c)
	{
		Vehicle v = vehicleRepository.findById(vid).get();
		//Customer c = customerRepository.findById(cid).get();
		v.setStatus("available");
		customerRepository.delete(c);
		vehicleRepository.save(v);
		
		return "released";
	}
	
	
	
	public Customer bookingStatus(String id)
	{
		return customerRepository.findById(id).get();
	}
	
	
	
}
