package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.Recepcioner;

public class GostTest {

	private Gost gost;
	private Recepcioner recepcioner;

	@Before
	public void setUp() throws Exception {
		gost = new Gost();
		recepcioner = new Recepcioner();
		recepcioner.setImeRecepcionera("Pera");
		recepcioner.setPrezimeRecepcionera("Peric");
		recepcioner.setKorisnickoIme("pera");
		recepcioner.setLozinka("perapera");
		recepcioner.setRecepcionerID(1L);
	}

	@After
	public void tearDown() throws Exception {
		gost = null;
	}

	@Test
	public void testSetGostId() {
		gost.setGostID(1l);
		
		assertEquals(Long.valueOf(1), gost.getGostID());
	}

	@Test
	public void testSetImeGosta() {
		gost.setImeGosta("Pera");
		
		assertEquals("Pera", gost.getImeGosta());
	}

	@Test
	public void testSetPrezimeGosta() {
		gost.setPrezimeGosta("Peric");
		
		assertEquals("Peric", gost.getPrezimeGosta());
	}

	@Test
	public void testSetBrojLicneKarte() {
		gost.setBrojLicneKarte("5651351");
		
		assertEquals("5651351", gost.getBrojLicneKarte());
	}

	@Test
	public void testSetBrojTelefona() {
		gost.setBrojTelefona("5651351");
		
		assertEquals("5651351", gost.getBrojTelefona());
	}

	@Test
	public void testSetEmail() {
		gost.setEmail("ppera@gmail.com");
		
		assertEquals("ppera@gmail.com", gost.getEmail());
	}

	@Test
	public void testSetRecepcioner() {
		gost.setRecepcioner(recepcioner);
		
		assertEquals(gost.getRecepcioner(), recepcioner);
	}

	@Test
	public void testToString() {
		gost.setImeGosta("Pera");
		gost.setPrezimeGosta("Peric");
		
		String s = gost.toString();
		
		assertTrue(s.contains("Pera"));
		assertTrue(s.contains("Peric"));
		
	}

	@Test
	public void testGetTableName() {
		assertEquals("gost",gost.getImeTabele());
	}

	@Test
	public void testGetParametersWithoutID() {
		gost=new Gost(1l, "Pera", "Peric", "1561651", "256451", "ppera@gmail.com", new Recepcioner(2l));
		
		assertEquals("'Pera', 'Peric', '1561651', '256451', 'ppera@gmail.com', 2",gost.getParametersWithoutID());
	}

	@Test
	public void testGetParameters() {
		gost=new Gost(1l, "Pera", "Peric", "1561651", "256451", "ppera@gmail.com", new Recepcioner(2l));
		
		assertEquals("1, 'Pera', 'Peric', '1561651', '256451', 'ppera@gmail.com', 2",gost.getParametre());
	}

	@Test
	public void testGetParameterNames() {
		assertEquals("gostID,imeGosta,prezimeGosta,brojLicneKarte,brojTelefona,email,recepcionerID",gost.getImenaParametara());
	}

	@Test
	public void testGetParameterNamesWithoutID() {
		assertEquals("imeGosta,prezimeGosta,brojLicneKarte,brojTelefona,email,recepcionerID",gost.getImenaParametaraBezID());
	}

	@Test
	public void testGetPrimaryKeyName() {
		assertEquals("gostID", gost.getImePrimarnogKljuca());
	}

	@Test
	public void testGetPrimaryKeyValue() {
		gost=new Gost(1l, "Pera", "Peric", "1561651", "256451", "ppera@gmail.com", new Recepcioner(2l));
		assertEquals(Long.valueOf(1), gost.getVrednostPrimarnogKljuca());
	}


	@Test
	public void testGetUpdateQuery() {
		gost=new Gost(1l, "Pera", "Peric", "1561651", "256451", "ppera@gmail.com", new Recepcioner(2l));
		assertEquals("imeGosta = 'Pera', prezimeGosta = 'Peric', brojLicneKarte = '1561651', brojTelefona = '256451', email = 'ppera@gmail.com', recepcionerID = 2", gost.getUpitAzuriranje());
	}

	@Test
	public void testGetComplexPrimaryKey() {
		gost=new Gost(1l, "Pera", "Peric", "1561651", "256451", "ppera@gmail.com", new Recepcioner(2l));
		assertEquals(null, gost.getSlozeniPrimarniKljuc());
	}

}
