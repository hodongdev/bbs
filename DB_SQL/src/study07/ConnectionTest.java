package study07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	Connection con;
//	�ʱ�ȭ ��
	static {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.out.println("����̹��� �����ϴ�.");
			}

	}
	
	public void connect() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			con = DriverManager.getConnection(url, "javalink", "javalink");
			System.out.println("Connection Success!");
		} catch (SQLException e) {
			System.out.println("�ּ�,id,pw�� �ٸ��ϴ�.");
		}
	}
	public static void main(String[] args) {
		
		ConnectionTest ct  = new ConnectionTest();
		ct.connect();
		
		
	}

}
