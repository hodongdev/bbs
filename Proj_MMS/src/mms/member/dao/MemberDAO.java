package mms.member.dao;

import java.sql.Connection;
import java.util.ArrayList;

import mms.member.vo.Member;

public class MemberDAO {
//9. Oracle DB로 필요한 SQL구문을 전송하는 클래스 구현
	Connection con;
	public MemberDAO(Connection con) {
		this.con = con;
	}
	
	public int insertNewMember(Member newMember) {
		
		String sql = "insert into mms_member values()";
		
		return 0;
		
	}
	
	
	
	
	public ArrayList<Member> selectMemberList() {
		return null;
		
	}
	
	public int updateMember(Member updateMember) {
		return 0;
		
	}
	
	public int deleteMember(String name) {
		return 0;
		
	}
}
