package com.kjy.mapper;

import com.kjy.domain.MemberVO;

public interface MemberMapper {

	public MemberVO read(String userid);
	
	public void insert(MemberVO member);
	
	public void insertSelectKey(MemberVO member);
}
