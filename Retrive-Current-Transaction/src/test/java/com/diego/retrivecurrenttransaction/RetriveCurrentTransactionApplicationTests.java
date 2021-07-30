package com.diego.retrivecurrenttransaction;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.diego.retrivecurrenttransaction.controller.TransactionController;
import com.diego.retrivecurrenttransaction.vo.RequestVo;
import com.diego.retrivecurrenttransaction.vo.ResponseVo;

@SpringBootTest
class RetriveCurrentTransactionApplicationTests {

	@Autowired
	private TransactionController transactionController;

	private RequestVo request = new RequestVo(123456, new Date(), new Date());

	@Test
	void getCustomerById() {
		ResponseEntity<ResponseVo> responseEntity = transactionController.getByCustomerId(request);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

}
