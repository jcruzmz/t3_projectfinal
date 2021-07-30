package com.diego.retrivecurrenttransaction.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.retrivecurrenttransaction.dto.TransactionDto;
import com.diego.retrivecurrenttransaction.entity.TransactionEntity;
import com.diego.retrivecurrenttransaction.repository.TransactionRepository;
import com.diego.retrivecurrenttransaction.vo.RequestVo;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private ModelMapper mapper;

	public List<TransactionDto> findByCustomerId(RequestVo request) {
		List<TransactionEntity> listDb = transactionRepository.findByCustomerIdAndDateBetweenOrderByDateDesc(request.getCustomerId(),
				request.getTransactionDateStart(), request.getTransactionDateEnd());
		return convertToDto(listDb);
	}

	public List<TransactionDto> convertToDto(List<TransactionEntity> listDb) {
		List<TransactionDto> response = new ArrayList<>();
		listDb.forEach(transactionEntity -> {
			TransactionDto aux = mapper.map(transactionEntity, TransactionDto.class);
			response.add(aux);
		});
		return response;
	}
}
