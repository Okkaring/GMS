package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.dao.ArticleDAOImpl;
import com.hanbit.gms.dao.MemberDAOImpl;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.service.MemberService;

public class MemberServiceImpl implements MemberService{
	public static MemberServiceImpl getInstance() {return new MemberServiceImpl();}
	private MemberServiceImpl(){}
	//List<MemberBean> list = new ArrayList<>();
	@Override
	public String addMember(MemberBean member) {
		return (MemberDAOImpl.getInstance().insert(member).equals("1"))? "등록 성공!!": "등록 실패!!";
	}
	@Override
	public List<MemberBean> list() {
		return MemberDAOImpl.getInstance().selectAll();
	}
	@Override
	public String countMembers() {
		return String.valueOf(MemberDAOImpl.getInstance().countMembers());
	}
	
	@Override
	public MemberBean findById(String id) {
		return MemberDAOImpl.getInstance().selectById(id);
	}

	@Override
	public List<MemberBean> findByName(String name) {
		return MemberDAOImpl.getInstance().selectByName(name);
	}

	@Override
	public String modify(MemberBean bean) {
		return MemberDAOImpl.getInstance().update(bean);
	}

	@Override
	public String remove(String id) {
		return	(MemberDAOImpl.getInstance().delete(id).equals("1"))? "등록 성공!!": "등록 실패!!";
	}
}
