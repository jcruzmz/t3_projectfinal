package com.diego.retrivetransaction.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TransactionDto {
	private Integer customerId;
	private Date date;
	private TransactionDescriptionDto transactionDescription;
}
