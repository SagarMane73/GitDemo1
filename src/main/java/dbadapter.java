import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbadapter implements dbservice{

	@Override
	public Connection dbconnect() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","root");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

}
