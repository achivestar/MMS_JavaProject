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
			if(memberList.size()==0) { // �˻���� memberList�� ����� 0 �̸� �˻��� �ȵ� ���̹Ƿ�  null ����
				return null;
			}
			
		JdbcUtil.close(con);
		return memberList;
	}

}
