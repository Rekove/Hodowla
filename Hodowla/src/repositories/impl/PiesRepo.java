package repositories.impl;

import java.sql.*;

import domain.*;
import unitofwork.IUnitOfWork;

public class PiesRepo extends Repo<Pies> {
	
	public PiesRepo(Connection connection, IEntityBuilder<Pies> builder, IUnitOfWork uow) {
		super(connection,builder,uow);
	}

	@Override
	protected void setUpInsertQuery(Pies entity) throws SQLException {
		insert.setString(1, entity.getRasa());
		insert.setString(2, entity.getWiek());
		insert.setString(3, entity.getImie());
	}
	
	@Override
	protected String getInsertQuery() {
		return "INSERT INTO psy(rasa,wiek,imie) VALUES(?,?,?)";
	}
	
	@Override
	protected String getUpdateQuery() {
		return "UPDATE psy SET rasa=?, wiek=?, imie=? WHERE id=?";
	}
	
	@Override
	protected String getTableName() {
		return "psy";
	}

	@Override
	protected void setUpUpdateQuery(Pies entity) throws SQLException {
		update.setString(1, entity.getRasa());
		update.setString(2, entity.getWiek());
		update.setInt(3, entity.getId());
		update.setString(4, entity.getImie());
	}

}
