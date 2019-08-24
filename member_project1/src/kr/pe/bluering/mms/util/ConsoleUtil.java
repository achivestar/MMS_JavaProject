package kr.pe.bluering.mms.util;

import java.util.ArrayList;
import java.util.Scanner;

import kr.pe.bluering.mms.vo.Member;

public class ConsoleUtil {

	public Member getNewMember(Scanner sc) {
		System.out.println("����� ȸ�������� �Է��ϼ���");
		System.out.print("�̸� : ");
		String name = sc.next().trim();
		
		System.out.print("�ּ� : ");
		String addr = sc.next().trim();
		
		System.out.print("�̸��� : ");
		String email = sc.next().trim();
		
		System.out.print("���� : ");
		String nation = sc.next().trim();
		
		System.out.print("���� : ");
		int age = sc.nextInt();
		
		return new Member(name,addr,nation,email,age);
	}

	public void printAddSuccessMessage(Member newMember) {
		System.out.println(newMember.getName()+" ȸ������ �߰� ����");
		
	}

	public void printAddFailMessage(Member newMember) {
		System.out.println(newMember.getName()+" ȸ������ �߰� ����");
	}

	public void printMemberList(ArrayList<Member> memberList) {
		for(int i=0; i<memberList.size();i++) {
			Member data = memberList.get(i);
			String name = data.getName();
			String addr = data.getAddr();
			String nation = data.getNation();
			String email = data.getEmail();
			int age = data.getAge();
			System.out.println("�̸� : "+name+" ,�ּ� : "+addr+" ,���� : "+nation+" ,�̸��� : "+email+" ,���� : "+age);
		}
		
	}

	public String getName(String string, Scanner sc) {
		System.out.println(string + "ȸ���� �̸��� �Է��ϼ���.");
		System.out.print("ȸ���̸� : "); 
		return sc.next();
	}

	public Member getUpdateMember(Scanner sc, Member oldMember) {
		System.out.println("������ ȸ�������� �Է��ϼ���.");
		System.out.print("���� ���� : " + oldMember.getNation());
		System.out.print("������ ���� : ");
		String nation = sc.next();
		
		System.out.print("���� �ּ� : " + oldMember.getAddr());
		System.out.print("������ �ּ� : ");
		String addr = sc.next();
		
		
		System.out.print("���� �̸��� : " + oldMember.getEmail());
		System.out.print("������ �̸��� : ");
		String email = sc.next();
		
		System.out.print("���� ���� : " + oldMember.getAge());
		System.out.print("������ ���� : ");
		int age = sc.nextInt();
		
		return new Member(oldMember.getName(),addr,nation,email,age);

	}

	public void printModifySuccessMessage(Member updateMember) {
		System.out.println(updateMember.getName() + " ȸ������ ���� ����");
		
	}

	public void printModifyFailMemssage(Member updateMember) {
		System.out.println(updateMember.getName() + " ȸ������ ���� ����");
		
	}

	public void printRemoveSuccessMessage(String name) {
		System.out.println(name+ " ȸ������ ���� ����");
		
	}

	public void printRemoveFailMessage(String name) {
		System.out.println(name+ " ȸ������ ����  ����");
		
	}

	public void printSearchSuccessMessage(ArrayList<Member> searchSuccess) {
		for(int i=0; i<searchSuccess.size();i++) {
			Member data = searchSuccess.get(i);
			String name = data.getName();
			String addr = data.getAddr();
			String nation = data.getNation();
			String email = data.getEmail();
			int age = data.getAge();
			System.out.println("�̸� : "+name+" ,�ּ� : "+addr+" ,���� : "+nation+" ,�̸��� : "+email+" ,���� : "+age);
		}
		
	}

	public void printSearchFailMessage(String name) {
		 System.out.println(name + "�� �����ϴ�.");
	}

}
