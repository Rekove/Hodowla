package repositories.impl.dummy;

import repositories.*;

public class DummyRepoKatalog implements IRepoKatalog {
	
	private DummyDb db = new DummyDb();

	@Override
	public IHodowcaRepo getHodowcy() {
		return new DummyHodowcaRepo(db);
	}

	@Override
	public IPiesRepo getPsy() {
		return new DummyPiesRepo(db);
	}

	@Override
	public IKupiecRepo getKupcy() {
		return new DummyKupiecRepo(db);
	}

	@Override
	public IAdresRepo getAdresy() {
		return new DummyAdresRepo(db);
	}
	
}
