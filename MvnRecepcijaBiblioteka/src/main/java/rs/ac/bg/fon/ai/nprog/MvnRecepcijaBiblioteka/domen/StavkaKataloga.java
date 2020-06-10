package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.Katalog;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.UslugaNajma;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

public class StavkaKataloga implements OpstiDomenskiObjekat, Serializable{
	private Katalog katalog;
    private Long stavkaKatalogaID;
    private String nazivStavkeKataloga;
    private UslugaNajma uslugaNajma;

    public StavkaKataloga() {
    	
    }

    public StavkaKataloga(Katalog katalog, Long stavkaKatalogaID, String nazivStavkeKataloga) {
        this.katalog = katalog;
        this.stavkaKatalogaID = stavkaKatalogaID;
        this.nazivStavkeKataloga = nazivStavkeKataloga;
    }

    public StavkaKataloga(Long stavkaKatalogaID) {
        this.stavkaKatalogaID = stavkaKatalogaID;
    }
	
	public Katalog getKatalog() {
		return katalog;
	}

	public void setKatalog(Katalog katalog) {
		this.katalog = katalog;
	}

	public Long getStavkaKatalogaID() {
		return stavkaKatalogaID;
	}

	public void setStavkaKatalogaID(Long stavkaKatalogaID) {
		this.stavkaKatalogaID = stavkaKatalogaID;
	}

	public String getNazivStavkeKataloga() {
		return nazivStavkeKataloga;
	}

	public void setNazivStavkeKataloga(String nazivStavkeKataloga) {
		this.nazivStavkeKataloga = nazivStavkeKataloga;
	}

	public UslugaNajma getUslugaNajma() {
		return uslugaNajma;
	}

	public void setUslugaNajma(UslugaNajma uslugaNajma) {
		this.uslugaNajma = uslugaNajma;
	}

	@Override
	public String getImeTabele() {
		return "stavkaKataloga";
	}

	@Override
	public String getParametre() {
        return String.format("%s, %s, '%s'", katalog.getKatalogID(),stavkaKatalogaID,nazivStavkeKataloga);
	}

	@Override
	public String getImenaParametara() {
		return "katalogID,stavkaKatalogaID,nazivStavkeKataloga";
	}

	@Override
	public String getImePrimarnogKljuca() {
		return null;
	}

	@Override
	public Long getVrednostPrimarnogKljuca() {
		return null;
	}

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

	@Override
	public String getUpitAzuriranje() {
        return "katalogID = "+katalog.getKatalogID()+", stavkaKatalogaID = "+stavkaKatalogaID+", nazivStavkeKataloga = '"+nazivStavkeKataloga+"'";
	}

	@Override
	public String getSlozeniPrimarniKljuc() {
        return "WHERE katalogID="+katalog.getKatalogID()+" AND stavkaKataloga="+stavkaKatalogaID;
	}

	
}
