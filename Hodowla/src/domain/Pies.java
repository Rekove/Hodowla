package domain;

import java.util.ArrayList;
import java.util.List;

public class Pies extends Entity {
	
	public Pies()
	{
		this.hodowcy=new ArrayList<Hodowca>();
		this.kupcy=new ArrayList<Kupiec>();
	}
	
	private String imie;
	private String rasa;
	private String wiek;
	
	private List<Hodowca> hodowcy;
	private List<Kupiec> kupcy;
	
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	
	public String getRasa() {
		return rasa;
	}
	public void setRasa(String rasa) {
		this.rasa = rasa;
	}
	public String getWiek() {
		return wiek;
	}
	public void setWiek(String wiek) {
		this.wiek = wiek;
	}
	public List<Hodowca> getHodowcy() {
		return hodowcy;
	}
	public void setHodowcy(List<Hodowca> hodowcy) {
		this.hodowcy = hodowcy;
	}
	public List<Kupiec> getKupcy() {
		return kupcy;
	}
	public void setKupcy(List<Kupiec> kupcy) {
		this.kupcy = kupcy;
	}
		

}
