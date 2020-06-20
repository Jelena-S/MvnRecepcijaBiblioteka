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
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.UslugaNajma;

public class VrstaSobeTest {

	VrstaSobe vrstaSobe;
	UslugaNajma un1, un2;

	@Before
	public void setUp() throws Exception {
		vrstaSobe = new VrstaSobe();
		vrstaSobe.setVrstaSobeID(1l);
		vrstaSobe.setNazivVrsteSobe("Vrsta sobe 1");
		vrstaSobe.setBrojKreveta(1);
		vrstaSobe.setOpis("Opis");
		
	}

	@After
	public void tearDown() throws Exception {
		vrstaSobe = null;
	}

	@Test
	public void testSetVrstaSobeID() {
		assertEquals(Long.valueOf(1), vrstaSobe.getVrstaSobeID());
	}

	@Test
	public void testSetNazivVrsteSobe() {
		assertEquals("Vrsta sobe 1", vrstaSobe.getNazivVrsteSobe());
	}

	@Test
	public void testSetBrojKreveta() {
		assertEquals(1, vrstaSobe.getBrojKreveta());
	}

	@Test
	public void testSetOpis() {
		assertEquals("Opis", vrstaSobe.getOpis());
	}

	@Test
	public void testSetUsluge() {
		un1 = new UslugaNajma(new StavkaKataloga(111l), 11l, "Usluga1", 100.0, vrstaSobe);
		un1 = new UslugaNajma(new StavkaKataloga(222l), 22l, "Usluga1", 100.0, vrstaSobe);
		
		List<UslugaNajma> usluge = new ArrayList<>();
		usluge.add(un1);
		usluge.add(un2);
		
		assertTrue(usluge.size() == 2);
		assertEquals(un1, usluge.get(0));
		assertEquals(un2, usluge.get(1));
		
	}

	@Test
	public void testToString() {
		String s = vrstaSobe.toString();
		
		assertTrue(s.contains("Vrsta sobe 1"));
	}

	@Test
	public void testGetTableName() {
		assertEquals("vrstaSobe", vrstaSobe.getImeTabele());
	}

	@Test
	public void testGetParameters() {
		assertEquals("1, 'Vrsta sobe 1', 1, 'Opis'", vrstaSobe.getParametre());
	}

	@Test
	public void testGetParameterNames() {
		assertEquals("vrstaSobeID,nazivVrsteSobe,brojKreveta,opis", vrstaSobe.getImenaParametara());
	}

	@Test
	public void testGetPrimaryKeyName() {
		assertEquals("vrstaSobeID", vrstaSobe.getImePrimarnogKljuca());
	}

	@Test
	public void testGetPrimaryKeyValue() {
		assertEquals(Long.valueOf(1), vrstaSobe.getVrednostPrimarnogKljuca());
	}

	

	@Test
	public void testGetUpdateQuery() {
		assertEquals("vrstaSobeID = 1, nazivVrsteSobe = 'Vrsta sobe 1', brojKreveta = 1, opis = 'Opis'", vrstaSobe.getUpitAzuriranje());
	}

	@Test
	public void testGetComplexPrimaryKey() {
		assertEquals(null, vrstaSobe.getSlozeniPrimarniKljuc());
	}

}
