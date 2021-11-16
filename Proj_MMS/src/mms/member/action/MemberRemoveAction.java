package mms.member.action;

import java.util.Scanner;


import mms.member.svc.MemberRemoveService;
import mms.member.util.ConsoleUtil;


public class MemberRemoveAction implements Action {

	@Override
	public void execute(Scanner sc)  {
		ConsoleUtil cu = new ConsoleUtil();
		String name = cu.getName("삭제할", sc);
		MemberRemoveService memberRemoveService = new MemberRemoveService();
		boolean isDeleteSuccess = memberRemoveService.removeMember(name);
		if(isDeleteSuccess)
			cu.printRemoveSuccessMessage(name);
		else
			cu.printRemoveFailMessage(name);;

	}

}
