package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals("SEK", SEK.getName());
		assertEquals("DKK", DKK.getName());
		assertEquals("EUR", EUR.getName());
	}
	
	@Test
	public void testGetRate() {
		assertTrue(0.15==SEK.getRate());
		assertTrue(0.20==DKK.getRate());
		assertTrue(1.5==EUR.getRate());
	}
	
	@Test
	public void testSetRate() {
		SEK.setRate(0.16);
		assertTrue(0.16==SEK.getRate());
		DKK.setRate(0.21);
		assertTrue(0.21==DKK.getRate());
		EUR.setRate(1.51);
		assertTrue(1.51==EUR.getRate());
	}
	
	@Test
	public void testGlobalValue() {
		assertTrue((100*0.15)==SEK.universalValue(100));
		assertTrue((100*0.20)==DKK.universalValue(100));
		assertTrue((100*1.5)==EUR.universalValue(100));
	}
	
	@Test
	public void testValueInThisCurrency() {
		SEK.setRate(0.2);
		DKK.setRate(0.15);
		EUR.setRate(1.5);
		assertTrue((100*0.15/0.2)==SEK.valueInThisCurrency(100, DKK));
		assertTrue((100*0.2/1.5)==DKK.valueInThisCurrency(100, EUR));
		assertTrue((100*1.5/0.15)==EUR.valueInThisCurrency(100, SEK));
	}

}
