package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.Katalog;

public class StavkaKatalogaTest {

	StavkaKataloga stavkaKataloga;
	Katalog katalog;

	@Before
	public void setUp() throws Exception {
		stavkaKataloga = new StavkaKataloga();
		stavkaKataloga.setStavkaKatalogaID(1l);
		stavkaKataloga.setNazivStavkeKataloga("StavkaKataloga1");
		
		katalog = new Katalog();
		katalog.setKatalogID(10l);
		
		stavkaKataloga.setKatalog(katalog);
		
	}

	@After
	public void tearDown() throws Exception {
		stavkaKataloga = null;
		katalog = null;
	}

	@Test
	public void testSetStavkaKatalogaID() {
		assertEquals(Long.valueOf(1), stavkaKataloga.getStavkaKatalogaID());
	}
	
	@Test
	public void testSetNazivStavkeKataloga() {
		assertEquals("StavkaKataloga1", stavkaKataloga.getNazivStavkeKataloga());
	}

	@Test
	public void testSetKatalog() {
		assertEquals(katalog, stavkaKataloga.getKatalog());
	}


	@Test
	public void testGetTableName() {
		assertEquals("stavkaKataloga", stavkaKataloga.getImeTabele());
	}

	@Test
	public void testGetParameters() {
		assertEquals("10, 1, 'StavkaKataloga1'", stavkaKataloga.getParametre());
	}

	@Test
	public void testGetParameterNames() {
		assertEquals("katalogID,stavkaKatalogaID,nazivStavkeKataloga", stavkaKataloga.getImenaParametara());
	}

	@Test
	public void testGetPrimaryKeyName() {
		assertEquals(null, stavkaKataloga.getImePrimarnogKljuca());
	}

	@Test
	public void testGetPrimaryKeyValue() {
		assertEquals(null, stavkaKataloga.getVrednostPrimarnogKljuca());
	}

	

	@Test
	public void testGetUpdateQuery() {
		assertEquals("katalogID = 10, stavkaKatalogaID = 1, nazivStavkeKataloga = 'StavkaKataloga1'", stavkaKataloga.getUpitAzuriranje());
	}

	@Test
	public void testGetComplexPrimaryKey() {
		assertEquals("WHERE katalogID=10 AND stavkaKataloga=1", stavkaKataloga.getSlozeniPrimarniKljuc());
	}

}
