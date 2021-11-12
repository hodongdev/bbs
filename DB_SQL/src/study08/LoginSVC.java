package study08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginSVC {
	Connection con = null;
	Statement stmt = null;
	User user = new User(null, null, null, null, null, null);
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {

		}

	}

	public void connect() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			con = DriverManager.getConnection(url, "javalink", "javalink");
			stmt = con.createStatement();
		} catch (SQLException e) {

		}
		System.out.println("Connection Success!");
	}

	public User login(String id, String passwd) {
			String sql = "select * from member where id= '" + id + "' AND " + "passwd = '" + passwd + "'";
			ResultSet rs;
			try {
				rs = stmt.executeQuery(sql);
				if(rs.next()) {
						String ID = rs.getString(1);
						user.setID(ID);
						String PW = rs.getString(2);
						user.setPW(PW);
						String name = rs.getString(3);
						user.setName(name);
						String age = rs.getString(4);
						user.setAge(age);
						String gender = rs.getString(5);
						user.setGender(gender);
						String email = rs.getString(6);
						user.setEmail(email);
						user = new User(ID, PW, name, age, gender, email);
					}
				
			} catch (SQLException e) {
				
			}
			return user;

		}
	}

