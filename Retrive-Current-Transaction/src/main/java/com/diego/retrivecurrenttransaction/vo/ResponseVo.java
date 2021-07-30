package com.diego.retrivecurrenttransaction.vo;

import java.util.List;

import com.diego.retrivecurrenttransaction.dto.TransactionDto;

import lombok.Data;

@Data
public class ResponseVo {
	private List<TransactionDto> transactions;
}
