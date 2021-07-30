package com.diego.retrivetransaction.dto;

import lombok.Data;

@Data
public class TransactionDescriptionDto {
	private String transactionType;
	private String description;
	private Double amount;
}
