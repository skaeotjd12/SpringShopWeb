package com.nice.shop.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor 
@NoArgsConstructor 
@Data
@Entity
public class OrderPage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int orderPrice;
	private int orderCount;
	
	
	@ManyToOne(fetch = FetchType.LAZY)   //여러개의 답변을 하나의 유저가 쓸 수 있다.	
	@JoinColumn(name="userId") 
	private User user; 
	
	@ManyToOne(fetch = FetchType.LAZY)    //여러개의 답변은 하나의 게시글에 존재할 수있다 
	@JoinColumn(name="prdNum")
	private Product product;
	
	
	private LocalDateTime createDate;
	
	@PrePersist 
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}
	
}
