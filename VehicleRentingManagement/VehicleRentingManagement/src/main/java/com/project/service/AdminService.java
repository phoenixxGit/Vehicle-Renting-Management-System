package com.project.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.CustomerRepository;
import com.project.dao.VehicleRepository;
import com.project.model.Customer;
import com.project.model.Vehicle;



@Service
public class AdminService {

	@Autowired
	VehicleRepository vehicleRepo;

    @Autowired
    CustomerRepository customerRepository;
    
	public Vehicle getVehicleById(String id) {
		
		return vehicleRepo.findById(id).get();
	}
   
	public List<Customer> viewAllCustomers()
	{
		return customerRepository.findAll();
	}
	
	public List<Vehicle> showAllVehicle()
	 {
		return vehicleRepo.findAll();
		
	 }

	public Vehicle addVehicle(Vehicle vehicle) {
		
		return vehicleRepo.save(vehicle);
	}

	public String deleteVehicleById(String id) {
		vehicleRepo.deleteById(id);
		return "vehicle deleted successfully";
	}

	public Vehicle updateVehiclePrice(String id, Vehicle toUpdate) {
		
		Vehicle v = vehicleRepo.findById(id).get();
		v.setRentPrice(toUpdate.getRentPrice());
		vehicleRepo.save(v);
		return v;
	}

	public Vehicle updateVehicleStatus(String id, Vehicle toUpdate) {
		
		Vehicle v = getVehicleById(id);
		v.setStatus(toUpdate.getStatus());
		vehicleRepo.save(v);
		
		return v;
	}
    
	public boolean checkAvailability(Vehicle v)
	{
		if(v.getStatus().equals("available"))
			return true;
		else
			return false;
	}
	
	public String addCustomer(Customer c)
	{
		 if(checkAvailability(c.getVehicle()))
		   { c.getVehicle().setStatus("booked");
			 customerRepository.save(c);
			 vehicleRepo.save(c.getVehicle());
			 return "saved successfully";
		   }
		 else
			return "cannot be added"; 
	}
}
