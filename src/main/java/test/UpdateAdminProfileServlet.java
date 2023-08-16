package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/updateProfile")
public class UpdateAdminProfileServlet extends HttpServlet
{
		protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
		{
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			 HttpSession hs=req.getSession(false);
			if(hs==null) {
				 pw.println("Session expired....<br>");
					RequestDispatcher rd=req.getRequestDispatcher("home.html");
					rd.include(req, res);
			}else {
				 AdminBean ab=(AdminBean)hs.getAttribute("abean");
				pw.println("<br> pageBelongs to : "+ab.getfName()+"<br>");
				
				ab.setAddr(req.getParameter("addr"));
				ab.setmId(req.getParameter("mid"));
				ab.setPhNo(Long.parseLong(req.getParameter("phno")));
				int k=new UpdateAdminProfileDAO().update(ab);
				if(k>0) {
					pw.println("Profile updated succesfully ..<br>");
					RequestDispatcher rd=req.getRequestDispatcher("link1.html");
					rd.include(req, res);
				}
				
				
			}
		}
}
