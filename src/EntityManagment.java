

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EntityManagment {

	public Connection connection() {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/chat?user=root&password=123");

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;

	}

	public void addUser(User user) {

		try {
			PreparedStatement ps = connection()
					.prepareStatement(
							"INSERT INTO user(username,password)"
									+ " VALUES (?,?,?,?)");

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, 0);
			ps.setInt(4, 0);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void deleteUser(String us) {
		try {

			PreparedStatement ps = connection().prepareStatement(
					"DELETE FROM userWHERE username like ?");

			ps.setString(1, us);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public String userExist(User user) {
		String message="";
		try {

			PreparedStatement ps = connection()
					.prepareStatement(
							"select * from user where username like ?");

			ps.setString(1, user.getUsername());
			//ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				if(rs.getString(2).equals(user.getPassword()))
					message= "USER TRUE";
				else message= "USER PASSWORD";
			}
			else
				message="USER USERNAME";

			ps.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return message;
		

	}
}
	