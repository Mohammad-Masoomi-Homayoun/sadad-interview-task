package ir.bmi.baam.interviewassignment.bank.service;

import ir.bmi.baam.interviewassignment.bank.dto.RatingReportDto;
import ir.bmi.baam.interviewassignment.bank.model.Bank;

import java.util.List;

public interface RatingService {
    RatingReportDto getRatingAverage(Long cityId);

    RatingReportDto getRatingAverage(List<Bank> banks);
}