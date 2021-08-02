package com.diego.retrivetransaction.dto;

import lombok.Data;

@Data
public class TransactionMapDto {
	private String transactionType;
	private String description;
	private String date;
	private Double amount;
}
