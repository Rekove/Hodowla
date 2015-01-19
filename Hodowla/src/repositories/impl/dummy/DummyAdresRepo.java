package repositories.impl.dummy;

import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.IAdresRepo;

public class DummyAdresRepo implements IAdresRepo {
	
private DummyDb db;
	
	public DummyAdresRepo(DummyDb db) {
		super();
		this.db = db;
	}

	@Override
	public void add(Adres entity) {
		db.adresy.add(entity);	
	}
	
	@Override
	public void update(Adres entity) {
	}

	@Override
	public void delete(Adres entity) {
		db.adresy.remove(entity);
	}

	@Override
	public Adres get(int id) {
		
		for(Adres a:db.adresy)
		{
			if(a.getId()==id)
				return a;
		}
		return null;
	}

	@Override
	public List<Adres> getAll() {
		return db.adresy;
	}

	@Override
	public List<Adres> ofHodowca(Hodowca hodowca) {
		return ofHodowca(hodowca.getId());
	}

	@Override
	public List<Adres> ofHodowca(int hodowcaId) {
		
		for(Hodowca s:db.hodowcy)
		{
			if(s.getId()==hodowcaId)
				return s.getAdresy();
		}
		return new ArrayList<Adres>();
	}

	@Override
	public List<Adres> ofHodowca(String hodowcaImie,
			String hodowcaNazwisko) {

		for(Hodowca s:db.hodowcy)
		{
			if((s.getImie()==hodowcaImie)&&(s.getNazwisko()==hodowcaNazwisko))
				return s.getAdresy();
		}
		return new ArrayList<Adres>();
	}
	
}
