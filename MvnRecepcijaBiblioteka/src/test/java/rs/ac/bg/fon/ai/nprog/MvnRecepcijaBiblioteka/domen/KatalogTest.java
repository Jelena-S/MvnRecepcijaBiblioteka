package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.StavkaKataloga;

public class KatalogTest {

	Katalog katalog;
	StavkaKataloga sk1, sk2;
	

	@Before
	public void setUp() throws Exception {
		katalog = new Katalog(1l,"Katalog1");
		
	}

	@After
	public void tearDown() throws Exception {
		katalog = null;
	}

	@Test
	public void testSetNazivKataloga() {
		katalog.setNazivKataloga("Katalog2");
		assertEquals("Katalog2", katalog.getNazivKataloga());
	}

	@Test
	public void testSetKatalogID() {
		katalog.setKatalogID(2l);
		assertEquals(Long.valueOf(2), katalog.getKatalogID());
	}

	@Test
	public void testSetListaStavki() {
		sk1 = new StavkaKataloga(katalog,11l,"StavkaKataloga11");
		sk2 = new StavkaKataloga(katalog,22l,"StavkaKataloga22");
		List<StavkaKataloga> stavke = new ArrayList<>();
		stavke.add(sk1);
		stavke.add(sk2);
		
		assertTrue(stavke.size() == 2);
		assertEquals(sk1, stavke.get(0));
		assertEquals(sk2, stavke.get(1));
	}

	@Test
	public void testGetTableName() {
		assertEquals("katalog", katalog.getImeTabele());
	}

	@Test
	public void testGetParameters() {
		assertEquals("1, 'Katalog1'", katalog.getParametre());
	}

	@Test
	public void testGetParameterNames() {
		assertEquals("katalogID,nazivKataloga", katalog.getImenaParametara());
	}

	@Test
	public void testGetPrimaryKeyName() {
		assertEquals("katalogID", katalog.getImePrimarnogKljuca());
	}

	@Test
	public void testGetPrimaryKeyValue() {
		assertEquals(katalog.getKatalogID(), katalog.getVrednostPrimarnogKljuca());
	}

	

	@Test
	public void testGetUpdateQuery() {
		assertEquals("katalogID = 1, nazivKataloga = 'Katalog1'", katalog.getUpitAzuriranje());
	}

	@Test
	public void testGetComplexPrimaryKey() {
		assertEquals(null, katalog.getSlozeniPrimarniKljuc());
	}

}
