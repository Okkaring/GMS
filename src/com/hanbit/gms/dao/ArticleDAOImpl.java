package com.hanbit.gms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constants.DB;
import com.hanbit.gms.domain.ArticleBean;

public class ArticleDAOImpl implements ArticleDAO{
	public ArticleDAOImpl() {
		try {
			Class.forName(DB.DRIVER);
		} catch (Exception e) {
			System.out.println("DRIVER LOAD FAIL...");
			e.printStackTrace();
		}
		
	}
	@Override
	public int insert(ArticleBean bean) {
		int rs = 0;
		try {
			/*String sql=String.format("INSERT INTO %s(%s,%s,%s,%s,%s,%s) VALUES(article_seq.nextval,'%s','%s','%s',0,SYSDATE)"
					,DB.TABLE_BOARD, DB.BOARD_ARTICLE_SEQ, DB.BOARD_ID, DB.BOARD_TITLE, DB.BOARD_CONTENT,DB.BOARD_HITCOUNT, DB.BOARD_REGDATE
					,bean.getId(),bean.getTitle(),bean.getContent());
			System.out.println("=============sql: "+sql);
			rs= DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeUpdate
					//INSERT INTO Board(article_seq,id,title,content,hitcount,regdate) VALUES(article_seq.nextval,'cream','냐옹','난 아이스크림따위는 먹지않아.',0,SYSDATE);
					
					(sql);	*/
			
			Connection connection= DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD);
			Statement stmt=connection.createStatement();
			String sql="INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)"
					+ " VALUES(article_seq.nextval,'"+bean.getId()+"','"+bean.getTitle()+"','"+bean.getContent()+"',0,SYSDATE)";
			System.out.println("=============SQL:::"+sql);
			rs=stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<ArticleBean> selectAll() {
		List<ArticleBean> list = new ArrayList<>();
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT * FROM %s", DB.TABLE_BOARD));
		ArticleBean bean = null;
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
	public List<ArticleBean> selectById(String id) {
		ArticleBean bean = null;
		List<ArticleBean> list = new ArrayList<>();
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT * FROM Board WHERE id = '%s'",id));
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
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT * FROM Board WHERE article_seq = '"+ seq + "'"));
			
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
	public int count() {
		int result = 0;
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT COUNT(*) AS %s FROM %s"
							,"count", DB.TABLE_BOARD));
			if(rs.next()){
				result = Integer.parseInt(rs.getString("count"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String update(ArticleBean bean) {
		int rs = 0;
		try {
			rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeUpdate(
					"UPDATE Board SET title = '"+bean.getTitle()+"', content = '"+bean.getContent()+"' WHERE article_seq = '"+bean.getArticleSeq()+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return String.valueOf(rs);
	}

	@Override
	public String delete(String seq) {
		int rs = 0;
		try {
			rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeUpdate(
					"DELETE Board WHERE article_seq = '"+seq+"' ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(rs);
	}

}
