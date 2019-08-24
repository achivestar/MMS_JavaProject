package kr.pe.bluering.mms.service;

import java.sql.Connection;
import java.util.Scanner;

import kr.pe.bluering.mms.dao.MemberDAO;
import kr.pe.bluering.mms.db.JdbcUtil;

public class MemberRemoveService {

	public boolean removeMember(String name) {
		boolean isRemoveSuccess = false;
		
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		Scanner sc = new Scanner(System.in);
		// ����ڷκ��� �Է��� �޴´�.
		
		System.out.println("���� �����Ͻðڽ��ϱ�? y/n");
		String ans = sc.next();
		
		if(ans.equals("y")) {  // ����ڰ�  'Y'�� �Է��Ѵٸ� ������ ����
			int deleteCount = memberDAO.deleteMember(name);
			// ������ ȸ���� �̸��� �Ķ���ͷ� �����ϸ鼭 �ش� �̸��� ������ �ִ�
			// ȸ���� ������  DB���� �����ϴ� �޼ҵ带 ȣ���Ѵ�.
			// �޼ҵ带 �����ϸ�  DB���� ���ŵ� ���ڵ� ������ ��ȯ�Ѵ�.
			if(deleteCount>0) {  //��ȯ�� ���ڵ� ������ 1�� �̻��̶��..
				isRemoveSuccess = true;
			}else {
				isRemoveSuccess = false;
			}
		}else {  // ����ڰ� 'Y' �̿� �Է½� �������� ����
			return false;
		}
		
		JdbcUtil.close(con);
		
		return isRemoveSuccess;  
	}

}
