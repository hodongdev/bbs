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
		String query = "insert into member1 values('aaa','1111','홍길동',22,'서울시','a@a.com')";
		
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
				System.out.println("아이디 : "+id+",비밀번호 : "+password+",이름 : "+name+
						           ",나이 : "+age+",주소 : "+addr+",이메일 : "+email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public void update() {
		try {
			stmt = con.createStatement();
			String query = "update member1 set addr='부산시' where id='aaa'";
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
				System.out.println("데이터가 삭제되었습니다.");
			else
				System.out.println("데이터가 삭제되지 않았습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		
		CRUDTest st = new CRUDTest();
		st.connect();
		st.insert();
		
		System.out.println("insert 수행 후");
		st.connect();
		st.select();

		st.connect();
		st.update();

		System.out.println("update 수행 후");
		st.connect();
		st.select();
		st.delete();
		
		System.out.println("delete 수행 후");
		st.connect();
		st.select();

	}

}
