package com.nice.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoDto {
	
	private String userId;
	private int prdNum;
	private int orderCount;
	private int orderPrice;
}
