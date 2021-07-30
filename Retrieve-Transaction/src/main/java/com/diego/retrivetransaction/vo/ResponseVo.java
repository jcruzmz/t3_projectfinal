package com.diego.retrivetransaction.vo;

import java.util.List;

import com.diego.retrivetransaction.dto.TransactionMapDto;

import lombok.Data;
@Data
public class ResponseVo {
	List<TransactionMapDto> transactions;
}
