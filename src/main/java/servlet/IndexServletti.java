package servlet;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import balsalaskin.Balsa;

@WebServlet("")
public class IndexServletti extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	DecimalFormat desi = new DecimalFormat("0.00");
    	// korkeus, pituus, leveys, paino
    	String[] parametrit = new String[4];
    	
    	parametrit[0] = req.getParameter("paksuus");
    	parametrit[1] = req.getParameter("pituus");
    	parametrit[2] = req.getParameter("leveys");
    	parametrit[3] = req.getParameter("paino");
    	
    	// Tarkistaa onko form täytetty
    	boolean kaikkiTaytetty = true;
    	
    	for(String i : parametrit) {
    		if(i == null) {
    			kaikkiTaytetty = false;
    			break;
    		}
    	}
    	
    	if(kaikkiTaytetty) {
    		
    		req.setAttribute("paksuus", parametrit[0]);
    		req.setAttribute("pituus", parametrit[1]);
    		req.setAttribute("leveys", parametrit[2]);
    		req.setAttribute("paino", parametrit[3]);

    			try{
    				Double korkeus = Double.parseDouble(req.getParameter("paksuus")); 
        			Double pituus = Double.parseDouble(req.getParameter("pituus"));
        			Double leveys = Double.parseDouble(req.getParameter("leveys"));
        			Double paino = Double.parseDouble(req.getParameter("paino"));    			
        			 
        			Balsa lasku = new Balsa(korkeus, leveys, pituus, paino);
        			  
        			String tuloste = desi.format(lasku.getTiheys()) + "kg/m3";
        			req.setAttribute("tulos", tuloste);
    			}catch(Exception e){
    				req.setAttribute("tulos", "Tapahtui virhe.");
    			}

	}
		 
        // lähetä request edelleen index.jsp sivulle
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}
