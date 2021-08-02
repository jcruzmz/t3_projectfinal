package com.diego.retrivecurrenttransaction.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestVo {
	@NotNull
	private Integer customerId;
	@NotNull
	private Date transactionDateStart;
	@NotNull
	private Date transactionDateEnd;
}
