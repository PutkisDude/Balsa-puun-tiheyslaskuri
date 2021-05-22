package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import balsalaskin.Balsa;
import balsalaskin.JDBCBalsaDao;

@WebServlet("/premium")
public class ProVersionServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	JDBCBalsaDao dao = new JDBCBalsaDao();
    	List<Balsa> balsat = dao.haeKaikkiBalsat();
    	
		req.setAttribute("lista", balsat);

    	
    	
        req.getRequestDispatcher("/WEB-INF/proversion.jsp").forward(req, resp);

    }
	
}
