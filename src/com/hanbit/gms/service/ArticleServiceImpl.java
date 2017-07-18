package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.dao.ArticleDAOImpl;
import com.hanbit.gms.domain.ArticleBean;

public class ArticleServiceImpl implements ArticleService{
	public static ArticleServiceImpl getInstance() {
		return new ArticleServiceImpl();
		}
	
	private ArticleServiceImpl() {}

	@Override
	public String write(ArticleBean bean) {
		return (ArticleDAOImpl.getInstance().insert(bean).equals("1"))?"등록성공":"등록실패";//(dao.insert(bean)==1)?"등록성공":"등록실패";
	}

	@Override
	public List<ArticleBean> list() {
		return ArticleDAOImpl.getInstance().selectAll();
	}
	
	@Override
	public String count() {
		return ArticleDAOImpl.getInstance().count();
	}
	
	@Override
	public List<ArticleBean> findByid(String id) {
		return ArticleDAOImpl.getInstance().selectById(id);
	}

	@Override
	public ArticleBean findBySeq(String seq) {
		return ArticleDAOImpl.getInstance().selectBySeq(seq);
	}

	@Override
	public String modify(ArticleBean bean) {
		return ArticleDAOImpl.getInstance().update(bean);
	}

	@Override
	public String remove(String seq) {
		return ArticleDAOImpl.getInstance().delete(seq);
	}

}
