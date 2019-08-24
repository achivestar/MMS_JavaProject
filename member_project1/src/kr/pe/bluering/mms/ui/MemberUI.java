package kr.pe.bluering.mms.ui;

import java.util.Scanner;

import kr.pe.bluering.mms.action.Action;
import kr.pe.bluering.mms.action.MemberAddAction;
import kr.pe.bluering.mms.action.MemberListAction;
import kr.pe.bluering.mms.action.MemberModifyAction;
import kr.pe.bluering.mms.action.MemberRemoveAction;
import kr.pe.bluering.mms.action.MemberSearchAction;
import kr.pe.bluering.mms.controller.MemberController;

public class MemberUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean isStop = false;
		MemberController memberController = new MemberController();
		Action action = null;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("======== MMS JavaProgram Application ========");
			System.out.println("========     Project By bluering     ========");
			System.out.println("=============================================");
			System.out.println("1.ȸ�����");
			System.out.println("2.ȸ�����");
			System.out.println("3.ȸ������");
			System.out.println("4.ȸ������");
			System.out.println("5.ȸ���˻�");
			System.out.println("6.���α׷�����");
			int menu = sc.nextInt();

			switch (menu) {
				case 1:
					action = new MemberAddAction();
					break;
				case 2:
					action = new MemberListAction();
					break;
				case 3:
					action = new MemberModifyAction();
					break;
				case 4:
					action = new MemberRemoveAction();
					break;
				case 5:
					action = new MemberSearchAction();
					break;
				case 6:
					System.out.print("���α׷�����");
					isStop = true;
					break;
				default:
					break;
			}
			
			if(action != null) {
				memberController.processRequest(action,sc);
			}
		} while (!isStop);
	}

}
