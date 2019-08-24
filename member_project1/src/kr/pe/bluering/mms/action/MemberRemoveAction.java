package kr.pe.bluering.mms.action;

import java.util.Scanner;

import kr.pe.bluering.mms.service.MemberRemoveService;
import kr.pe.bluering.mms.util.ConsoleUtil;

public class MemberRemoveAction implements Action {

	@Override
	public void execute(Scanner sc) {
		ConsoleUtil cu = new ConsoleUtil();
		String name = cu.getName("������", sc); 
		// ������ ȸ���� �̸��� �ַܼκ��� �Է¹޴´�.
		MemberRemoveService memberRemoveService = new MemberRemoveService();
		// ���� ����Ͻ� ������ ó���ϴ� ���� ��ü�� �����ϴ� �κ�
		boolean removeSuccess = memberRemoveService.removeMember(name);
		// ���� ��ü memberRemoveService�� ȸ�������� �����ϴ� �����
		//  �ϴ� �޼ҵ带 ȣ���ϸ鼭 ������ ȸ���� �̸��� �Ķ���ͷ� ����
		
		if(removeSuccess) { // ȸ������ ���� ���� ���ο� ���� ��� �޽��� ���
			cu.printRemoveSuccessMessage(name);
		}else {
			cu.printRemoveFailMessage(name);
		}

	}

}
