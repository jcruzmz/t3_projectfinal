package com.diego.retrivetransaction.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.diego.retrivetransaction.dto.TransactionsDto;
import com.diego.retrivetransaction.vo.RequestClientVo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "RETRIEVE-CURRENT-TRANSACTION")
public interface TransactionClient {

	@PostMapping("/retrieve-current-information")
	@CircuitBreaker(name="RETRIEVE-CURRENT-TRANSACTION", fallbackMethod = "getTransactionsFallback")
	TransactionsDto getTransactions(@RequestBody RequestClientVo request);
	
	default TransactionsDto getTransactionsFallback(Throwable throwable) {
		return new TransactionsDto();
	}

}
