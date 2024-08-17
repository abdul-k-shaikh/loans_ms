package com.eazybytes.loans.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
