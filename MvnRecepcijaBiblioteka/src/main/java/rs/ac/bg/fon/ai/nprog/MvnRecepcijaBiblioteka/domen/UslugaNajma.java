package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.StavkaKataloga;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.VrstaSobe;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

/**
 * Klasa predstavlja stavku kataloga sa svim svojim svojstvima. Implementira interfejse OpstiDomenskiObjekat i Serializable
 *
 * @Jelena Sreckovic
 */

public class UslugaNajma implements OpstiDomenskiObjekat, Serializable{

	/**
	 * Stavka kataloga koja predstavlja uslugu najma
	 */
	private StavkaKataloga stavkaKataloga;
	
	/**
	 * Identifikator usluge najma
	 */
    private Long uslugaNajmaID;
    
    /**
     * Naziv usluge najma
     */
    private String nazivUslugeNajma;
    
    /**
     * Cena usluge najma
     */
    private double cenaUsluge; 
    
    /**
     * Vrsta sobe za koju je vezana usluga najma
     */
    private VrstaSobe vrstaSobe; 

    /**
     * Neparametrizovani konstruktor. Inicijalizuje stavku kataloga
     */
    public UslugaNajma() {
    }

    /**
     * Parametrizovani konstruktor. Inicijalizuje uslugu najma i postavlja vrednosti atributa pozivanjem set metoda.
     * 
     * @param stavkaKataloga stavka kataloga koju je potrebno postaviti
     * @param uslugaNajmaID identifikator usluge koji je potrebno postaviti
     * @param nazivUslugeNajma naziv usluge koji je potrebno postaviti
     * @param cenaUsluge cena usluge koju je potrebno postaviti
     * @param vrstaSobe vrsta sobe koju je potrebno postaviti
     */
    public UslugaNajma(StavkaKataloga stavkaKataloga, Long uslugaNajmaID, String nazivUslugeNajma, double cenaUsluge, VrstaSobe vrstaSobe) {
        this.stavkaKataloga = stavkaKataloga;
        this.uslugaNajmaID = uslugaNajmaID;
        this.nazivUslugeNajma = nazivUslugeNajma;
        this.cenaUsluge = cenaUsluge;
        this.vrstaSobe=vrstaSobe;
    }

    /**
     * Parametrizovani konstruktor. Inicijalizuje uslugu najma i postavlja vrednost atributa na unete vrednosti pozivanjem set metoda.
     * 
     * @param stavkaKataloga stavka kataloga koju je potrebno postaviti
     * @param uslugaNajmaID identifikator koji je potrebno postaviti
     */
    public UslugaNajma(StavkaKataloga stavkaKataloga, Long uslugaNajmaID) {
        this.stavkaKataloga = stavkaKataloga;
        this.uslugaNajmaID = uslugaNajmaID;
    }
    
    /**
     * Parametrizovani konstruktor. Inicijalizuje uslugu najma i postavlja vrednost identifikatora na unetu vrednost pozivanjem set metode.
     * 
     * @param uslugaNajmaID identifikator koji je potrebno postaviti
     */
    public UslugaNajma(Long uslugaNajmaID) {
        this.uslugaNajmaID=uslugaNajmaID;
    }
	
    /**
     * Metoda vraća stavku kataloga koja predstavlja uslugu najma
     * 
     * @return stavkaKataloga kao StavkaKataloga
     */
	public StavkaKataloga getStavkaKataloga() {
		return stavkaKataloga;
	}

	/**
	 * Metoda postavlja novu vrednost stavke kataloga koja predstavlja uslugu najma 
	 * 
	 * @param stavkaKataloga Stavka kataloga koju je potrebno postaviti
	 */
	public void setStavkaKataloga(StavkaKataloga stavkaKataloga) {
		this.stavkaKataloga = stavkaKataloga;
	}

	/**
     * Metoda vraća identifikator usluge najma
     * 
     * @return uslugaNajmaID kao Long
     */
	public Long getUslugaNajmaID() {
		return uslugaNajmaID;
	}

	/**
	 * Metoda postavlja novu vrednost identifikatora usluge najma
	 * 
	 * @param uslugaNajmaID identifikator usluge najma koji je potrebno postaviti
	 */
	public void setUslugaNajmaID(Long uslugaNajmaID) {
		this.uslugaNajmaID = uslugaNajmaID;
	}

	/**
     * Metoda vraća naziv usluge najma
     * 
     * @return nazivUslugeNajma kao String
     */
	public String getNazivUslugeNajma() {
		return nazivUslugeNajma;
	}

	/**
	 * Metoda postavlja novu vrednost naziva usluge najma
	 * 
	 * @param nazivUslugeNajma naziv usluge najma koji je potrebno postaviti
	 */
	public void setNazivUslugeNajma(String nazivUslugeNajma) {
		this.nazivUslugeNajma = nazivUslugeNajma;
	}

	/**
     * Metoda vraća cenu usluge najma
     * 
     * @return cenaUsluge kao double
     */
	public double getCenaUsluge() {
		return cenaUsluge;
	}

	/**
	 * Metoda postavlja novu vrednost cene usluge najma
	 * 
	 * @param cenaUsluge cena usluge najma koju je potrebno postaviti
	 */
	public void setCenaUsluge(double cenaUsluge) {
		this.cenaUsluge = cenaUsluge;
	}

