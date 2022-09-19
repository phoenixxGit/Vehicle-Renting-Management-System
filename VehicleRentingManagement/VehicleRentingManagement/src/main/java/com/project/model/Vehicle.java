package com.project.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Vehicle {
    
	@Id
	private String id;
	private String vehicleModel;
	private double rentPrice;
    private String status;
	
    
    
	

	

	public Vehicle(String id, String vehicleModel, double rentPrice, String status) {
		super();
		this.id = id;
		this.vehicleModel = vehicleModel;
		this.rentPrice = rentPrice;
		this.status = status;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vehicleModel=" + vehicleModel + ", rentPrice=" + rentPrice + ", status="
				+ status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, rentPrice, status, vehicleModel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return id == other.id && Double.doubleToLongBits(rentPrice) == Double.doubleToLongBits(other.rentPrice)
				&& Objects.equals(status, other.status) && Objects.equals(vehicleModel, other.vehicleModel);
	}

	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

}
