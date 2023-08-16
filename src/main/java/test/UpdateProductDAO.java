package test;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
public class UpdateProductDAO {
	public int k=0;
	public int update(HttpServletRequest req) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("update product51 set price=?,qty=? where code=?");
			ps.setFloat(1,Float.parseFloat(req.getParameter("price")));
			ps.setInt(2, Integer.parseInt(req.getParameter("qty")));
			ps.setString(3, req.getParameter("code"));
			k=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
