package repositories.impl;

import java.sql.*;

import domain.Kupiec;

public class KupiecBuilder implements IEntityBuilder<Kupiec> {

	@Override
	public Kupiec build(ResultSet rs) throws SQLException {
		
		Kupiec kupiec = new Kupiec();
		kupiec.setId(rs.getInt("id"));
		kupiec.setImie(rs.getString("imie"));
		kupiec.setNazwisko(rs.getString("nazwisko"));
		kupiec.setTelefon(rs.getString("telefon"));
		return kupiec;
	}

}
