package com.diego.retrivecurrenttransaction.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diego.retrivecurrenttransaction.entity.TransactionEntity;

@Repository
public interface TransactionRepository extends MongoRepository<TransactionEntity, String>{
	
	public List<TransactionEntity> findByCustomerIdAndDateBetweenOrderByDateDesc(Integer cumstomerId, Date from, Date to);

}