	/**
	 * Metoda vraća vrstu sobe za koju je usluga najma vezana
	 * 
	 * @return vrstaSobe kao VrstaSobe
	 */
	public VrstaSobe getVrstaSobe() {
		return vrstaSobe;
	}

	/**
	 * Metoda postavlja novu vrednost vrste sobe za koju je usluga najma vezana
	 * 
	 * @param vrstaSobe Vrsta sobe koju je potrebno postaviti
	 */
	public void setVrstaSobe(VrstaSobe vrstaSobe) {
		this.vrstaSobe = vrstaSobe;
	}
	
	/**
	 * Proverava da li su dve usluge iste i vraca
	 * true ako jesu, a false ako nisu.
	 * 
	 * @return true ako je unet objekat klase UslugaNajma
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
		UslugaNajma other = (UslugaNajma) obj;
		if (uslugaNajmaID == null) {
			if (other.uslugaNajmaID != null)
				return false;
		} else if (!uslugaNajmaID.equals(other.uslugaNajmaID))
			return false;
		return true;
	}

	/**
   	 * Metoda vraća naziv tabele u bazi u kojoj se nalaze podaci o usluzi najma
   	 * 
   	 * @return String koji predstavlja naziv tabele.
   	 */
	@Override
	public String getImeTabele() {
		return "uslugaNajma";
	}

	/**
	 * Metoda vraća vrednosti atributa objekta klase UslugaNajma
	 * 
	 * @return String koji predstavlja vrednosti atributa.
	 */
	@Override
	public String getParametre() {
        return String.format("%s, %s, '%s', %s, %s",stavkaKataloga.getStavkaKatalogaID(),uslugaNajmaID,nazivUslugeNajma,cenaUsluge,vrstaSobe.getVrstaSobeID()); //vidi format za jak-slab
	}

	/**
	 * Metoda vraća imena atributa objekta klase usluga najma nad kojim se poziva metoda
	 * 
	 * @return String koji predstavlja imena atributa, odvojeni su zapetom.
	 */
	@Override
	public String getImenaParametara() {
        return "stavkaKatalogaID,uslugaNajmaID,nazivUslugeNajma,cenaUsluge,vrstaSobeID";
	}

	/**
   	 * Metoda vraća ime primarnog kljuca tabele u bazi u kojoj se nalaze podaci o usluzi
   	 * 
   	 * @return null koji predstavlja ime primarnog ključa, jer je primarni kljuc slozen.
   	 */
	@Override
	public String getImePrimarnogKljuca() {
		return null;
	}

	/**
	 * Metoda vraca vrednost primarnog kljuca tabele u kojoj se nalaze podaci o usluzi najma
	 * 
	 * @return null koji predstavlja vrednost primarnog kljuca, jer je primarni ključ složen.
	 */
	@Override
	public Long getVrednostPrimarnogKljuca() {
		return null;
	}

	/**
	 * Metoda konvertuje prosledjeni ResultSet u listu objekata klase UslugaNajma 
	 * 
	 * @param rs ResultSet koji je potrebno konvertovati u listu usluga
	 * 
	 * @return Lista domenskih objekata koji su procitani iz baze
	 */
	@Override
	public List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs) {
		List<OpstiDomenskiObjekat> usluge = new ArrayList<>();
        try {
            while (rs.next()) {     
                Long stavkaID = rs.getLong("stavkaKatalogaID");
                Long uslugaID = rs.getLong("uslugaNajmaID");
                String name = rs.getString("nazivUslugeNajma");
                Double price = rs.getDouble("cenaUsluge");
                Long vrstaSobeID = rs.getLong("vrstaSobeID");
                
               UslugaNajma un = new UslugaNajma(new StavkaKataloga(stavkaID),uslugaID, name, price, new VrstaSobe(vrstaSobeID));
               usluge.add(un);
            }
        } catch (Exception e) {
            System.out.println("Greska u UslugaNajma.Class ResultSet"); 
                 
        }
        
        return usluge;
	}

	/**
	 * Metoda vraća nazive atributa usluge najma i njihovih novih vrednosti koje ce biti ažurirane
	 * 
	 * @return String koji predstavlja kombinaciju parametara i njihovih novih vrednosti koje je potrebno ažurirati u bazi.
	 */
	@Override
	public String getUpitAzuriranje() {
        return "stavkaKatalogaID = "+stavkaKataloga.getStavkaKatalogaID()+", uslugaNajmaID = "+uslugaNajmaID+", nazivUslugeNajma = '"+nazivUslugeNajma+"', cenaUsluge = "+cenaUsluge+", vrstaSobeID = "+vrstaSobe.getVrstaSobeID();
	}

	/**
	 * Metoda vraća uslov složenog primarnog ključa tabele u bazi koja predstavlja uslugu najma
	 * 
	 * @return String koji predstavlja ime i vrednost složenog primarnog kljuca.
	 */
	@Override
	public String getSlozeniPrimarniKljuc() {
        return "stavkaKatalogaID="+stavkaKataloga.getStavkaKatalogaID()+" AND uslugaNajmaID="+uslugaNajmaID+ " AND vrstaSobeID="+vrstaSobe.getVrstaSobeID();
	}

	
	public String getComplexPrimaryKeyNames() {
        return "stavkaKatalogaID,uslugaNajmaID,vrstaSobeID";
    }
}
