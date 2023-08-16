package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			RequestDispatcher rd = 
					 req.getRequestDispatcher("home.html");
					 rd.include(req, res);
		}else{
			AdminBean ab=(AdminBean)hs.getAttribute("abean");
			pw.println("page belongs to : "+ab.getfName()+"<br>");
			RequestDispatcher rd = 
					 req.getRequestDispatcher("link1.html");
					 rd.include(req, res);
			int k=new UpdateProductDAO().update(req);
			if(k>0) {
				pw.println("<br>Product update successfully.....");
			}
		}
	}
	

}
