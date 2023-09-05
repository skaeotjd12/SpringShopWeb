package com.nice.shop.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nice.shop.dto.ReplySaveRequestDto;
import com.nice.shop.model.Reply;
import com.nice.shop.repository.ReplyRepository;



@Service
public class ReplyService {
	
	
	@Autowired
	private ReplyRepository replyRepository;
	
	
	@Transactional
	public void deleteReply(int replyId) {
		replyRepository.deleteById(replyId);
	}
	
	
	@Transactional
	public void 댓글쓰기(ReplySaveRequestDto replySaveRequestDto) {
			replyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getPrdNum(), replySaveRequestDto.getReplyText());
	}

	@Transactional(readOnly = true)
	public Page<Reply> 댓글목록(int prdNum,Pageable pageable) {
			return  replyRepository.findByProduct_PrdNum(prdNum,pageable);
	}
}