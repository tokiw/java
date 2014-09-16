package ex24_3;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DateParser {
	public static void parseShow(String date, Locale locale) {
		DateFormat df = DateFormat.getDateInstance();
		DateFormat shortDf = DateFormat.getDateInstance(DateFormat.SHORT);
		DateFormat mediumDf = DateFormat.getDateInstance(DateFormat.MEDIUM);
		DateFormat longDf = DateFormat.getDateInstance(DateFormat.LONG);
		DateFormat fullDf = DateFormat.getDateInstance(DateFormat.FULL);
		
		try {
			Date parse = df.parse(date);
			System.out.println(shortDf.format(parse));
			System.out.println(mediumDf.format(parse));
			System.out.println(longDf.format(parse));
			System.out.println(fullDf.format(parse));

		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DateParser.parseShow("2014/07/03", Locale.JAPAN);
		//DateParser.parseShow("2014年7月3日", Locale.JAPAN);
		//DateParser.parseShow("2014.7.3", Locale.JAPAN);
		DateParser.parseShow("2014/7/3 21:21:21", Locale.JAPAN);
	}
}
