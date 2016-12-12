package Online;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Member.Member;

public class SQLManager {
	private static Connection conn;
	public static void initConnection() {
		String url = "jdbc:mysql://lhcp1011.webapps.net:3306/";
	    String dbName = "cl1lff8g_iutgo";
	    String driver = "com.mysql.jdbc.Driver";
	    String userName = "cl1lff8g_david";
	    String password = "dagovide2306";
	    
		conn = null;
	   try {
		   Class.forName(driver).newInstance();
		   conn = DriverManager.getConnection(url+dbName,userName,password);	
	   } catch (Exception e) {
		e.printStackTrace();
	   }  
	}
	
	public static ArrayList<Member> getListMembers() {
		Statement st = null;
		ResultSet rs = null; 
		String sql = ("SELECT * FROM members");
		ArrayList<Member> toReturn = new ArrayList<Member>();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				toReturn.add(new Member(rs.getInt("id_member")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	
	public static void insertMember(Member m) {
		Statement st = null;
		int rs; 
		String sql = "INSERT INTO members VALUES ('"+m.getId()+"')";

		try {
			st = conn.createStatement();
			rs = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
