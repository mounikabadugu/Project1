package com.mounika.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SupplierPOJO 
{
	@Id
	int supplierId;
	@Column
	String supplierName;
	@Column
	String supplierSalary;
	@Column
	String supplierAddress;
	
	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAdress) {
		this.supplierAddress = supplierAdress;
	}

	public void setSupplierId(int id)
	{
		supplierId=id;
	}

	public int getSupplierId()
	{
		return supplierId;
	}

	public void setSupplierName(String name)
	{
		supplierName=name;
	}
	public String getSupplierName()
	{
		return supplierName;
	}
	public void setSupplierSalary(String sal)
	{
		supplierSalary=sal;
	}
	public String getSupplierSalary()
	{
		return supplierSalary;
	}



}
