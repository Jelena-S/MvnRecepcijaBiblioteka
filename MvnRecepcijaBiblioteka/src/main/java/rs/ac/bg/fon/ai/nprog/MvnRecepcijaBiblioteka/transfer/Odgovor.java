package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.transfer;

import java.io.Serializable;

public class Odgovor implements Serializable{
	private Object odgovor;
    private String poruka;
    private boolean uspesno;
    private int operacija;
    
    public Odgovor() {
		
	}
    
    public Odgovor(Object odgovor, String poruka, boolean uspesno, int operacija) {
		this.odgovor = odgovor;
		this.poruka = poruka;
		this.uspesno = uspesno;
		this.operacija = operacija;
	}

    public Object getOdgovor() {
		return odgovor;
	}

    public void setOdgovor(Object odgovor) {
		this.odgovor = odgovor;
	}

    public String getPoruka() {
		return poruka;
	}

    public void setPoruka(String poruka) {
		this.poruka = poruka;
	}

    public boolean isUspesno() {
		return uspesno;
	}

    public void setUspesno(boolean uspesno) {
		this.uspesno = uspesno;
	}

    public int getOperacija() {
		return operacija;
	}

    public void setOperacija(int operacija) {
		this.operacija = operacija;
	}
    
    
}
