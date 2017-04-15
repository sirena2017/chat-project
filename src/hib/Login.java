package hib;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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

		String s = "<html lang='en'><head><title>List Page</title>"
				  +"<meta charset='utf-8'><meta name='viewport' content='width=device-width, initial-scale=1'>"
				  +"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"
				  +"<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js'></script><script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>"
				    +"<style> .row.content {height: 1500px}"
				    +".sidenav {background-color: #f1f1f1;height: 100%; }"
				    +"footer {background-color: #555;color: white;padding: 15px;}" 
				    +"@media screen and (max-width: 767px) {.sidenav {height: auto;padding: 15px;}"
				      +".row.content {height: auto;} }</style></head>"
				    
				+ "<body><div class='container-fluid'>  <div class='row content'>    <div class='col-sm-3 sidenav'>      <img src='http://prateekjain.co/resources/Chat%20Client%20Logo.png'></img>"
      +"<ul class='nav nav-pills nav-stacked'>        <li ><a>Welcome back!!</a></li>        <li><a>You can have live chat here</a></li>      </ul><br>      </div>"
    +"<div class='col-sm-9'>	  <br>   <form action='/ChatProject/TestLogin' method='POST'>    <br><br>	<div class='col-md-4 col-md-offset-3'>"
    +"<div class='panel panel-info'> <div class='panel-heading'> <h3 class='panel-title'>Please Sign In</h3> </div>      <div class='panel-body'>	 <div class='input-group'>"
       +"<input type='text' name='user' id='user' class='form-control' placeholder='Username' aria-describedby='basic-addon1'>      </div>     <br>     <div class='input-group'>"
      +"<input type='text' name='password' class='form-control' placeholder='Password' aria-describedby='basic-addon1'></div> <br><button type='submit' class='btn btn-info'>Sign in</button></div></div></div></form></div></div></div>"
		+"<footer class='container-fluid'><p>contact us</p><p>Mazhari44@gmail.com</p><p>Ghelichkhani.m@gmail.com</p></footer></body></html>";

		response.getWriter().append(s);

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
