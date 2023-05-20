package Test19;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns={"/MyLoginServlet"},asyncSupported=true,loadOnStartup=10,name="MyLoginServlet",displayName="MyLoginServlet")
public class MyLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MyLoginServlet() {
        super();
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(true);
		session.setAttribute("name", request.getParameter("name"));
		session.setAttribute("psw", request.getParameter("password"));
		session.setAttribute("type", request.getParameter("type"));
		String type=request.getParameter("type");
		if(type==null) {
			response.sendRedirect(request.getContextPath() + "/MyLogin.html");
			return;
		}else if(type.equals("user")) {
			response.sendRedirect(request.getContextPath() + "/normal.jsp");
			return;
		}else if(type.equals("manager")) {
			response.sendRedirect(request.getContextPath() + "/manager.jsp");
			return;
		}
	}

}
