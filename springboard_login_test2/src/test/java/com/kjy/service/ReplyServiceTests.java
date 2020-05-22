package com.kjy.service;

import static org.junit.Assert.assertNotNull;

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
public class ReplyServiceTests {
	
	@Setter(onMethod_ = {@Autowired })
	private ReplyService service;
	
	//@Test
	public void testExist() {
		
		log.info(service);
		assertNotNull(service);
	}
	
	//@Test
	public void testRegister() {
		
		ReplyVO board = new ReplyVO();
		board.setReplyer("new 작성자");
		board.setReply("작성 내용");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호 : " + board.getBno());
	}
	
	@Test
	public void testGet() {
		log.info(service.get(2L));
	}
	
	//@Test
	public void testDelete() {
		// 게시물 번호의 존재 여부를 확인하고 테스트 할것.
		log.info("REMOVE RESULT:" + service.remove(2L));
	}
	
	//@Test
	public void testUpdate() {
		ReplyVO board = service.get(2L);
		
		if (board == null) {
			return;
		}
		
		board.setReply("제목을 수정 테스트 합니다.");
		log.info("MODIFY RESULT:"+ service.modify(board));
	}
}
