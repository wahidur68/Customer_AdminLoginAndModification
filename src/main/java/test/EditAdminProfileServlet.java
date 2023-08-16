package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditAdminProfileServlet extends HttpServlet
{
 protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	 PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 HttpSession hs=req.getSession(false);
	 if(hs==null) {
		    pw.println("Session expired....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
	 }else {
		 AdminBean ab=(AdminBean)hs.getAttribute("abean");
		 pw.println("<div style='color:red'>Page Belongs to : "+ab.getfName()+"</div>");
		 pw.println("<form action='updateProfile' method='post'>");
		 pw.println("Address:<input type='text' name='addr' value='"+ab.getAddr()+"'>"+"<br>");
		 pw.println("MailId:<input type='text' name='mid' value='"+ab.getmId()+"'>"+"<br>");
		 pw.println("PhoneNo:<input type='text' name='phno' value='"+ab.getPhNo()+"'>"+"<br>");
		 pw.println("<input type='submit' value='UpdateProfile'>"+"<br>");
		 pw.println("</form></div>");
	 }
 }
}
