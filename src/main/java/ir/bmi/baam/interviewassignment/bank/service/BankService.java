package ir.bmi.baam.interviewassignment.bank.service;

import ir.bmi.baam.interviewassignment.bank.model.Bank;

import java.util.List;


public interface BankService {
    List<Bank> getAllBanks();

    List<Bank> getBanksByCity(Long cityId);

    Bank createNewBank(Bank bank);

    Bank getBank(Long id);

    void deleteBank(Long id);

    List<Bank> getSortedBanksBy(Long cityId, String sortBy);
}
