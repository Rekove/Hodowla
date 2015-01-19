package repositories.impl.dummy;

import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.IPiesRepo;

public class DummyPiesRepo implements IPiesRepo {
	
private DummyDb db;
	
	public DummyPiesRepo(DummyDb db) {
		super();
		this.db = db;
	}

	@Override
	public void add(Pies entity) {
		db.psy.add(entity);
	}

	@Override
	public void update(Pies entity) {
	}

	@Override
	public void delete(Pies entity) {
		db.psy.remove(entity);
	}

	@Override
	public Pies get(int id) {
		
		for(Pies l:db.psy)
		{
			if(l.getId()==id)
				return l;
		}
		return null;
	}

	@Override
	public List<Pies> getAll() {
		return db.psy;
	}

	@Override
	public List<Pies> ofHodowca(Hodowca hodowca) {
		return ofHodowca(hodowca.getId());
	}

	@Override
	public List<Pies> ofHodowca(String hodowcaImie, String hodowcaNazwisko) {
		
		for(Hodowca s:db.hodowcy)
		{
			if((s.getImie()==hodowcaImie) && (s.getNazwisko()==hodowcaNazwisko))
				return s.getPsy();
		}
		return new ArrayList<Pies>();
	}

	@Override
	public List<Pies> ofHodowca(int hodowcaId) {
		
		for(Hodowca s:db.hodowcy)
		{
			if(s.getId()==hodowcaId)
				return s.getPsy();
		}
		return new ArrayList<Pies>();
	}
	
	
	@Override
	public Pies ofKupiec(Kupiec kupiec) {
		return ofKupiec(kupiec.getId());
	}

	@Override
	public Pies ofKupiec(String kupiecImie, String kupiecNazwisko, String kupiecTelefon) {
		
		for(Kupiec t:db.kupcy)
		{
			if((t.getImie()==kupiecImie) && (t.getNazwisko()==kupiecNazwisko) && (t.getTelefon()==kupiecTelefon))
				return t.getPies();
		}
		return null;
	}

	@Override
	public Pies ofKupiec(int kupiecId) {
		
		for(Kupiec t:db.kupcy)
		{
			if(t.getId()==kupiecId)
				return t.getPies();
		}
		return null;
	}
	
}
