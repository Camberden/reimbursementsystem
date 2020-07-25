package com.chrispy.projectone.models;

import java.sql.Timestamp;

public class Reimbursement {
	
	private int reimbId;
	private int amount;
	private Timestamp now;
	private int author;
	private int statusId;
	private int typeId;
	
	@Override
	public String toString() {
		return "Reimbursement [reimbId = " + reimbId + ", amount = " + amount + ", now = " + now + ", author = " + author
				+ ", statusId = " + statusId + ", typeId = " + typeId + "]";
	}
	// WITHOUT ID
	public Reimbursement(int amount, Timestamp now, int author, int statusId, int typeId) {
		super();
		this.amount = amount;
		this.now = now;
		this.author = author;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	// WITH ID
	public Reimbursement(int reimbId, int amount, Timestamp now, int author, int statusId, int typeId) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.now = now;
		this.author = author;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	
	public Reimbursement() {
		super();
	}
	
	public int getReimbId() {
		return reimbId;
	}
		
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
}
