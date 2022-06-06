import java.sql.*;
import javax.swing.*;

public class DbConn 
{
	public static Connection ConnectDB()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			String jdbcUrl = "jdbc:sqlite:library_db.sqlite";
			Connection conn = DriverManager.getConnection(jdbcUrl);
			
			System.out.println("Connected Succesfully with "+conn);
			
			return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
