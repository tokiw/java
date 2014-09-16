package ex24_2;

import java.util.Currency;
import java.util.Locale;
import java.util.Map;

public class LocaleCurrency {
	private static Currency[] currency;
	private static final Locale[] LOCALES  = new Locale[] {
		Locale.CHINA,
		Locale.JAPAN,
		Locale.KOREA,
		Locale.US,
		Locale.FRANCE,
		Locale.GERMANY,
	};
	
	public LocaleCurrency() {
		currency = new Currency[LOCALES.length];
		for (int i = 0; i < LOCALES.length; i++) {
			currency[i] = Currency.getInstance(LOCALES[i]);
		}
	}
	
	public void showCurrency() {
		for (int i = 0; i < LOCALES.length; i++) {
			System.out.printf("Country: %-13s Currency: %s%n", LOCALES[i].getDisplayCountry(Locale.US), currency[i].getSymbol());
		}
	}
	
	public static void main(String[] args) {
		LocaleCurrency lc = new LocaleCurrency();
		lc.showCurrency();
	}
}
