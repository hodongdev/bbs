package study07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDTest {

	Connection con;
	Statement stmt;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {

		}
	}

	public void connect() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			con = DriverManager.getConnection(url, "javalink", "javalink");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection Success!");
	}

	public void insert() {
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String query = "insert into member1 values('aaa','1111','ȫ�浿',22,'�����','a@a.com')";
		
		try {
		int count = stmt.executeUpdate(query);
		
		if(count > 0)
			System.out.println("insert success!");
		else
			System.out.println("insert failed!.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void select() {
		try {
			stmt = con.createStatement();
			String query = "select * from member1";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString("name");
				int age = rs.getInt(4);
				String addr = rs.getString("addr");
				String email = rs.getString("email");
				System.out.println("���̵� : "+id+",��й�ȣ : "+password+",�̸� : "+name+
						           ",���� : "+age+",�ּ� : "+addr+",�̸��� : "+email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public void update() {
		try {
			stmt = con.createStatement();
			String query = "update member1 set addr='�λ��' where id='aaa'";
			int count = stmt.executeUpdate(query);
			if (count > 0)
				System.out.println("Update Success!");
			else
				System.out.println("Update Failed!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void delete() {
		try {
			stmt = con.createStatement();
			String query = "delete member1 where id='aaa'";
			int count = stmt.executeUpdate(query);
			if(count > 0)
				System.out.println("�����Ͱ� �����Ǿ����ϴ�.");
			else
				System.out.println("�����Ͱ� �������� �ʾҽ��ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		
		CRUDTest st = new CRUDTest();
		st.connect();
		st.insert();
		
		System.out.println("insert ���� ��");
		st.connect();
		st.select();

		st.connect();
		st.update();

		System.out.println("update ���� ��");
		st.connect();
		st.select();
		st.delete();
		
		System.out.println("delete ���� ��");
		st.connect();
		st.select();

	}

}
