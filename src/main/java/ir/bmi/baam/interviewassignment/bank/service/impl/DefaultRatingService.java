package ir.bmi.baam.interviewassignment.bank.service.impl;

import ir.bmi.baam.interviewassignment.bank.dto.RatingReportDto;
import ir.bmi.baam.interviewassignment.bank.model.Bank;
import ir.bmi.baam.interviewassignment.bank.service.BankService;
import ir.bmi.baam.interviewassignment.bank.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class DefaultRatingService implements RatingService {
    private final BankService bankService;

    @Autowired
    DefaultRatingService(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public RatingReportDto getRatingAverage(Long cityId) {
        return getRatingAverage(bankService.getBanksByCity(cityId));
    }

    @Override
    public RatingReportDto getRatingAverage(List<Bank> banks) {
        double ratingSum = 0;
        int ratingCount = 0;

        for (Bank bank : banks) {
            ratingSum += bank.getRating();
            ratingCount++;
        }

        return new RatingReportDto(ratingCount, ratingSum / ratingCount);
    }
}
