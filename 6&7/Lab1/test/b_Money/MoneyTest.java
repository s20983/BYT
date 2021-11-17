package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
		assertEquals(10000, SEK100.getAmount().intValue());
		assertEquals(1000, EUR10.getAmount().intValue());
		assertEquals(20000, SEK200.getAmount().intValue());
		assertEquals(2000, EUR20.getAmount().intValue());
		assertEquals(0, SEK0.getAmount().intValue());
		assertEquals(0, EUR0.getAmount().intValue());
		assertEquals(-10000, SEKn100.getAmount().intValue());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK, SEK100.getCurrency());
		assertEquals(EUR, EUR10.getCurrency());
		assertEquals(SEK, SEK200.getCurrency());
		assertEquals(EUR, EUR20.getCurrency());
		assertEquals(SEK, SEK0.getCurrency());
		assertEquals(EUR, EUR0.getCurrency());
		assertEquals(SEK, SEKn100.getCurrency());
	}

	@Test
	public void testToString() {
		assertEquals("100.00 SEK", SEK100.toString());
		assertEquals("10.00 EUR", EUR10.toString());
		assertEquals("20.00 EUR", EUR20.toString());
		assertEquals("0.00 SEK", SEK0.toString());
		assertEquals("0.00 EUR", EUR0.toString());
		assertEquals("-100.00 SEK", SEKn100.toString());
	}

	@Test
	public void testGlobalValue() {
		assertTrue((100*0.15)==SEK100.universalValue());
		assertTrue((10*1.5)==EUR10.universalValue());
		assertTrue((20*1.5)==EUR20.universalValue());
	}

	@Test
	public void testEqualsMoney() {
		assertFalse(SEK100.equals(SEK0));
		assertFalse(SEK100.equals(SEKn100));
	}

	@Test
	public void testAdd() {
		assertEquals(0, SEK100.add(SEKn100));
		assertEquals(30, EUR10.add(EUR20));
	}

	@Test
	public void testSub() {
		assertEquals(200, SEK100.sub(SEKn100));
		assertEquals(-10, EUR10.sub(EUR20));
	}

	@Test
	public void testIsZero() {
		assertFalse(SEK100.isZero());
		assertFalse(EUR10.isZero());
		assertFalse(SEK200.isZero());
		assertFalse(EUR20.isZero());
		assertTrue(SEK0.isZero());
		assertTrue(EUR0.isZero());
		assertFalse(SEKn100.isZero());
	}

	@Test
	public void testNegate() {
		assertTrue(SEK100.negate().getAmount().intValue()<0);
		assertTrue(EUR10.negate().getAmount().intValue()<0);
		assertTrue(SEK200.negate().getAmount().intValue()<0);
		assertTrue(EUR20.negate().getAmount().intValue()<0);
		assertFalse(SEKn100.negate().getAmount().intValue()<0);
	}

	@Test
	public void testCompareTo() {
		assertTrue(EUR20.compareTo(new Money(2000, EUR))==0);
	}
}
