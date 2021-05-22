package balsalaskin;
import java.util.List;


public interface BalsaDao {
	
    public List<Balsa> haeKaikkiBalsat();
    public Balsa haeBalsa(int id);
    public boolean lisaaBalsa(Balsa balsa);
    public boolean poistaBalsa(Balsa balsa);
    
}
