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
		// ���� ����� �Ǵ� ȸ���� �̸��� �Ķ���� ������ �޾Ƽ� �ش� ȸ���� ���� ������ ��ȯ�ϴ� �޼ҵ带 �����ϴ� �κ�
		JdbcUtil.close(con);
		return oldMember;
	}

	public boolean modifyMember(Member updateMember) {
		// ȸ���� ���� ������ �Ķ���� ������ �޾Ƽ� ȸ���� ���� ������ 
		// �Ķ���ͷ� ���۵� ���ο� ������ �����ϴ� �޼ҵ�
		boolean isModifySuccess = false;
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		
		int updateCount = memberDAO.updateMember(updateMember);
		// DB���� ȸ���� ���Ǥ����� ���ο� ������ �����ϴ� �޼ҵ带 ȣ���Ѵ�.
		
		
		if(updateCount>0) {  //ȸ������ ���� ���� ���ο� ���� ó��
			isModifySuccess = true;
			
		}else {
			isModifySuccess =  false;
		}
			
		return isModifySuccess;
	}

}
