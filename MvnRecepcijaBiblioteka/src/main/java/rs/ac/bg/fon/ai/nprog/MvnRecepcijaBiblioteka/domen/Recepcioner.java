package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

/**
 * Klasa predstavlja gosta sa svim svojim svojstvima. Implementira interfejse OpstiDomenskiObjekat i Serializable
 *
 * @author Jelena Sreckovic
 */

public class Recepcioner implements OpstiDomenskiObjekat, Serializable{
	
	/**
	 * Identifikator recepcionera
	 */
	private Long recepcionerID;
	
	/**
     * Ime recepcionera
     */
    private String imeRecepcionera;
    
    /**
     * Prezime recepcionera
     */
    private String prezimeRecepcionera;
    
    /**
     * Korisničko ime recepcionera
     */
    private String korisnickoIme;
    
    /**
     * Lozinka za nalog korisnika
     */
    private String lozinka;
    
    /**
     * Neparametrizovani konstruktor. Inicijalizuje recepcionera.
     */
    public Recepcioner() {
    }

    /**
     * Parametrizovani konstruktor. Inicijalizuje recepcionera i postavlja vrednosti pozivanjem set metoda.
     * 
     * @param recepcionerID identifikator recepcionera koji je potrebno uneti
     * @param imeRecepcionera ime recepcionera koje je potrebno uneti
     * @param prezimeRecepcionera prezime recepcionera koje je potrebno uneti
     * @param korisnickoIme korisnicko ime recepcionera koje je potrebno uneti
     * @param lozinka lozinka recepcionera koju je potrebno uneti
     */
    public Recepcioner(Long recepcionerID, String imeRecepcionera, String prezimeRecepcionera, String korisnickoIme, String lozinka) {
        this.recepcionerID = recepcionerID;
        this.imeRecepcionera = imeRecepcionera;
        this.prezimeRecepcionera = prezimeRecepcionera;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    /**
     * Parametrizovani konstruktor. Inicijalizuje recepcionera i postavlja identifikator  na unetu vrednost pozivanjem set metode.
     * 
     * @param recepcionerID Vrednost identifikatora gosta koju je potrebno postaviti
     */
    public Recepcioner(Long recepcionerID) {
        this.recepcionerID = recepcionerID;
    }
    
    /**
     * Metoda koja vraća identifikator recepcionera
     * 
     * @return recepcionerID kao Long
     */
	public Long getRecepcionerID() {
		return recepcionerID;
	}

	/**
     * Metoda postavlja novi identifikator recepcionera
     * 
     * @param recepcionerID nova vrednost za identifikator recepcionera
     */
	public void setRecepcionerID(Long recepcionerID) {
		this.recepcionerID = recepcionerID;
	}

	/**
     * Metoda vraća ime recepcionera
     * 
     * @return imeRecepcionera kao String
     */
	public String getImeRecepcionera() {
		return imeRecepcionera;
	}

	/**
     * Metoda postavlja novo ime recepcionera
     * 
     * @param imeRecepcionera nova vrednost za ime recepcionera
     */
	public void setImeRecepcionera(String imeRecepcionera) {
		this.imeRecepcionera = imeRecepcionera;
	}

	/**
     * Metoda vraća prezime recepcionera
     * 
     * @return prezimeRecepcionera kao String
     */
	public String getPrezimeRecepcionera() {
		return prezimeRecepcionera;
	}

	/**
     * Metoda postavlja novo prezime recepcionera
     * 
     * @param prezimeRecepcionera nova vrednost za prezime
     */
	public void setPrezimeRecepcionera(String prezimeRecepcionera) {
		this.prezimeRecepcionera = prezimeRecepcionera;
	}

	/**
     * Metoda vraća korisničko ime recepcionera
     * 
     * @return korisnickoIme kao String
     */
	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	/**
     * Metoda postavlja novo korisničko ime korisnika
     * 
     * @param korisnickoIme nova vrednost za korisničko ime recepcionera
     */
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	/**
     * Metoda vraca lozinku korisničkog naloga recepcionera
     * 
     * @return lozinka kao String
     */
	public String getLozinka() {
		return lozinka;
	}

	/**
     * Metoda postavlja novu lozinku za korisnički nalog recepcionera
     * 
     * @param lozinka nova vrednost lozinke korisničkog naloga recepcionera
     */
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	/**
     * Metoda vraća String koji sadrži ime i prezime recepcionera
     * 
     * @return String koji sadrži ime i prezime recepcionera
     */
	@Override
	public String toString() {
		return imeRecepcionera+" "+prezimeRecepcionera;
	}
	  
	/**
	 * Metoda vraća naziv tabele u bazi u kojoj se nalaze podaci o recepcioneru
	 * 
	 * @return String koji predstavlja naziv tabele.
	 */
	@Override
	public String getImeTabele() {
		return "recepcioner";
	}

	/**
	 * Metoda vraća vrednosti atributa objekta klase Recepcioner
	 * 
	 * @return String koji predstavlja vrednosti atributa.
	 */
	@Override
	public String getParametre() {
        return String.format("%s,'%s','%s','%s','%s'",recepcionerID,imeRecepcionera,prezimeRecepcionera,korisnickoIme,lozinka);
	}

	/**
	 * Metoda vraca imena atributa objekta klase Recepcioner nad kojim se poziva metoda
	 * 
	 * @return String koji predstavlja imena atributa, odvojeni su zapetom.
	 */
	@Override
	public String getImenaParametara() {
        return "recepcionerID,imeRecepcionera,prezimeRecepcionera,korisnickoIme,password";
	}

	/**
   	 * Metoda vraća ime primarnog ključa tabele u bazi u kojoj se nalaze podaci o recepcioneru
   	 * 
   	 * @return String koji predstavlja ime primarnog ključa.
   	 */
	@Override
	public String getImePrimarnogKljuca() {
		return "recepcionerID";
	}

	/**
	 * Metoda vraća vrednost primarnog ključa tabele u bazi u kojoj se nalaze podaci o recepcioneru
	 * 
	 * @return recepcionerID kao Long koji predstavlja vrednost primarnog ključa.
	 */
	@Override
	public Long getVrednostPrimarnogKljuca() {
		return recepcionerID;
	}

	/**
	 * Metoda konvertuje prosledjeni ResultSet u listu objekata klase Recepcioner 
	 * 
	 * @param rs ResultSet koji je potrebno konvertovati u listu recepcionera
	 * 
	 * @return Lista domenskih objekata koji su procitani iz baze
	 */
	@Override
	public List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs) {
		List<OpstiDomenskiObjekat> receptionists = new ArrayList<>();
        try {
            while (rs.next()) {                
                Long id = rs.getLong("recepcionerID");
                String name = rs.getString("imeRecepcionera");
                String lastname = rs.getString("prezimeRecepcionera");
                String username = rs.getString("username");
                String pass = rs.getString("password");
                
                Recepcioner r = new Recepcioner(id, name, lastname, username, pass);
                receptionists.add(r);
            }
        } catch (Exception e) {
            System.out.println("Greska u Recepcioner.Class ResultSet"); 
                 
        }
        
        return receptionists;
	}
	
