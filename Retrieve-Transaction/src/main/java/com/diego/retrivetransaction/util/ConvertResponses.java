package com.diego.retrivetransaction.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.diego.retrivetransaction.dto.TransactionMapDto;
import com.diego.retrivetransaction.dto.TransactionsDto;
import com.diego.retrivetransaction.vo.RequestClientVo;
import com.diego.retrivetransaction.vo.RequestVo;

@Component
public class ConvertResponses {

	public RequestClientVo convertToResponseVo(RequestVo request) {
		RequestClientVo requestClient = new RequestClientVo();
		int customerId = Integer.parseInt(
				request.getAccountId().toString().substring(0, 3) + request.getBranchId().toString().substring(0, 3));
		requestClient.setCustomerId(customerId);
		requestClient.setTransactionDateEnd(request.getTransactionDateEnd());
		requestClient.setTransactionDateStart(request.getTransactionDateStart());
		return requestClient;
	}

	public List<TransactionMapDto> convertToTransactionsList(TransactionsDto transactions){
		return transactions.getTransactions().stream().map(transaction -> {
			TransactionMapDto mapTransaction = new TransactionMapDto();
			mapTransaction.setAmount(transaction.getTransactionDescription().getAmount());
			mapTransaction.setDate(transaction.getDate());
			mapTransaction.setDescription(transaction.getTransactionDescription().getDescription());
			mapTransaction.setTransactionType(transaction.getTransactionDescription().getTransactionType());
			return mapTransaction;
		}).collect(Collectors.toList());
	}
}
