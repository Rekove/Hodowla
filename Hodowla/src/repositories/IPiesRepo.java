package repositories;

import java.util.List;

import domain.*;

public interface IPiesRepo extends IRepo<Pies> {
	
	public Pies ofKupiec(Kupiec kupiec);
	public Pies ofKupiec(int kupiecId);
	public Pies ofKupiec(String kupiecImie, String kupiecNazwisko, String kupiecTelefon);
	
	public List<Pies> ofHodowca(Hodowca hodowca);
	public List<Pies> ofHodowca(int hodowcaId);
	public List<Pies> ofHodowca(String hodowcaImie, String hodowcaNazwisko);

}
