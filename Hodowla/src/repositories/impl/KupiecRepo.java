package repositories.impl;

import java.sql.*;

import domain.*;
import unitofwork.IUnitOfWork;

public class KupiecRepo extends Repo<Kupiec> {
	
	public KupiecRepo(Connection connection, IEntityBuilder<Kupiec> builder, IUnitOfWork uow) {
		super(connection,builder,uow);
	}

	@Override
	protected void setUpInsertQuery(Kupiec entity) throws SQLException {
		insert.setString(1, entity.getImie());
		insert.setString(2, entity.getNazwisko());
		insert.setString(3, entity.getTelefon());
	}
	
	@Override
	protected String getInsertQuery() {
		return "INSERT INTO kupcy(imie,nazwisko,telefon) VALUES(?,?,?)";
	}

	@Override
	protected String getUpdateQuery() {
		return "UPDATE kupcy SET imie=?, nazwisko=?, telefon=? WHERE id=?";
	}

	@Override
	protected String getTableName() {
		return "kupcy";
	}
	
	@Override
	protected void setUpUpdateQuery(Kupiec entity) throws SQLException {
		update.setString(1, entity.getImie());
		update.setString(2, entity.getNazwisko());
		update.setInt(3, entity.getId());
		update.setString(4, entity.getTelefon());
	
	}

}

