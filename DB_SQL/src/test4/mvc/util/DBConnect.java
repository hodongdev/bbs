package test4.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private static DBConnect db = new DBConnect();
	private Connection conn = null;

	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";

//	�⺻ ������ - ��ü ������ �ʱⰪ ����
	private DBConnect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(url, "javalink", "javalink");
		} catch (SQLException e) {

		} catch (ClassNotFoundException e) {

		}

	}

//	Singleton: �޼ҵ带 ���� ��ü������ �ѹ���, ���� Ŭ�������� ����
	public static DBConnect getInstance() {
		return db;
	}

//	DB���� �Ϸ�� ����
	public Connection getConnection() {
		return conn;

	}
}
