package ir.bmi.baam.interviewassignment.bank.service.impl;

import ir.bmi.baam.interviewassignment.bank.exception.BadRequestException;
import ir.bmi.baam.interviewassignment.bank.exception.ElementNotFoundException;
import ir.bmi.baam.interviewassignment.bank.model.Bank;
import ir.bmi.baam.interviewassignment.bank.model.City;
import ir.bmi.baam.interviewassignment.bank.repository.BankRepository;
import ir.bmi.baam.interviewassignment.bank.service.BankService;
import ir.bmi.baam.interviewassignment.bank.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class DefaultBankService implements BankService {
    private final BankRepository bankRepository;
    private final CityService cityService;

    @Autowired
    DefaultBankService(BankRepository bankRepository, CityService cityService) {
        this.bankRepository = bankRepository;
        this.cityService = cityService;
    }

    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public List<Bank> getBanksByCity(Long cityId) {
        return bankRepository.findAll().stream()
                .filter((bank) -> cityId.equals(bank.getCity().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Bank createNewBank(Bank bank) {
        if (bank.getId() != null) {
            throw new BadRequestException("The ID must not be provided when creating a new Bank");
        }

        return bankRepository.save(bank);
    }

    @Override
    public Bank getBank(Long id) {
        return bankRepository.findById(id).orElseThrow(() -> new ElementNotFoundException("Bank not found"));
    }

    @Override
    public void deleteBank(Long id) {
        bankRepository.deleteById(id);
    }

    @Override
    public List<Bank> getSortedBanksBy(Long cityId, String sortBy) {
        if (sortBy == null) {
            throw new BadRequestException("The sortBy param must be provided when search for bank");
        }

        if (!sortBy.equals("distance")) {
            throw new BadRequestException("The other features are not implemented yet");
        }

        final City goalCity = cityService.getCityById(cityId);

        return getAllBanks().stream().sorted((bank1, bank2) -> {
            if (goalCity.distanceToMe(bank1) >= goalCity.distanceToMe(bank2))
                return 1;
            else return -1;
        }).limit(3).collect(Collectors.toList());
    }
}