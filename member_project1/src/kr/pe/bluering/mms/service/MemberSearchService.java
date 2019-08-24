package kr.pe.bluering.mms.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.pe.bluering.mms.dao.MemberDAO;
import kr.pe.bluering.mms.db.JdbcUtil;
import kr.pe.bluering.mms.vo.Member;

public class MemberSearchService {

	public ArrayList<Member> searchMember(String name) {
	
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		
		ArrayList<Member> memberList = memberDAO.searchMember(name);
			if(memberList.size()==0) { // 검색결과 memberList의 사이즈가 0 이면 검색이 안된 것이므로  null 리턴
				return null;
			}
			
		JdbcUtil.close(con);
		return memberList;
	}

}
