package p01.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection_Update {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";

			conn = DriverManager.getConnection(url, "javalink", "javalink");
			stmt = conn.createStatement();

			String query = "update goodsinfo set maker='����' where code='10002'";
			int count = stmt.executeUpdate(query);
			if (count > 0)
				System.out.println("������Ʈ�� �Ǿ����ϴ�.");
			else
				System.out.println("������Ʈ�� ���� �ʾҽ��ϴ�.");

		} catch (ClassNotFoundException e) {
			System.out.println("Driver�� ����:: �ش� Ŭ������ ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("��������");
		try {
			conn.close();
		} catch (SQLException e) {

		}
	}

}
