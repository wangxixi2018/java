package opposervlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/user.do")
public class User extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String opr=req.getParameter("opr");
    	System.out.println(opr);
    	HttpSession session=req.getSession();
    	session.setAttribute("ppp", "11122233");
    	req.getRequestDispatcher("index.jsp").forward(req, resp);
    }  
}
