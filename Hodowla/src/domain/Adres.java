package domain;

public class Adres extends Entity {
	
	private String panstwo;
	private String miasto;
	private String kodPocztowy;
	private String ulica;
	private String nrDomu;
	private String nrMieszkania;
	
	private Hodowca hodowca;
	
	public String getPanstwo() {
		return panstwo;
	}
	public void setPanstwo(String panstwo) {
		this.panstwo = panstwo;
	}
	public String getMiasto() {
		return miasto;
	}
	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}
	public String getKodPocztowy() {
		return kodPocztowy;
	}
	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getNrDomu() {
		return nrDomu;
	}
	public void setNrDomu(String nrDomu) {
		this.nrDomu = nrDomu;
	}
	public String getNrMieszkania() {
		return nrMieszkania;
	}
	public void setNrMieszkania(String nrMieszkania) {
		this.nrMieszkania = nrMieszkania;
	}
	public Hodowca getHodowca() {
		return hodowca;
	}
	public void setHodowca(Hodowca hodowca) {
		this.hodowca = hodowca;
	}
	
	
}






