package com.diego.retrivetransaction.vo;

import java.util.Date;

import lombok.Data;

@Data
public class RequestClientVo {
	private Integer customerId;
	private Date transactionDateStart;
	private Date transactionDateEnd;
}
