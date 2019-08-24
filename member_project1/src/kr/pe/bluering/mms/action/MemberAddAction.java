package kr.pe.bluering.mms.action;

import java.util.Scanner;

import kr.pe.bluering.mms.service.MemberAddService;
import kr.pe.bluering.mms.util.ConsoleUtil;
import kr.pe.bluering.mms.vo.Member;

public class MemberAddAction implements Action {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		ConsoleUtil cu = new ConsoleUtil();
		Member newMember = cu.getNewMember(sc);
		
		MemberAddService memberAddService = new MemberAddService();
		
		boolean isAddSuccess = memberAddService.addMember(newMember);
		
		if(isAddSuccess) {
			cu.printAddSuccessMessage(newMember);
		}else {
			cu.printAddFailMessage(newMember);
		}
	}

}
