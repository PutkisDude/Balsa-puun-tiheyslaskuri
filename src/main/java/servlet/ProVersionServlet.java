package servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import balsalaskin.Balsa;
import balsalaskin.JDBCBalsaDao;

@WebServlet("/premium")
public class ProVersionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		JDBCBalsaDao dao = new JDBCBalsaDao();
		List<Balsa> balsat = dao.haeKaikkiBalsat();
		req.setAttribute("lista", balsat);

		if (req.getParameter("laske") != null) {
			String[] parametrit = new String[5];

			parametrit[0] = req.getParameter("paksuus");
			parametrit[1] = req.getParameter("pituus");
			parametrit[2] = req.getParameter("leveys");
			parametrit[3] = req.getParameter("paino");
			parametrit[4] = req.getParameter("grain");

			// Tarkistaa onko form täytetty
			boolean kaikkiTaytetty = true;

			for (String i : parametrit) {
				if (i == null) {
					kaikkiTaytetty = false;
					break;
				}
			}

			if (kaikkiTaytetty) {

				try {
					// Tarkistaa, ettei ole pilkkuja ja muuttaa ne pisteiksi
					for (String x : parametrit) {
						if (x.contains(",")) {
							String[] osat = x.split(",");
							x = osat[0] + "." + osat[1];
						}
					}

					// Castaa String Doublesiksi
					Double korkeus = Double.parseDouble(parametrit[0]);
					Double pituus = Double.parseDouble(parametrit[1]);
					Double leveys = Double.parseDouble(parametrit[2]);
					Double paino = Double.parseDouble(parametrit[3]);

					// Tekee uuden balsa olion, joka laskee automaattisesti tiheyden konstruktorin
					// sisällä.
					Balsa uusiBalsa = new Balsa(korkeus, leveys, pituus, paino);
					uusiBalsa.setGrain(parametrit[4]);
					// Lisää olion tietokantaan
					dao.lisaaBalsa(uusiBalsa);
					resp.sendRedirect("/premium");

				} catch (Exception e) {
					req.setAttribute("tulos", "Tapahtui virhe.");
					resp.sendRedirect("/premium");

				}
			}
		}else if (req.getParameter("remove") != null) {
			int remove = Integer.parseInt(req.getParameter("remove"));
			Balsa poistoBalsa = dao.haeBalsa(remove);
			System.out.println("poisto onnistui? " + dao.poistaBalsa(poistoBalsa));
			resp.sendRedirect("/premium");
		} else {
			req.getRequestDispatcher("/WEB-INF/proversion.jsp").forward(req, resp);
		}

	}

}
