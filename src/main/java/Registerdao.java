import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registerdao {
	
	public String adduser(registerpojo rp) throws SQLException
	{
		String q1="insert into Register1 values(?,?,?,?,?,?,?,?)";
		dbadapter da=new dbadapter();
		Connection con=da.dbconnect();
		
		PreparedStatement pst=con.prepareStatement(q1);
		pst.setInt(1, 0);
		pst.setString(2, rp.getRfname());
		pst.setString(3, rp.getRlname());
		pst.setString(4, rp.getRmail());
		pst.setString(5, rp.getRpwd());
		pst.setString(6, rp.getRgender());
		pst.setString(7, rp.getRcountry());
		pst.setInt(8,rp.getRcont());
		
		int i=pst.executeUpdate();
		
		
		String q2="insert into Login1 values(?,?,?)";
		pst=con.prepareStatement(q2);
		pst.setInt(1, 0);
		pst.setString(2, rp.getRmail());
		pst.setString(3, rp.getRpwd());
		
		int j=pst.executeUpdate();
		
		if(i>0 && j>0)
		{
			return "success";
		}
		else
			return "error";
		
	}

}
