
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

		String username = (String) request.getSession().getAttribute("name");
/*		String username = "";

		for (String names : TestLogin.listOfOnline) {
			if (names.equals(id)) {
				username = names;
			}
		}*/
		String groupNames = "";
		String starter = username + " Connected to:";
		groupNames = ((String) request.getSession().getAttribute("groupNames"));

		String message;
		message = (String) request.getSession().getAttribute("message");

		String chatPage = "<html lang='en'><head>" + "<title>Chat Page</title><meta http-equiv='refresh' content='8' >"
				+ "<meta charset='utf-8'>" + "<meta name='viewport' content='width=device-width, initial-scale=1'>"
				+ "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"
				+ "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js'></script>"
				+ "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>"
				+ "<script>"
				+ "function f1() {var m = document.getElementById('message').textContent;document.getElementById('message').innerHTML = m + '&#128512;';}"
				+ "function f2() {var m = document.getElementById('message').textContent;document.getElementById('message').innerHTML = m + '&#128513;';}"
				+ "function f3() {var m = document.getElementById('message').textContent;document.getElementById('message').innerHTML = m + '&#128514;';}"
				+ "function f4() {var m = document.getElementById('message').textContent;document.getElementById('message').innerHTML = m + '&#128521;';}"
				+"  function func(){var a = document.getElementById('message').textContent;document.getElementById('msg').value = a; var b = document.getElementById('msg').value; alert(b);}"
				+ "</script>" 
				+ "<style>" + ".row.content {height: 1500px}"
				+ ".sidenav {      background-color: #f1f1f1;      height: 100%;    }"
				+ "footer {      background-color: #555;      color: white;      padding: 15px;    }"
				+ "@media screen and (max-width: 767px) {      .sidenav {        height: auto;        padding: 15px;      }"
				+ ".row.content {height: auto;}    }" + "</style></head>" + "<body>"

				+ "<div class='container-fluid'>" + "<div class='row content'>" + "  <div class='col-sm-3 sidenav'>"
				+ "  <img src='http://prateekjain.co/resources/Chat%20Client%20Logo.png'></img>"
				+ "<ul class='nav nav-pills nav-stacked'>"
				+ "<li class='active'><a href='/ChatProject/InfoPage'>Online People</a></li>"
				+ "<li><a href='/ChatProject/LogOut'>Logout</a></li>" + "<li><a href='/ChatProject/ChatRoomClosed'>Leave Chat</a></li>"//close the chat page
				+ "</ul><br></div>" + "    <div class='col-sm-9'>" + "   <h4><small>" + starter + groupNames + "</small></h4>"
				+ "<form action='/ChatProject/MessageHandling' method='GET'>"
				+ "<div name='history' name='history' id='history' class='form-control custom-control' style='width:500px; height: 300px;'>"+message+"</div><br>"
				+ "<div name='message' id='message' contenteditable='true' class='form-control custom-control' placeholder='Write Message Here' style='width:500px;resize:none'></div>"
				+ "<button onclick='func()' type='submit' class='btn btn-default'>Send</button>"
				+ "<button type='button' class='btn btn-default' id='em1' onclick='f1()'>&#128512;</button>"
				+ "<button type='button' class='btn btn-default' id='em2' onclick='f2()'>&#128513;</button>"
				+ "<button type='button' class='btn btn-default' id='em3' onclick='f3()'>&#128514;</button>"
				+ "<button type='button' class='btn btn-default' id='em4' onclick='f4()'>&#128521;</button>"
				+ "<input type='hidden' name='msg' id='msg' value=''></form><br><br>" + "<h4><small>Use Live Chat</small></h4><hr><br><br>" + "</div>  </div></div>"
				+ "<footer class='container-fluid'>" + "<p>Footer Text</p></footer>" + "</body></html>";

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
