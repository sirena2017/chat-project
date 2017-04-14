
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		String thisUsername = (String) request.getSession().getAttribute("name");
		TestLogin.listOfOnline.remove(thisUsername);
		TestLogin.listOfBusy.add(thisUsername);
		
		String messageHistory = (String) request.getSession().getAttribute("message");
		String newMessage = thisUsername+": "+request.getParameter("msg");
		System.out.println(newMessage);
		request.getSession().setAttribute("message", messageHistory + "\n" +newMessage);

		String groupNames = (String) request.getSession().getAttribute("groupNames");
		String[] slctedNames = groupNames.split(",");

		for (HttpSession session : TestLogin.sessions) {
			for (String string : slctedNames) {
				if (session.getAttribute("name").equals(string)) {

					if (request.getSession().getAttribute("isStarter").equals(true)
							&& session.getAttribute("isJoined").equals(false)) {
						session.setAttribute("isJoined", true);
						session.setAttribute("groupNames", groupNames.replaceAll(string, thisUsername));
						TestLogin.listOfOnline.remove(string);
						TestLogin.listOfBusy.add(string);
					}

					messageHistory = (String) session.getAttribute("message");
					session.setAttribute("message", messageHistory + "\n" +newMessage);
					break;
				}
			}
		}

		String referer = request.getHeader("referer");
		response.sendRedirect(referer);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
