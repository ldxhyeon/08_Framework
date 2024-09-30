package com.kh.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor


// DB 컬럼명과 다름
// title
// writer
// price
public class Book {
	
	private int bookNo;
	private String title;
	private String writer;
	private int price;
	
}