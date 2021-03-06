package mms.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberDAO {
//	9. Oracle DB로 필요한 SQL구문을 전송하는 클래스 구현
	Connection con = null;

	public MemberDAO(Connection con) {
		this.con = con;
	}

//	1.
	public int insertNewMember(Member newMember) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "INSERT INTO mms_member VALUES(member_id_seq.nextval,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newMember.getName());
			pstmt.setString(2, newMember.getAddr());
			pstmt.setString(3, newMember.getNation());
			pstmt.setString(4, newMember.getEmail());
			pstmt.setInt(5, newMember.getAge());
			
			insertCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
		}finally {
			JdbcUtil.close(pstmt);
		}
		return insertCount;

	}

//	2.회원목록 보기
	public ArrayList<Member> selectMemberList() {
		ArrayList<Member> memberList = new ArrayList<>();
		String sql = "select * from mms_member";
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String nation = rs.getString("nation");
				String email = rs.getString("email");
				int age = rs.getInt("age");
				
				member = new Member(name, addr, nation, email, age);
				memberList.add(member);
			}
		} catch (SQLException e) {
			
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		
		return memberList;
	}

//	3.update 할때 특정 회원 정보 보기
	public Member selectOldMember(String name) {
		String sql = "select * from mms_member where name=?";
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String name2 = rs.getString("name");
				String addr = rs.getString("addr");
				String nation = rs.getString("nation");
				String email = rs.getString("email");
				int age = rs.getInt("age");
				
				member = new Member(name2, addr, nation, email, age);
			}
		} catch (SQLException e) {
			
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		
		return member;
	}

//	4.회원 정보 수정
	public int updateMember(Member updateMember) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "update mms_member set nation=?,addr=?,email=?,age=? where name=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateMember.getNation());
			pstmt.setString(2, updateMember.getAddr());
			pstmt.setString(3, updateMember.getEmail());
			pstmt.setInt(4, updateMember.getAge());
			pstmt.setString(5, updateMember.getName());
			
			updateCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
		}finally {
			JdbcUtil.close(pstmt);
		}
		return updateCount;

	}

//	5.
	public int deleteMember(String name) {
		PreparedStatement pstmt = null;
		int deleteCount = 0;
		String sql = "delete mms_member where name=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
		
			deleteCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
		}finally {
			JdbcUtil.close(pstmt);
		}
		return deleteCount;

	}
}
