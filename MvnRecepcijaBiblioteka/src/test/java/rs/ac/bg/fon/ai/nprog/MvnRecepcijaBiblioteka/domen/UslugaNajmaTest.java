package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.StavkaKataloga;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.VrstaSobe;

public class UslugaNajmaTest {

	UslugaNajma uslugaNajma;
	StavkaKataloga stavkaKataloga;
	VrstaSobe vrstaSobe;

	@Before
	public void setUp() throws Exception {
		uslugaNajma = new UslugaNajma();
		uslugaNajma.setUslugaNajmaID(1l);
		uslugaNajma.setNazivUslugeNajma("Usluga1");
		uslugaNajma.setCenaUsluge(100);
		
		stavkaKataloga = new StavkaKataloga();
		stavkaKataloga.setStavkaKatalogaID(100l);
		
		uslugaNajma.setStavkaKataloga(stavkaKataloga);
		
		vrstaSobe = new VrstaSobe();
		vrstaSobe.setVrstaSobeID(1000l);
		
		uslugaNajma.setVrstaSobe(vrstaSobe);
	}

	@After
	public void tearDown() throws Exception {
		uslugaNajma = null;
		stavkaKataloga = null;
		vrstaSobe = null;
	}

	@Test
	public void testSetStavkaKataloga() {
		assertEquals(stavkaKataloga, uslugaNajma.getStavkaKataloga());
	}

	@Test
	public void testSetUslugaNajmaID() {
		assertEquals(Long.valueOf(1), uslugaNajma.getUslugaNajmaID());
	}

	@Test
	public void testSetNazivUslugeNajma() {
		assertEquals("Usluga1", uslugaNajma.getNazivUslugeNajma());
	}

	@Test
	public void testSetCenaUsluge() {
		assertEquals(Double.valueOf(100), uslugaNajma.getCenaUsluge(), Double.valueOf(0.001));
	}

	@Test
	public void testSetVrstaSobe() {
		assertEquals(vrstaSobe, uslugaNajma.getVrstaSobe());
	}

	@Test
	public void testGetTableName() {
		assertEquals("uslugaNajma", uslugaNajma.getImeTabele());
	}

	@Test
	public void testGetParameters() {
		assertEquals("100, 1, 'Usluga1', 100.0, 1000", uslugaNajma.getParametre());
	}

	@Test
	public void testGetParameterNames() {
		assertEquals("stavkaKatalogaID,uslugaNajmaID,nazivUslugeNajma,cenaUsluge,vrstaSobeID", uslugaNajma.getImenaParametara());
	}

	@Test
	public void testGetPrimaryKeyName() {
		assertEquals(null, uslugaNajma.getImePrimarnogKljuca());
	}

	@Test
	public void testGetPrimaryKeyValue() {
		assertEquals(null, uslugaNajma.getVrednostPrimarnogKljuca());
	}

	

	@Test
	public void testGetUpdateQuery() {
		assertEquals("stavkaKatalogaID = 100, uslugaNajmaID = 1, nazivUslugeNajma = 'Usluga1', cenaUsluge = 100.0, vrstaSobeID = 1000", uslugaNajma.getUpitAzuriranje());
	}

	@Test
	public void testGetComplexPrimaryKey() {
		assertEquals("stavkaKatalogaID=100 AND uslugaNajmaID=1 AND vrstaSobeID=1000", uslugaNajma.getSlozeniPrimarniKljuc());
	}

	@Test
	public void testGetComplexPrimaryKeyNames() {
		assertEquals("stavkaKatalogaID,uslugaNajmaID,vrstaSobeID", uslugaNajma.getComplexPrimaryKeyNames());
	}

}
