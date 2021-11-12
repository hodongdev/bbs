package study08;

import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) {
		boolean isStop = false;
		Scanner sc = new Scanner(System.in);
		LoginSVC svc = new LoginSVC();

		do {
			System.out.println("로그인 화면입니다.");
			System.out.println("아이디와 비밀번호를 입력하세요.");
			System.out.print("아이디 : ");
			String inputID = sc.next();
			System.out.print("비밀번호 : ");
			String inputPass = sc.next();
			svc.connect();
			svc.login(inputID, inputPass);
			
			
			if (svc.login(inputID, inputPass) == null) {
				System.out.println("아이디나 비밀번호가 일치하지 않습니다.");
			}else if(svc.login(inputID, inputPass) != null) 
				System.out.println("로그인한 사용자 정보");
					svc.login(inputID, inputPass);
			isStop = true;

			
		} while (!isStop);

	}

}
