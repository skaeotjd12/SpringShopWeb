package com.nice.shop.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴
@Entity // 자동으로 User 클래스가 MySql에 테이블이 생성이 된다.
public class Product {
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prdNum;
	
	@Column(nullable = false, length = 100) 
	private String prdCtg;
	
	@Column(nullable = false, length = 100) 
	private String prdName;
	
	@Column(nullable = false, length = 100) 
	private int prdPrice;
	
	@Column(nullable = false, length = 100) 
	private String prdStatuts;
	
	@Lob
	private String prdDetail;
	
	@Column(length = 1000)
	private String prdFilename;
	
	//LAZY는 기본전략 안 적어줘도됨 EAGER와 LAZY 차이점 명확히알기
	//하나의 게시글은 여러개의 댓글을 가질 수 있기 때문에										
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)   //mappedBy란 연간관계의 주인이 아니다 (난 fk가아니다.) DB에 칼럼을 만들지말란 뜻
	@JsonIgnoreProperties({"product"}) //무한참조 해결
	@OrderBy("replyId desc")
	private List<Reply> replys;
	
	
	@JsonIgnoreProperties({"product"})
	@OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE) 
	private List<OrderPage> orderpage;
	
	@JsonIgnoreProperties({"product"})
	@OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE) 
	private List<Likes> likes;
	
	@ColumnDefault("0")
	@Column(nullable = false, length = 100) 
	private int likeCount;
	
	@Transient  //이 어노테이션 쓰면 DB에 컬럼이 만들어 지지 않는다.
	private boolean likeState;
	
}
