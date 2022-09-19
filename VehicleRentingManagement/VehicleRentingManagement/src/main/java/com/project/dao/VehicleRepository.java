package com.project.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
  
	public List<Vehicle> findAllByStatus(String status);
}
