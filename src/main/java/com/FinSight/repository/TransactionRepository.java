package com.FinSight.repository;

import com.FinSight.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query("SELECT SUM(t.price) FROM Transaction t WHERE t.transactionType = 'income'")
    Double getTotalIncome();

    @Query("SELECT SUM(t.price) FROM Transaction t WHERE t.transactionType = 'expense'")
    Double getTotalExpense();
}
