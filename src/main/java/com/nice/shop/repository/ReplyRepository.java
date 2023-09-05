package com.nice.shop.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nice.shop.model.Reply;


public interface ReplyRepository extends JpaRepository<Reply, Integer> {

	public Page<Reply> findByProduct_PrdNum(int prdNum,Pageable pageable);
	
	
	//댓글작성
	@Modifying
	@Query(value = "INSERT INTO reply(userId, prdNum, replyText, createDate) VALUES(?1, ?2, ?3,now())", nativeQuery = true)
	int mSave(String userId, int prdNum, String replyText); //업데이트된 행의 개수를 리턴해줌.
	

 
//	@Modifying
//	@Query(value = "select * from reply where prdNum=?1", nativeQuery = true)
//	Page<Reply> mSa(int prdNum, Pageable pageable);
	
	
	
	 

}
