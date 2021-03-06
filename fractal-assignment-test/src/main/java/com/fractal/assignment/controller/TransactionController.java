package com.fractal.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fractal.assignment.model.Results;
import com.fractal.assignment.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@GetMapping(path = "/companies/{companyId}/transactions")
	public List<Results> getTrasactions(@PathVariable String companyId) {
		return transactionService.getTransactions(companyId);

	}

	@GetMapping(path = "/companies/{companyId}/transactions/{category}")
	public List<Results> getTransactionsForCategory(@PathVariable String companyId, @PathVariable String category) {
		return transactionService.getTransactionsForCategory(companyId, category);

	}

	// This route could be used to categorise for single or multiple categories
	@GetMapping(path = "/companies/{companyId}/categories/{categoriesList}/transactions")
	@ResponseBody
	public List<Results> getCategorisedTransactions(@PathVariable String companyId,
			@PathVariable List<String> categoriesList) {
		return transactionService.getTransactionsForCategoryList(companyId, categoriesList);
	}

	@PutMapping(path = "/companies/{companyId}/categories/{categoryId}/transactions/{transactionId}")
	public  void updateTransactionCategory(@PathVariable String transactionId, @PathVariable String categoryId,
			@PathVariable String companyId) throws JsonProcessingException {
		 transactionService.updateTransactionCategory(companyId, categoryId, transactionId);

	}

}
