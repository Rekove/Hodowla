package repositories;

import java.util.List;
import domain.*;

public interface IKupiecRepo extends IRepo<Kupiec> {
	
	public List<Kupiec> ofPies(Pies pies);
	public List<Kupiec> ofPies(int piesId);
	public List<Kupiec> ofPies(String piesRasa, String piesImie);
}
