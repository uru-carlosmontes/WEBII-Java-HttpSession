package cams.org.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cams.org.cson.Cson;
import cams.org.sql.JDBConnection;
import cams.org.sql.SQLTable;

/**
 * Servlet implementation class Test
 */
@WebServlet("/test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		System.out.println(id);
		System.out.println(pass);
		JDBConnection pgsql = new JDBConnection ("postgresql", "localhost", 5432, "test", "postgres", "masterkey");

        SQLTable res = pgsql.simpleExecuteQuery("SELECT * FROM _user WHERE user_id = ? AND user_pass = ?", Integer.parseInt(id), pass).asTable();
		
		HttpSession session = request.getSession();
		Cson cson = new Cson();
		
		if (session.isNew()) {
			if (res.getRowsCount() > 0) {
				
				User user = new User(Integer.parseInt(res.getUTF8Value(0, 0)), res.getUTF8Value(0, 1), res.getUTF8Value(0, 2));
				
				session.setAttribute("user_info", user);
				
				cson.add("status", 200);
				cson.add("user", res.getColumns(), res.getUTF8Rows());
			} else {
				cson.add("status", 404);
				cson.add("response", "User Not Found");
			}
		} else {
			cson.add("status", 401);
			cson.add("response", "Session already exists");
		}
		
		
		response.getWriter().print(cson);
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		
	}

}
