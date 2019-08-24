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
		String name = cu.getName("검색할", sc); 
		
		MemberSearchService memberSearchService = new MemberSearchService();
		// 검색할 비즈니스 로직을 처리하는 서비스 객체를 생성하는 부분
		ArrayList<Member> searchSuccess  = memberSearchService.searchMember(name);
		//System.out.println(searchSuccess);
		if(searchSuccess != null) { // 회원정보 검색 성공 여부에 따른 결과 메시지 출력
			cu.printSearchSuccessMessage(searchSuccess);
		}
		else if(searchSuccess==null) {
			cu.printSearchFailMessage(name);
		}

	}

}
