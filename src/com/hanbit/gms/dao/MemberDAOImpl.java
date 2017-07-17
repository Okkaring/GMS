package com.hanbit.gms.dao;

import com.hanbit.gms.constants.DB;
import com.hanbit.gms.dao.MemberDAO;
import com.hanbit.gms.domain.MemberBean;

import java.sql.*;					//0번
import java.util.ArrayList;
import java.util.List;
public class MemberDAOImpl implements MemberDAO{
	public MemberDAOImpl(){
		try {
			Class.forName(DB.DRIVER);
		} catch (Exception e) {
			System.out.println("DRIVER LOAD FAIL...");
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(MemberBean member) {
		int rs = 0;
		try {
			rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeUpdate(
					String.format("INSERT INTO %s(%s,%s,%s,%s,%s) VALUES('%s','%s','%s','%s',SYSDATE)"
							,DB.TABLE_MEMBER, DB.MEMBER_ID,DB.MEMBER_PW,DB.MEMBER_SSN,DB.MEMBER_NAME,DB.MEMBER_REGDATE
							,member.getId(),member.getPw(),member.getSsn(),member.getName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean> list = new ArrayList<>();
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT * FROM %s",
					DB.TABLE_MEMBER));
			MemberBean member = null;
			
			while(rs.next()){
				member = new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setPw(rs.getString(DB.MEMBER_PW));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
		
	}

	@Override
	public int countMembers() {
		int result=0;
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT COUNT(*) AS %s FROM %s",
					"count",DB.TABLE_MEMBER));
			if(rs.next()){
				result = Integer.parseInt(rs.getString("count"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean member = new MemberBean();
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT * FROM Member WHERE id = '"+id+"'"));
			if(rs.next()){
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setPw(rs.getString(DB.MEMBER_PW));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		MemberBean member =null;
		List<MemberBean> list = new ArrayList<>();
		try {
			Class.forName(DB.DRIVER);
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT * FROM Member WHERE name = '"+name+"'"));
			while(rs.next()){
				member =  new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setPw(rs.getString(DB.MEMBER_PW));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(MemberBean bean) {
		int rs = 0;
		try {
			Class.forName(DB.DRIVER);
			rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeUpdate(
					String.format("%s", "")
					);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int delete(String id) {
		int rs = 0;
		try {
			Class.forName(DB.DRIVER);
			rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeUpdate(
					String.format("%s", "")
					);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	
	
}
