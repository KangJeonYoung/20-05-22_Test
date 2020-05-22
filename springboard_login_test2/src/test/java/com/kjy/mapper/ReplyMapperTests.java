package com.kjy.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kjy.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Setter(onMethod_ = @Autowired)
	ReplyMapper mapper;
	
	//@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	//@Test
	public void testInsert() {
		ReplyVO board = new ReplyVO();
		board.setBno(2L);
		board.setReply("안녕");
		board.setReplyer("강전영");;
		
		mapper.insert(board);
		
		log.info(board);
	}
	
//	 //@Test
//	 public void testInsertSelectKey() {
//		 ReplyVO board = new ReplyVO();
//		 board.setTitle("새로 작성하는 글 select key");
//		 board.setContent("새로 작성하는 내용 select key");
//		 board.setWriter("newbie");
//		 
//		 mapper.insertSelectKey(board);
//		 
//		 log.info(board);
//	 }
	
	@Test
	public void testRead() {
		
		//존재하는 게시물 번호로 테스트
		ReplyVO board = mapper.read(2L);
		
		log.info(board);
	}
	
	//@Test
	public void testDelete() {
		log.info("DELETE COUNT:"+mapper.delete(2L));
	}
	
	//@Test
	 public void testUpdate() {
		 ReplyVO board = new ReplyVO();
		 board.setRno(2L);	// 존재하는 번호인지 먼저 확인
		 board.setReply("make new test");
		 
		 int count = mapper.update(board);
		 log.info("UPDATE COUNT: " + count);
	 }
}
