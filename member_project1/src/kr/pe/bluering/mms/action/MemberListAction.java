package kr.pe.bluering.mms.action;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.mms.service.MemberListService;
import kr.pe.bluering.mms.util.ConsoleUtil;
import kr.pe.bluering.mms.vo.Member;

public class MemberListAction implements Action {

	@Override
	public void execute(Scanner sc) {
		
		ConsoleUtil cu = new ConsoleUtil();
		
		MemberListService memberListService = new MemberListService();
		ArrayList<Member> memberList = memberListService.getMemberList();
		
		cu.printMemberList(memberList);
	}

}
