package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.Recepcioner;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

public class Gost implements OpstiDomenskiObjekat, Serializable{
	private Long gostID;
	private String imeGosta;
	private String prezimeGosta;
	private String brojLicneKarte;
	private String brojTelefona;
	private String email;
	private Recepcioner recepcioner;
	
	public Gost() {
		
    }
	
	public Gost(Long gostID, String imeGosta, String prezimeGosta, String brojLicneKarte, String brojTelefona, String email, Recepcioner recepcioner) {
        this.gostID = gostID;
        this.imeGosta = imeGosta;
        this.prezimeGosta = prezimeGosta;
        this.brojLicneKarte = brojLicneKarte;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.recepcioner = recepcioner;
    }
	
	public Gost(Long gostID) {
        this.gostID = gostID;
    }

	public Long getGostID() {
		return gostID;
	}

	public void setGostID(Long gostID) {
		this.gostID = gostID;
	}

	public String getImeGosta() {
		return imeGosta;
	}

	public void setImeGosta(String imeGosta) {
		this.imeGosta = imeGosta;
	}

	public String getPrezimeGosta() {
		return prezimeGosta;
	}

	public void setPrezimeGosta(String prezimeGosta) {
		this.prezimeGosta = prezimeGosta;
	}

	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Recepcioner getRecepcioner() {
		return recepcioner;
	}

	public void setRecepcioner(Recepcioner recepcioner) {
		this.recepcioner = recepcioner;
	}
	
	@Override
    public String toString() {
        return imeGosta+" "+prezimeGosta;
    }

	@Override
	public String getImeTabele() {
		return "gost";
	}

	@Override
	public String getParametre() {
        return String.format("%s, '%s', '%s', '%s', '%s', '%s', %s", gostID, imeGosta, prezimeGosta, brojLicneKarte, brojTelefona, email, recepcioner.getRecepcionerID()); //dodaj recepcionera
	}
	
	public String getParametersWithoutID() {
        return String.format("'%s', '%s', '%s', '%s', '%s', %s", imeGosta, prezimeGosta, brojLicneKarte, brojTelefona, email, recepcioner.getRecepcionerID()); //dodaj recepcionera
    }

	@Override
	public String getImenaParametara() {
        return "gostID,imeGosta,prezimeGosta,brojLicneKarte,brojTelefona,email,recepcionerID"; 

	}
	
	public String getImenaParametaraBezID() {
        return "imeGosta,prezimeGosta,brojLicneKarte,brojTelefona,email,recepcionerID"; 
    }

	@Override
	public String getImePrimarnogKljuca() {
		return "gostID";
	}

	@Override
	public Long getVrednostPrimarnogKljuca() {
		return gostID;
	}

	@Override
	public List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs) {
		List<OpstiDomenskiObjekat> guests = new ArrayList<>();
        try {
            while (rs.next()) {                
                Long guestID = rs.getLong("gostID");
                String name = rs.getString("imeGosta");
                String lastname = rs.getString("prezimeGosta");
                String cardID = rs.getString("brojLicneKarte");
                String phoneNumber = rs.getString("brojTelefona");
                String mail = rs.getString("email");
                Long recepcionistID = rs.getLong("recepcionerID");
                
                Gost g = new Gost(guestID,name, lastname, cardID, phoneNumber, mail, new Recepcioner(recepcionistID));
                guests.add(g);
            }
        } catch (Exception e) {
            System.out.println("Greska u Gost.Class ResultSet"); 
                 
        }
        return guests;
	}

	@Override
	public String getUpitAzuriranje() {
		 return "imeGosta = '"+imeGosta+"', prezimeGosta = '"+prezimeGosta+"', brojLicneKarte = '"+brojLicneKarte+
	                "', brojTelefona = '"+brojTelefona +"', email = '"+email+"', recepcionerID = "+recepcioner.getRecepcionerID();
	}

	@Override
	public String getSlozeniPrimarniKljuc() {
		return null;
	}
	
	
}
