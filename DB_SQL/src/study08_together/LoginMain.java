package study08_together;


import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) {
		boolean isStop = false;
		LoginSVC loginSVC = new LoginSVC();
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("�α��� ȭ���Դϴ�.");
			System.out.println("���̵�� ��й�ȣ�� �Է��ϼ���.");
			System.out.print("���̵� : ");
			String id  = sc.next();
			System.out.print("��й�ȣ : ");
			String passwd = sc.next();
			User user = loginSVC.login(id, passwd);
			
//			user = 'aaa','aaa','ȫ�浿',22,'�����','a@a.com'
			if(user == null){
				System.out.println("���̵� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
			else{
				System.out.println("�α����� ����� ����");
				System.out.println(user);
//				break,true
				isStop=true;
			}
		}while(!isStop);
		
	}
}

