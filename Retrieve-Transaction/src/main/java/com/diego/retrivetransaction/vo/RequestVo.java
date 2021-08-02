package com.diego.retrivetransaction.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class RequestVo {
	@NotNull
	private Integer accountId;
	@NotNull
	private Integer branchId;
	@NotNull
	private Date transactionDateStart;
	@NotNull
	private Date transactionDateEnd;
}
