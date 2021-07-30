package com.diego.retrivecurrenttransaction.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "transaction")
public class TransactionEntity {
	private String id;
	private Integer customerId;
	private Date date;
	private TransactionDescription transactionDescription;
}
