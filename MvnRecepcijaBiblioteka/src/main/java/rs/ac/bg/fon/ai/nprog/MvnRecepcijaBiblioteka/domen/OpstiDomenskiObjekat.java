package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.sql.ResultSet;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

public interface OpstiDomenskiObjekat {
	String getImeTabele();
	String getParametre();
	String getImenaParametara();
	String getImePrimarnogKljuca();
	Long getVrednostPrimarnogKljuca();
	List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs);
	String getUpitAzuriranje();
	String getSlozeniPrimarniKljuc();
}
