package mms.member.ui;
//3. ����ڰ� �޴��� ������ �� �ִ� ȭ���� ������ �ִ� Ŭ����
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
			System.out.println("=====ȸ������ ���α׷�=====");
			System.out.println("1.ȸ�����");
			System.out.println("2.ȸ����Ϻ���");
			System.out.println("3.ȸ����������");
			System.out.println("4.ȸ����������");
			System.out.println("5.���α׷�����");
			System.out.println("�޴���ȣ : ");
			int menu = sc.nextInt();
			Action action = null;
			switch(menu) {
			case 1:
				action = new MemberAddAction();//1.ȸ�����
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
