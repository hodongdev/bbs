package p01.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//CRUD: Create/Read/Update/Delete
public class CRUDConnection {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(url, "javalink", "javalink");
			stmt = conn.createStatement();
			String query = "select * from goodsinfo";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String code = rs.getString(1);
				String name = rs.getString("name");
				String price = rs.getString(3);
				String maker = rs.getString("maker");
				System.out.println(code + " : " + name + " : " + price + " : " + maker );
			}

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
