package repositories.impl.dummy;

import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.IHodowcaRepo;

public class DummyHodowcaRepo implements IHodowcaRepo{
	
	private DummyDb db;
	
	public DummyHodowcaRepo(DummyDb db) {
		super();
		this.db = db;
	}

	@Override
	public void add(Hodowca entity) {
		db.hodowcy.add(entity);
	}

	@Override
	public void update(Hodowca entity) {
	}

	@Override
	public void delete(Hodowca entity) {
		db.hodowcy.remove(entity);
	}

	@Override
	public Hodowca get(int id) {
		
		for(Hodowca s:db.hodowcy)
		{
			if(s.getId()==id)
				return s;
		}
		return null;
	}

	@Override
	public List<Hodowca> getAll() {
		return db.hodowcy;
	}

	@Override
	public List<Hodowca> byPies(Pies pies) {
		return byPies(pies.getId());
	}

	@Override
	public List<Hodowca> byPies(String piesRasa) {
		
		for(Pies l:db.psy)
		{
			if(l.getRasa()==piesRasa)
				return l.getHodowcy();
		}
		return new ArrayList<Hodowca>();
	}

	@Override
	public List<Hodowca> byPies(int piesId) {
		
		for(Pies l:db.psy)
		{
			if(l.getId()==piesId)
				return l.getHodowcy();
		}
		return new ArrayList<Hodowca>();
	}

	@Override
	public Hodowca byAdres(Adres adres) {
		return byAdres(adres.getId());
	}

	@Override
	public Hodowca byAdres(int adresId) {
		
		for(Adres a:db.adresy)
		{
			if(a.getId()==adresId)
				return a.getHodowca();
		}
		return null;
	}

	@Override
	public Hodowca byAdres(String ulica, String nrDomu,
			String nrMieszkania, String kodPocztowy, String miasto, String panstwo) {
		
		for(Adres a:db.adresy)
		{
			if((a.getUlica()==ulica)&&(a.getNrDomu()==nrDomu)&&(a.getNrMieszkania()==nrMieszkania)&&(a.getKodPocztowy()==kodPocztowy)&&(a.getMiasto()==miasto)&&(a.getPanstwo()==panstwo))
				return a.getHodowca();
		}
		
		return null;
	}
	
}
