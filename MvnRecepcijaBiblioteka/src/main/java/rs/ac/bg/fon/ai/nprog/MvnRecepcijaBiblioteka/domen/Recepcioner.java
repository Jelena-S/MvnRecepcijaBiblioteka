package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

public class Recepcioner implements OpstiDomenskiObjekat, Serializable{
	private Long recepcionerID;
    private String imeRecepcionera;
    private String prezimeRecepcionera;
    private String korisnickoIme;
    private String lozinka;
    
    public Recepcioner() {
    }

    public Recepcioner(Long recepcionerID, String imeRecepcionera, String prezimeRecepcionera, String korisnickoIme, String lozinka) {
        this.recepcionerID = recepcionerID;
        this.imeRecepcionera = imeRecepcionera;
        this.prezimeRecepcionera = prezimeRecepcionera;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public Recepcioner(Long recepcionerID) {
        this.recepcionerID = recepcionerID;
    }
    
	
	public Long getRecepcionerID() {
		return recepcionerID;
	}

	public void setRecepcionerID(Long recepcionerID) {
		this.recepcionerID = recepcionerID;
	}

	public String getImeRecepcionera() {
		return imeRecepcionera;
	}

	public void setImeRecepcionera(String imeRecepcionera) {
		this.imeRecepcionera = imeRecepcionera;
	}

	public String getPrezimeRecepcionera() {
		return prezimeRecepcionera;
	}

	public void setPrezimeRecepcionera(String prezimeRecepcionera) {
		this.prezimeRecepcionera = prezimeRecepcionera;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	@Override
	public String toString() {
		return imeRecepcionera+" "+prezimeRecepcionera;
	}
	 
	
	 

	@Override
	public String getImeTabele() {
		return "recepcioner";
	}

	@Override
	public String getParametre() {
        return String.format("%s,'%s','%s','%s','%s'",recepcionerID,imeRecepcionera,prezimeRecepcionera,korisnickoIme,lozinka);
	}

	@Override
	public String getImenaParametara() {
        return "recepcionerID,imeRecepcionera,prezimeRecepcionera,korisnickoIme,password";
	}

	@Override
	public String getImePrimarnogKljuca() {
		return "recepcionerID";
	}

	@Override
	public Long getVrednostPrimarnogKljuca() {
		return recepcionerID;
	}

	@Override
	public List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs) {
		List<OpstiDomenskiObjekat> receptionists = new ArrayList<>();
        try {
            while (rs.next()) {                
                Long id = rs.getLong("recepcionerID");
                String name = rs.getString("imeRecepcionera");
                String lastname = rs.getString("prezimeRecepcionera");
                String username = rs.getString("username");
                String pass = rs.getString("password");
                
                Recepcioner r = new Recepcioner(id, name, lastname, username, pass);
                receptionists.add(r);
            }
        } catch (Exception e) {
            System.out.println("Greska u Recepcioner.Class ResultSet"); 
                 
        }
        
        return receptionists;
	}
	
	public OpstiDomenskiObjekat convertRS(ResultSet rs) {
        Recepcioner r=null;
        try {
            while (rs.next()) {                
                Long id = rs.getLong("recepcionerID");
                String name = rs.getString("imeRecepcionera");
                String lastname = rs.getString("prezimeRecepcionera");
                String username = rs.getString("korisnickoIme");
                String pass = rs.getString("password");
                
                r = new Recepcioner(id, name, lastname, username, pass);
                
            }
        } catch (Exception e) {
            System.out.println("Greska u Recepcioner.Class ResultSet"); 
                 
        }
        
        return r;
    }

	@Override
	public String getUpitAzuriranje() {
        return "recepcionerID = "+recepcionerID+", imeRecepcionera = '"+imeRecepcionera+"', prezimeRecepcionera = '"+prezimeRecepcionera+"', korisnickoIme = '"+korisnickoIme+"', password = '"+lozinka+"'";

	}

	@Override
	public String getSlozeniPrimarniKljuc() {
		return null;
	}

	
}
