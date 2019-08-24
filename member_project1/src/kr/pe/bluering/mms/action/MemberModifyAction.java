package kr.pe.bluering.mms.action;

import java.util.Scanner;

import kr.pe.bluering.mms.service.MemberModifyService;
import kr.pe.bluering.mms.util.ConsoleUtil;
import kr.pe.bluering.mms.vo.Member;

public class MemberModifyAction implements Action {

	@Override
	public void execute(Scanner sc) {
		ConsoleUtil cu = new ConsoleUtil();
		String name = cu.getName("������",sc); 
		//������ ȸ���� �̸��� �ַܼκ��� �Է� �޴µ�.
		
		MemberModifyService memberModifyService = new MemberModifyService();
		//ȸ�������� �����ϴ� ����Ͻ� ������ ó���ϴ� ���� ��ü�� �����ϴ� �κ�
		
		Member oldMember = memberModifyService.getOldMember(name);
		//������ ����� �Ǵ� ȸ���� �����ϱ� ���� ������ ���´�.
		
		Member updateMember = cu.getUpdateMember(sc,oldMember);
		// ������ ����� �Ǵ� ȸ���� ���� ����(oldMember)�� �Ķ���ͷ� �����ϸ鼭
		// �ֻܼ󿡼� ȸ���� ���� ������ �Է� �޴� �κ��̴�.
		
		boolean isModifySuccess = memberModifyService.modifyMember(updateMember);
		// ȸ���� ���� ������ �Ķ���ͷ� �����ϸ鼭 ȸ������ ���� ó���� �ϴ� �޼ҵ带 ȣ���Ѵ�.
		
		if(isModifySuccess) {  // ���� ���ο� ���� �޽����� ���
			cu.printModifySuccessMessage(updateMember);
		}else {
			cu.printModifyFailMemssage(updateMember);
		}
	}

}
