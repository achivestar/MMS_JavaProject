package kr.pe.bluering.mms.action;

import java.util.Scanner;

import kr.pe.bluering.mms.service.MemberRemoveService;
import kr.pe.bluering.mms.util.ConsoleUtil;

public class MemberRemoveAction implements Action {

	@Override
	public void execute(Scanner sc) {
		ConsoleUtil cu = new ConsoleUtil();
		String name = cu.getName("삭제할", sc); 
		// 삭제할 회원의 이름을 콘솔로부터 입력받는다.
		MemberRemoveService memberRemoveService = new MemberRemoveService();
		// 삭제 비즈니스 로직을 처리하는 서비스 객체를 생성하는 부분
		boolean removeSuccess = memberRemoveService.removeMember(name);
		// 서비스 객체 memberRemoveService의 회원정보를 삭제하는 기능을
		//  하는 메소드를 호출하면서 삭제할 회원의 이름을 파라미터로 전송
		
		if(removeSuccess) { // 회원정보 삭제 성공 여부에 따른 결과 메시지 출력
			cu.printRemoveSuccessMessage(name);
		}else {
			cu.printRemoveFailMessage(name);
		}

	}

}
