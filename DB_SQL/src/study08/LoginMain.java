package study08;

import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) {
		boolean isStop = false;
		Scanner sc = new Scanner(System.in);
		LoginSVC svc = new LoginSVC();

		do {
			System.out.println("�α��� ȭ���Դϴ�.");
			System.out.println("���̵�� ��й�ȣ�� �Է��ϼ���.");
			System.out.print("���̵� : ");
			String inputID = sc.next();
			System.out.print("��й�ȣ : ");
			String inputPass = sc.next();
			svc.connect();
			svc.login(inputID, inputPass);
			
			
			if (svc.login(inputID, inputPass) == null) {
				System.out.println("���̵� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}else if(svc.login(inputID, inputPass) != null) 
				System.out.println("�α����� ����� ����");
					svc.login(inputID, inputPass);
			isStop = true;

			
		} while (!isStop);

	}

}
