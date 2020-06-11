package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.Katalog;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.UslugaNajma;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

/**
 * Klasa predstavlja stavku kataloga sa svim svojim svojstvima. Implementira interfejse OpstiDomenskiObjekat i Serializable
 *
 * @Jelena Sreckovic
 */

public class StavkaKataloga implements OpstiDomenskiObjekat, Serializable{
	/**
     * Katalog u kom se stavka kanalazi
     */
	private Katalog katalog;
	
	/**
	 * Identifikator stavke kataloga
	 */
    private Long stavkaKatalogaID;
    
    /**
     * Naziv stavke kataloga
     */
    private String nazivStavkeKataloga;
    
    /**
     * Usluga najma koju predstavlja stavka kataloga
     */
    private UslugaNajma uslugaNajma;

    /**
     * Neparametrizovani konstruktor. Inicijalizuje stavku kataloga
     */
    public StavkaKataloga() {
    	
    }

    /**
     * Parametrizovani konstruktor. Inicijalizuje stavku kataloga i postavlja vrednosti atributa pozivanjem set metoda.
     * 
     * @param katalog katalog koji je potrebno postaviti
     * @param stavkaKatalogaID identifikator stavke kataoga koji je potrebno postaviti
     * @param nazivStavkeKataloga naziv stavke kataloga koji je potrebno postaviti
     */
    public StavkaKataloga(Katalog katalog, Long stavkaKatalogaID, String nazivStavkeKataloga) {
        this.katalog = katalog;
        this.stavkaKatalogaID = stavkaKatalogaID;
        this.nazivStavkeKataloga = nazivStavkeKataloga;
    }

    /**
     * Parametrizovani konstruktor. Inicijalizuje stavku kataloga i postavlja vrednost identifikatora na unetu vrednost pozivanjem set metode.
     * 
     * @param stavkaKatalogaID identifikator koji je potrebno postaviti
     */
    public StavkaKataloga(Long stavkaKatalogaID) {
        this.stavkaKatalogaID = stavkaKatalogaID;
    }
	
    /**
     * Metoda vraća katalog u kome se stavka nalazi
     * 
     * @return katalog kao Katalog
     */
	public Katalog getKatalog() {
		return katalog;
	}

	/**
	 * Metoda postavlja novu vrednost kataloga u kome se nalazi stavka 
	 * 
	 * @param katalog Katalog koji je potrebno postaviti
	 */
	public void setKatalog(Katalog katalog) {
		this.katalog = katalog;
	}

	/**
     * Metoda vraća identifikator stavke kataloga
     * 
     * @return stavkaKatalogaID kao Long
     */
	public Long getStavkaKatalogaID() {
		return stavkaKatalogaID;
	}

	/**
	 * Metoda postavlja novu vrednost identifikatora stavke kataloga
	 * 
	 * @param stavkaKatalogaID identifikator stavke kataloga koji je potrebno postaviti
	 */
	public void setStavkaKatalogaID(Long stavkaKatalogaID) {
		this.stavkaKatalogaID = stavkaKatalogaID;
	}

	/**
     * Metoda vraća naziv stavke kataloga
     * 
     * @return nazivStavkeKataloga kao String
     */
	public String getNazivStavkeKataloga() {
		return nazivStavkeKataloga;
	}

	/**
	 * Metoda postavlja novu vrednost naziva stavke kataloga
	 * 
	 * @param nazivStavkeKataloga naziv stavke kataloga koji je potrebno postaviti
	 */
	public void setNazivStavkeKataloga(String nazivStavkeKataloga) {
		this.nazivStavkeKataloga = nazivStavkeKataloga;
	}

	/**
     * Metoda vraća uslugu najma koju stavka kataloga predstavlja
     * 
     * @return uslugaNajma kao UslugaNajma
     */
	public UslugaNajma getUslugaNajma() {
		return uslugaNajma;
	}

