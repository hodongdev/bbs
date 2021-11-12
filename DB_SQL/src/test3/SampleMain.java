package test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SampleMain {

	public static void main(String[] args) {
		Connection con;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			con = DriverManager.getConnection(url, "javalink", "javalink");
			SampleDAO sd = new SampleDAO();
			for(int i=0; i<sd.findAll().size(); i++) {
				String id = sd.findAll().get(i).getId();
				String name = sd.findAll().get(i).getName();
				int price = sd.findAll().get(i).getPrice();
				System.out.println("id: " + id);
				System.out.println("name: " + name);
				System.out.println("price: " + price);
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
