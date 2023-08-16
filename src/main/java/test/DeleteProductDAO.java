package test;

import java.sql.*;
public class DeleteProductDAO {
	public int k=0;
	public int delete(String code) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("delete from product51 where code=?");
			ps.setString(1, code);
			k=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}


}
