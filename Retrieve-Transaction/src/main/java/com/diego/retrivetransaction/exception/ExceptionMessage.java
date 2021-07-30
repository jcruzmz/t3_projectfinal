package com.diego.retrivetransaction.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionMessage {
	private String type;
	private int code;
	private String location;
	private String moreInfo;
}
