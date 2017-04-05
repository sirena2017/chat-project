
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
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

	//	String names = (String) request.getAttribute("online");// online names got
		//	System.out.println("Hereeeeeeeeeeeeeeeeeeeeeeeeee"+names);												// from server
															// request.getParameter("");
	//	String[] name = names.split(" ");
		String a = "";
	/*	
		  for (String string : name) {
			  a = a + "<option value=" + name + ">" + name + "</option>";
			  }
		 */
		
		for (String string : TestLogin.listOfOnline) {
			a = a + "<option value=" + string + ">" + string + "</option>";
		}
		
		
		String id =(String) request.getSession(false).getAttribute("name");
		String username = "";
		
		for (String names : TestLogin.listOfOnline) {
			if(names.equals(id)){
				username = names;
			}
		}
		
		Cookie[] c = request.getCookies();
		for (Cookie cook : c) {
			id = cook.getValue();
			//a = a + "<option value=" + cook.getName() + ">" + cook.getName() + "</option>";
		}
		
		
		

	
		
		

		String infopage = "<html>" + "<head>"
				+ "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>"
				+ "</head><body><br><p>Hello "+username+"</p><br><div class='container'><div class='col-md-3 col-md-offset-4'>  "
				+ " <form action='/finalproject/InfoProcess.jsp' method='GET'><select multiple class='form-control' name='slct'>"
				+ a + " </select> " + "<div class='input-group'></div>" + "<br>" + "<div class='btn-group'>"
				+ "<button type='submit' class='btn btn-primary'>Start Chat</button>"
				+ " <button type='button' class='btn btn-primary' onclick='history.go(0)'>Refresh</button>"
				+ "<form action='/finalproject/Logout' method='POST'><button type='submit' class='btn btn-primary'>Logout</button></form>"

				+ "</div> </form>	</div></div></body></html>";

		response.getWriter().append(infopage).append(request.getContextPath());
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
