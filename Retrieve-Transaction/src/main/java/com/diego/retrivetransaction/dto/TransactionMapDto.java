package com.diego.retrivetransaction.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TransactionMapDto {
	private String transactionType;
	private String description;
	private Date date;
	private Double amount;
}
