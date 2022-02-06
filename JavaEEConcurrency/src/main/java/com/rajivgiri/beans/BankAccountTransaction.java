package com.rajivgiri.beans;

import java.util.Date;

public class BankAccountTransaction {

	private int accNumber;
	private double amount;
	private Date transDate;
	private String transType;
	private int transId;

	public int getAccNUmber() {
		return accNumber;
	}

	public void setAccNUmber(int accNUmber) {
		this.accNumber = accNUmber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

}
