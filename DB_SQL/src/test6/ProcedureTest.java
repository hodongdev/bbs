package test6;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProcedureTest {
	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	Statement stmt = null;
	String id;
	String passwd;
	String name;
	int age;
	String addr;
	String email;

	public void connet() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			try {
				conn = DriverManager.getConnection(url, "javalink", "javalink");
			} catch (SQLException e) {

			}
		} catch (ClassNotFoundException e) {

		
		}
		System.out.println("Connection Success!");
	}

//	저장프로시저 호출전 데이터 입력
	public void insert() {
		System.out.println("아이디를 입력하세요.");
		id = sc.next();
		System.out.println("패스워드를 입력하세요.");
		passwd = sc.next();
		System.out.println("이름을 입력하세요.");
		name = sc.next();
		System.out.println("나이를 입력하세요.");
		age = sc.nextInt();
		System.out.println("주소를 입력하세요.");
		addr = sc.next();
		System.out.println("이메일을 입력하세요.");
		email = sc.next();
		System.out.println("insert success!");
	}

	public void select() {
		try {
			stmt = conn.createStatement();
			String query = "select * from member2";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id1 = rs.getString(1);
				String passwd1 = rs.getString(2);
				String name1 = rs.getString(3);
				int age1 = rs.getInt(4);
				String addr1 = rs.getString(5);
				String email1 = rs.getString(6);
				System.out.println("아이디 : "+id1+", 비밀번호 : " +passwd1+", 이름 : "+name1+
						", 나이 : "+age1+", 주소 : "+addr1+", 이메일 : "+email1);
			}
		} catch (SQLException e) {
			
		}
	
		
	}

	public void insertMember() {
		try {
			CallableStatement cs = conn.prepareCall("{call member_data(?,?,?,?,?,?)}");
			cs.setString(1, id);
			cs.setString(2, passwd);
			cs.setString(3, name);
			cs.setInt(4, age);
			cs.setString(5, addr);
			cs.setString(6, email);
			
			cs.execute();
		} catch (SQLException e) {
			
		}
		System.out.println("insert success!");
	}

	public static void main(String[] args) {
		ProcedureTest ta = new ProcedureTest();
		System.out.println("*** 저장프로시저 호출 전 데이터 ***");
		ta.connet();
		ta.insert();
		ta.connet();
		System.out.println("==== 저장프로시저 호출 후 데이터====");
		ta.connet();
		ta.insertMember();
		ta.connet();
		ta.select();
	}

}
