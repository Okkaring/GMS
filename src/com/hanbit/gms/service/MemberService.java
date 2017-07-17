package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.domain.MemberBean;

//관리자의 회원목록(list,array로 지금은 하자)
//지금은 목록을 가져오는 기능을 설정하는 것이다.

public interface MemberService {
	public String addMember(MemberBean member);			
	public List<MemberBean> list();					
	public int countMembers();							
	public MemberBean findById(String id);	
	public List<MemberBean> findByName(String name); 
	public String modify(MemberBean bean);
	public String remove(String id);		
	
}
