package ex24_1;

import static org.junit.Assert.*;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class TestGlobalRes {

	@Test
	public void test() {
		Locale.setDefault(Locale.ENGLISH);
		ResourceBundle rb = ResourceBundle.getBundle("ex24_1.GlobalRes");
		assertEquals(rb.getString(GlobalRes.HELLO), "Hello");
		assertEquals(rb.getString(GlobalRes.GOODBYE), "Goodbye");

		Locale locale = new Locale("en", "AU");
		Locale.setDefault(locale);
		rb = ResourceBundle.getBundle("ex24_1.GlobalRes");
		assertEquals("G'day", rb.getString(GlobalRes.HELLO));

		locale = new Locale("ja");
		Locale.setDefault(locale);
		rb = ResourceBundle.getBundle("ex24_1.GlobalRes");
		assertEquals("‚±‚ñ‚É‚¿‚Í", rb.getString(GlobalRes.HELLO));
		assertEquals("‚³‚æ‚¤‚È‚ç", rb.getString(GlobalRes.GOODBYE));
	}

}
