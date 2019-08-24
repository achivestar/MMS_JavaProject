package kr.pe.bluering.mms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.pe.bluering.mms.vo.Member;

public class MemberDAO {
	
	Connection con;
	
	public MemberDAO(Connection con) {
		this.con = con;
	}

	public int insertNewMember(Member newMember) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member (name,addr,nation,email,age) VALUES (?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,newMember.getName());
			pstmt.setString(2, newMember.getAddr());
			pstmt.setString(3, newMember.getNation());
			pstmt.setString(4, newMember.getEmail());
			pstmt.setInt(5, newMember.getAge());
			
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertCount;
	}

	public ArrayList<Member> selectMemberList() {
		ArrayList<Member> memberList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			memberList = new ArrayList<Member>();
			Member member = null;
			while(rs.next()) {
				member = new Member(
						rs.getString("name"),
						rs.getString("addr"),
						rs.getString("nation"),
						rs.getString("email"),
						rs.getInt("age"));
						memberList.add(member);			
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberList;
	}

	public Member selectOldMember(String name) {
		Member oldMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member WHERE name = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				oldMember = new Member(
					rs.getString("name"),
					rs.getString("addr"),
					rs.getString("nation"),
					rs.getString("email"),
					rs.getInt("age")
					);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oldMember;
	}

	public int updateMember(Member updateMember) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE member set addr=?, nation=?, email=?, age=? where name = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateMember.getAddr());
			pstmt.setString(2, updateMember.getNation());
			pstmt.setString(3, updateMember.getEmail());
			pstmt.setInt(4, updateMember.getAge());
			pstmt.setString(5, updateMember.getName());
			
			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateCount;
	}

	public int deleteMember(String name) {
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM member WHERE name = ?";
		System.out.println(sql);
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteCount;
	}

	public ArrayList<Member> searchMember(String name) {
		ArrayList<Member> memberList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member where name = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			//System.out.println(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			//System.out.println();
			memberList = new ArrayList<Member>();
			Member member = null;
			
			while(rs.next()) {
				member = new Member(
						rs.getString("name"),
						rs.getString("addr"),
						rs.getString("nation"),
						rs.getString("email"),
						rs.getInt("age"));
						memberList.add(member);			
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberList;
	}

}
