package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			pw.println("Session expired....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
		}else {
			AdminBean ab=(AdminBean)hs.getAttribute("abean");
			pw.println("page belongs to : "+ab.getfName()+"<br>");
			
			RequestDispatcher rd=req.getRequestDispatcher("link1.html");
			rd.include(req, res);
			
			ProductBean pb=new ProductBean();
			pb.setCode(req.getParameter("code"));
			pb.setName(req.getParameter("name"));
			pb.setPrice(Float.parseFloat(req.getParameter("price")));
			pb.setQty(Integer.parseInt(req.getParameter("qty")));
			
			AddProductDAO apd=new AddProductDAO();
			
			int k=0;
			try {
				k = apd.insert(pb);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(k>0) {
				pw.println("<br>Product added successfully......"+"<br>");
				
				
			}
			
			
		}
		
		
		
	}

}
