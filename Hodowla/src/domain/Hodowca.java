package domain;

import java.util.ArrayList;
import java.util.List;

public class Hodowca extends Entity {
	
	public Hodowca()
	{
		this.adresy=new ArrayList<Adres>();
		this.psy=new ArrayList<Pies>();
	}
	
	private String imie;
	private String nazwisko;
	private String pesel;
	
	private List<Adres> adresy;
	private List<Pies> psy;
	
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public List<Adres> getAdresy() {
		return adresy;
	}
	public void setAdresy(List<Adres> adresy) {
		this.adresy = adresy;
	}
	public List<Pies> getPsy() {
		return psy;
	}
	public void setPsy(List<Pies> psy) {
		this.psy = psy;
	}

}
