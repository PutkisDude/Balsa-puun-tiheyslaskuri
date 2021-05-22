package balsalaskin;

public class Balsa {

	private int id;
	private double korkeus, pituus, leveys, paino, tiheys;
	private String grain;
	
	public Balsa(double korkeus, double pituus, double leveys, double paino) {
		this.korkeus = korkeus;
		this.pituus = pituus;
		this.leveys = leveys;
		this.paino = paino;
		double kuutiomitta = korkeus * pituus * leveys;
		this.tiheys = (paino/1000.0) / (kuutiomitta/1000000000.0);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getTiheys() {
		return tiheys;
	}

	public double getPaksuus() {
		return korkeus;
	}

	public double getPituus() {
		return pituus;
	}

	public double getLeveys() {
		return leveys;
	}

	public double getPaino() {
		return paino;
	}

	public String getGrain() {
		return grain;
	}

	public void setGrain(String grain) {
		this.grain = grain;
	}
	
	@Override
	public String toString() {
		return "Balsa [id=" + id + ", paksuus=" + korkeus + ", pituus=" + pituus + ", leveys=" + leveys + ", paino="
				+ paino + ", tiheys=" + tiheys + ", grain=" + grain + "]";
	}

	public double getKorkeus() {
		return korkeus;
	}

}
