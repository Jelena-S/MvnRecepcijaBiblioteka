package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.StavkaKataloga;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

public class Katalog implements OpstiDomenskiObjekat, Serializable{
	private Long katalogID;
    private String nazivKataloga;
    private List<StavkaKataloga> listaStavki;

    public Katalog() {
        listaStavki = new ArrayList<>();
    }

    public Katalog(Long katalogID, String nazivKataloga) {
        this.katalogID = katalogID;
        this.nazivKataloga = nazivKataloga;
    }

    public Katalog(Long katalogID) {
        this.katalogID = katalogID;
    }
	
	public Long getKatalogID() {
		return katalogID;
	}

	public void setKatalogID(Long katalogID) {
		this.katalogID = katalogID;
	}

	public String getNazivKataloga() {
		return nazivKataloga;
	}

	public void setNazivKataloga(String nazivKataloga) {
		this.nazivKataloga = nazivKataloga;
	}

	public List<StavkaKataloga> getListaStavki() {
		return listaStavki;
	}

	public void setListaStavki(List<StavkaKataloga> listaStavki) {
		this.listaStavki = listaStavki;
	}

	@Override
	public String getImeTabele() {
		return "katalog";
	}

	@Override
	public String getParametre() {
		return String.format("%s, '%s'", katalogID,nazivKataloga);
	}

	@Override
	public String getImenaParametara() {
		return "katalogID,nazivKataloga";
	}

	@Override
	public String getImePrimarnogKljuca() {
		return "katalogID";
	}

	@Override
	public Long getVrednostPrimarnogKljuca() {
		return katalogID;
	}

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

	@Override
	public String getUpitAzuriranje() {
        return "katalogID = "+katalogID+", nazivKataloga = '"+nazivKataloga+"'";
	}

	@Override
	public String getSlozeniPrimarniKljuc() {
		return null;
	}

	
}
