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

public class ZakupSobe implements OpstiDomenskiObjekat, Serializable{
	private Gost gostZakupljuje;
    private Soba zakupljenaSoba;
    private Long zakupID;
    private Date datumOd;
    private Date datumDo;
    private double cena;
    private Recepcioner recepcioner;
    private boolean status;
    
    public ZakupSobe() {
    	
    }

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
    
	public Gost getGostZakupljuje() {
		return gostZakupljuje;
	}

	public void setGostZakupljuje(Gost gostZakupljuje) {
		this.gostZakupljuje = gostZakupljuje;
	}

	public Soba getZakupljenaSoba() {
		return zakupljenaSoba;
	}

	public void setZakupljenaSoba(Soba zakupljenaSoba) {
		this.zakupljenaSoba = zakupljenaSoba;
	}

	public Long getZakupID() {
		return zakupID;
	}

	public void setZakupID(Long zakupID) {
		this.zakupID = zakupID;
	}

	public Date getDatumOd() {
		return datumOd;
	}

	public void setDatumOd(Date datumOd) {
		this.datumOd = datumOd;
	}

	public Date getDatumDo() {
		return datumDo;
	}

	public void setDatumDo(Date datumDo) {
		this.datumDo = datumDo;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Recepcioner getRecepcioner() {
		return recepcioner;
	}

	public void setRecepcioner(Recepcioner recepcioner) {
		this.recepcioner = recepcioner;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String getImeTabele() {
		return "zakupsobe";
	}

	@Override
	public String getParametre() {
    	return String.format("%s, %s, %s, '%s', '%s', %s, %s, %s", gostZakupljuje.getGostID(),zakupljenaSoba.getSobaID(),zakupID,datumOd,datumDo,cena,status,recepcioner.getRecepcionerID());
	}

	@Override
	public String getImenaParametara() {
        return "gostZakupljujeID,zakupljenaSobaID,zakupID,datumOD,datumDO,cena,recepcionerID,status";
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

	@Override
	public String getUpitAzuriranje() {
		return "gostZakupljujeID = "+gostZakupljuje.getGostID()+", zakupljenaSobaID = "+zakupljenaSoba.getSobaID()+", zakupID = "+zakupID+
                ", datumOD = "+datumOd+", datumDO = "+datumDo+", cena = "+cena+", recepcionerID = "+recepcioner.getRecepcionerID()+", status = "+status;
	}

	@Override
	public String getSlozeniPrimarniKljuc() {
        return "WHERE gostZakupljujeID="+gostZakupljuje.getGostID()+" AND zakupljenaSobaID="+zakupljenaSoba.getSobaID()+" AND zakupID="+zakupID;
	}

	
}
