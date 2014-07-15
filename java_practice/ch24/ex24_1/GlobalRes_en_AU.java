package ex24_1;

import java.util.ListResourceBundle;

public class GlobalRes_en_AU extends ListResourceBundle {
	public static final String HELLO = "Hello";
	public static final String GOODBYE = "Goodbye";

	@Override
	protected Object[][] getContents() {
		return contents;
	}
	
	private static final Object[][] contents = {
			{ GlobalRes.HELLO, "G'day" },
	};
}
