
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

		String infopage = "<html lang='en'><head><title>List Page</title>"
		  +"<meta charset='utf-8'><meta http-equiv='refresh' content='8' ><meta name='viewport' content='width=device-width, initial-scale=1'>"
		  +"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"
		  +"<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js'></script><script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>"
		    +"<style> .row.content {height: 1500px}"
		    +".sidenav {background-color: #f1f1f1;height: 100%; }"
		    +"footer {background-color: #555;color: white;padding: 15px;}" 
		    +"@media screen and (max-width: 767px) {.sidenav {height: auto;padding: 15px;}"
		      +".row.content {height: auto;} }</style></head>"
		+"<body><div class='container-fluid'><div class='row content'><div class='col-sm-3 sidenav'>"
		      +"<img src='http://prateekjain.co/resources/Chat%20Client%20Logo.png'></img><ul class='nav nav-pills nav-stacked'>"
		        +"<li ><a href='#' onclick='history.go(0)'>Refresh</a></li><li><a href='/ChatProject/LogOut'>Logout</a></li></ul><br></div><div class='col-sm-9'>"
			+"<h2>Hello "+username+"<h2><hr><h4><small>select one or more(using ctrl) row to start chat</small></h4><br>"
		      +"<form action='/ChatProject/SettingChatInfo' method='GET'>"
						   +"<select multiple class='form-control' name='slct'>"+a+"</select><br><div class='btn-group'><button type='submit' class='btn btn-default'>Start Chat</button>"
						  +"</div> </form><br><br><br><br><br><br><br><br><h4><small>Use Live Chat</small></h4><hr><br><br>     </div></div></div>"
		+"<footer class='container-fluid'><p>contact us</p><p>Mazhari44@gmail.com</p><p>Ghelichkhani.m@gmail.com</p></footer></body></html>";

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
