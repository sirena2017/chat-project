

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChatRoomClosed
 */
@WebServlet("/ChatRoomClosed")
public class ChatRoomClosed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatRoomClosed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String username=(String) request.getSession().getAttribute("name");
		TestLogin.listOfBusy.remove(username);
		TestLogin.listOfOnline.add(username);
		

		request.getSession().setAttribute("message","");
		request.getSession().setAttribute("isJoined",false);
		request.getSession().setAttribute("isStarter",false);
		request.getSession().setAttribute("groupNames","");
		
		/*
		String referer = request.getHeader("Referer");
		int n = referer.length();
		int i = n - 1;
		while (referer.charAt(i) != '/') {
			i--;
		}

		referer = referer.substring(0, i) + "/InfoPage";
		response.sendRedirect(referer);*/
		
		response.sendRedirect("/ChatProject/InfoPage");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
