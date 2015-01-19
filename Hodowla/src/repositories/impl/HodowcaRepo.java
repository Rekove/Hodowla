package repositories.impl;

import java.sql.*;

import domain.*;
import unitofwork.IUnitOfWork;

public class HodowcaRepo extends Repo<Hodowca> {
	
	public HodowcaRepo(Connection connection, IEntityBuilder<Hodowca> builder, IUnitOfWork uow) {
		super(connection,builder,uow);
	}
	
	@Override
	protected void setUpInsertQuery(Hodowca entity) throws SQLException {
		insert.setString(1, entity.getImie());
		insert.setString(2, entity.getNazwisko());
		insert.setString(3, entity.getPesel());
	}
	
	@Override
	protected String getInsertQuery() {
		return "INSERT INTO hodowcy(imie,nazwisko,pesel) VALUES(?,?,?)";
	}

	@Override
	protected String getUpdateQuery() {
		return "UPDATE hodowcy SET imie=?, nazwisko=?, pesel=? WHERE id=?";
	}

	@Override
	protected String getTableName() {
		return "hodowcy";
	}
	
	@Override
	protected void setUpUpdateQuery(Hodowca entity) throws SQLException {
		update.setString(1, entity.getImie());
		update.setString(2, entity.getNazwisko());
		update.setString(3, entity.getPesel());
		update.setInt(4, entity.getId());
	}

}

