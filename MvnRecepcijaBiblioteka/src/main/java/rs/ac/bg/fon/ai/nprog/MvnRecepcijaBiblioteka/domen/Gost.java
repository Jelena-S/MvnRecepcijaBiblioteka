package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.Recepcioner;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

/**
 * Klasa predstavlja gosta sa svim svojim svojstvima. Implementira interfejse OpstiDomenskiObjekat i Serializable.
 *
 * @author Jelena Sreckovic
 */

public class Gost implements OpstiDomenskiObjekat, Serializable{
	
	/**
	 * Identifikator gosta
	 */
	private Long gostID;
	
	/**
	 * Ime gosta
	 */
	private String imeGosta;
	
	/**
	 * Prezime gosta
	 */
	private String prezimeGosta;
	
	/**
	 * Broj lične karte gosta
	 */
	private String brojLicneKarte;
	
	/**
	 * Broj telefona gosta
	 */
	private String brojTelefona;
	
	/**
	 * E-mail gosta
	 */
	private String email;
	
	/**
	 * Recepcioner koji je uneo gosta u bazu 
	 */
	private Recepcioner recepcioner;
	
	/**
	 * Neparametrizovani konstruktor. Inicijalizuje gosta.
	 */
	public Gost() {
		
    }
	
	/**
	 * Parametrizovani konstruktor. Inicijalizuje gosta i postavlja prosledjene vrednosti pozivanjem set metoda.
	 * 
	 * @param gostID Vrednost identifikatora gosta koju je potrebno postaviti
	 * @param imeGosta Ime gosta koju je potrebno postaviti
	 * @param prezimeGosta Prezime gosta koje je potrebno postaviti
	 * @param brojLicneKarte Vrednost broja lične karte gosta koju je potrebno postaviti
	 * @param brojTelefona Vrednost broja telefona gosta koju je potrebno postaviti
	 * @param email Email gosta koju je potrebno postaviti
	 * @param recepcioner Vrednost recepcionera koju je potrebno postaviti
	 */
	public Gost(Long gostID, String imeGosta, String prezimeGosta, String brojLicneKarte, String brojTelefona, String email, Recepcioner recepcioner) {
        this.gostID = gostID;
        this.imeGosta = imeGosta;
        this.prezimeGosta = prezimeGosta;
        this.brojLicneKarte = brojLicneKarte;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.recepcioner = recepcioner;
    }
	
	/**
     * Parametrizovani kontruktor. Inicijalizuje gosta i postavlja identifikator na prosledjenu vrednost pozivanjem set metode.
     * 
     * @param gostID Vrednost identifikatora gosta koju je potrebno postaviti
     */
	public Gost(Long gostID) {
        this.gostID = gostID;
    }

	/**
     * Metoda vraća vrednost identifikatora gosta
     * 
     * @return gostID kao Long
     */
	public Long getGostID() {
		return gostID;
	}

	/**
     * Metoda postavlja novu vrednost za atribut identifikator gosta.
     * 
     * @param gostId Identifikator gosta koji je potrebno postaviti.
     */
	public void setGostID(Long gostID) {
		this.gostID = gostID;
	}

	/**
     * Metoda vraća ime gosta
     * 
     * @return imeGosta kao String
     */
	public String getImeGosta() {
		return imeGosta;
	}

	/**
     * Metoda postavlja novu vrednost za atribut ime gosta.
     * 
     * @param imeGosta Ime gosta koje je potrebno postaviti.
     */
	public void setImeGosta(String imeGosta) {
		this.imeGosta = imeGosta;
	}

	/**
     * Metoda vraća prezime gosta
     * 
     * @return prezimeGosta kao String 
     */
	public String getPrezimeGosta() {
		return prezimeGosta;
	}

	/**
     * Metoda postavlja novu vrednost za atribut prezime gosta.
     * 
     * @param prezimeGosta Prezime gosta koje je potrebno postaviti.
     */
	public void setPrezimeGosta(String prezimeGosta) {
		this.prezimeGosta = prezimeGosta;
	}

