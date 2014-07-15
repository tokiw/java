package ex24_1;

import java.util.ListResourceBundle;

public class GlobalRes extends ListResourceBundle {
	public static final String HELLO = "Hello";
    public static final String GOODBYE = "Goodbye";
    
	@Override
	protected Object[][] getContents() {
		return contents;
	}
	
	public static final Object[][] contents = {
		{ GlobalRes.HELLO, "Ciao" },
		{ GlobalRes.GOODBYE, "Ciao" },
	};
}
