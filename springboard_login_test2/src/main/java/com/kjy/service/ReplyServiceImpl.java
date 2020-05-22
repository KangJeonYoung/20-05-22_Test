package com.kjy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kjy.domain.ReplyVO;
import com.kjy.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import org.junit.Test;


@Log4j
@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {


	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Override
	public void register(ReplyVO reply) {
		log.info("register....."+reply);
		mapper.insertSelectKey(reply);
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info("get....." + rno);
		return mapper.read(rno);
	}

	@Override
	public boolean modify(ReplyVO reply) {
		log.info("modify....." + reply);
		return mapper.update(reply) == 1;
	}

	@Override
	public boolean remove(Long rno) {
		log.info("remove....."+ rno);
		return mapper.delete(rno) == 1;
	}

	@Override
	public List<ReplyVO> getList() {
		log.info("getList.....");
		return mapper.getList();
	}


}
