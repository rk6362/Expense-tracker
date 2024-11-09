package com.FinSight.service;

import com.FinSight.entity.Transaction;
import com.FinSight.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository repository;

	public void save(Transaction transaction) {
		repository.save(transaction); // Saves the transaction
	}

	public List<Transaction> getAllTransaction() {
		return repository.findAll(); // Fetches all transactions
	}

	public Transaction getTransactionById(int id) {
		return repository.findById(id).orElse(null); // Fetches transaction by ID
	}

	public void deleteById(int id) {
		repository.deleteById(id); // Deletes transaction by ID
	}

	public Map<String, Double> getIncomeExpenseData() {
		double totalIncome = 0.0;
		double totalExpenses = 0.0;

		// Fetch all transactions from the repository
		List<Transaction> transactions = repository.findAll();

		// Iterate over the transactions to calculate totals
		for (Transaction transaction : transactions) {
			if ("income".equalsIgnoreCase(transaction.getTransactionType())) {
				totalIncome += transaction.getPrice();
			} else if ("expense".equalsIgnoreCase(transaction.getTransactionType())) {
				totalExpenses += transaction.getPrice();
			}
		}

		// Create a map to hold the totals
		Map<String, Double> incomeExpenseData = new HashMap<>();
		incomeExpenseData.put("Total Income", totalIncome);
		incomeExpenseData.put("Total Expenses", totalExpenses);

		return incomeExpenseData; // Return the income and expense totals
	}
}
