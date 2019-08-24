package kr.pe.bluering.mms.controller;

import java.util.Scanner;

import kr.pe.bluering.mms.action.Action;

public class MemberController {

	public void processRequest(Action action, Scanner sc) {
		try {
			action.execute(sc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
