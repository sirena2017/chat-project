

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MessageHandling
 */
@WebServlet("/MessageHandling")
public class MessageHandling extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageHandling() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String m = request.getParameter("message");
		
		
		request.getSession().setAttribute("message",request.getParameter("history")+"\n"+m);
		request.getSession().setAttribute("isMsg", true);
		
//		String selectedNames = request.getParameter("selectedNames");
		String selectedNames = "nahid";
		
		String[] slctedNames = selectedNames.split(",");
		
		HttpSession[] sessionNames = new HttpSession[slctedNames.length];
		
		int i = 0;
		
		for (HttpSession session : TestLogin.sessions) {
			for (String string : slctedNames) {
				if(session.getAttribute("name").equals(string)){
					//sessionNames[i] = session;
					session.setAttribute("message", request.getAttribute("message") +" \n" + m);
					i++;
 				}
			}
		}
		
		String referer=request.getHeader("referer");
		response.sendRedirect(referer);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
