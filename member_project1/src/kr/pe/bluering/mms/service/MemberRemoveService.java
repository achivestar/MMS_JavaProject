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
		// 사용자로부터 입력을 받는다.
		
		System.out.println("정말 삭제하시겠습니까? y/n");
		String ans = sc.next();
		
		if(ans.equals("y")) {  // 사용자가  'Y'를 입력한다면 삭제를 진행
			int deleteCount = memberDAO.deleteMember(name);
			// 삭제할 회원의 이름을 파라미터로 전송하면서 해당 이름을 가지고 있는
			// 회원의 정보를  DB에서 삭제하는 메소드를 호출한다.
			// 메소드를 실행하면  DB에서 제거된 레코드 개수를 반환한다.
			if(deleteCount>0) {  //반환된 래코드 개수가 1개 이상이라면..
				isRemoveSuccess = true;
			}else {
				isRemoveSuccess = false;
			}
		}else {  // 사용자가 'Y' 이외 입력시 삭제진행 안함
			return false;
		}
		
		JdbcUtil.close(con);
		
		return isRemoveSuccess;  
	}

}
