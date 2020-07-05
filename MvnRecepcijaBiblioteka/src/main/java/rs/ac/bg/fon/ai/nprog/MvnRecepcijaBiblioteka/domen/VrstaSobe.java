package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.UslugaNajma;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

/**
 * Klasa predstavlja vrstu sobe sa svim svojim svojstvima. Implementira interfejse OpstiDomenskiObjekat i Serializable
 *
 * @Jelena Sreckovic
 */

public class VrstaSobe implements OpstiDomenskiObjekat, Serializable{
	/**
	 * Identifikator vrste sobe
	 */
	private Long vrstaSobeID;
	
	/**
	 * Naziv vrste sobe
	 */
    private String nazivVrsteSobe;
    
    /**
     * Broj kreveta koji odgovara vrsti sobe
     */
    private int brojKreveta;
    
    /**
     * Opis vrste sobe
     */
    private String opis; 
    
    /**
     * Lista usluga koje su vezane za vrstu sobe
     */
    private List<UslugaNajma> usluge; 

    /**
     * Neparametrizovani konstruktor. Inicijalizuje vrstu sobe i listu usluga.
     */
    public VrstaSobe() {
    	usluge=new ArrayList<>();
    }

    /**
     * Parametrizovani konstruktor. Inicijalizuje vrstu sobe i postavlja vrednosti atributa pozivanjem set metoda.
     * 
     * @param vrstaSobeID identifikator vrste sobe koje je potrebno postaviti
     * @param nazivVrsteSobe naziv vrste sobe koji je potrebno postaviti
     * @param brojKreveta broj kreveta koji je potrebno postaviti
     * @param opis opis vrste sobe koji je potrebno postaviti
     */
    public VrstaSobe( Long vrstaSobeID, String nazivVrsteSobe, int brojKreveta, String opis) {
        this.vrstaSobeID = vrstaSobeID;
        this.nazivVrsteSobe = nazivVrsteSobe;
        this.brojKreveta = brojKreveta;
        this.opis = opis;
    }

    /**
     * Parametrizovani konstruktor. Inicijalizuje vrstu sobe i postavlja vrednost identifikatora na unetu vrednost pozivanjem set metode.
     * 
     * @param vrstaSobeID identifikator koji je potrebno postaviti
     */
    public VrstaSobe(Long vrstaSobeID) {
        this.vrstaSobeID = vrstaSobeID;
    }
	
    /**
     * Metoda vraća identifikator vrste sobe
     * 
     * @return vrstaSobeID
     */
	public Long getVrstaSobeID() {
		return vrstaSobeID;
	}

	/**
	 * Metoda postavlja novu vrednost identifikatora vrste sobe
	 * 
	 * @param vrstaSobeID identifikator vrste sobe koji je potrebno postaviti
	 */
	public void setVrstaSobeID(Long vrstaSobeID) {
		this.vrstaSobeID = vrstaSobeID;
	}

	/**
	 * Metoda vraća naziv vrste sobe
	 * 
	 * @return nazivVrsteSobe kao String
	 */
	public String getNazivVrsteSobe() {
		return nazivVrsteSobe;
	}

	/**
	 * Metoda postavlja novu vrednost naziva vrste sobe
	 * 
	 * @param nazivVrsteSobe naziv vrste sobe koji je potrebno postaviti
	 */
	public void setNazivVrsteSobe(String nazivVrsteSobe) {
		this.nazivVrsteSobe = nazivVrsteSobe;
	}

	/**
	 * Metoda vraća broj kreveta koji odgovara vrsti sobe
	 * 
	 * @return brojKreveta kao int
	 */
	public int getBrojKreveta() {
		return brojKreveta;
	}

	/**
	 * Metoda postavlja novu vrednost broja kreveta koji odgovara vrsti sobe
	 * 
	 * @param brojKreveta broj kreveta koji je potrebno postaviti
	 */
	public void setBrojKreveta(int brojKreveta) {
		this.brojKreveta = brojKreveta;
	}

	/**
	 * Metoda vraća opis koji odgovara vrsti sobe
	 * 
	 * @return opis kao String
	 */
	public String getOpis() {
		return opis;
	}

	/**
	 * Metoda postavlja novu vrednost opisa koji odgovara vrsti sobe
	 * 
	 * @param opis Opis koji je potrebno postaviti
	 */
	public void setOpis(String opis) {
		this.opis = opis;
	}

	/**
	 * Metoda vraća listu usluga koje odgovara vrsti sobe
	 * 
	 * @return usluge kao List<UslugaNajma>
	 */
	public List<UslugaNajma> getUsluge() {
		return usluge;
	}

