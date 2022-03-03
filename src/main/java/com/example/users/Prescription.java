package com.example.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="PRESCRIPTION") // USER is a reserved word for many SQL databases
public class Prescription {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer prescription_id;

	private String drug_name;
	
	private String user_name;
	
	private String drug_id;
	
	private Integer prescription_quantity;
	
	private String instruction_to_customer;
	
	public Integer getId() {
		return prescription_id;
	}

	public void setId(Integer prescription_id) {
		this.prescription_id = prescription_id;
	}

	public String getUserName() {
		return user_name;
	}

	public void setUserName(String user_name) {
		this.user_name = user_name;
	}
	
	public String getName() {
		return drug_name;
	}

	public void setName(String drug_name) {
		this.drug_name = drug_name;
	}

	public String getDrugId() {
		return drug_id;
	}

	public void setDrugId(String drug_id) {
		this.drug_id = drug_id;
	}

	public Integer getPrescriptionQuantity() {
		return prescription_quantity;
	}

	public void setPrescriptionQuantity(Integer prescription_quantity) {
		this.prescription_quantity = prescription_quantity;
	}

	public String getInstructionCustomer() {
		return instruction_to_customer;
	}

	public void setInstructionCustomer(String instruction_to_customer) {
		this.instruction_to_customer = instruction_to_customer;
	}

//	public Date getPrescriptionRefilledDate() {
//		return prescription_refilled_date;
//	}
//
//	public void setPrescriptionRefilledDate(Date prescription_refilled_date) {
//		this.prescription_refilled_date = prescription_refilled_date;
//	}
//
//	public Date getPrescriptionIssuedDate() {
//		return prescription_issued_date;
//	}
//
//	public void setPrescriptionIssuedDate(Date prescription_issued_date) {
//		this.prescription_issued_date = prescription_issued_date;
//	}

}
