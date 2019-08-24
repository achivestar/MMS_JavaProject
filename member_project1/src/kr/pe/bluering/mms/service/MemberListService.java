package kr.pe.bluering.mms.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.pe.bluering.mms.dao.MemberDAO;
import kr.pe.bluering.mms.db.JdbcUtil;
import kr.pe.bluering.mms.vo.Member;

public class MemberListService {

	public ArrayList<Member> getMemberList() {
		
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		
		ArrayList<Member> memberList = memberDAO.selectMemberList();
		
		//JdbcUtil.close(con);
		return memberList;
	}

}