	/**
	 * Metoda postavlja novu vrednost usluga koje odgovaraju vrsti sobe
	 * 
	 * @param usluge usluge koje je potrebno postaviti
	 */
	public void setUsluge(List<UslugaNajma> usluge) {
		this.usluge = usluge;
	}
	
	/**
	 * Metoda vraća String koji sadrži naziv vrste sobe
     * 
     * @return String koji sadrži naziv vrste sobe
	 */
	@Override
    public String toString() {
        return nazivVrsteSobe;
    }

	/**
	 * Proverava da li su dve vrste sobe iste i vraca
	 * true ako jesu, a false ako nisu.
	 * 
	 * @return true ako je unet objekat klase VrstaSobe
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
		VrstaSobe other = (VrstaSobe) obj;
		if (vrstaSobeID == null) {
			if (other.vrstaSobeID != null)
				return false;
		} else if (!vrstaSobeID.equals(other.vrstaSobeID))
			return false;
		return true;
	}

	/**
   	 * Metoda vraća naziv tabele u bazi u kojoj se nalaze podaci o vrsti sobe
   	 * 
   	 * @return String koji predstavlja naziv tabele.
   	 */
	@Override
	public String getImeTabele() {
		return "vrstaSobe";
	}

	/**
	 * Metoda vraća vrednosti atributa objekta klase VrstaSobe
	 * 
	 * @return String koji predstavlja vrednosti atributa.
	 */
	@Override
	public String getParametre() {
        return String.format("%s, '%s', %s, '%s'",vrstaSobeID,nazivVrsteSobe,brojKreveta,opis);
	}

	/**
	 * Metoda vraća imena atributa objekta klase VrstaSobe nad kojim se poziva metoda
	 * 
	 * @return String koji predstavlja imena atributa, odvojeni su zapetom.
	 */
	@Override
	public String getImenaParametara() {
        return "vrstaSobeID,nazivVrsteSobe,brojKreveta,opis"; 
	}

	/**
   	 * Metoda vraća ime primarnog kljuca tabele u bazi u kojoj se nalaze podaci o vrsti sobe
   	 * 
   	 * @return String koji predstavlja ime primarnog ključa.
   	 */
	@Override
	public String getImePrimarnogKljuca() {
		return "vrstaSobeID";
	}

	/**
	 * Metoda vraća vrednost primarnog ključa tabele u bazi u kojoj se nalaze podaci o vrsti sobe
	 * 
	 * @return vrstaSobeID kao long 
	 */
	@Override
	public Long getVrednostPrimarnogKljuca() {
		return vrstaSobeID;
	}

	/**
	 * Metoda konvertuje prosledjeni ResultSet u listu objekata klase VrstaSobe 
	 * 
	 * @param rs ResultSet koji je potrebno konvertovati u listu vrsta 
	 * 
	 * @return Lista domenskih objekata koji su procitani iz baze
	 */
	@Override
	public List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs) {
		List<OpstiDomenskiObjekat> vrste = new ArrayList<>();
        try {
            while (rs.next()) {                
                Long vrstaID = rs.getLong("vrstaSobeID");
                String naziv = rs.getString("nazivVrsteSobe");
                int broj = rs.getInt("brojKreveta");
                String opiss = rs.getString("opis");
                
                VrstaSobe vs = new VrstaSobe(vrstaID, naziv, broj, opiss); 
                vrste.add(vs);
                
                
            }
        } catch (Exception e) {
            System.out.println("Greska u VrstaSobe.Class ResultSet"); 
                 
        }
        
        return vrste;
	}

	/**
	 * Metoda vraća nazive atributa vrste sobe i njihovih novih vrednosti koje će biti ažurirane
	 * 
	 * @return String koji predstavlja kombinaciju parametara i njihovih novih vrednosti koje je potrebno ažurirati u bazi.
	 */
	@Override
	public String getUpitAzuriranje() {
        return "vrstaSobeID = "+vrstaSobeID+", nazivVrsteSobe = '"+nazivVrsteSobe+"', brojKreveta = "+brojKreveta+", opis = '"+opis+"'"; 
	}

	/**
	 * Metoda vraća uslov složenog primarnog ključa tabele u bazi koja predstavlja vrstu sobe
	 * 
	 * @return null koji predstavlja ime i vrednost slozenog primarnog kljuca, jer primarni ključ nije složen.
	 */
	@Override
	public String getSlozeniPrimarniKljuc() {
		return null;
	}

	
}
