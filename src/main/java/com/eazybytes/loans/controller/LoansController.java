package com.eazybytes.loans.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.loans.constants.LoansConstants;
import com.eazybytes.loans.dto.ResponseDto;
import com.eazybytes.loans.service.ILoansService;

import lombok.AllArgsConstructor;

/**
 * @author abshaikh
 */
@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
@Validated
public class LoansController {

	private ILoansService iLoanService;

	@PostMapping("/create")
	public ResponseEntity<ResponseDto>createLoan(@RequestParam String mobileNumber){
		iLoanService.createLoan(mobileNumber);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));
	}
}
