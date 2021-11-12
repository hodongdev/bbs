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

//	�������ν��� ȣ���� ������ �Է�
	public void insert() {
		System.out.println("���̵� �Է��ϼ���.");
		id = sc.next();
		System.out.println("�н����带 �Է��ϼ���.");
		passwd = sc.next();
		System.out.println("�̸��� �Է��ϼ���.");
		name = sc.next();
		System.out.println("���̸� �Է��ϼ���.");
		age = sc.nextInt();
		System.out.println("�ּҸ� �Է��ϼ���.");
		addr = sc.next();
		System.out.println("�̸����� �Է��ϼ���.");
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
				System.out.println("���̵� : "+id1+", ��й�ȣ : " +passwd1+", �̸� : "+name1+
						", ���� : "+age1+", �ּ� : "+addr1+", �̸��� : "+email1);
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
		System.out.println("*** �������ν��� ȣ�� �� ������ ***");
		ta.connet();
		ta.insert();
		ta.connet();
		System.out.println("==== �������ν��� ȣ�� �� ������====");
		ta.connet();
		ta.insertMember();
		ta.connet();
		ta.select();
	}

}