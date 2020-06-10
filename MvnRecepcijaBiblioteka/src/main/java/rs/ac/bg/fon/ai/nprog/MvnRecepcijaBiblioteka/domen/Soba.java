package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.VrstaSobe;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

public class Soba implements OpstiDomenskiObjekat, Serializable{
	private Long sobaID;
    private boolean status;
    private VrstaSobe vrstaSobe;

    public Soba() {
    	
    }
    
    public Soba(Long sobaID, boolean status, VrstaSobe vrstaSobe) {
        this.sobaID = sobaID;
        this.status = status;
        this.vrstaSobe = vrstaSobe;
    }
    
    public Soba(Long sobaID) {
        this.sobaID = sobaID;
    }
	
	public Long getSobaID() {
		return sobaID;
	}

	public void setSobaID(Long sobaID) {
		this.sobaID = sobaID;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public VrstaSobe getVrstaSobe() {
		return vrstaSobe;
	}

	public void setVrstaSobe(VrstaSobe vrstaSobe) {
		this.vrstaSobe = vrstaSobe;
	}
	

	@Override
	public String getImeTabele() {
		return "soba";
	}

	@Override
	public String getParametre() {
        return String.format("%s, '%s', %s", sobaID,status,vrstaSobe.getVrstaSobeID());
	}

	@Override
	public String getImenaParametara() {
        return "sobaID,status,vrstaSobeID";
	}

	@Override
	public String getImePrimarnogKljuca() {
		return "sobaID";
	}

	@Override
	public Long getVrednostPrimarnogKljuca() {
		return sobaID;
	}

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

	@Override
	public String getUpitAzuriranje() {
        return "sobaID = "+sobaID+", status = "+status+", vrstaSobeID = "+vrstaSobe.getVrstaSobeID();
	}

	@Override
	public String getSlozeniPrimarniKljuc() {
		return null;
	}

	
	
}
