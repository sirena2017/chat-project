
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/CreateChatConnection")
public class CreatChatConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreatChatConnection() {
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

		String[] s;

		if (request.getSession().getAttribute("isJoined").equals(true)) {

			s = ((String) request.getSession().getAttribute("groupNames")).split(",");

		} else {
			request.getSession().setAttribute("isStarter", true);
			s = request.getParameterValues("slct");

		}

		String id = (String) request.getSession(false).getAttribute("name");
		String username = "";

		for (String names : TestLogin.listOfOnline) {
			if (names.equals(id)) {
				username = names;
			}
		}

		String n = username;
		String g = username + " Connected to:";
		for (String string : s) {
			g = g + " " + string;
			n = n + "," + string;
		}

		request.getSession().setAttribute("groupNames", n);

		String message = "";
		if (request.getSession().getAttribute("isMsg").equals(true)) {
			message = (String) request.getSession().getAttribute("message");
		}

		String chatPage = "<html><head><meta http-equiv='refresh' content='8' >"
				+ "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>"
				+ "<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'></head>"
				+ "<body><br><<br><div class='container'><div class='col-md-2 col-md-offset-3'><form action='/ChatProject/MessageHandling' method='GET'>"
				+ "<p>" + g + "<input type='hidden' name='selectedNames valu='" + n + "'>"
				+ "</p><textarea name='history' readonly='true' class='form-control custom-control'  style='width:500px; height: 400px;'>"
				+ message + "</textarea>"
				+ "<br><div class='input-group'><textarea name='message' class='form-control custom-control' rows='2' placeholder='Write Message Here' style='width:400px;resize:none'>"
				+ "</textarea><button type='submit' class='btn btn-info'>Send</button> "
				+ "</div></form></div></div></body></html>";

		response.getWriter().append(chatPage);

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
