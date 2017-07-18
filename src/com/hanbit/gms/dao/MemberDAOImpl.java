package com.hanbit.gms.dao;

import com.hanbit.gms.constants.DB;
import com.hanbit.gms.constants.SQL;
import com.hanbit.gms.constants.Vendor;
import com.hanbit.gms.dao.MemberDAO;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.factory.DatabaseFactory;

import java.sql.*;					//0번
import java.util.ArrayList;
import java.util.List;
public class MemberDAOImpl implements MemberDAO{
	
		public static MemberDAOImpl getInstance() {
			return new MemberDAOImpl();
		}
	private MemberDAOImpl(){}
	
	@Override
	public String insert(MemberBean member) {
		String rs ="";
		try {
			PreparedStatement pstmt =DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_INSERT);
			System.out.println("INSERT SQL : "+ SQL.MEMBER_INSERT);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getSsn());
			pstmt.setString(4, member.getName());
			rs = String.valueOf(pstmt.executeUpdate());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean> list = new ArrayList<>();
		MemberBean member = null;
		try {
			ResultSet rs =DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_LIST).executeQuery();
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
	public String countMembers() {
		String result="";
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.COUNT_MEMBERS).executeQuery();
			if(rs.next()){
				result = rs.getString("count");
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
			PreparedStatement pstmt =DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYID);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
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
			PreparedStatement pstmt =DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYNAME);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
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
	public String update(MemberBean bean) {
		String rs = "";
		try {
			PreparedStatement pstmt =DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_UPDATE);
			pstmt.setString(1, bean.getPw());
			pstmt.setString(1, bean.getId());
			rs = String.valueOf(pstmt.executeQuery());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String delete(String id) {
		String rs = "";
		try {
			PreparedStatement pstmt =DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_DELETE);
			pstmt.setString(1, id);
			pstmt.setString(1, id);
			rs = String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	
	
}
