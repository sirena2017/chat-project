package hib;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SettingChatInfo
 */
@WebServlet("/SettingChatInfo")
public class SettingChatInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SettingChatInfo() {
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

		ArrayList<HttpSession> listOfParticipation = new ArrayList<HttpSession>();

		String thisUsername = (String) request.getSession().getAttribute("name");
		//TestLogin.listOfOnline.remove(thisUsername);
		TestLogin.listOfBusy.add(thisUsername);

		String groupNames = "";
		String[] s = null;

		if (request.getSession().getAttribute("isJoined").equals(true)) {

			groupNames = ((String) request.getSession().getAttribute("groupNames"));

		} else {
			request.getSession().setAttribute("isStarter", true);
			s = request.getParameterValues("slct");
			for (String string : s) {
				groupNames = groupNames + "," + string;
			}
			request.getSession().setAttribute("groupNames", groupNames);
		}

		String[] slctedNames = groupNames.split(",");

		for (HttpSession session : TestLogin.sessions) {
			for (String string : slctedNames) {
				if (session.getAttribute("name").equals(string)) {

					if (request.getSession().getAttribute("isStarter").equals(true)
							&& session.getAttribute("isJoined").equals(false)) {
						session.setAttribute("isJoined", true);
						session.setAttribute("groupNames", groupNames.replaceAll(string, thisUsername));
					}
					listOfParticipation.add(session);
					
				}
			}
		}
		String referer = request.getHeader("Referer");
		System.out.println(referer);
		int n = referer.length();
		int i = n - 1;
		while (referer.charAt(i) != '/') {
			i--;
		}

		referer = referer.substring(0, i) + "/CreateChatConnection";
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
