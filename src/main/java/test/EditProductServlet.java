package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;
import java.util.stream.*;
@SuppressWarnings("serial")
@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet  {
 @SuppressWarnings("unchecked")
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
		 LinkedList<ProductBean> ll=(LinkedList<ProductBean>)hs.getAttribute("plist");
		 pw.println("page belong to : "+ab.getfName()+"<br>");
		 String code=req.getParameter("pcode");
		 List<ProductBean> l =
				 ll.stream().filter((x)->x.getCode().equals(code)).collect(Collectors.toList()) ;
				 l.forEach((k)->
				 {
				 ProductBean pb = (ProductBean)k;
				 pw.println("<form action='updateProduct' method='post'>");
				 pw.println("<input type='hidden' name='code' value='"+pb.getCode()+"'>");
				 pw.println("Price:<input type='text' name='price' value='"+pb.getPrice()+"'><br>");
				 pw.println("Qty:<input type='text' name='qty' value='"+pb.getQty()+"'><br>");
				 pw.println("<input type='submit' value='UpdateProduct'>");
				 pw.println("</form>");
				 });
		 
	 }
 }
}
