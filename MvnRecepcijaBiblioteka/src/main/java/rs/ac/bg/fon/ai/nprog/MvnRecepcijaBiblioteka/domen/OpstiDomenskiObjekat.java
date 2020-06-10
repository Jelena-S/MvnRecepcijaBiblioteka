package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import java.sql.ResultSet;
import java.util.List;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.OpstiDomenskiObjekat;

/**
 * Interfejs koji nasledjuju domenske klase. Sadrži potpise metoda koje domenske klase treba da implementiraju.
 * 
 * @author Jelena Sreckovic
 */

public interface OpstiDomenskiObjekat {
	
	/**
	 * Metoda vraća naziv tabele u bazi koja se odnosi na odredjenu domensku klasu.
	 * 
	 * @return String koji predstavlja naziv tabele.
	 */
	String getImeTabele();
	
	/**
	 * Metoda vraća vrednosti atributa objekta u vidu formatiranog stringa koji bi trebalo sačuvati u bazi.
	 * 
	 * @return String koji predstavlja vrednosti atributa.
	 */
	String getParametre();
	
	/**
	 * Metoda vraća imena atributa objekta nad kojim se poziva metoda.
	 * 
	 * @return String koji predstavlja imena atributa koja su odvojena zapetom.
	 */
	String getImenaParametara();
	
	/**
	 * Metoda vraća ime primarnog kljuca tabele u bazi koja predstavlja objekat.
	 * 
	 * @return String koji predstavlja ime primarnog kljuca ili null ako je primarni ključ složen.
	 */
	String getImePrimarnogKljuca();
	
	/**
	 * Metoda vraća vrednost primarnog kljuca tabele u bazi koja predstavlja objekat.
	 * 
	 * @return Long koji predstavlja vrednost primarnog kljuca ili null ako je primarni ključ složen.
	 */
	Long getVrednostPrimarnogKljuca();
	
	/**
	 * Metoda konvertuje prosledjeni ResultSet u listu domenskih objekata.
	 * 
	 * @param rs ResultSet koji je potrebno konvertovati u listu.
	 * 
	 * @return Lista domenskih objekata koji su pročitani iz baze.
	 */
	List<OpstiDomenskiObjekat> konvertujRSUListu(ResultSet rs);
	
	/**
	 * Metoda vraća nazive parametara i vrednosti u vidu stringa koje će biti postavljene.
	 * 
	 * @return String koji predstavlja kombinaciju parametara i njihovih novih vrednosti koje je potrebno azurirati u bazi.
	 */
	String getUpitAzuriranje();
	
	/**
	 * Metoda vraća uslov složenog primarnog ključa tabele u bazi koja predstavlja objekat
	 * 
	 * @return String koji predstavlja ime i vrednost slozenog primarnog kljuca ili null ako primarni ključ nije složen.
	 */
	String getSlozeniPrimarniKljuc();
}
