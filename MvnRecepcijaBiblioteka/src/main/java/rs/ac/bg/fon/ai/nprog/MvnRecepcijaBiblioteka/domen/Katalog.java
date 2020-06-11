package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.StavkaKataloga;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

/**
 * Klasa predstavlja katalog sa svim svojim svojstvima. Implementira interfejse OpstiDomenskiObjekat i Serializable
 *
 * @author Jelena Sreckovic
 */

public class Katalog implements OpstiDomenskiObjekat, Serializable{
	
	/**
	 * Identifikator kataloga
	 */
	private Long katalogID;
	
	/**
	 * Naziv kataloga
	 */
    private String nazivKataloga;
    
    /**
	 * Lista stavki kataloga
	 */
    private List<StavkaKataloga> listaStavki;

    /**
     * Neparametrizovani kontruktor. Inicijalizuje katalog i listu stavki.
     */
    public Katalog() {
        listaStavki = new ArrayList<>();
    }

    /**
     * Parametrizovani kontruktor. Inicijalizuje katalog i postavlja prosledjene vrednosti pozivanjem set metoda.
     * 
     * @param katalogID Vrednost identifikatora kataloga koju je potrebno postaviti
     * @param nazivKataloga Naziv kataloga koji je potrebno postaviti
     */
    public Katalog(Long katalogID, String nazivKataloga) {
        this.katalogID = katalogID;
        this.nazivKataloga = nazivKataloga;
    }

    /**
     * Parametrizovani kontruktor. Inicijalizuje katalog i postavlja identifikator na prosledjenu vrednost pozivanjem set metode.
     * 
     * @param katalogID Vrednost identifikatora kataloga koju je potrebno postaviti
     */
    public Katalog(Long katalogID) {
        this.katalogID = katalogID;
    }
	
    /**
     * Metoda vraća vrednost identifikatora kataloga
     * 
     * @return katalogID kao Long
     */
	public Long getKatalogID() {
		return katalogID;
	}

	/**
     * Metoda postavlja novu vrednost za atribut identifikator kataloga
     * 
     * @param katalogID Identifikator kataloga koji je potrebno postaviti
     */
	public void setKatalogID(Long katalogID) {
		this.katalogID = katalogID;
	}

	/**
     * Metoda vraća naziv kataloga
     * 
     * @return nazivKataloga kao String
     */
	public String getNazivKataloga() {
		return nazivKataloga;
	}

	/**
     * Metoda postavlja novu vrednost za atribut naziv kataloga
     * 
     * @param nazivKataloga Naziv kataloga koje je potrebno postaviti
     */
	public void setNazivKataloga(String nazivKataloga) {
		this.nazivKataloga = nazivKataloga;
	}

	/**
     * Metoda vraća listu stavki kataloga
     * 
     * @return listaStavki kao List<StavkaKataloga>
     */
	public List<StavkaKataloga> getListaStavki() {
		return listaStavki;
	}

	/**
	  * Metoda postavlja novu vrednost za atribut listaStavki
	  * 
	  * @param listaStavki Lista stavki koju je potrebno postaviti
	  */
	public void setListaStavki(List<StavkaKataloga> listaStavki) {
		this.listaStavki = listaStavki;
	}

	/**
	 * Metoda vraća naziv tabele u bazi u kojoj se nalaze podaci o katalogu
	 * 
	 * @return String koji predstavlja naziv tabele.
	 */
	@Override
	public String getImeTabele() {
		return "katalog";
	}

	/**
	 * Metoda vraća vrednosti atributa objekta klase Katalog koji bi trebalo sačuvati u bazi
	 * 
	 * @return String koji predstavlja vrednosti atributa.
	 */
	@Override
	public String getParametre() {
		return String.format("%s, '%s'", katalogID,nazivKataloga);
	}

	/**
	 * Metoda vraća imena atributa objekta klase Katalog nad kojim se poziva metoda
	 * 
	 * @return String koji predstavlja imena atributa odvojeni zapetom.
	 */
	@Override
	public String getImenaParametara() {
		return "katalogID,nazivKataloga";
	}

	/**
   	 * Metoda vraća ime primarnog ključa tabele u bazi koja predstavlja objekat klase Katalog
   	 * 
   	 * @return String koji predstavlja ime primarnog ključa.
   	 */
	@Override
	public String getImePrimarnogKljuca() {
		return "katalogID";
	}

	/**
	 * Metoda vraca vrednost primarnog kljuca tabele koja predstavlja objekat klase Katalog
	 * 
	 * @return katalogID kao Long koji predstavlja vrednost primarnog kljuca.
	 */
	@Override
	public Long getVrednostPrimarnogKljuca() {
		return katalogID;
	}

	/**
	 * Metoda konvertuje prosledjeni ResultSet u listu objekata klase Katalog 
	 * 
	 * @param rs ResultSet koji je potrebno konvertovati u listu kataloga
	 * 
	 * @return Lista domenskih objekata koji su procitani iz baze
	 */
	@Override
	public List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs) {
		List<OpstiDomenskiObjekat> katalogs = new ArrayList<>();
        try {
            while (rs.next()) {                
                Long id = rs.getLong("katalogID");
                String name = rs.getString("nazivKataloga");
                
                Katalog k = new Katalog(id, name);
                katalogs.add(k);
            }
        } catch (Exception e) {
            System.out.println("Greska u Katalog.Class ResultSet");   
        }
        
        return katalogs;
	}

	/**
	 * Metoda vraća nazive parametara Kataloga i njihovih novih vrednosti koje ce biti ažurirane
	 * 
	 * @return String koji predstavlja kombinaciju parametara i njihovih novih vrednosti koje je potrebno ažurirati u bazi.
	 */
	@Override
	public String getUpitAzuriranje() {
        return "katalogID = "+katalogID+", nazivKataloga = '"+nazivKataloga+"'";
	}

	 /**
	  * Metoda vraća uslov složenog primarnog ključa tabele koja predstavlja objekat klase Katalog
	  * 
	  * @return String koji predstavlja ime i vrednost složenog primarnog ključa ili null ako primarni kljuc nije slozen.
	  */
	@Override
	public String getSlozeniPrimarniKljuc() {
		return null;
	}

	
}
