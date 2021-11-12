package test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SampleDAO {

	public ArrayList<SampleDTO> findAll() {
		ArrayList<SampleDTO> sampleDTOs = new ArrayList<SampleDTO>();
		Connection con;
		Statement stmt;
		SampleDTO dto;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			con = DriverManager.getConnection(url, "javalink", "javalink");
			stmt = con.createStatement();
			String sql = "select * from book";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				dto = new SampleDTO(id, name, price);
				sampleDTOs.add(dto);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sampleDTOs;

	}
}
