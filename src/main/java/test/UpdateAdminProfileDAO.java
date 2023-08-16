package test;
import java.sql.*;
public class UpdateAdminProfileDAO {
	public int k=0;
	public int update(AdminBean ab) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("update admintab51 set addr=?,mid=?,phno=? where uname=? and pword=?");
			ps.setString(1, ab.getAddr());
			ps.setString(2,ab.getmId());
			ps.setLong(3, ab.getPhNo());
			ps.setString(4, ab.getuName());
			ps.setString(5, ab.getpWord());
			k=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
