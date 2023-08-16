package test;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/alog")
public class AdminLoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		AdminBean ab=new AdminDAO().login(req);
		if(ab==null) {
			pw.println("Invalid Login <br>");
			RequestDispatcher rd=req.getRequestDispatcher("Admin.html");
			rd.include(req, res);
		}else{
			HttpSession hs=req.getSession();
			hs.setAttribute("abean", ab);
			pw.println("<div style='color:red'>Welcome Admin : "+ab.getfName()+"</div>");
			RequestDispatcher rd=req.getRequestDispatcher("link1.html");
			rd.include(req, res);
		}
	}
}
