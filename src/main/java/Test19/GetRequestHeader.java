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
 * Servlet implementation class GetRequestHeader
 */
@WebServlet(urlPatterns={"/GetRequestHeader"},asyncSupported=true,loadOnStartup=10,name="GetRequestHeader",displayName="GetRequestHeader")
public class GetRequestHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRequestHeader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text.html;charset=GBK");
		PrintWriter out=response.getWriter();
		out.println("Request Information Example<br>");
		out.println("Method:"+request.getMethod()+"<br>");
		out.println("Request URI:"+request.getRequestURI()+"<br>");
		out.println("Protocol:"+request.getProtocol()+"<br>");
		out.println("PathInfo:"+request.getPathInfo()+"<br>");
		out.println("Remote Address:"+request.getRemoteAddr()+"<br>");
		Enumeration e=request.getHeaderNames();
		while(e.hasMoreElements()) {
			String name=(String)e.nextElement();
			String value=request.getHeader(name);
			out.println(name+"="+value+"<br>");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

