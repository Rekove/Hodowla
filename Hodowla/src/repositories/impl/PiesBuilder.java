package repositories.impl;

import java.sql.*;

import domain.Pies;

public class PiesBuilder implements IEntityBuilder<Pies> {

	@Override
	public Pies build(ResultSet rs) throws SQLException {
		
		Pies pies = new Pies();
		pies.setId(rs.getInt("id"));
		pies.setRasa(rs.getString("rasa"));
		pies.setWiek(rs.getString("wiek"));
		pies.setImie(rs.getString("imie"));
		return pies;
	}

}
