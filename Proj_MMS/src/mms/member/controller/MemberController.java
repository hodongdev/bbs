package mms.member.controller;
//6. ������� ��ü ��û�� �����ϴ� Ŭ���� ����
import java.util.Scanner;

import mms.member.action.Action;

public class MemberController {

	public void processRequest(Action action, Scanner sc) {
		try {
			action.execute(sc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}