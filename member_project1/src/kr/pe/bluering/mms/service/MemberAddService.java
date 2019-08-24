package kr.pe.bluering.mms.service;

import java.sql.Connection;

import kr.pe.bluering.mms.dao.MemberDAO;
import kr.pe.bluering.mms.db.JdbcUtil;
import kr.pe.bluering.mms.vo.Member;

public class MemberAddService {

	public boolean addMember(Member newMember) {
		
		boolean isInsertSuccess = false;
		Connection con =  JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		
		int insertCount = memberDAO.insertNewMember(newMember);
		
		if(insertCount>0) {
			isInsertSuccess = true;
		}else {
			return false;
		}
		
		JdbcUtil.close(con);  // close 메소드를 호출하여 필요한 작업을 모두 샐행한 Connection 객체를 
         //  닫아준다.
		return isInsertSuccess;

	}

}
