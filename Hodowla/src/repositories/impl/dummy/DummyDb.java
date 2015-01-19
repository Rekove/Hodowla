package repositories.impl.dummy;

import java.util.*;
import domain.*;

public class DummyDb {
	
	public List<Hodowca> hodowcy;
	public List<Pies> psy;
	public List<Kupiec> kupcy;
	public List<Adres> adresy;
	
	public DummyDb()
	{
		hodowcy = new ArrayList<Hodowca>();
		psy = new ArrayList<Pies>();
		kupcy = new ArrayList<Kupiec>();
		adresy = new ArrayList<Adres>();
	}

}