	/**
     * Metoda vraća broj lične karte gosta
     * 
     * @return brojLičneKarte kao String
     */
	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	/**
     * Metoda postavlja novu vrednost za atribut brojLicneKarte gosta
     * 
     * @param brojLicneKarte Broj licne karte gosta koji je potrebno postaviti
     */
	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}
	
	/**
     * Metoda vraća broj telefona gosta
     * 
     * @return brojTelefona kao String 
     */
	public String getBrojTelefona() {
		return brojTelefona;
	}

	/**
     * Metoda postavlja novu vrednost za atribut brojTelefona gosta.
     * 
     * @param brojTelefona Broj telefona gosta koji je potrebno postaviti.
     */
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	/**
     * Metoda vraća email gosta
     * 
     * @return email kao String  
     */
	public String getEmail() {
		return email;
	}

	/**
     * Metoda postavlja novu vrednost za atribut email gosta.
     * 
     * @param email Email gosta koji je potrebno postaviti.
     */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
     * Metoda vraća recepcionera koji je uneo gosta u sistem
     * 
     * @return recepcioner kao Recepcioner 
     */
	public Recepcioner getRecepcioner() {
		return recepcioner;
	}

	/**
     * Metoda postavlja novu vrednost za atribut recepcioner koji je uneo gosta.
     * 
     * @param recepcioner Recepcioner kog je potrebno postaviti
     */
	public void setRecepcioner(Recepcioner recepcioner) {
		this.recepcioner = recepcioner;
	}
	
	/**
     * Metoda vraća String koji sadrži ime i prezime gosta
     * 
     * @return String koji sadrži ime i prezime gosta
     */
	@Override
    public String toString() {
        return imeGosta+" "+prezimeGosta;
    }

	/**
	 * Proverava da li su dva gosta ista i vraca
	 * true ako jesu, a false ako nisu.
	 * 
	 * @return true ako je unet objekat klase Gost
	 * sa istim identifikatorom i brojem licne karte, inace false.
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gost other = (Gost) obj;
		if (brojLicneKarte == null) {
			if (other.brojLicneKarte != null)
				return false;
		} else if (!brojLicneKarte.equals(other.brojLicneKarte))
			return false;
		if (gostID == null) {
			if (other.gostID != null)
				return false;
		} else if (!gostID.equals(other.gostID))
			return false;
		return true;
	}
	
	/**
	 * Metoda vraća naziv tabele u bazi u kojoj se nalaze podaci o gostu.
	 * 
	 * @return String koji predstavlja naziv tabele.
	 */
	@Override
	public String getImeTabele() {
		return "gost";
	}

	

	/**
	 * Metoda vraća vrednosti atributa objekta klase Gost koje bi trebalo sačuvati u bazi.
	 * 
	 * @return String koji predstavlja vrednosti atributa.
	 */
	@Override
	public String getParametre() {
        return String.format("%s, '%s', '%s', '%s', '%s', '%s', %s", gostID, imeGosta, prezimeGosta, brojLicneKarte, brojTelefona, email, recepcioner.getRecepcionerID()); //dodaj recepcionera
	}
	
	/**
	 * Metoda vraća vrednosti atributa objekta klase Gost koje bi trebalo sačuvati u bazi
	 * 
	 * @return String koji predstavlja vrednosti atributa.
	 */
	public String getParametersWithoutID() {
        return String.format("'%s', '%s', '%s', '%s', '%s', %s", imeGosta, prezimeGosta, brojLicneKarte, brojTelefona, email, recepcioner.getRecepcionerID()); //dodaj recepcionera
    }

	/**
	 * Metoda vraća imena atributa objekta klase Gost nad kojim se poziva metoda
	 * 
	 * @return String koji predstavlja imena atributa odvojeni zapetom.
	 */
	@Override
	public String getImenaParametara() {
        return "gostID,imeGosta,prezimeGosta,brojLicneKarte,brojTelefona,email,recepcionerID"; 

	}
	
	/**
	 * Metoda vraća imena atributa objekta klase Gost nad kojim se poziva metoda, bez identifikatora
	 * 
	 * @return String koji predstavlja imena atributa odvojeni zapetom.
	 */
	public String getImenaParametaraBezID() {
        return "imeGosta,prezimeGosta,brojLicneKarte,brojTelefona,email,recepcionerID"; 
    }

	/**
   	 * Metoda vraća ime primarnog ključa tabele u bazi koja predstavlja objekat klase Gost.
   	 * 
   	 * @return String koji predstavlja ime primarnog ključa.
   	 */
	@Override
	public String getImePrimarnogKljuca() {
		return "gostID";
	}

	/**
	 * Metoda vraća vrednost primarnog ključa tabele u bazi koja predstavlja objekat klase Gost
	 * 
	 * @return gostID kao Long koji predstavlja vrednost primarnog ključa.
	 */
	@Override
	public Long getVrednostPrimarnogKljuca() {
		return gostID;
	}

	/**
	 * Metoda konvertuje prosledjeni ResultSet u listu objekata klase Gost 
	 * 
	 * @param rs ResultSet koji je potrebno konvertovati u listu gostiju
	 * 
	 * @return Lista domenskih objekata koji su procitani iz baze
	 */
	@Override
	public List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs) {
		List<OpstiDomenskiObjekat> guests = new ArrayList<>();
        try {
            while (rs.next()) {                
                Long guestID = rs.getLong("gostID");
                String name = rs.getString("imeGosta");
                String lastname = rs.getString("prezimeGosta");
                String cardID = rs.getString("brojLicneKarte");
                String phoneNumber = rs.getString("brojTelefona");
                String mail = rs.getString("email");
                Long recepcionistID = rs.getLong("recepcionerID");
                
                Gost g = new Gost(guestID,name, lastname, cardID, phoneNumber, mail, new Recepcioner(recepcionistID));
                guests.add(g);
            }
        } catch (Exception e) {
            System.out.println("Greska u Gost.Class ResultSet"); 
                 
        }
        return guests;
	}

	/**
	 * Metoda vraća nazive parametara klase Gost i njihovih novih vrednosti koje će biti ažurirane
	 * 
	 * @return String koji predstavlja kombinaciju parametara i njihovih novih vrednosti koje je potrebno ažurirati u bazi.
	 */
	@Override
	public String getUpitAzuriranje() {
		 return "imeGosta = '"+imeGosta+"', prezimeGosta = '"+prezimeGosta+"', brojLicneKarte = '"+brojLicneKarte+
	                "', brojTelefona = '"+brojTelefona +"', email = '"+email+"', recepcionerID = "+recepcioner.getRecepcionerID();
	}

	/**
	 * Metoda vraća uslov složenog primarnog ključa tabele u bazi koja predstavlja objekat
	 * 
	 * @return String koji predstavlja ime i vrednost složenog primarnog kljuca ili null ako primarni ključ nije složen.
	 */
	@Override
	public String getSlozeniPrimarniKljuc() {
		return null;
	}
	
	
}
