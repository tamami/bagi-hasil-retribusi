package lab.aikibo.test;

import static org.junit.Assert.*;
import lab.aikibo.manager.BulanManager;

import org.junit.Before;
import org.junit.Test;

public class BulanManagerTest {
	private BulanManager bm;
	
	@Before
	public void init() {
		bm = new BulanManager();
	}

	@Test
	public void testBulanFormatted() {
		assertEquals("01 - JANUARI", bm.getFormattedBulanByName("JANUARI"));
	}
	
	@Test
	public void testIndexBulan() {
		assertEquals(new Integer(0), bm.getIndexBulanByName("JANUARI"));
	}

}
