package game;

import java.sql.*;

public class connectionn {
	
	/*1.import thu vien có tên là java.sql
	 * 2.load jdbc driver 
	 * 3.kết nối với mysql sử dụng getconection(thuộc lớp drivermanager)
	 * - khởi tạo 1 đối tượng có tên là: Connection
	 * - khởi tạo url, username, password
	 * 4. đóng connection lại
	 * */
	
	
	public static Connection ketnoi(String username, String password, String url)
	{
		
		
		Connection conn = null;
	
//		String url = "jdbc:mysql://localhost:3306/minigame";
		
		try 
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
//			if (conn != null)
//				System.out.print("ahihi" + conn);
//			conn.close();
			
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("Load driver error::");	
		} 
		catch (SQLException e) 
		{	
			System.out.println("Error:: " + e.getMessage());
		}
		return conn;
	}
	

}
