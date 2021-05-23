Koulukurssin harjoitustyö

database-package:
	Paketissa on yksinkertainen database.java, jolla yhdistetään oikeaan serveriosoitteeseen.
		Olion ideana on vähentää mahdollisia virheitä ja mahdolliset virheet on helppo korjata, jos tietää mistä ne löytää.

balsalaskin-package:

	Balsa.javan avulla tehdään olio, jossa on tarvittavat muuttujat ja setterit/getterit puuntiheyden laskemiseen. Konstruktori laskee tiheyden 	automaattisesti kun muut arvot syötetty.

	BalsaDao(Interface):
		BalsaDaossa on metodit, joita tarvitaan tietokantasovelluksen toteutukseen:
			haeKaikkiBalsat, haeBalsa, lisaaBalsa ja poistaBalsa.

	JDBCBalsaDao toteuttaa interfacen mukaisesti metodit, jotka toimivat tietokannan kautta.


	
servet-package:
	IndexServletti.java hoitaa puun tiheyslaskimen yksinkertaisen version ja login sivun.
	Tein loginin doPostilla, vaikka ohjeistettiin että pitäisi olla doGet, koska
	doGet salasanan kanssa, ei ole koskaan järkevä vaihtoehto. 
	
	proVersionServlet.java hoitaa tietokannan kanssa toimivan version, mutta kummatkin servletit aika samanlaisia.
	

Sen lisäksi tein projektiin tiedostot index.jsp, login.jsp, proversion.jsp
	Kaikissa niissä on yksinkertaiset formit pelkästään ja proversion.jsp:ssä on foreach printtaus

Ohjelmasta olisi voinut tehdä paremman esim. regexin avulla ja monella muullakin asialla. Anyway pääasia et toimii, varsinkin kun tehty kipeänä alle parissa päivässä.

