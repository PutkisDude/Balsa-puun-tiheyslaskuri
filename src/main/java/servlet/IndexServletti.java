package servlet;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import balsalaskin.Balsa;

@WebServlet({"", "/laske"})
public class IndexServletti extends HttpServlet {

	String[] parametrit = new String[4];

	
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
    		
    		// Syöttää sivulle edellisellä kerralla täytetyt luvut
    		req.setAttribute("paksuus", parametrit[0]);
    		req.setAttribute("pituus", parametrit[1]);
    		req.setAttribute("leveys", parametrit[2]);
    		req.setAttribute("paino", parametrit[3]);
    			try{
    				// Tarkistaa, ettei ole pilkkuja ja muuttaa ne pisteiksi
    				for(String x : parametrit) {
    					if(x.contains(",")) {
    						String[] osat = x.split(",");
    						x = osat[0] + "." + osat[1];
    					}
    				}
    				
    				// Castaa String Doublesiksi
    				Double korkeus = Double.parseDouble(parametrit[0]); 
        			Double pituus = Double.parseDouble(parametrit[1]);
        			Double leveys = Double.parseDouble(parametrit[2]);
        			Double paino = Double.parseDouble(parametrit[3]);    			
        			 
        			// Tekee uuden balsa olion, joka laskee automaattisesti tiheyden konstruktorin sisällä.
        			Balsa lasku = new Balsa(korkeus, leveys, pituus, paino);
        			// Hakee tiheyden ja rajoittaa tulokset kahteen desimaalilukuun.
        			String tuloste = desi.format(lasku.getTiheys()) + "kg/m3";
        			req.setAttribute("tulos", tuloste);
    			}catch(Exception e){
    				req.setAttribute("tulos", "Tapahtui virhe.");
    			}

	}
    	
    	// lähettää login sivulle, jos painaa premium nappia
    	if(req.getParameter("premium") != null) {
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    	}else {
            req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    	}
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {   	    	
    	String pswd = req.getParameter("password");
    	String back = req.getParameter("back");	
    	if(back != null) {
        	if(back.equals("Back to normal")) {
                req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
         	}
    	}else if(pswd != null) { 		
    		if(pswd.equals("42")) {
				resp.sendRedirect("/WEB-INF/proversion.jsp");
    		}else{
    		req.setAttribute("msg", "You shall not pass!");
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
			}
    	}    
    }

   }


