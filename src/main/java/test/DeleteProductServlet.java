package test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet	 {
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException{
		 PrintWriter pw=res.getWriter();
		 res.setContentType("text/html");
		 HttpSession hs=req.getSession(false);
		 if(hs==null) {
			 pw.println("Session Expired..");
			 RequestDispatcher rd=req.getRequestDispatcher("home.html");
			 rd.include(req, res);
		 }else {
			 
			 AdminBean ab=(AdminBean)hs.getAttribute("abean");
			 String code=req.getParameter("pcode");
			
			 pw.println("page belongs to : "+ab.getfName()+"<br>");
			 RequestDispatcher rd=req.getRequestDispatcher("link1.html");
			 rd.include(req, res);
			 int k=new DeleteProductDAO().delete(code);
			 if(k>0) {
				 pw.println("<br>product deleted successfully....");
				
			 }
		 }
	 }

}
