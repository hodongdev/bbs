package mms.member.svc;

import java.sql.Connection;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

//8-3. 회원정보 수정 요청을 처리하는 Business Logic이 구현되는 Service 클래스 구현
public class MemberModifyService {

		
	public boolean modifyMember(Member updateMember) {
		boolean isModifySuccess = false;
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		int updateCount = memberDAO.updateMember(updateMember);
		if(updateCount > 0) {
			isModifySuccess = true;
			JdbcUtil.commit(con);
		}else {
			JdbcUtil.rollback(con);
		}
		JdbcUtil.close(con);
		
		return isModifySuccess;
		
	}
	
//	수정할 이름을 불러올때 Member 정보 가져오기
	public Member getOldMember(String name) {
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		Member member = memberDAO.selectOldMember(name);
		
		JdbcUtil.close(con);
		return member;
		
	}
}
