package mms.member.ui;
//3. 사용자가 메뉴를 선택할 수 있는 화면을 구성해 주는 클래스
import java.util.Scanner;

import mms.member.action.Action;
import mms.member.action.MemberAddAction;
import mms.member.controller.MemberController;

public class MemberUI {

	public static void main(String[] args) {
		
		boolean isStop = false;
		MemberController memberController = new MemberController();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("=====회원관리 프로그램=====");
			System.out.println("1.회원등록");
			System.out.println("2.회원목록보기");
			System.out.println("3.회원정보수정");
			System.out.println("4.회원정보삭제");
			System.out.println("5.프로그램종료");
			System.out.println("메뉴번호 : ");
			int menu = sc.nextInt();
			Action action = null;
			switch(menu) {
			case 1:
				action = new MemberAddAction();//1.회원등록
				break;
				
				
				
				
			default:
				break;
			}
			
			if(action != null) {
				memberController.processRequest(action, sc);
			}
			
			
			
			
			
			
			
		}while (!isStop);

	}

}
