package com.diego.retrivecurrenttransaction.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestVo {
	
	private Integer customerId;
	private Date transactionDateStart;
	private Date transactionDateEnd;
}
