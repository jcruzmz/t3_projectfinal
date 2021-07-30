package com.diego.retrivecurrenttransaction.dto;

import lombok.Data;

@Data
public class TransactionDescriptionDto {
	private String transactionType;
	private String description;
	private Double amount;
}
