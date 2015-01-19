package repositories.impl;

import java.sql.*;

import domain.Adres;

public class AdresBuilder implements IEntityBuilder<Adres> {
	
	@Override
	public Adres build(ResultSet rs) throws SQLException {
		
		Adres adres = new Adres();
		adres.setId(rs.getInt("id"));
		adres.setPanstwo(rs.getString("panstwo"));
		adres.setMiasto(rs.getString("miasto"));
		adres.setKodPocztowy(rs.getString("kodPocztowy"));
		adres.setUlica(rs.getString("ulica"));
		adres.setNrDomu(rs.getString("nrDomu"));
		adres.setNrMieszkania(rs.getString("nrMieszkania"));
		return adres;
	}

}
