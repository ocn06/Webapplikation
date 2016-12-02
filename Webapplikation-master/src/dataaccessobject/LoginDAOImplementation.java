package dataaccessobject;

import models.ContentModel;
import models.CredModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fede0004@stud.kea.dk on 22-10-2016.
 */
public class LoginDAOImplementation implements LoginDAO {
	public CredModel fetchUser(String username, String password) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7141186";
		String user = "sql7141186";
		String passwordConnection = "LENV1AXG9w";
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			con = DriverManager.getConnection(url, user, passwordConnection);
			st = con.createStatement();
			String s = "SELECT username, password, role FROM users \n" +
					"WHERE username = '" + username + "' AND password = '" + password + "'";
			rs = st.executeQuery(s);
			CredModel cred = new CredModel();
			if (rs.next()) {
				cred.setUsername(rs.getString(1));
				cred.setPassword(rs.getString(2));
				cred.setRole(rs.getString(3));
				return cred;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if (rs != null) {
					rs.close();
				}
				
				if (st != null) {
					st.close();
				}
				
				if (con != null) {
					con.close();
				}
				
			} catch (SQLException ex) {
				
			}
		}
		return null;
	}
	
	public List<ContentModel> fetchContent() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7141186";
		String user = "sql7141186";
		String passwordConnection = "LENV1AXG9w";
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			con = DriverManager.getConnection(url, user, passwordConnection);
			st = con.createStatement();
			String s = "SELECT * FROM text";
			rs = st.executeQuery(s);
			
			List<ContentModel> contentModelList = new ArrayList<ContentModel>();
			while (rs.next()) {
				ContentModel contModel = new ContentModel();
				contModel.setContent(rs.getString("content"));
				contentModelList.add(contModel);
			}
			if (!contentModelList.isEmpty()) {
				return contentModelList;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if (rs != null) {
					rs.close();
				}
				
				if (st != null) {
					st.close();
				}
				
				if (con != null) {
					con.close();
				}
				
			} catch (SQLException ex) {
				
			}
		}
		return null;
	}
	
	public boolean addContent(ContentModel content) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7141186";
		String user = "sql7141186";
		String passwordConnection = "LENV1AXG9w";
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			con = DriverManager.getConnection(url, user, passwordConnection);
			st = con.createStatement();
			String s = "INSERT INTO text (`content`) VALUES ('" + content.getContent() + "');";
			st.executeUpdate(s);
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if (rs != null) {
					rs.close();
				}
				
				if (st != null) {
					st.close();
				}
				
				if (con != null) {
					con.close();
				}
				
			} catch (SQLException ex) {
				
			}
		}
		return false;
	}
}

