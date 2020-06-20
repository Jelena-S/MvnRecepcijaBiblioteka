package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.VrstaSobe;

public class SobaTest {

	Soba soba;
	VrstaSobe vrstaSobe;

	@Before
	public void setUp() throws Exception {
		soba = new Soba();
		soba.setSobaID(1l);
		soba.setStatus(true);
		
		vrstaSobe = new VrstaSobe();
		vrstaSobe.setVrstaSobeID(10l);
		
		soba.setVrstaSobe(vrstaSobe);
	}

	@After
	public void tearDown() throws Exception {
		soba = null;
	}

	@Test
	public void testSetSobaID() {
		assertEquals(Long.valueOf(1), soba.getSobaID());
	}

	@Test
	public void testSetStatus() {
		assertEquals(true, soba.isStatus());
	}
	
	@Test
	public void testSetVrstaSobe() {
		assertEquals(vrstaSobe, soba.getVrstaSobe());
	}

	@Test
	public void testGetTableName() {
		assertEquals("soba", soba.getImeTabele());
	}

	@Test
	public void testGetParameters() {
		assertEquals("1, 'true', 10", soba.getParametre());
	}

	@Test
	public void testGetParameterNames() {
		assertEquals("sobaID,status,vrstaSobeID", soba.getImenaParametara());
	}

	@Test
	public void testGetPrimaryKeyName() {
		assertEquals("sobaID", soba.getImePrimarnogKljuca());
	}

	@Test
	public void testGetPrimaryKeyValue() {
		assertEquals(Long.valueOf(1), soba.getVrednostPrimarnogKljuca());
	}


	@Test
	public void testGetUpdateQuery() {
		assertEquals("sobaID = 1, status = true, vrstaSobeID = 10", soba.getUpitAzuriranje());
	}

	@Test
	public void testGetComplexPrimaryKey() {
		assertEquals(null, soba.getSlozeniPrimarniKljuc());
	}

}
