package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.Gost;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.Recepcioner;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.Soba;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

/**
 * Klasa predstavlja zakup sobe sa svim svojim svojstvima. Implementira interfejse OpstiDomenskiObjekat i Serializable
 *
 * @author Jelena Sreckovic
 */

public class ZakupSobe implements OpstiDomenskiObjekat, Serializable{
	/**
	 * Gost koji zakupljuje sobu
	 */
	private Gost gostZakupljuje;
	
	/**
	 * Soba koja je zakupljena, na koju se odnosi zakup
	 */
    private Soba zakupljenaSoba;
    
    /**
     * Identifikator zakupa sobe
     */
    private Long zakupID;
    
    /**
     * Datum od kog važi zakup sobe
     */
    private Date datumOd;
    
    /**
     * Datum do kog važi zakup sobe
     */
    private Date datumDo;
    
    /**
     * Cena zakupa sobe
     */
    private double cena;
    
    /**
     * Recepcioner koji je uneo zakup sobe u sistem
     */
    private Recepcioner recepcioner;
    
    /**
     * Status zakupa
     */
    private boolean status;
    
    /**
     * Neparametrizovani konstruktor. Inicijalizuje zakup sobe.
     */
    public ZakupSobe() {
    	
    }

    /**
     * Parametrizovani konstruktor. Inicijalizuje vrstu sobe i postavlja vrednosti pozivanjem set metoda.
     * 
     * @param gostZakupljuje Gost kog je potrebno postaviti
     * @param zakupljenaSoba Soba koju je potrebno postaviti
     * @param zakupID identifikator koji je potrebno postaviti
     * @param datumOd datum početka zakupa koji je potrebno postaviti
     * @param datumDo datum završetka koji je potrebno postaviti
     * @param cena cena zakupa koju je potrebno postaviti
     * @param status status zakupa koji je potrebno postaviti
     * @param recepcioner Recepcioner kog je potrebno postaviti
     */
    public ZakupSobe(Gost gostZakupljuje, Soba zakupljenaSoba, Long zakupID, Date datumOd, Date datumDo, double cena, boolean status,Recepcioner recepcioner) {
        this.gostZakupljuje = gostZakupljuje;
        this.zakupljenaSoba = zakupljenaSoba;
        this.zakupID = zakupID;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.cena = cena;
        this.status = status;
        this.recepcioner=recepcioner;
    }
    
    /**
     * Metoda vraća gosta koje je zakupio sobu
     * 
     * @return gostZakupljuje kao Gost
     */
	public Gost getGostZakupljuje() {
		return gostZakupljuje;
	}

	/**
     * Metoda postavlja gosta koji je zakupio sobu
     * 
     * @param gostZakupljuje novi gost kog je potrebno postaviti
     */
	public void setGostZakupljuje(Gost gostZakupljuje) {
		this.gostZakupljuje = gostZakupljuje;
	}

	/**
     * Metoda vraća sobu koja je zakupljena
     * 
     * @return zakupljenaSoba kao Soba
     */
	public Soba getZakupljenaSoba() {
		return zakupljenaSoba;
	}

	/**
     * Metoda postavlja sobu koja je zakupljena
     * 
     * @param zakupljenaSoba nova soba koju je potrebno postaviti
     */
	public void setZakupljenaSoba(Soba zakupljenaSoba) {
		this.zakupljenaSoba = zakupljenaSoba;
	}

	/**
     * Metoda vraća identifikator zakupa sobe
     * 
     * @return zakupID kao Long
     */
	public Long getZakupID() {
		return zakupID;
	}

	/**
     * Metoda postavlja identifikator zakupa sobe
     * 
     * @param zakupID nova vrednost identifikatora zakupa sobe koju je potrebno postaviti
     */
	public void setZakupID(Long zakupID) {
		this.zakupID = zakupID;
	}

	/**
     * Metoda vraća datum od kog važi zakup sobe
     * 
     * @return datumOd kao Date
     */
	public Date getDatumOd() {
		return datumOd;
	}

	/**
     * Metoda postavlja datum od kog važi zakup sobe
     * 
     * @param datumOd nova vrednost datuma koju je potrebno postaviti
     */
	public void setDatumOd(Date datumOd) {
		this.datumOd = datumOd;
	}

	/**
     * Metoda vraća datum do kog važi zakup sobe
     * 
     * @return datumDo kao Date
     */
	public Date getDatumDo() {
		return datumDo;
	}

	/**
     * Metoda postavlja datum do kog važi zakup sobe
     * 
     * @param datumDo nova vrednost datuma koju je potrebno postaviti
     */
	public void setDatumDo(Date datumDo) {
		this.datumDo = datumDo;
	}

	/**
     * Metoda vraća cenu zakupa sobe
     * 
     * @return cena kao double
     */
	public double getCena() {
		return cena;
	}

	/**
     * Metoda postavlja cenu zakupa sobe
     * 
     * @param cena nova vrednost cene zakupa sobe koju je potrebno postaviti
     */
	public void setCena(double cena) {
		this.cena = cena;
	}

	/**
     * Metoda vraća recepcionera koji je uneo zakup sobe u sistem
     * 
     * @return recepcioner kao Recepcioner
     */
	public Recepcioner getRecepcioner() {
		return recepcioner;
	}

	/**
     * Metoda postavlja recepcionera koji je uneo zakup sobe u sistem
     * 
     * @param recepcioner novi recepcioner kog je potrebno postaviti
     */
	public void setRecepcioner(Recepcioner recepcioner) {
		this.recepcioner = recepcioner;
	}

