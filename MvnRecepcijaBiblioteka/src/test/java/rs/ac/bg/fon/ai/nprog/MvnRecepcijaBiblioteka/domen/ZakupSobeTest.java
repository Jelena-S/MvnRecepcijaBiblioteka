package rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.Gost;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.Recepcioner;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.Soba;

public class ZakupSobeTest {

	ZakupSobe zakupSobe;
	Gost gost;
	Soba soba;
	Recepcioner recepcioner;

	@Before
	public void setUp() throws Exception {
		zakupSobe = new ZakupSobe();
		zakupSobe.setZakupID(1l);
		
		gost = new Gost(10l);
		
		zakupSobe.setGostZakupljuje(gost);
		
		soba = new Soba(100l);
		
		zakupSobe.setZakupljenaSoba(soba);
		
		recepcioner = new Recepcioner(1000l);
		
		zakupSobe.setRecepcioner(recepcioner);
		
		zakupSobe.setCena(100.0);
		zakupSobe.setStatus(true);
		
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss");
		Date datumOd = new Date();
		Date datumDo = new Date();
		datumOd = df.parse("12.12.2020. 12:12:12");
		datumDo = df.parse("15.12.2020. 12:12:12");
		
		zakupSobe.setDatumOd(datumOd);
		zakupSobe.setDatumDo(datumDo);
		
	}

	@After
	public void tearDown() throws Exception {
		zakupSobe = null;
		gost = null;
		soba = null;
		recepcioner = null;
	}

	@Test
	public void testSetCena() {
		assertEquals(Double.valueOf(100), zakupSobe.getCena(), Double.valueOf(0.001));
	}

	@Test
	public void testSetGostZakupljuje() {
		assertEquals(gost, zakupSobe.getGostZakupljuje());
	}

	@Test
	public void testSetZakupljenaSoba() {
		assertEquals(soba, zakupSobe.getZakupljenaSoba());
	}

	@Test
	public void testSetZakupID() {
		assertEquals(Long.valueOf(1), zakupSobe.getZakupID());
	}

	@Test
	public void testSetDatumOd() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss");
		
		try {
			assertEquals(sdf.parse("12.12.2020. 12:12:12"), zakupSobe.getDatumOd());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSetDatumDo() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss");
		
		try {
			assertEquals(sdf.parse("15.12.2020. 12:12:12"), zakupSobe.getDatumDo());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSetRecepcioner() {
		assertEquals(recepcioner, zakupSobe.getRecepcioner());
	}

	@Test
	public void testSetStatus() {
		assertEquals(true, zakupSobe.isStatus());
	}

	@Test
	public void testGetTableName() {
		assertEquals("zakupsobe", zakupSobe.getImeTabele());
	}

	@Test
	public void testGetParameters() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss");
		try {
			assertEquals("10, 100, 1, '"+sdf.parse("12.12.2020. 12:12:12")+"', '"+sdf.parse("15.12.2020. 12:12:12")+"', 100.0, true, 1000", zakupSobe.getParametre());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetParameterNames() {
		assertEquals("gostZakupljujeID,zakupljenaSobaID,zakupID,datumOD,datumDO,cena,recepcionerID,status", zakupSobe.getImenaParametara());
	}

	@Test
	public void testGetPrimaryKeyName() {
		assertEquals(null, zakupSobe.getImePrimarnogKljuca());
	}

	@Test
	public void testGetPrimaryKeyValue() {
		assertEquals(null, zakupSobe.getVrednostPrimarnogKljuca());
	}

	

	@Test
	public void testGetUpdateQuery() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss");
		try {
			assertEquals("gostZakupljujeID = 10, zakupljenaSobaID = 100, zakupID = 1, datumOD = "+sdf.parse("12.12.2020. 12:12:12")+", datumDO = "+sdf.parse("15.12.2020. 12:12:12")+", cena = 100.0, recepcionerID = 1000, status = true", zakupSobe.getUpitAzuriranje());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetComplexPrimaryKey() {
		assertEquals("WHERE gostZakupljujeID=10 AND zakupljenaSobaID=100 AND zakupID=1", zakupSobe.getSlozeniPrimarniKljuc());
	}

}
