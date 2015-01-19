package repositories;

import java.util.List;
import domain.*;

public interface IAdresRepo extends IRepo<Adres> {
	
	public List<Adres> ofHodowca(Hodowca hodowca);
	public List<Adres> ofHodowca(int hodowcaId);
	public List<Adres> ofHodowca(String hodowcaImie, String hodowcaNazwisko);

}
