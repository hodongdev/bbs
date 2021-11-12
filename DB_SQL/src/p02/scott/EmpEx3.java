package p02.scott;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//SCOTT DB�� �ִ� EMP���̺� ������ �ڹٿ��� ���
//���� - Scanner �Է��� �޾Ƽ� empno=7902�� �ش� ���ڵ�(tuple) ����ϱ�
//Statement => PreparedStatement
public class EmpEx3 {

	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
//			1.Driver ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";

//			2.���� ����
			con = DriverManager.getConnection(url, "scott", "scott");

//			3.Query
			Scanner sc = new Scanner(System.in);
			System.out.println("�����ȣ�� �Է��ϼ���.");
			int no = sc.nextInt();// 7902
			
			String sql = "select * from emp where empno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);

//			4.����� ����
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				int mgr = rs.getInt(4);
				Date hiredate = rs.getDate(5);
				int sal = rs.getInt(6);
				int comm = rs.getInt(7);
				int deptno = rs.getInt(8);
				System.out.println(empno + " : " + ename + " : " + job + " : " + mgr + " : " + hiredate + " : " + sal
						+ " : " + comm + " : " + deptno);
			}
//			5.DB����
			sc.close();
			con.close();
			rs.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
		System.out.println("��������");

	}

}
