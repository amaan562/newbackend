package com.thecodeveal.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name="BANK_DETAILS")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class BankDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
//	@Column(name= "username")
//	private String username;
	
	@Column(name = "ifsc")
	private String ifsc;
	
	@Column(name = "pan")
	private String pan;
	
	@Column(name = "accountNumber")
	private String accountNumber;
	
	@Column(name = "firstEmployment")
	private boolean firstEmployment;
	
	@Column(name = "previousCompany")
	private String previousCompany;
	
	@Column(name = "previousRole")
	private String previousRole;
	
	@Column(name = "previousSalary")
	private int previousSalary;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "bankDetails")
	private User user;
	
	
	public BankDetails() {}
	public BankDetails(String ifsc, String pan, String accountNumber, boolean firstEmployment, String previousCompany,
			String previousRole, int previousSalary) {
		super();
		this.ifsc = ifsc;
		this.pan = pan;
		this.accountNumber = accountNumber;
		this.firstEmployment = firstEmployment;
		this.previousCompany = previousCompany;
		this.previousRole = previousRole;
		this.previousSalary = previousSalary;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean isFirstEmployment() {
		return firstEmployment;
	}

	public void setFirstEmployment(boolean firstEmployment) {
		this.firstEmployment = firstEmployment;
	}
	public String getPreviousCompany() {
		return previousCompany;
	}
	public void setPreviousCompany(String previousCompany) {
		this.previousCompany = previousCompany;
	}
	public String getPreviousRole() {
		return previousRole;
	}
	public void setPreviousRole(String previousRole) {
		this.previousRole = previousRole;
	}
	public int getPreviousSalary() {
		return previousSalary;
	}
	public void setPreviousSalary(int previousSalary) {
		this.previousSalary = previousSalary;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}