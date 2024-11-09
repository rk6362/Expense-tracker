package com.FinSight.entity;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String transactionType; // "income" or "expense"
	private String category; // for expenses
	private String incomeCategory; // for incomes
	private String note;
	private double price;

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIncomeCategory() {
		return incomeCategory;
	}

	public void setIncomeCategory(String incomeCategory) {
		this.incomeCategory = incomeCategory;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
