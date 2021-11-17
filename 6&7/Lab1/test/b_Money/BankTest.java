package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("SweBank", SweBank.getName());
		assertEquals("Nordea", Nordea.getName());
		assertEquals("DanskeBank", DanskeBank.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK, SweBank.getCurrency());
		assertEquals(SEK, Nordea.getCurrency());
		assertEquals(DKK, DanskeBank.getCurrency());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		fail("Write test case here");
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		int before = SweBank.getBalance("Ulrika");
		SweBank.deposit("Ulrika", new Money(10000, SEK));
		assertEquals(before+10000, SweBank.getBalance("Ulrika").intValue());
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		int before = SweBank.getBalance("Ulrika");
		SweBank.withdraw("Ulrika", new Money(1000, SEK));
		assertEquals(before-1000, SweBank.getBalance("Ulrika").intValue());
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		try {
			SweBank.openAccount("Magdalena");
		} catch (AccountExistsException e) {}
		assertEquals(0, SweBank.getBalance("Magdalena").intValue());
		SweBank.deposit("Magdalena", new Money(100000, SEK));
		assertEquals(100000, SweBank.getBalance("Magdalena").intValue());
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		int uBefore = SweBank.getBalance("Ulrika");
		int bBefore = SweBank.getBalance("Bob");
		SweBank.transfer("Ulrika", "Bob", new Money(100, SEK));
		assertEquals(uBefore-100, SweBank.getBalance("Ulrika").intValue());
		assertEquals(bBefore+100, SweBank.getBalance("Bob").intValue());
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		fail("Write test case here");
	}
}
