package com.diego.retrivetransaction.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.retrivetransaction.client.TransactionClient;
import com.diego.retrivetransaction.dto.TransactionMapDto;
import com.diego.retrivetransaction.dto.TransactionsDto;
import com.diego.retrivetransaction.exception.DataNotFoundException;
import com.diego.retrivetransaction.util.ConvertResponses;
import com.diego.retrivetransaction.vo.RequestClientVo;
import com.diego.retrivetransaction.vo.RequestVo;
import com.diego.retrivetransaction.vo.ResponseVo;

@RestController
@RequestMapping("/retrieve-transaction-user")
public class TransactionController {
	@Autowired
	private TransactionClient transactionClient;
	
	@Autowired
	private ConvertResponses convertResponses;
	
	@PostMapping()
	public ResponseEntity<ResponseVo> getTransacctions(@Valid @RequestBody RequestVo request) throws ClassNotFoundException{
		ResponseVo response = new ResponseVo();
		RequestClientVo requestClient = convertResponses.convertToResponseVo(request);
		TransactionsDto transactions = transactionClient.getTransactions(requestClient);
		if(transactions.getTransactions().isEmpty()) {
			throw new DataNotFoundException("Transacctions are empty");
		}
		List<TransactionMapDto> listTransactionMap = convertResponses.convertToTransactionsList(transactions);
		response.setTransactions(listTransactionMap);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
