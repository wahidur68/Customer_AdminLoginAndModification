package test;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/Userlogout")
public class UserLogOutServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie ck[]=req.getCookies();
		if(ck==null) {
			pw.println("Session Expired"
					+ "<br>");
			
		}else {
			ServletContext sct=req.getServletContext();
			sct.getAttribute("ubean");
			ck[0].setMaxAge(0);
			res.addCookie(ck[0]);
			pw.println("LogOut Successfully <br>");	
		}
		RequestDispatcher rd=req.getRequestDispatcher("CustomerLogin.html");
		rd.include(req, res);
	}
}
