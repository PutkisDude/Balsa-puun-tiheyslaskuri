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
	private String premiumUrl = "/lauripuuntiheys/premium";
	private String loginUrl = "/WEB-INF/login.jsp";
	private String indexUrl = "/WEB-INF/index.jsp";
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	DecimalFormat desi = new DecimalFormat("0.00");
    	// korkeus, pituus, leveys, paino
    	
    	boolean kaikkiTaytetty = false;
    	
    	String[] parametrit = new String[4];
    	
    	parametrit[0] = req.getParameter("paksuus");
    	parametrit[1] = req.getParameter("pituus");
    	parametrit[2] = req.getParameter("leveys");
    	parametrit[3] = req.getParameter("paino");
    	
    	
    	if(req.getParameter("laske") != null) {
        	kaikkiTaytetty = true;
        	
        	// Tarkistaa onko form täytetty
        	for(String i : parametrit) {
        		if(i.isEmpty()) {
        			kaikkiTaytetty = false;
        			req.setAttribute("tulos", "Täytä kaikki arvot :)");
        			break;
        		}
        	}
    		req.setAttribute("paksuus", parametrit[0]);
    		req.setAttribute("pituus", parametrit[1]);
    		req.setAttribute("leveys", parametrit[2]);
    		req.setAttribute("paino", parametrit[3]);
    	}

    	
    	if(kaikkiTaytetty) {
    		
    		// Syöttää sivulle edellisellä kerralla täytetyt luvut

    			try{
    				// Tarkistaa, ettei ole pilkkuja ja muuttaa ne pisteiksi
    				for(int i = 0; i < parametrit.length; i++) {
    					if(parametrit[i].contains(",")) {
    						String[] osat = parametrit[i].split(",");
    						parametrit[i] = osat[0] + "." + osat[1];
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
    				System.out.println(e);
    				req.setAttribute("tulos", "Tapahtui virhe.");
    			}

	}
    	
    	// lähettää login sivulle, jos painaa premium nappia
    	if(req.getParameter("premium") != null) {
			req.getRequestDispatcher(loginUrl).forward(req, resp);
    	}else {
            req.getRequestDispatcher(indexUrl).forward(req, resp);
    	}
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {   	    	
    	String pswd = req.getParameter("password");
    	String back = req.getParameter("back");	
    	if(back != null) {
        	if(back.equals("Back to normal")) {
                req.getRequestDispatcher(indexUrl).forward(req, resp);
         	}
    	}else if(pswd != null) { 		
    		if(pswd.equals("42")) {
				resp.sendRedirect(premiumUrl);
    		}else{
    		req.setAttribute("msg", "You shall not pass!");
			req.getRequestDispatcher(loginUrl).forward(req, resp);
			}
    	}    
    }

   }


