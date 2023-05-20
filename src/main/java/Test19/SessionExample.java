package Test19;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionExample
 */
@WebServlet(urlPatterns={"/SessionExample"},asyncSupported=true,loadOnStartup=10,name="SessionExample",displayName="SessionExample")
public class SessionExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		out.println("print session info<br>");
		Date created=new Date(session.getCreationTime());
		Date accessed=new Date(session.getLastAccessedTime());
		out.println("ID"+session.getId()+"<br>");
		out.println("Created:"+created+"<br>");
		out.println("Last Accessed:"+accessed+"<br>");
		out.println("set session info<br>");
		String dataName=request.getParameter("dataName");
		if(dataName!=null&&dataName.length()>0) {
			String dataValue=request.getParameter("dataValue");
			session.setAttribute(dataName, dataValue);
		}
		out.println("print session comtents<br>");
		Enumeration e=session.getAttributeNames();
		while(e.hasMoreElements()) {
			String name=(String)e.nextElement();
			String value=session.getAttribute(name).toString();
			out.println(name+"="+value+"<br>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
