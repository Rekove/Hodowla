package repositories.impl.dummy;

import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.IKupiecRepo;

public class DummyKupiecRepo implements IKupiecRepo {
	
	private DummyDb db;
	
	public DummyKupiecRepo(DummyDb db) {
		super();
		this.db = db;
	}

	@Override
	public void add(Kupiec entity) {
		db.kupcy.add(entity);
	}

	@Override
	public void update(Kupiec entity) {
	}

	@Override
	public void delete(Kupiec entity) {
		
		db.kupcy.remove(entity);
		
	}

	@Override
	public Kupiec get(int id) {
		
		for(Kupiec t:db.kupcy)
		{
			if(t.getId()==id)
				return t;
		}
		return null;
	}

	@Override
	public List<Kupiec> getAll() {
		return db.kupcy;
	}

	@Override
	public List<Kupiec> ofPies(Pies pies) {
		return ofPies(pies.getId());
	}

	@Override
	public List<Kupiec> ofPies(String piesRasa, String piesImie) {
		
		for(Pies l:db.psy)
		{
			if((l.getRasa()==piesRasa)&&(l.getImie()==piesImie))
				return l.getKupcy();
		}
		return new ArrayList<Kupiec>();
	}

	@Override
	public List<Kupiec> ofPies(int piesId) {
		
		for(Pies l:db.psy)
		{
			if(l.getId()==piesId)
				return l.getKupcy();
		}
		return new ArrayList<Kupiec>();
	}
	
}
