package com.kjy.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Select;

import com.kjy.domain.ReplyVO;

public interface ReplyMapper {

//		@Select("select * from tbl_board where bno > 0")
		public List<ReplyVO> getList();
		
		public void insert(ReplyVO reply);
		
		public void insertSelectKey(ReplyVO reply);
		
		public ReplyVO read(Long rno);
		
		public int delete(Long rno);
		//error가 날 시에는 int bno
		
		public int update(ReplyVO reply);
}
