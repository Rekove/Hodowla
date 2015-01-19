package repositories;

import java.util.List;

import domain.*;

public interface IHodowcaRepo extends IRepo<Hodowca> {
	
	public List<Hodowca> byPies(Pies pies);
	public List<Hodowca> byPies(int piesId);
	public List<Hodowca> byPies(String piesRasa);
	public Hodowca byAdres(Adres adres);
	public Hodowca byAdres(int adresId);
	public Hodowca byAdres(String ulica, String nrMieszkania, String nrDomu, String kodPocztowy, String miasto, String panstwo);
	
}

