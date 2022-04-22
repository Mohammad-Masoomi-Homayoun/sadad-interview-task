package ir.bmi.baam.interviewassignment.bank.repository;

import ir.bmi.baam.interviewassignment.bank.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BankRepository extends JpaRepository<Bank, Long> {}