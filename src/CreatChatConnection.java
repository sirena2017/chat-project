
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
		
		String id = (String) request.getSession(false).getAttribute("name");
		String username = "";

		for (String names : TestLogin.listOfOnline) {
			if (names.equals(id)) {
				username = names;
			}
		}
		String groupNames = "";
		String starter = username + " Connected to:";
		
		
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
	

		String message;
			message = (String) request.getSession().getAttribute("message");
			if(message==null){
				message="";
			}

		String chatPage = "<html><head><meta http-equiv='refresh' content='8' >"
				+ "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>"
				+ "<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'></head>"
				+ "<body><br><<br><div class='container'><div class='col-md-2 col-md-offset-3'><form action='/ChatProject/MessageHandling' method='GET'>"
				+ "<p>" + starter +groupNames+"</p>"
				+ "<div class='input-group'>"
				+ "<div name='history' id='history' class='form-control custom-control' style='width:500px; height: 300px;'></div>"
				+ message + "</textarea>"
				+ "<br><div class='input-group'><div name='message' id='message' contenteditable='true' class='form-control custom-control' rows='2' placeholder='Write Message Here' style='width:280px;resize:none'></div><button type='submit' class='btn btn-info'>Send</button> "
				+ "</div></form>"
				+ "<form action='/ChatProject/LogOut' method='GET'><button type='submit' class='btn btn-info'>Logout</button></form>"
				+"</div></div></body></html>";

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
