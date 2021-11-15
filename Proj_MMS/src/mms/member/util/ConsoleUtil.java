package mms.member.util;
//5. 사용자로부터의 입력을 콘솔에서 읽어 들이거나 콘솔로 메시지를 출력하는 역할을 하는 클래스 구현

import java.util.ArrayList;
import java.util.Scanner;
import mms.member.vo.Member;
//키보드 입력
public class ConsoleUtil {
//	1.회원 등록
	public Member getMember(Scanner sc) {
		System.out.println("등록할 회원정보를 입력하세요?");
		System.out.println("이름 : ");
		String name = sc.next();
		
		
		System.out.println("주소 : ");
		String addr = sc.next();
		
		
		System.out.println("국가 : ");
		String nation = sc.next();
		
		
		System.out.println("이메일 : ");
		String email = sc.next();
		
		
		System.out.println("나이 : ");
		int age = sc.nextInt();
		System.out.println(name + " 회원 정보 입력 성공");
		return new Member(name, addr, nation, email, age);
	}
	
	public void printAddSuccessMessage(Member newMember) {
		System.out.println(newMember.getName() + "회원 정보 추가 성공");
	}
	
	public void printAddFailMessage(Member newMember) {
		System.out.println(newMember.getName() + "회원 정보 추가 실패");
	}
	
	public void printMemberList(ArrayList<Member> memberList) {
		//size() : 컬렉션에 저장되어 있는 요소의 개수를 리턴하는 메소드
	}
	
	public String getName(String msgkind, Scanner sc) {
		
		return msgkind;
		
	}
	
	public Member getUpdateMember(Scanner sc, Member oldMember) {
		return oldMember;
	}
	
	public void printModifySuccessMessage(Member updateMember) {
		System.out.println(updateMember.getName() + "회원 정보 수정 성공");
	}
	
	public void printModifyFailMessage(Member updateMember) {
		System.out.println(updateMember.getName() + "회원 정보 수정 실패");
	}
	
	public void printRemoveSuccessMessage(String name) {
		System.out.println(name + "회원의 정보 삭제 성공.");
	}
	
	public void printRemoveFailMessage(String name) {
		System.out.println(name + "회원의 정보 삭제 실패");
	}

}
