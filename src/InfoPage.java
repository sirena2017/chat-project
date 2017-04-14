
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoPage
 */
@WebServlet("/InfoPage")
public class InfoPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfoPage() {
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

		String a = "";

		for (String string : TestLogin.listOfOnline) {
			if (request.getSession().getAttribute("name").equals(string)) {
				continue;
			} else
				a = a + "<option value=" + string + ">" + string + "</option>";
		}

		String username = (String) request.getSession(false).getAttribute("name");
/*		String username = "";

		for (String names : TestLogin.listOfOnline) {
			if (names.equals(id)) {
				username = names;
			}
		}*/

		String infopage = "<html><head><meta http-equiv='refresh' content='8' >"
				+ "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>"
				+ "</head><body><br><p>Hello " + username
				+ "</p><br><div class='container'><div class='col-md-3 col-md-offset-4'>  "
				+ " <form action='/ChatProject/SettingChatInfo' method='GET'><select multiple class='form-control' name='slct'>"
				+ a + " </select> " + "<div class='input-group'></div>" + "<br>" + "<div class='btn-group'>"
				+ "<button type='submit' class='btn btn-primary'>Start Chat</button>"
				+ " <button type='button' class='btn btn-primary' onclick='history.go(0)'>Refresh</button>"

				+ "</div> </form>"
				+ "<form action='/ChatProject/LogOut' method='GET'><button type='submit' class='btn btn-primary'>Logout</button></form>"
				+ "	</div></div></body></html>";

		if (request.getSession().getAttribute("isLogedin").equals(true)) {

			if (request.getSession().getAttribute("isJoined").equals(false)) {
				response.getWriter().append(infopage);
			} else {
				
/*				String referer = request.getHeader("Referer");
				int n=referer.length();
				int i=n-1;
				while(referer.charAt(i)!='/')
				{
					i--;
				}
				
				referer=referer.substring(0, i)+"/CreateChatConnection";*/
				response.sendRedirect("/ChatProject/CreateChatConnection");
				
				String c = request.getContextPath();

				//response.getWriter().append("hereeeeeeeee").append(c);
				//response.sendRedirect(response.encodeURL(c+"/SettingChatInfo"));


			}

		} else {
			response.sendRedirect("/ChatProject/Login");
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
