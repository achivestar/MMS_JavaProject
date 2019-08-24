package kr.pe.bluering.mms.action;

import java.util.Scanner;

import kr.pe.bluering.mms.service.MemberModifyService;
import kr.pe.bluering.mms.util.ConsoleUtil;
import kr.pe.bluering.mms.vo.Member;

public class MemberModifyAction implements Action {

	@Override
	public void execute(Scanner sc) {
		ConsoleUtil cu = new ConsoleUtil();
		String name = cu.getName("수정할",sc); 
		//수정할 회원의 이름을 콘솔로부터 입력 받는디.
		
		MemberModifyService memberModifyService = new MemberModifyService();
		//회원정보를 수정하는 비즈니스 로직을 처리하는 서비스 객체를 생성하는 부분
		
		Member oldMember = memberModifyService.getOldMember(name);
		//수정할 대상이 되는 회원의 수정하기 전의 정보를 얻어온다.
		
		Member updateMember = cu.getUpdateMember(sc,oldMember);
		// 수정할 대상이 되는 회원의 이전 정보(oldMember)를 파라미터로 전송하면서
		// 콘솔상에서 회원의 수정 정보를 입력 받는 부분이다.
		
		boolean isModifySuccess = memberModifyService.modifyMember(updateMember);
		// 회원의 수정 정보를 파라미터로 전송하면서 회원정보 수정 처리를 하는 메소드를 호출한다.
		
		if(isModifySuccess) {  // 수정 여부에 따른 메시지를 출력
			cu.printModifySuccessMessage(updateMember);
		}else {
			cu.printModifyFailMemssage(updateMember);
		}
	}

}
