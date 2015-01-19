package domain;

public class Kupiec extends Entity {
	
	private String imie;
	private String nazwisko;
	private String telefon;
	
	private Pies pies;
	
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
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public Pies getPies() {
		return pies;
	}
	public void setPies(Pies pies) {
		this.pies = pies;
	}
	
}
