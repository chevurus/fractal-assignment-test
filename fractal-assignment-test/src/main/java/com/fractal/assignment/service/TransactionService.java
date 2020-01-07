package com.fractal.assignment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fractal.assignment.model.Results;
import com.fractal.assignment.model.ResultsList;



@Service
public class TransactionService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

	@Autowired
	RestTemplate restTemplate;

	@Value("${fractal.transaction.api.url}")
	private String transactionApiUrl;

	@Value("${fractal.category.api.url}")
	private String categoryApiUrl;

	public String getTransactionApiUrl() {
		return transactionApiUrl;
	}

	public void setTransactionApiUrl(String transactionApiUrl) {
		this.transactionApiUrl = transactionApiUrl;
	}

	public List<Results> getTransactions(String companyId) {

		List<Results> transactions = getCompanyTransactions(companyId);
		return transactions;

	}

	public List<Results> getTransactionsForCategoryList(String companyId, List<String> categories) {

		List<Results> transactions = getCompanyTransactions(companyId);
		
		transactions.removeIf(t -> (!categories.contains(t.getCategory())));

		return transactions;

	}

	public List<Results> getTransactionsForCategory(String companyId, String category) {

		List<Results> transactions = getCompanyTransactions(companyId);

		transactions.removeIf(transaction -> !category.equals(transaction.getCategory()));

		return transactions;

	}

	private List<Results> getCompanyTransactions(String companyId) {

		ResultsList response = restTemplate.getForObject(transactionApiUrl+"?companyId="+companyId, ResultsList.class);

		List<Results> trasactions = response.getResults();

		return trasactions;
	}

	public List<Results> updateTransactionCategory(String companyId, String categoryId, String transactionId) {
		
	       Map<String, String> vars = new HashMap<String, String>();
	        vars.put("companyId", companyId);
	        vars.put("categoryId", categoryId);
	        vars.put("transactionId", transactionId);
	        
		//User returns = rt.postForObject(uri, u, User.class, vars);
	        Results transaction = new Results();
		
		restTemplate.put(categoryApiUrl, transaction, vars);
		

		return null;
	}

}
