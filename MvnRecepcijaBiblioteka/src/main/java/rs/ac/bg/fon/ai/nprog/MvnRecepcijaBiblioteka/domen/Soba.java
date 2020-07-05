package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.VrstaSobe;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

/**
 * Klasa predstavlja sobu sa svim svojim svojstvima. Implementira interfejse OpstiDomenskiObjekat i Serializable
 *
 * @author Jelena Sreckovic
 */

public class Soba implements OpstiDomenskiObjekat, Serializable{
	/**
	 * Identifikator sobe
	 */
	private Long sobaID;
	
	/**
	 * Status sobe
	 */
    private boolean status;
    
    /**
     * Vrsta sobe koja odgovara sobi
     */
    private VrstaSobe vrstaSobe;

    /**
     * Neparametrizovani konstruktor. Inicijalizuje sobu.
     */
    public Soba() {
    	
    }
    
    /**
     * Parametrizovani konstruktor. Inicijalizuje sobu i postavlja vrednosti pozivanjem set metoda.
     * 
     * @param sobaID identifikator sobe koji je potrebno postaviti
     * @param status status sobe koji j epotrebno postaviti
     * @param vrstaSobe vrsta sobe koju je potrebno postaviti
     */
    public Soba(Long sobaID, boolean status, VrstaSobe vrstaSobe) {
        this.sobaID = sobaID;
        this.status = status;
        this.vrstaSobe = vrstaSobe;
    }
    
    /**
     * Parametrizovani konstruktor. Inicijalizuje sobu i postavlja identifikator  na unetu vrednost pozivanjem set metode.
     * 
     * @param sobaID identifikator sobe koji je potrebno postaviti
     */
    public Soba(Long sobaID) {
        this.sobaID = sobaID;
    }
	
    /**
     * Metoda vraća identifikator sobe
     * 
     * @return sobaID kao Long
     */
	public Long getSobaID() {
		return sobaID;
	}

	/**
     * Metoda postavlja identifikator sobe
     * 
     * @param sobaID nova vrednost identifikatora sobe koju je potrebno postaviti
     */
	public void setSobaID(Long sobaID) {
		this.sobaID = sobaID;
	}

	/**
     * Metoda vraća status sobe
     * 
     * @return status kao boolean
     */
	public boolean isStatus() {
		return status;
	}

	/**
     * Metoda postavlja status sobe
     * 
     * @param status nova vrednost statusa koju je potrebno postaviti
     */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
     * Metoda vraća vrstu sobe
     * 
     * @return vrstaSobe kao objekat klase VrstaSobe
     */
	public VrstaSobe getVrstaSobe() {
		return vrstaSobe;
	}

	/**
     * Metoda postavlja vrstu sobe 
     * 
     * @param vrstaSobe nova vrsta sobe koju je potrebno postaviti
     */
	public void setVrstaSobe(VrstaSobe vrstaSobe) {
		this.vrstaSobe = vrstaSobe;
	}
	
	/**
	 * Proverava da li su dve sobe iste i vraca
	 * true ako jesu, a false ako nisu.
	 * 
	 * @return true ako je unet objekat klase Soba
	 * sa istim identifikatorom, inace false.
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Soba other = (Soba) obj;
		if (sobaID == null) {
			if (other.sobaID != null)
				return false;
		} else if (!sobaID.equals(other.sobaID))
			return false;
		return true;
	}

	/**
   	 * Metoda vraća naziv tabele u bazi u kojoj se nalaze podaci o sobi.
   	 * 
   	 * @return String koji predstavlja naziv tabele.
   	 */
	@Override
	public String getImeTabele() {
		return "soba";
	}

	/**
	 * Metoda vraća vrednosti atributa objekta klase Soba
	 * 
	 * @return String koji predstavlja vrednosti atributa.
	 */
	@Override
	public String getParametre() {
        return String.format("%s, '%s', %s", sobaID,status,vrstaSobe.getVrstaSobeID());
	}

	/**
	 * Metoda vraća imena atributa objekta klase Soba nad kojim se poziva metoda
	 * 
	 * @return String koji predstavlja imena atributa, odvojeni su zapetom.
	 */
	@Override
	public String getImenaParametara() {
        return "sobaID,status,vrstaSobeID";
	}

	/**
   	 * Metoda vraća ime primarnog ključa tabele u bazi u kojoj se nalaze podaci o sobi
   	 * 
   	 * @return String koji predstavlja ime primarnog ključa.
   	 */
	@Override
	public String getImePrimarnogKljuca() {
		return "sobaID";
	}

	/**
	 * Metoda vraća vrednost primarnog ključa tabele u bazi u kojoj se nalaze podaci o sobi
	 * 
	 * @return sobaID kao Long koji predstavlja vrednost primarnog ključa.
	 */
	@Override
	public Long getVrednostPrimarnogKljuca() {
		return sobaID;
	}

	/**
	 * Metoda konvertuje ResultSet u listu objekata klase Soba 
	 * 
	 * @param rs ResultSet koji je potrebno konvertovati u listu soba
	 * 
	 * @return Lista domenskih objekata koji su procitani iz baze
	 */
	@Override
	public List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs) {
		List<OpstiDomenskiObjekat> rooms = new ArrayList<>();
        try {
            while (rs.next()) {                
                Long id = rs.getLong("sobaID");
                boolean s = rs.getBoolean("status");
                Long roomTypeID = rs.getLong("vrstaSobeID");
                
                Soba r = new Soba(id, s, new VrstaSobe(roomTypeID));
                rooms.add(r);
            }
        } catch (Exception e) {
            System.out.println("Greska u Soba.Class ResultSet"); 
                 
        }
        
        return rooms;   
	}

	/**
	 * Metoda vraca nazive atributa sobe i njihovih novih vrednosti koje ce biti ažurirane
	 * 
	 * @return String koji predstavlja kombinaciju parametara i njihovih novih vrednosti koje je potrebno ažurirati u bazi.
	 */
	@Override
	public String getUpitAzuriranje() {
        return "sobaID = "+sobaID+", status = "+status+", vrstaSobeID = "+vrstaSobe.getVrstaSobeID();
	}

	/**
	 * Metoda vraća uslov složenog primarnog ključa tabele u bazi koja predstavlja sobu.
	 * 
	 * @return null koji predstavlja ime i vrednost složenog primarnog ključa, jer primarni ključ nije složen.
	 */
	@Override
	public String getSlozeniPrimarniKljuc() {
		return null;
	}

	
	
}
