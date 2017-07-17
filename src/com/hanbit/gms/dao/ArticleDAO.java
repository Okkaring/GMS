package com.hanbit.gms.dao;

import java.util.List;

import com.hanbit.gms.domain.ArticleBean;

public interface ArticleDAO {
	public int insert(ArticleBean member);			
	public List<ArticleBean> selectAll();					
	public List<ArticleBean> selectById(String id); 
	public ArticleBean selectBySeq(String seq);	
	public int count();							
	public String update(ArticleBean bean);
	public String delete(String seq);		
}
