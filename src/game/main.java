package game;

import java.sql.Connection;

public class main {
	
	public static void main (String[] args)
	{
		try 
		{
			Login frame = new Login();
			frame.setVisible(true);			
		} 
		catch (Exception e) 
		{
			System.out.println("Lỗi : " + e.getMessage());
		}	
	}

}