	/**
     * Metoda vraća status zakupa sobe
     * 
     * @return status kao boolean
     */
	public boolean isStatus() {
		return status;
	}

	/**
     * Metoda postavlja status zakupa sobe
     * 
     * @param status nova vrednost statusa zakupa sobe koju je potrebno postaviti
     */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	/**
	 * Proverava da li su dva zakupa ista i vraca
	 * true ako jesu, a false ako nisu.
	 * 
	 * @return true ako je unet objekat klase ZakupSobe
	 * sa istim identifikatorom, gostom koji zakupljuje i sobom koja je zakupljena, inace false.
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZakupSobe other = (ZakupSobe) obj;
		if (gostZakupljuje == null) {
			if (other.gostZakupljuje != null)
				return false;
		} else if (!gostZakupljuje.equals(other.gostZakupljuje))
			return false;
		if (zakupID == null) {
			if (other.zakupID != null)
				return false;
		} else if (!zakupID.equals(other.zakupID))
			return false;
		if (zakupljenaSoba == null) {
			if (other.zakupljenaSoba != null)
				return false;
		} else if (!zakupljenaSoba.equals(other.zakupljenaSoba))
			return false;
		return true;
	}

	/**
   	 * Metoda vraća naziv tabele u bazi u kojoj se nalaze podaci o zakupu sobe
   	 * 
   	 * @return String koji predstavlja naziv tabele.
   	 */
	@Override
	public String getImeTabele() {
		return "zakupsobe";
	}

	/**
	 * Metoda vraća vrednosti atributa objekta klase ZakupSobe
	 * 
	 * @return String koji predstavlja vrednosti atributa.
	 */
	@Override
	public String getParametre() {
    	return String.format("%s, %s, %s, '%s', '%s', %s, %s, %s", gostZakupljuje.getGostID(),zakupljenaSoba.getSobaID(),zakupID,datumOd,datumDo,cena,status,recepcioner.getRecepcionerID());
	}

	/**
	 * Metoda vraća vrednosti atributa objekta klase ZakupSobe
	 * 
	 * @return String koji predstavlja vrednosti atributa.
	 */
	@Override
	public String getImenaParametara() {
        return "gostZakupljujeID,zakupljenaSobaID,zakupID,datumOD,datumDO,cena,recepcionerID,status";
	}

	/**
   	 * Metoda vraća ime primarnog ključa tabele u bazi u kojoj se nalaze podaci o zakupu sobe
   	 * 
   	 * @return null koji predstavlja ime primarnog kljuca, jer je primarni kljuc složen.
   	 */
	@Override
	public String getImePrimarnogKljuca() {
		return null;
	}

	/**
	 * Metoda vraća vrednost primarnog ključa tabele u bazi u kojoj se nalaze podaci o zakupu sobe
	 * 
	 * @return null koji predstavlja vrednost primarnog kljuca, jer je primarni ključ složen.
	 */
	@Override
	public Long getVrednostPrimarnogKljuca() {
		return null;
	}

	/**
	 * Metoda konvertuje ResultSet u listu objekata klase ZakupSobe
	 * 
	 * @param rs ResultSet koji je potrebno konvertovati u listu zakupa
	 * 
	 * @return Lista domenskih objekata koji su procitani iz baze
	 */
	@Override
	public List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs) {
		List<OpstiDomenskiObjekat> rents = new ArrayList<>();
        try {
            while (rs.next()) {                
                Long gost = rs.getLong("gostZakupljujeID");
                Long room = rs.getLong("zakupljenaSobaID");
                Long rent = rs.getLong("zakupID");
                Date dOD = rs.getDate("datumOd");
                Date dDO = rs.getDate("datumDo");
                Double price = rs.getDouble("cena");
                Long recepcionistID = rs.getLong("recepcionerID");
                boolean status = rs.getBoolean("status");
                
                ZakupSobe z = new ZakupSobe(new Gost(gost), new Soba(room), rent, dOD, dDO, price,status,new Recepcioner(recepcionistID));
                rents.add(z);
            }
        } catch (Exception e) {
            System.out.println("Greska u ZakupSObe.Class ResultSet"); 
                 
        }
        
        return rents;
	}

	/**
	 * Metoda vraća nazive atributa zakupa sobe i njihovih novih vrednosti koje ce biti ažurirane
	 * 
	 * @return String koji predstavlja kombinaciju parametara i njihovih novih vrednosti koje je potrebno ažurirati u bazi.
	 */
	@Override
	public String getUpitAzuriranje() {
		return "gostZakupljujeID = "+gostZakupljuje.getGostID()+", zakupljenaSobaID = "+zakupljenaSoba.getSobaID()+", zakupID = "+zakupID+
                ", datumOD = "+datumOd+", datumDO = "+datumDo+", cena = "+cena+", recepcionerID = "+recepcioner.getRecepcionerID()+", status = "+status;
	}

	/**
	 * Metoda vraća uslov složenog primarnog ključa tabele koja predstavlja zakup sobe
	 * 
	 * @return String koji predstavlja ime i vrednost složenog primarnog ključa,jer je primarni kljuc složen.
	 */
	@Override
	public String getSlozeniPrimarniKljuc() {
        return "WHERE gostZakupljujeID="+gostZakupljuje.getGostID()+" AND zakupljenaSobaID="+zakupljenaSoba.getSobaID()+" AND zakupID="+zakupID;
	}

	
}
