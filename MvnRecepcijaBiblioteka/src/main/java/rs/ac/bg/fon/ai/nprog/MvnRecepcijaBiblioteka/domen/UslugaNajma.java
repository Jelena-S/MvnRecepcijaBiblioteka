package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.StavkaKataloga;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.VrstaSobe;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

public class UslugaNajma implements OpstiDomenskiObjekat, Serializable{

	private StavkaKataloga stavkaKataloga;
    private Long uslugaNajmaID;
    private String nazivUslugeNajma;
    private double cenaUsluge; 
    private VrstaSobe vrstaSobe; 

    public UslugaNajma() {
    }

    public UslugaNajma(StavkaKataloga stavkaKataloga, Long uslugaNajmaID, String nazivUslugeNajma, double cenaUsluge, VrstaSobe vrstaSobe) {
        this.stavkaKataloga = stavkaKataloga;
        this.uslugaNajmaID = uslugaNajmaID;
        this.nazivUslugeNajma = nazivUslugeNajma;
        this.cenaUsluge = cenaUsluge;
        this.vrstaSobe=vrstaSobe;
    }

    public UslugaNajma(StavkaKataloga stavkaKataloga, Long uslugaNajmaID) {
        this.stavkaKataloga = stavkaKataloga;
        this.uslugaNajmaID = uslugaNajmaID;
    }
    
    public UslugaNajma(Long uslugaID) {
        this.uslugaNajmaID=uslugaID;
    }
	
	public StavkaKataloga getStavkaKataloga() {
		return stavkaKataloga;
	}

	public void setStavkaKataloga(StavkaKataloga stavkaKataloga) {
		this.stavkaKataloga = stavkaKataloga;
	}

	public Long getUslugaNajmaID() {
		return uslugaNajmaID;
	}

	public void setUslugaNajmaID(Long uslugaNajmaID) {
		this.uslugaNajmaID = uslugaNajmaID;
	}

	public String getNazivUslugeNajma() {
		return nazivUslugeNajma;
	}

	public void setNazivUslugeNajma(String nazivUslugeNajma) {
		this.nazivUslugeNajma = nazivUslugeNajma;
	}

	public double getCenaUsluge() {
		return cenaUsluge;
	}

	public void setCenaUsluge(double cenaUsluge) {
		this.cenaUsluge = cenaUsluge;
	}

	public VrstaSobe getVrstaSobe() {
		return vrstaSobe;
	}

	public void setVrstaSobe(VrstaSobe vrstaSobe) {
		this.vrstaSobe = vrstaSobe;
	}

	@Override
	public String getImeTabele() {
		return "uslugaNajma";
	}

	@Override
	public String getParametre() {
        return String.format("%s, %s, '%s', %s, %s",stavkaKataloga.getStavkaKatalogaID(),uslugaNajmaID,nazivUslugeNajma,cenaUsluge,vrstaSobe.getVrstaSobeID()); //vidi format za jak-slab
	}

	@Override
	public String getImenaParametara() {
        return "stavkaKatalogaID,uslugaNajmaID,nazivUslugeNajma,cenaUsluge,vrstaSobeID";
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

	@Override
	public String getUpitAzuriranje() {
        return "stavkaKatalogaID = "+stavkaKataloga.getStavkaKatalogaID()+", uslugaNajmaID = "+uslugaNajmaID+", nazivUslugeNajma = '"+nazivUslugeNajma+"', cenaUsluge = "+cenaUsluge+", vrstaSobeID = "+vrstaSobe.getVrstaSobeID();
	}

	@Override
	public String getSlozeniPrimarniKljuc() {
        return "stavkaKatalogaID="+stavkaKataloga.getStavkaKatalogaID()+" AND uslugaNajmaID="+uslugaNajmaID+ " AND vrstaSobeID="+vrstaSobe.getVrstaSobeID();
	}

	public String getComplexPrimaryKeyNames() {
        return "stavkaKatalogaID,uslugaNajmaID,vrstaSobeID";
    }
}
