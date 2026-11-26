package com.luisedev.cuentadia.repository;

import com.luisedev.cuentadia.entities.Recurring_expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecurringExpenses extends JpaRepository<Recurring_expenses, Long> {
}
