package balsalaskin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;

public class JDBCBalsaDao implements BalsaDao {

	
	public Balsa teeUusiBalsa(ResultSet res) throws SQLException {
		ResultSet resultset = res;
		int id = resultset.getInt("id");
		double korkeus = resultset.getDouble("korkeus");
		double leveys = resultset.getDouble("leveys");
		double pituus = resultset.getDouble("pituus");
		double paino = resultset.getDouble("paino");
		String grain = resultset.getString("grain");
		Balsa balsa = new Balsa(korkeus, pituus, leveys, paino);
		balsa.setGrain(grain);
		balsa.setId(id);
		return balsa;
	}
	
	public ArrayList<Balsa> haeKaikkiBalsat() {
			ArrayList<Balsa> balsat = new ArrayList<Balsa>();
			Connection yhteys = Database.connect();
		try {
			PreparedStatement statement = yhteys.prepareStatement("SELECT * FROM Balsalevy");
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Balsa balsa = teeUusiBalsa(resultset);
				balsat.add(balsa);
			}
			resultset.close();
			statement.close();
			yhteys.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return balsat;
	}
	
	@Override
	public Balsa haeBalsa(int id) {
		Connection yhteys = Database.connect();
		try {
			PreparedStatement statement = yhteys.prepareStatement("SELECT * FROM Balsalevy WHERE id = ?");
			statement.setLong(1, id);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next()) {
				Balsa balsa = teeUusiBalsa(resultset);
				resultset.close();
				statement.close();
				yhteys.close();
				return balsa;
			} else {
				return null;
			}
		}catch(SQLException e){
			throw new RuntimeException("Tapahtui virhe haussa.");
		}
	}

	@Override
	public boolean lisaaBalsa(Balsa balsa) {
		String sql_insert = "INSERT INTO Balsalevy(tiheys,korkeus,leveys,paino,pituus,grain) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			Connection yhteys = Database.connect();
			PreparedStatement statement = yhteys.prepareStatement(sql_insert);
			statement.setDouble(1, balsa.getTiheys());
			statement.setDouble(2, balsa.getKorkeus());
			statement.setDouble(3, balsa.getLeveys());
			statement.setDouble(4, balsa.getPaino());
			statement.setDouble(5, balsa.getPituus());
			statement.setString(6, balsa.getGrain());
			statement.executeUpdate();
			ResultSet rsAvain = statement.getGeneratedKeys();
			if(rsAvain.next()) {
				return true;
			}else {
				return false;
			}		
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean poistaBalsa(Balsa balsa) {
		String sql = "DELETE FROM Balsalevy WHERE ID=?";
		try {
			Connection yhteys = Database.connect();
			PreparedStatement statement = yhteys.prepareStatement(sql);
			statement.setInt(1, balsa.getId());
			int delete = statement.executeUpdate();
			statement.close();
			yhteys.close();
			if(delete > 0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

}
