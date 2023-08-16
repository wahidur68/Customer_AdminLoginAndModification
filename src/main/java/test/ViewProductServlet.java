package test;
import java.io.*;
import java.util.*;
import java.util.Iterator;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")

@WebServlet("/viewProduct")
public class ViewProductServlet extends HttpServlet{

	@Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			pw.println("Session Expired...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
		}else {
			AdminBean ab=(AdminBean)hs.getAttribute("abean");
			pw.println("<div style='color:red'>page belongs to : "+ab.getfName()+"</div>");
			
			RequestDispatcher rd=req.getRequestDispatcher("link1.html");
			rd.include(req, res);
			
			RetrieveProductDAO ob=new RetrieveProductDAO();
			LinkedList<ProductBean> al=ob.retrieve();
			if(al.size()==0) {
				pw.println("products not availavle "+"<br>");
			}else {
				hs.setAttribute("plist", al);
				Iterator<ProductBean> it =al.iterator();
				pw.println("<br>code &nbsp &nbsp &nbsp &nbsp name &nbsp &nbsp &nbsp &nbsp price &nbsp &nbsp qty");
				while(it.hasNext()) {
					ProductBean pb=it.next();
					pw.println("<br>"+pb.getCode()+"&nbsp &nbsp"
					+pb.getName()+"&nbsp &nbsp"+pb.getPrice()
							+"&nbsp &nbsp"+pb.getQty()+
					"&nbsp&nbsp<a href='editProduct?pcode="+pb.getCode()+"'>Edit</a> &nbsp &nbsp <a href='delete?pcode="+pb.getCode()+"'>delete</a>");
				}
			}
			
		}
		
		
		
	
	}

}