	/**
	 * Metoda postavlja novu vrednost usluge najma koju stavka kataloga predstavlja
	 * 
	 * @param uslugaNajma usluga najma koji je potrebno postaviti
	 */
	public void setUslugaNajma(UslugaNajma uslugaNajma) {
		this.uslugaNajma = uslugaNajma;
	}

	/**
   	 * Metoda vraća naziv tabele u bazi u kojoj se nalaze podaci o stavci kataloga
   	 * 
   	 * @return String koji predstavlja naziv tabele.
   	 */
	@Override
	public String getImeTabele() {
		return "stavkaKataloga";
	}

	/**
	 * Metoda vraća vrednosti atributa objekta klase StavkaKataloga
	 * 
	 * @return String koji predstavlja vrednosti atributa.
	 */
	@Override
	public String getParametre() {
        return String.format("%s, %s, '%s'", katalog.getKatalogID(),stavkaKatalogaID,nazivStavkeKataloga);
	}

	/**
	 * Metoda vraća imena atributa objekta klase StavkaKataloga nad kojim se poziva metoda
	 * 
	 * @return String koji predstavlja imena atributa, odvojeni su zapetom.
	 */
	@Override
	public String getImenaParametara() {
		return "katalogID,stavkaKatalogaID,nazivStavkeKataloga";
	}

	/**
   	 * Metoda vraća ime primarnog ključa tabele u bazi u kojoj se nalaze podaci o stavci kataloga
   	 * 
   	 * @return null koji predstavlja ime primarnog kljuca, jer je primarni ključ složen. 
   	 */
	@Override
	public String getImePrimarnogKljuca() {
		return null;
	}

	/**
	 * Metoda vraća vrednost primarnog ključa tabele u bazi u kojoj se nalaze podaci o stavci kataloga
	 * 
	 * @return null koji predstavlja vrednost primarnog kljuca, jer je primarni ključ složen.
	 */
	@Override
	public Long getVrednostPrimarnogKljuca() {
		return null;
	}

	/**
	 * Metoda konvertuje prosledjeni ResultSet u listu objekata klase StavkaKataloga 
	 * 
	 * @param rs ResultSet koji je potrebno konvertovati u listu stavki kataloga
	 * 
	 * @return Lista domenskih objekata koji su pročitani iz baze
	 */
	@Override
	public List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs) {
		List<OpstiDomenskiObjekat> stavke = new ArrayList<>();
        try {
            while (rs.next()) {                
                Long kID = rs.getLong("katalogID");
                Long sID = rs.getLong("stavkaKatalogaID");
                String name = rs.getString("nazivStavkeKataloga");
                
                StavkaKataloga s = new StavkaKataloga(new Katalog(kID), sID, name);
                stavke.add(s);
            }
        } catch (Exception e) {
            System.out.println("Greska u StavkaKataloga.Class ResultSet"); 
                 
        }
        
        return stavke;
	}

	/**
	 * Metoda vraća nazive atributa stavke kataloga i njihovih novih vrednosti koje ce biti ažurirane
	 * 
	 * @return String koji predstavlja kombinaciju parametara i njihovih novih vrednosti koje je potrebno ažurirati u bazi.
	 */
	@Override
	public String getUpitAzuriranje() {
        return "katalogID = "+katalog.getKatalogID()+", stavkaKatalogaID = "+stavkaKatalogaID+", nazivStavkeKataloga = '"+nazivStavkeKataloga+"'";
	}

	/**
	 * Metoda vraća uslov složenog primarnog ključa tabele u bazi koja predstavlja stavku kataloga
	 * 
	 * @return String koji predstavlja ime i vrednost složenog primarnog ključa 
	 */
	@Override
	public String getSlozeniPrimarniKljuc() {
        return "WHERE katalogID="+katalog.getKatalogID()+" AND stavkaKataloga="+stavkaKatalogaID;
	}

	
}
