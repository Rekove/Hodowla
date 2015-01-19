package repositories.impl;

import java.sql.*;

import domain.Hodowca;

public class HodowcaBuilder implements IEntityBuilder<Hodowca> {

	@Override
	public Hodowca build(ResultSet rs) throws SQLException {
		
		Hodowca hodowca = new Hodowca();
		hodowca.setId(rs.getInt("id"));
		hodowca.setImie(rs.getString("imie"));
		hodowca.setNazwisko(rs.getString("nazwisko"));
		hodowca.setPesel(rs.getString("pesel"));
		return hodowca;
	}

}
