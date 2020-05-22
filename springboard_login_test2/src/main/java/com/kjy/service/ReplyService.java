package com.kjy.service;

import java.util.List;

import com.kjy.domain.ReplyVO;
import com.kjy.domain.Criteria;

public interface ReplyService {
	
	public void register(ReplyVO reply);
	
	public ReplyVO get(Long rno);
	
	public boolean modify(ReplyVO reply);
	// 기존의 글을 수정할 때
	// update 메서드와 mapping
	
	public boolean remove(Long bno);
	// 내가 지정한 글 번호를 이용해서 해당글을 삭제할 때.
	// delete 메서드와 mapping
	
	public List<ReplyVO> getList();
	// 전체 데이터를 조회할 때.
	// getList와 mapping
}
