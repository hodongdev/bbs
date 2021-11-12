package p02.scott;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//SCOTT DB�� �ִ� EMP���̺� ������ �ڹٿ��� ���
public class EmpEx1 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
//			1.Driver ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//			2.���� ����
			con = DriverManager.getConnection(url, "scott", "scott");
			stmt = con.createStatement();
//			3.Query
			String sql = "select * from emp";
//			4.����� ����
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				int mgr = rs.getInt(4);
				Date hiredate = rs.getDate(5);
				int sal = rs.getInt(6);
				int comm = rs.getInt(7);
				int deptno = rs.getInt(8);
				System.out.println(empno + "/ " + ename + "/ " + job + "/ " + mgr + "/ " + hiredate + "/ " + sal + "/ "
						+ comm + "/ " + deptno);
			}
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
		System.out.println("��������");
		try {
			con.close();
			rs.close();
			stmt.close();
		} catch (SQLException e) {

		}
		
	}

}
