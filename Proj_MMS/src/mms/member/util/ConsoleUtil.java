package mms.member.util;
//5. ����ڷκ����� �Է��� �ֿܼ��� �о� ���̰ų� �ַܼ� �޽����� ����ϴ� ������ �ϴ� Ŭ���� ����

import java.util.ArrayList;
import java.util.Scanner;

import mms.member.vo.Member;
//Ű���� �Է�
public class ConsoleUtil {
	
	public Member getNewMember(Scanner sc) {
		return new Member();
	}
	
	public void printAddSuccessMessage(Member newMember) {
		System.out.println(newMember.getName() + "ȸ�� ���� �߰� ����");
	}
	
	public void printAddFailMessage(Member newMember) {
		System.out.println(newMember.getName() + "ȸ�� ���� �߰� ����");
	}
	
	public void printMemberList(ArrayList<Member> memberList) {
		//size() : �÷��ǿ� ����Ǿ� �ִ� ����� ������ �����ϴ� �޼ҵ�
	}
	
	public String getName(String msgkind, Scanner sc) {
		return msgkind;
		
	}
	
	public Member getUpdateMember(Scanner sc, Member oldMember) {
		return oldMember;
		
	}
	
	public void printModifySuccessMessage(Member updateMember) {
		System.out.println(updateMember.getName() + "ȸ�� ���� ���� ����");
	}
	
	public void printModifyFailMessage(Member updateMember) {
		System.out.println(updateMember.getName() + "ȸ�� ���� ���� ����");
	}
	
	public void printRemoveSuccessMessage(String name) {
		System.out.println(name + "ȸ���� ���� ���� ����.");
	}
	
	public void printRemoveFailMessage(String name) {
		System.out.println(name + "ȸ���� ���� ���� ����");
	}

}