package b_Money;

public class Money implements Comparable {
	private int amount;
	private Currency currency;

	Money (Integer amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public Integer getAmount() {
		return amount;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	
	/**
	 * Returns the amount of the money in the string form "(amount) (currencyname)", e.g. "10.5 SEK".
	 * Recall that we represent decimal numbers with integers. This means that the "10.5 SEK" mentioned
	 * above is actually represented as the integer 1050
	 */
	public String toString() {
		return amount/100 + " " + currency;
	}
	
	public Integer universalValue() {
		return currency.universalValue(amount);
	}

	public Boolean equals(Money other) {
		if(this.universalValue()==other.universalValue()) 
			return true;
		return false;
	}
	
	public Money add(Money other) {
		int summedamount = this.amount + currency.valueInThisCurrency(other.amount, other.currency);
		return new Money(summedamount, this.currency);
	}

	public Money sub(Money other) {
		int subamount = this.amount - currency.valueInThisCurrency(other.amount, other.currency);
		return new Money(subamount, this.currency);
	}

	public Boolean isZero() {
		if(amount==0)
			return true;
		return false;
	}

	public Money negate() {
		return new Money(-this.amount, this.currency);
	}

	public int compareTo(Object other) {
		if(this.equals(other))
			return 0;
		if(this.universalValue()>((Money) other).universalValue())
			return 1;
		return -1; 
	}
}