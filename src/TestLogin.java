
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * Servlet implementation class testLogin
 */
@WebServlet("/TestLogin")
public class TestLogin extends HttpServlet {

	EntityManagment em;
	User user;
	static ArrayList<String> listOfOnline;
	static ArrayList<String> listOfBusy;
	static ArrayList<HttpSession> sessions;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestLogin() {
		super();
		em = new EntityManagment();
		user = new User();
		listOfOnline = new ArrayList<String>();
		listOfBusy = new ArrayList<String>();
		sessions = new ArrayList<HttpSession>();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = request.getParameter("user");
		user.setUsername(username);
		String pass = request.getParameter("password");
		user.setPassword(pass);
		String result = em.userExist(user);

		String referer = request.getHeader("Referer");
		HttpSession s = request.getSession(true);

		if (result.equals("USER TRUE")) {
			if (!listOfOnline.contains(username)) {

				s.setAttribute("isLogedin", true);
				s.setAttribute("name", username);
				s.setAttribute("isJoined", false);
				s.setAttribute("isStarter", false);
				s.setAttribute("message", "");
				s.setAttribute("groupNames", "");

				sessions.add(s);
				listOfOnline.add(username);

				int n = referer.length();
				int i = n - 1;
				while (referer.charAt(i) != '/') {
					i--;
				}

				referer = referer.substring(0, i) + "/InfoPage";
				response.getWriter().append(referer + "referer is::");
				response.sendRedirect(referer);
				// response.getWriter().append((CharSequence)
				// request.getSession().getAttribute("name"));
			} else {
				int n = referer.length();
				int i = n - 1;
				while (referer.charAt(i) != '/') {
					i--;
				}

				referer = referer.substring(0, i) + "/InfoPage";
				response.getWriter().append(referer + "referer is::");
				response.sendRedirect(referer);
			}

		} else {
			s.setAttribute("isLogedin", false);
			response.sendRedirect(referer);
		}
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
