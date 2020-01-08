package com.fractal.assignment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

		ResultsList response = restTemplate.getForObject(transactionApiUrl + "?companyId=" + companyId,
				ResultsList.class);

		List<Results> trasactions = response.getResults();

		return trasactions;
	}

	public void updateTransactionCategory(String companyId, String categoryId, String transactionId) throws JsonProcessingException {
		
		
		
		HttpHeaders header = new HttpHeaders();

		//You can use more methods of HttpHeaders to set additional information
		header.setContentType(MediaType.APPLICATION_JSON);

		Map<String, String> bodyParamMap = new HashMap<String, String>();

		//Set your request body params
		bodyParamMap.put("transactionId", transactionId);
		bodyParamMap.put("categoryId", categoryId);
		//bodyParamMap.put("companyId", companyId);
	

		String reqBodyData = new ObjectMapper().writeValueAsString(bodyParamMap);
		
		//"0={"transactionId":"fakeTrx04","categoryId":"dqwe4"}"
		String body = "\"0="+reqBodyData+"\"";
		
		LOGGER.info("reqBodyDate = " + reqBodyData);
		LOGGER.info("body = " + body);

		HttpEntity<String> requestEntity = new HttpEntity<>(body, header);
		
		LOGGER.info("requestEntity Body= " + requestEntity.getBody());
		
		restTemplate.exchange(categoryApiUrl, HttpMethod.PUT, requestEntity, String.class, bodyParamMap);
		
		
		//restTemplate.put(categoryApiUrl, requestEnty, reqBodyData);
		
	}

}
