package com.hanbit.gms.service;

import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.dao.ArticleDAO;
import com.hanbit.gms.dao.ArticleDAOImpl;
import com.hanbit.gms.dao.MemberDAO;
import com.hanbit.gms.dao.MemberDAOImpl;
import com.hanbit.gms.domain.ArticleBean;
import com.sun.beans.decoder.ValueObject;

public class ArticleServiceImpl implements ArticleService{
	ArticleBean bean;
	List<ArticleBean> list;
	
	public ArticleServiceImpl() {
		bean = new ArticleBean();
		list = new ArrayList<>();
	}

	@Override
	public String write(ArticleBean bean) {
		return (new ArticleDAOImpl().insert(bean)==1)?"등록성공":"등록실패";//(dao.insert(bean)==1)?"등록성공":"등록실패";
	}

	@Override
	public List<ArticleBean> list() {
		return new ArticleDAOImpl().selectAll();
	}

	@Override
	public List<ArticleBean> findByid(String id) {
		return list;
	}

	@Override
	public ArticleBean findBySeq(String seq) {
		return new ArticleDAOImpl().selectBySeq(seq);
	}

	@Override
	public int count() {
		return new ArticleDAOImpl().count();
	}

	@Override
	public String modify(ArticleBean bean) {
		return new ArticleDAOImpl().update(bean);
	}

	@Override
	public String remove(String seq) {
		return new ArticleDAOImpl().delete(seq);
	}

}
