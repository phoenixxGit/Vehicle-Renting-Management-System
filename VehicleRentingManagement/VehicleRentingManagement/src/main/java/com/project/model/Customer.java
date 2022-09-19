package com.project.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	private String custId;
	private String custName;
	private double num;
	
	@OneToOne
	Vehicle vehicle;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Customer(String custId, String custName, double num, Vehicle vehicle) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.num = num;
		this.vehicle = vehicle;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(custId, custName, num, vehicle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(custId, other.custId) && Objects.equals(custName, other.custName)
				&& Double.doubleToLongBits(num) == Double.doubleToLongBits(other.num)
				&& Objects.equals(vehicle, other.vehicle);
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", num=" + num + ", vehicle=" + vehicle + "]";
	}
	
	

}
