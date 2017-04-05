

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogOut
 */
@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String id =(String) request.getSession(false).getAttribute("name");
		String username = "";
		
		for (String names : TestLogin.listOfOnline) {
			if(names.equals(id)){
				username = names;
			}
		}
		
		TestLogin.listOfOnline.remove(username);
	
		request.getSession().setAttribute("isLogedin", false);
		request.getSession().removeAttribute("name");
		response.sendRedirect("/ChatProject/Login");
		String referer = request.getHeader("Referer");
		int n=referer.length();
		int i=n-1;
		while(referer.charAt(i)!='/')
		{
			i--;
		}
		
		referer=referer.substring(0, i)+"/Login";
		//response.sendRedirect(referer);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
