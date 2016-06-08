package cams.org.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cams.org.cson.Cson;

/**
 * Servlet implementation class Test2
 */
@WebServlet("/test2")
public class Test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Cson cson = new Cson();
		if (!session.isNew()) {
			User user = (User) session.getAttribute("user_info");
			
			cson.add("status", 200);
			cson.add("id", user.getId());
			cson.add("name", user.getName());
			cson.add("lastname", user.getLastname());
		} else {
			session.invalidate();
			cson.add("status", 500);
			cson.add("response", "You must login");
		}
		
		response.getWriter().print(cson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
