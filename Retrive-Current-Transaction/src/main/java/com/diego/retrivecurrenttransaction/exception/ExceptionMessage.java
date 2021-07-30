package com.diego.retrivecurrenttransaction.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionMessage {
	private String type;
	private Integer code;
	private String location;
	private String moreInfo;
}
