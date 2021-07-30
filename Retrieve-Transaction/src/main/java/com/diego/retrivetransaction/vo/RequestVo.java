package com.diego.retrivetransaction.vo;

import java.util.Date;

import lombok.Data;
@Data
public class RequestVo {
	private Integer accountId;
	private Integer branchId;
	private Date transactionDateStart;
	private Date transactionDateEnd;
}
