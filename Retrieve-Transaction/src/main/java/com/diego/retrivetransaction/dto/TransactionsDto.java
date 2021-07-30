package com.diego.retrivetransaction.dto;

import java.util.List;

import lombok.Data;

@Data
public class TransactionsDto {
	List<TransactionDto> transactions;
}