	public OpstiDomenskiObjekat convertRS(ResultSet rs) {
        Recepcioner r=null;
        try {
            while (rs.next()) {                
                Long id = rs.getLong("recepcionerID");
                String name = rs.getString("imeRecepcionera");
                String lastname = rs.getString("prezimeRecepcionera");
                String username = rs.getString("korisnickoIme");
                String pass = rs.getString("password");
                
                r = new Recepcioner(id, name, lastname, username, pass);
                
            }
        } catch (Exception e) {
            System.out.println("Greska u Recepcioner.Class ResultSet"); 
                 
        }
        
        return r;
    }

	/**
	 * Metoda vraća nazive atributa recepcionera i njihovih novih vrednosti koje ce biti ažurirane
	 * 
	 * @return String koji predstavlja kombinaciju parametara i njihovih novih vrednosti koje je potrebno ažurirati u bazi.
	 */
	@Override
	public String getUpitAzuriranje() {
        return "recepcionerID = "+recepcionerID+", imeRecepcionera = '"+imeRecepcionera+"', prezimeRecepcionera = '"+prezimeRecepcionera+"', korisnickoIme = '"+korisnickoIme+"', password = '"+lozinka+"'";

	}

	/**
	 * Metoda vraća uslov složenog primarnog ključa tabele koja predstavlja recepcionera
	 * 
	 * @return String koji predstavlja ime i vrednost složenog primarnog ključa ili null ako primarni kljuc nije složen.
	 */
	@Override
	public String getSlozeniPrimarniKljuc() {
		return null;
	}

	
}
