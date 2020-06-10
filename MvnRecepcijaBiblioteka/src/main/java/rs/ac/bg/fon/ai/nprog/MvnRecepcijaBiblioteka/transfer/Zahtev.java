package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.transfer;

import java.io.Serializable;

public class Zahtev implements Serializable{
	private Object parametar;
    private Object parametar2;
    private int operacija;
    
    public Zahtev() {
		
	}
    
    public Zahtev(Object parametar, int operacija) {
		this.parametar = parametar;
		this.operacija = operacija;
	}
    
    public Zahtev(Object parametar, Object parametar2, int operacija) {
		this.parametar = parametar;
		this.parametar2 = parametar2;
		this.operacija = operacija;
	}

    public Object getParametar() {
		return parametar;
	}

    public void setParametar(Object parametar) {
		this.parametar = parametar;
	}

    public Object getParametar2() {
		return parametar2;
	}

    public void setParametar2(Object parametar2) {
		this.parametar2 = parametar2;
	}

    public int getOperacija() {
		return operacija;
	}

    public void setOperacija(int operacija) {
		this.operacija = operacija;
	}
    
    
}
