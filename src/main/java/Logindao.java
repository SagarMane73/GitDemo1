import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Logindao {
	public String validate(Loginpojo lp) throws SQLException
	{
		System.out.println("from GitDemo1 from Logindao class");
		String q="select * from Login1 where lmail=? and lpwd=?";
		PreparedStatement pst= new dbadapter().dbconnect().prepareStatement(q); //here "con" reference jaisa connection get kiya hai
		pst.setString(1, lp.getLmail());
		pst.setString(2, lp.getLpwd());
		
		ResultSet rs=pst.executeQuery();
		String str="";
		if(rs.next())
			str="success";
		else
			str= "error";
		
		return str;
		
	}

}
