package com.eazybytes.loans.service.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.eazybytes.loans.constants.LoansConstants;
import com.eazybytes.loans.dto.LoansDto;
import com.eazybytes.loans.entity.Loans;
import com.eazybytes.loans.repository.LoansRepository;
import com.eazybytes.loans.service.ILoansService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {

	private LoansRepository loansRepository;

	
	/**
	 *@param mobileNumber - Mobile Number of the Customer
	 */
	@Override
	public void createLoan(String mobileNumber) {
		Optional<Loans> optionalLoans = loansRepository.findByMobileNumber(mobileNumber);
		if(optionalLoans.isPresent()) {
			 System.out.println("Loan already registered with given mobileNumber ");
			 return;
		}
		loansRepository.save(createNewLoan(mobileNumber));
//		loansRepository.save(createNewLoan(mobileNumber));
	}
	/**
     * @param mobileNumber - Mobile Number of the Customer
     * @return the new loan details
     */
	private Loans createNewLoan(String mobileNumber) {
		Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return newLoan;
	}

	@Override
	public LoansDto fetchLoan(String mobileNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateLoan(LoansDto loansDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLoan(String mobileNumber) {
		// TODO Auto-generated method stub
		return false;
	}

}
