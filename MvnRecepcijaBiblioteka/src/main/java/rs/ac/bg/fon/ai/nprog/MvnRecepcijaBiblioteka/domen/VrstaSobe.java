package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.UslugaNajma;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

public class VrstaSobe implements OpstiDomenskiObjekat, Serializable{
	private Long vrstaSobeID;
    private String nazivVrsteSobe;
    private int brojKreveta;
    private String opis; 
    private List<UslugaNajma> usluge; 

    public VrstaSobe() {
    	usluge=new ArrayList<>();
    }

    public VrstaSobe( Long vrstaSobeID, String nazivVrsteSobe, int brojKreveta, String opis) {//, List<UslugaNajma> usluge
        this.vrstaSobeID = vrstaSobeID;
        this.nazivVrsteSobe = nazivVrsteSobe;
        this.brojKreveta = brojKreveta;
        this.opis = opis;
    }

    public VrstaSobe(Long vrstaSobeID) {
        this.vrstaSobeID = vrstaSobeID;
    }
	
	public Long getVrstaSobeID() {
		return vrstaSobeID;
	}

	public void setVrstaSobeID(Long vrstaSobeID) {
		this.vrstaSobeID = vrstaSobeID;
	}

	public String getNazivVrsteSobe() {
		return nazivVrsteSobe;
	}

	public void setNazivVrsteSobe(String nazivVrsteSobe) {
		this.nazivVrsteSobe = nazivVrsteSobe;
	}

	public int getBrojKreveta() {
		return brojKreveta;
	}

	public void setBrojKreveta(int brojKreveta) {
		this.brojKreveta = brojKreveta;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<UslugaNajma> getUsluge() {
		return usluge;
	}

	public void setUsluge(List<UslugaNajma> usluge) {
		this.usluge = usluge;
	}
	
	@Override
    public String toString() {
        return nazivVrsteSobe;
    }

	@Override
	public String getImeTabele() {
		return "vrstaSobe";
	}

	@Override
	public String getParametre() {
        return String.format("%s, '%s', %s, '%s'",vrstaSobeID,nazivVrsteSobe,brojKreveta,opis);
	}

	@Override
	public String getImenaParametara() {
        return "vrstaSobeID,nazivVrsteSobe,brojKreveta,opis"; 
	}

	@Override
	public String getImePrimarnogKljuca() {
		return "vrstaSobeID";
	}

	@Override
	public Long getVrednostPrimarnogKljuca() {
		return vrstaSobeID;
	}

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

	@Override
	public String getUpitAzuriranje() {
        return "vrstaSobeID = "+vrstaSobeID+", nazivVrsteSobe = '"+nazivVrsteSobe+"', brojKreveta = "+brojKreveta+", opis = '"+opis+"'"; 
	}

	@Override
	public String getSlozeniPrimarniKljuc() {
		return null;
	}

	
}
