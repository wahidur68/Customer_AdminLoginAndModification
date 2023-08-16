package test;
import java.sql.*;
public class UserRegDAO {
	public int k=0;
	int register(UserBean ub) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into userreg51 values(?,?,?,?,?,?,?)");
			ps.setString(1, ub.getUname());
			ps.setString(2, ub.getPword());
			ps.setString(3, ub.getFname());
			ps.setString(4, ub.getLname());
			ps.setString(5, ub.getAddr());
			ps.setString(6, ub.getMid());
			ps.setLong(7, ub.getPhno());
			k=ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	

}
