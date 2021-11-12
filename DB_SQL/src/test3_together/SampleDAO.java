package test3_together;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SampleDAO {

//	DB������ ã�Ƽ� SampleDTO�� ������ ArrayList
	public ArrayList<SampleDTO> findAll() {

		ArrayList<SampleDTO> sampleDTOs = new ArrayList<SampleDTO>();
//		DTO�� �����ϴ� ����Ʈ
//		1.Driver ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//			2.���� ����
			Connection con;
			try {
				con = DriverManager.getConnection(url, "javalink", "javalink");
				Statement stmt = con.createStatement();
//				3.Query
				String sql = "select * from book";
//				4.����� ����
				ResultSet rs = stmt.executeQuery(sql);
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					SampleDTO dto = new SampleDTO();

					dto.setId(rs.getString(1));
					dto.setName(rs.getString(2));
					dto.setPrice(rs.getInt("price"));
					sampleDTOs.add(dto);

				}
			} catch (SQLException e) {

			}

		} catch (ClassNotFoundException e) {

		}

//		5.DB����

		return sampleDTOs;

	}
}
