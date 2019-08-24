package kr.pe.bluering.mms.action;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.mms.service.MemberRemoveService;
import kr.pe.bluering.mms.service.MemberSearchService;
import kr.pe.bluering.mms.util.ConsoleUtil;
import kr.pe.bluering.mms.vo.Member;

public class MemberSearchAction implements Action {

	@Override
	public void execute(Scanner sc) {
		ConsoleUtil cu = new ConsoleUtil();
		String name = cu.getName("�˻���", sc); 
		
		MemberSearchService memberSearchService = new MemberSearchService();
		// �˻��� ����Ͻ� ������ ó���ϴ� ���� ��ü�� �����ϴ� �κ�
		ArrayList<Member> searchSuccess  = memberSearchService.searchMember(name);
		//System.out.println(searchSuccess);
		if(searchSuccess != null) { // ȸ������ �˻� ���� ���ο� ���� ��� �޽��� ���
			cu.printSearchSuccessMessage(searchSuccess);
		}
		else if(searchSuccess==null) {
			cu.printSearchFailMessage(name);
		}

	}

}
