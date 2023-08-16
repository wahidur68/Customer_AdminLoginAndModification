package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/Userupdate")
public class UpdateUserProfileServlet extends HttpServlet
{
		protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
		{
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			Cookie c[]=req.getCookies();
			if(c==null) {
				pw.println("Session Expired ....<br>");
				RequestDispatcher rd=req.getRequestDispatcher("CustomerLogin.html");
				rd.include(req, res);
			}else {
				String fname=c[0].getValue();
				pw.println("<br> pageBelongs to : "+fname+"<br>");
				ServletContext sct=this.getServletContext();
				UserBean ub=(UserBean)sct.getAttribute("ubean");
				ub.setAddr(req.getParameter("addr"));
				ub.setMid(req.getParameter("mid"));
				ub.setPhno(Long.parseLong(req.getParameter("phno")));
				int k=new UpdateUserProfileDAO().update(ub);
				if(k>0) {
					pw.println("Profile updated succesfully ..<br>");
					RequestDispatcher rd=req.getRequestDispatcher("link.html");
					rd.include(req, res);
				}
				
				
			}
		}
}
