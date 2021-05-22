package servlet;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import balsalaskin.Balsa;
import balsalaskin.JDBCBalsaDao;

@WebServlet("")
public class IndexServletti extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	JDBCBalsaDao dao = new JDBCBalsaDao();
    	List<Balsa> balsalist = dao.haeKaikkiBalsat();
        req.setAttribute("lista", balsalist);

        // lähetä request edelleen index.jsp sivulle
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}
