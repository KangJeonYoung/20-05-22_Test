package com.kjy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kjy.domain.MemberVO;
import com.kjy.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import org.junit.Test;


@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {


	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Override
	public void register(MemberVO member) {
		log.info("register....."+member);
		mapper.insertSelectKey(member);
	}
//
//	@Override
//	public BoardVO get(Long bno) {
//		log.info("get....." + bno);
//		return mapper.read(bno);
//	}
//
//	@Override
//	public boolean modify(BoardVO board) {
//		log.info("modify....." + board);
//		return mapper.update(board) == 1;
//	}
//
//	@Override
//	public boolean remove(Long bno) {
//		log.info("remove....."+ bno);
//		return mapper.delete(bno) == 1;
//	}
//
//	@Override
//	public List<BoardVO> getList() {
//		log.info("getList.....");
//		return mapper.getList();
//	}


}
