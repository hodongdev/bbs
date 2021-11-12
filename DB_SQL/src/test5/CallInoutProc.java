package test5;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallInoutProc extends Object{

	public static void main(String[] args) {
		
//		DB 접속
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			
		}
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		
//		변수 선언
		String p1value = new String("a");
		String p2value = new String("b");
		String p3value = null;
		
		Connection con = null;;
			try {
				con = DriverManager.getConnection(url, "javalink", "javalink");
				CallableStatement cs = con.prepareCall("{call javatest(?,?,?)}");
				cs.setString(1, p1value);
				cs.setString(2, p2value);
				cs.registerOutParameter(2, Types.VARCHAR);
				cs.registerOutParameter(3, Types.VARCHAR);
				
				cs.execute();
				
				p2value = cs.getString(2);
				p3value = cs.getString(3);
			
			

			
//			수행결과 출력
			System.out.println("p2 :" + p2value);
			System.out.println("p3 :" + p3value);
			} catch (SQLException e) {
				
			}


	}

}
