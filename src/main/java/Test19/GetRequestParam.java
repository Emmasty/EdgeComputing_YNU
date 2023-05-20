package Test19;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetRequestParam
 */
@WebServlet(urlPatterns={"/GetRequestParam"},asyncSupported=true,loadOnStartup=10,name="GetRequestParam",displayName="GetRequestParam")
public class GetRequestParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRequestParam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse res)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Enumeration e=request.getParameterNames();
		PrintWriter out=res.getWriter();
		while(e.hasMoreElements()) {
			String name=(String)e.nextElement();
			String value=request.getParameter(name);
			out.println(name+"="+value+"<br>");
		}
	}

}
