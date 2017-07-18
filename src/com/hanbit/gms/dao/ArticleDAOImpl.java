package com.hanbit.gms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constants.DB;
import com.hanbit.gms.constants.SQL;
import com.hanbit.gms.constants.Vendor;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.factory.DatabaseFactory;

public class ArticleDAOImpl implements ArticleDAO{
	public static ArticleDAOImpl getInstance() {
		return new ArticleDAOImpl();
	}
	private ArticleDAOImpl(){}
	
	@Override
	public String insert(ArticleBean bean) {
		String rs = "";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_WRITE);
			System.out.println("SQL:"+SQL.BOARD_WRITE);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContent());
			rs= String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<ArticleBean> selectAll() {
		List<ArticleBean> list = new ArrayList<>();
		ArticleBean bean = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_LIST).executeQuery();
		while(rs.next()){
			bean = new ArticleBean();
			bean.setArticleSeq(Integer.parseInt(rs.getString("article_seq")));
			bean.setId(rs.getString(DB.BOARD_ID));
			bean.setTitle(rs.getString(DB.BOARD_TITLE));
			bean.setContent(rs.getString(DB.BOARD_CONTENT));
			bean.setHitcount(rs.getInt(DB.BOARD_HITCOUNT));
			bean.setRegdate(rs.getString(DB.BOARD_REGDATE));
			list.add(bean);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public String count() {
		String result = "";
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.COUNT_BOARDS).executeQuery();
			if(rs.next()){
				result = rs.getString("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<ArticleBean> selectById(String id) {
		List<ArticleBean> list = new ArrayList<>();
		ArticleBean bean = null;
		try { 
				PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME,DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_FINDBYID);
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()){
				bean = new ArticleBean();
				bean.setId(rs.getString(DB.BOARD_ID));
				bean.setTitle(rs.getString(DB.BOARD_TITLE));
				bean.setContent(rs.getString(DB.BOARD_CONTENT));
				bean.setRegdate(rs.getString(DB.BOARD_REGDATE));
				bean.setArticleSeq(rs.getInt(DB.BOARD_ARTICLE_SEQ));
				bean.setHitcount(rs.getInt(DB.BOARD_HITCOUNT));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArticleBean selectBySeq(String seq) {
		ArticleBean bean = null;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_FINDBYSEQ);
			pstmt.setInt(1, Integer.parseInt(seq));
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				bean = new ArticleBean();
				bean.setArticleSeq(rs.getInt(DB.BOARD_ARTICLE_SEQ));
				bean.setId(rs.getString(DB.BOARD_ID));
				bean.setTitle(rs.getString(DB.BOARD_TITLE));
				bean.setContent(rs.getString(DB.BOARD_CONTENT));
				bean.setRegdate(rs.getString(DB.BOARD_REGDATE));
				bean.setHitcount(rs.getInt(DB.BOARD_HITCOUNT));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public String update(ArticleBean bean) {
		String rs="";
		ArticleBean temp=selectBySeq(String.valueOf(bean.getArticleSeq()));
		String title= (bean.getTitle().equals(""))? temp.getTitle() : bean.getTitle();
		String content= (bean.getContent().equals(""))?temp.getContent():bean.getContent();
		/*if(bean.getTitle().equals("")){
			bean.setTitle(selectBySeq(String.valueOf(bean.getArticleSeq())).getTitle());
		}
		if(bean.getContent().equals("")){
			bean.setContent(selectBySeq(String.valueOf(bean.getArticleSeq())).getContent());
		}*/
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_UPDATE);
			System.out.println("sql======"+SQL.BOARD_UPDATE);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bean.getArticleSeq());
			rs = String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String delete(String seq) {
		String rs="";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.BOARD_DELETE);
			pstmt.setString(1, seq);
			rs=String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
