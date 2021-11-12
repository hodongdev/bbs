package mms.member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//1. DB���� ���� ��� Ŭ����
public class JdbcUtil {
	static Connection con;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			
		}
	}
	
	public static Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			con = DriverManager.getConnection(url, "javalink", "javalink");
		} catch (SQLException e) {
			
		}
		return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			
		}
	}
	
//	transaction ó�� �޼ҵ�
	public static void commit(Connection con) {
		try {
			con.commit();//insert,update,delete
		} catch (SQLException e) {
			
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();//insert,update,delete
		} catch (SQLException e) {
			
		}
	}
}