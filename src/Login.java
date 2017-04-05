
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
	String name="";

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
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		String s = "<html><head>"
				+ "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>"
				+ "</head><body background='rNjDs2.jpg'><div class='container'> "
				+ " <div class='col-md-3 col-md-offset-4'>      "
				+ "<form action='/ChatProject/TestLogin' method='POST'>    <br><br>    <div class='panel panel-info'> <div class='panel-heading'> <h3 class='panel-title'>Login</h3> </div>      <div class='panel-body'>	 	  <div class='input-group'>       <input type='text' name='user' class='form-control' placeholder='Username' aria-describedby='basic-addon1'>      </div>     <br>     <div class='input-group'>      <input type='text' name='password' class='form-control' placeholder='Password' aria-describedby='basic-addon1'>     </div>      <br>     <button type='submit' class='btn btn-info'>Sign in</button>     </div>    </div></form>	</div></div></body></html>";

		response.getWriter().append(s).append(request.getContextPath());
		

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
