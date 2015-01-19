package repositories.impl;

import java.sql.*;

import domain.*;
import unitofwork.IUnitOfWork;

public class AdresRepo extends Repo<Adres> {
	
	public AdresRepo(Connection connection, IEntityBuilder<Adres> builder, IUnitOfWork uow) {
		super(connection,builder,uow);
	}

	@Override
	protected void setUpInsertQuery(Adres entity) throws SQLException {
		insert.setString(1, entity.getPanstwo());
		insert.setString(2, entity.getMiasto());
		insert.setString(3, entity.getKodPocztowy());
		insert.setString(4, entity.getUlica());
		insert.setString(5, entity.getNrDomu());
		insert.setString(6, entity.getNrMieszkania());
	}
	
	@Override
	protected String getInsertQuery() {
		return "INSERT INTO adresy(panstwo,miasto,kodPocztowy,ulica,nrDomu,nrMieszkania)"
				+ "VALUES(?,?,?,?,?,?)";
	}

	@Override
	protected String getUpdateQuery() {
		return "UPDATE adresy SET panstwo=?, miasto=?, kodPocztowy=?, ulica=?, nrDomu=?, "
				+ "nrMieszkania=? WHERE id=?";
	}

	@Override
	protected String getTableName() {
		return "adresy";
	}

	@Override
	protected void setUpUpdateQuery(Adres entity) throws SQLException {
		update.setString(1, entity.getPanstwo());
		update.setString(2, entity.getMiasto());
		update.setString(3, entity.getKodPocztowy());
		update.setString(4, entity.getUlica());
		update.setString(5, entity.getNrDomu());
		update.setString(6, entity.getNrMieszkania());
		update.setInt(7, entity.getId());
	}

}
