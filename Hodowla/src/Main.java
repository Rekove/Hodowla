import java.sql.*;

import domain.*;
import repositories.*;
import repositories.impl.*;
import unitofwork.IUnitOfWork;
import unitofwork.UnitOfWork;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Witamy w hodowli!");
		
		String url = "jdbc:mysql://localhost:3306/";
		String user = "root";
		String password = "";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection(url, user, password);
			
			IUnitOfWork uow = new UnitOfWork(connection);
			
			
			Statement stmt = connection.createStatement();
			
			stmt.execute("CREATE DATABASE IF NOT EXISTS hodowla");
			stmt.execute("USE hodowla");
			stmt.execute("DROP TABLE IF EXISTS kupcy");
			stmt.execute("DROP TABLE IF EXISTS hodowcy");
			stmt.execute("DROP TABLE IF EXISTS adresy");
			stmt.execute("DROP TABLE IF EXISTS psy");
			
			
			String createKupiecTable=
					"CREATE TABLE kupcy ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "imie VARCHAR(20),"
					+ "nazwisko VARCHAR(40),"
					+ "telefon VARCHAR(20)"
					+ ")";
			
			String createHodowcaTable=
					"CREATE TABLE hodowcy ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "imie VARCHAR(20),"
					+ "nazwisko VARCHAR(40),"
					+ "pesel CHAR(11)"
					+ ")";
			
			String createAdresTable=
					"CREATE TABLE adresy ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "panstwo VARCHAR(30),"
					+ "miasto VARCHAR(40),"
					+ "kodPocztowy VARCHAR(10),"
					+ "ulica VARCHAR(40),"
					+ "nrDomu VARCHAR(10),"
					+ "nrMieszkania VARCHAR(10)"
					+ ")";
			
			String createPiesTable=
					"CREATE TABLE psy ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "imie VARCHAR(10),"
					+ "rasa VARCHAR(20),"
					+ "wiek VARCHAR(20)"
					+ ")";
			
			stmt.executeUpdate(createKupiecTable); 
			stmt.executeUpdate(createHodowcaTable); 
			stmt.executeUpdate(createAdresTable);
			stmt.executeUpdate(createPiesTable);
			
			
			IRepo<Kupiec> kupcy = new KupiecRepo(connection, new KupiecBuilder(), uow);
			IRepo<Hodowca> hodowcy = new HodowcaRepo(connection, new HodowcaBuilder(), uow);
			IRepo<Adres> adresy = new AdresRepo(connection, new AdresBuilder(), uow);
			IRepo<Pies> psy = new PiesRepo(connection, new PiesBuilder(), uow);
			
			
			Hodowca hodowca1 = new Hodowca();
			hodowca1.setImie("Karol");
			hodowca1.setNazwisko("Rudy");
			hodowca1.setPesel("75020107565");
			Hodowca hodowca2 = new Hodowca();
			hodowca2.setImie("Karolina");
			hodowca2.setNazwisko("Kubala");
			hodowca2.setPesel("90051507582");
			
			Kupiec kupiec1 = new Kupiec();
			kupiec1.setImie("Krzysztof");
			kupiec1.setNazwisko("Gorski");
			kupiec1.setTelefon("+48789123456");
			
			Pies pies1 = new Pies();
			pies1.setImie("Kami");
			pies1.setRasa("Basenji");
			pies1.setWiek("3 miesiace");
			
			Pies pies2 = new Pies();
			pies2.setImie("Nikita");
			pies2.setRasa("Alaskan Malamute");
			pies2.setWiek("16 miesiecy");
			
			Adres adres1 = new Adres();
			adres1.setPanstwo("Polska");
			adres1.setMiasto("S³upsk");
			adres1.setKodPocztowy("76-200");
			adres1.setUlica("Sierpinka");
			adres1.setNrDomu("8");
			adres1.setNrMieszkania("4");
			
			
			//dodawanie
			
			hodowcy.add(hodowca1);
			hodowcy.add(hodowca2);
			kupcy.add(kupiec1);
			psy.add(pies1);
			psy.add(pies2);
			adresy.add(adres1);
			
			uow.commit();
			
			System.out.println("Wszyscy Hodowcy w bazie:");
			for(Hodowca fromDb : hodowcy.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getImie()+" "+fromDb.getNazwisko()+" "
				+fromDb.getPesel());
			
			System.out.println("Wszyscy Kupcy w bazie:");
			for(Kupiec fromDb : kupcy.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getImie()+" "+fromDb.getNazwisko()+" "+fromDb.getTelefon());
			
			System.out.println("Wszystkie psy w bazie:");
			for(Pies fromDb : psy.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getImie()+" "+fromDb.getRasa()+" "+fromDb.getWiek());
			
			System.out.println("Wszystkie adresy w bazie:");
			for(Adres fromDb : adresy.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getPanstwo()+", "+fromDb.getMiasto()+", "
				+fromDb.getKodPocztowy()+", "+fromDb.getUlica()+", "+fromDb.getNrDomu()+"/"
				+fromDb.getNrMieszkania());
			
			//uaktualnienie
			
			hodowca2 = hodowcy.get(2);
			hodowca2.setNazwisko("Krakowska");
			hodowcy.update(hodowca2);
			
			uow.commit();
			
			System.out.println("Wszyscy hodowcy w bazie:");
			for(Hodowca fromDb : hodowcy.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getImie()+" "+fromDb.getNazwisko()+" "
				+fromDb.getPesel());
			
			//usuwanie
			
			Hodowca toDel = hodowcy.getAll().get(0);
			hodowcy.delete(toDel);
			
			uow.commit();
			
			System.out.println("Wszyscy hodowcy w bazie:");
			for(Hodowca fromDb : hodowcy.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getImie()+" "+fromDb.getNazwisko()+" "
				+fromDb.getPesel());
			
			
			System.out.println("Hodowca o id 2 to: "+hodowcy.get(2).getImie()+" "+hodowcy.get(2).getNazwisko());
			
			
			stmt.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

