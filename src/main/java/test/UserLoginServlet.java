package test;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/clog")
public class UserLoginServlet extends HttpServlet
{
 protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
 {
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 UserBean ub=new UserLoginDAO().login(req);
	 if(ub==null) {
		 pw.println("Login process fail.....<br>");
		 RequestDispatcher rd=req.getRequestDispatcher("CustomerLogin.html");
		 rd.include(req, res);
	 }else {
		 ServletContext sct=this.getServletContext();
		 sct.setAttribute("ubean", ub);
		 
		 Cookie ck=new Cookie("fname",ub.getFname());
		 res.addCookie(ck);
		 pw.println("welcome user : "+ub.getFname()+"<br>");
		 RequestDispatcher rd=req.getRequestDispatcher("link.html");
		 rd.include(req, res);		 
	 }
 }
}
