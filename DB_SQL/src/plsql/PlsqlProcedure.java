package plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class PlsqlProcedure {

	public static void main(String[] args) {
		
		
//		Oracle DB연결
//		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		
//		1.Driver 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			
		}
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		
//		변수 선언
		int p1InValue = Integer.parseInt(args[0]);
		int p2InOutValue = Integer.parseInt(args[1]);
		int p3OutValue;
//		2.계정 연결
		Connection con = null;;
		try {
			con = DriverManager.getConnection(url, "javalink", "javalink");
			CallableStatement cs = con.prepareCall("{call member_data(?,?,?)}");
			cs.setInt(1, p1InValue);
			cs.setInt(2, p2InOutValue);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.registerOutParameter(3, Types.INTEGER);
			
			cs.execute();
			
			p2InOutValue = cs.getInt(2);
			p3OutValue = cs.getInt(3);
			
			System.out.println(p1InValue+"^"+p2InOutValue+" = "+p3OutValue);
		} catch (SQLException e) {
			
		}
	
		

	}

}
