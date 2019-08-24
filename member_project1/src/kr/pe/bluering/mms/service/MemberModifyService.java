package kr.pe.bluering.mms.service;

import java.sql.Connection;

import kr.pe.bluering.mms.dao.MemberDAO;
import kr.pe.bluering.mms.db.JdbcUtil;
import kr.pe.bluering.mms.vo.Member;

public class MemberModifyService {

	public Member getOldMember(String name) {
		Member oldMember = null;
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		oldMember = memberDAO.selectOldMember(name);
		// 수정 대상이 되는 회원의 이름을 파라미터 변수로 받아서 해당 회원의 이전 정보를 반환하는 메소드를 정의하는 부분
		JdbcUtil.close(con);
		return oldMember;
	}

	public boolean modifyMember(Member updateMember) {
		// 회원의 수정 정보를 파라미터 변수로 받아서 회원의 이전 정보를 
		// 파라미터로 전송된 새로운 정보로 변경하는 메소드
		boolean isModifySuccess = false;
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		
		int updateCount = memberDAO.updateMember(updateMember);
		// DB에서 회원의 저ㅗㅇ보를 새로운 정보로 수정하는 메소드를 호출한다.
		
		
		if(updateCount>0) {  //회원정보 수정 성공 여부에 따라 처리
			isModifySuccess = true;
			
		}else {
			isModifySuccess =  false;
		}
			
		return isModifySuccess;
	}

}
