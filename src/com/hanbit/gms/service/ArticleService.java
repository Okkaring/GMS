package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.domain.ArticleBean;

	public interface ArticleService {
		public String write(ArticleBean bean);			
		public List<ArticleBean> list();					
		public List<ArticleBean> findByid(String id); 
		public ArticleBean findBySeq(String seq);	
		public int count();							
		public String modify(ArticleBean bean);
		public String remove(String seq);		
		
	}

