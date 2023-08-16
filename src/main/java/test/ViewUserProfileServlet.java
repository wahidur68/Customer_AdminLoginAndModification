package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/Userrview")
public class ViewUserProfileServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie[] c =req.getCookies();//Getting the cookie from request
		if(c==null) {
			pw.println("Session expiried....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("CustomerLogin.html");
			rd.include(req, res);
		}else{
			String fName=c[0].getValue();
			pw.println("page belongs to : "+fName+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
			
			ServletContext sct=this.getServletContext();
			UserBean ub=(UserBean)sct.getAttribute("ubean");
			pw.println("<br>"+ub.getFname()+"&nbsp &nbsp"+
					ub.getLname()+"&nbsp &nbsp"+ub.getAddr()+"&nbsp &nbsp"
					+"&nbsp &nbsp"+ub.getMid()+"&nbsp &nbsp"+ub.getPhno()+"<br>");
			
		}
	}
}
