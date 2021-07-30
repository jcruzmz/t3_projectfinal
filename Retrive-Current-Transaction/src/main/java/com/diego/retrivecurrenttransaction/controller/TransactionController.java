package com.diego.retrivecurrenttransaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.retrivecurrenttransaction.dto.TransactionDto;
import com.diego.retrivecurrenttransaction.service.TransactionService;
import com.diego.retrivecurrenttransaction.vo.RequestVo;
import com.diego.retrivecurrenttransaction.vo.ResponseVo;

@RestController
@RequestMapping("/retrieve-current-information")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping()
	public ResponseEntity<ResponseVo> getByCustomerId(@RequestBody RequestVo requestBody){
		ResponseVo response = new ResponseVo();
		List<TransactionDto> result = transactionService.findByCustomerId(requestBody);
		response.setTransactions(result);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
