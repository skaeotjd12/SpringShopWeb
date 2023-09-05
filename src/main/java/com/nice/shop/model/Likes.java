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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor //전체생성자
@NoArgsConstructor 
@Data
@Entity 
@Table(
		uniqueConstraints =  {
				@UniqueConstraint(
						name ="likes_uk",
						columnNames = {"prdNum", "userId"} 
				)
			}
	)
public class Likes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "userId")
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
