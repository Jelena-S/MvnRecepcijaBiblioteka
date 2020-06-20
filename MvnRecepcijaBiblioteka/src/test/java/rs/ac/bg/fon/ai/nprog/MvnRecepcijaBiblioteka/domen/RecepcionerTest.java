package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RecepcionerTest {

	Recepcioner recepcioner;

	@Before
	public void setUp() throws Exception {
		recepcioner = new Recepcioner();
		recepcioner.setRecepcionerID(1l);
		recepcioner.setImeRecepcionera("Pera");
		recepcioner.setPrezimeRecepcionera("Peric");
		recepcioner.setKorisnickoIme("Pera");
		recepcioner.setLozinka("perapera");
	}

	@After
	public void tearDown() throws Exception {
		recepcioner = null;
	}

	@Test
	public void testSetRecepcionerID() {
		recepcioner.setRecepcionerID(2l);
		
		assertEquals(Long.valueOf(2), recepcioner.getRecepcionerID());
	}

	@Test
	public void testSetImeRecepcionera() {
		recepcioner.setImeRecepcionera("Mika");
		
		assertEquals("Mika", recepcioner.getImeRecepcionera());
	}

	@Test
	public void testSetPrezimeRecepcionera() {
		recepcioner.setPrezimeRecepcionera("Mikic");
		
		assertEquals("Mikic", recepcioner.getPrezimeRecepcionera());
	}

	@Test
	public void testSetKorisnickoIme() {
		recepcioner.setKorisnickoIme("Miki");
		
		assertEquals("Miki", recepcioner.getKorisnickoIme());
	}

	@Test
	public void testSetPassword() {
		recepcioner.setLozinka("mikamika123");
		
		assertEquals("mikamika123", recepcioner.getLozinka());
	}

	@Test
	public void testToString() {
		String s = recepcioner.toString();
		assertTrue(s.contains("Pera"));
		assertTrue(s.contains("Peric"));
	}

	@Test
	public void testGetTableName() {
		assertEquals("recepcioner", recepcioner.getImeTabele());
	}

	@Test
	public void testGetParameters() {
		assertEquals("1,'Pera','Peric','Pera','perapera'", recepcioner.getParametre());
	}

	@Test
	public void testGetParameterNames() {
		assertEquals("recepcionerID,imeRecepcionera,prezimeRecepcionera,korisnickoIme,password", recepcioner.getImenaParametara());
	}

	@Test
	public void testGetPrimaryKeyName() {
		assertEquals("recepcionerID", recepcioner.getImePrimarnogKljuca());
	}

	@Test
	public void testGetPrimaryKeyValue() {
		assertEquals(Long.valueOf(1), recepcioner.getVrednostPrimarnogKljuca());
	}

	

	@Test
	public void testGetUpdateQuery() {
		assertEquals("recepcionerID = 1, imeRecepcionera = 'Pera', prezimeRecepcionera = 'Peric', korisnickoIme = 'Pera', password = 'perapera'", recepcioner.getUpitAzuriranje());
	}

	@Test
	public void testGetComplexPrimaryKey() {
		assertEquals(null, recepcioner.getSlozeniPrimarniKljuc());
	}

}
