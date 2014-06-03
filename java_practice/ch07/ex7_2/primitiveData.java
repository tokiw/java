package ex7_2;

public class primitiveData {
	static boolean booleanValue = true;
	static char charValue = '1';
	static byte byteValue = 1;
	static short shortValue = 1;
	static int intValue = 1;
	static long longValue = 1L;
	static float floatValue = 1.8F;
	static double doubleValue = 1.8;
	
	public static void main(String[] args) {
		/*boolean*/
		booleanValue = false;
		//booleanValue = charValue;
		//booleanValue = byteValue;
		//booleanValue = shortValue;
		//booleanValue = intValue;
		//booleanValue = longValue;
		//booleanValue = floatValue;
		//booleanValue = doubleValue;
		
		/*char*/
		charValue = 0xFFFF;
		//charValue = booleanValue;
		//charValue = byteValue;
		//charValue = shortValue;
		//charValue = intValue;
		//charValue = longValue;
		//charValue = floatValue;
		//charValue = doubleValue;
		
		/*byte*/
		byteValue = 127;
		//byteValue = 128;
		byteValue = -128;
		//byteValue = -129;
		//byteValue = booleanValue;
		//byteValue = charValue;
		//byteValue = shortValue;
		//byteValue = intValue;
		//byteValue = longValue;
		//byteValue = floatValue;
		//byteValue = doubleValue;
		
		/*short*/
		shortValue = 32767;
		//shortValue = 32768;
		shortValue = -32768;
		//shortValue = -32769;
		//shorteValue = booleanValue;
		//shortValue = charValue;
		shortValue = byteValue;
		//shortValue = intValue;
		//shortValue = longValue;
		//shortValue = floatValue;
		//shortValue = doubleValue;
		
		/*int*/
		intValue = 2147483647;
		//intValue = 2147483648;
		intValue = -2147483648;
		//intValue = -2147483649;
		//intValue = booleanValue;
		intValue = charValue;
		intValue = byteValue;
		intValue = shortValue;
		//intValue = longValue;
		//intValue = floatValue;
		//intValue = doubleValue;
		
		/*long*/
		longValue = 9223372036854775807L;
		//longValue = 9223372036854775808L;
		longValue = -9223372036854775808L;
		//longValue = -9223372036854775809L;
		//longValue = booleanValue;
		longValue = charValue;
		longValue = byteValue;
		longValue = shortValue;
		longValue = intValue;
		//longValue = floatValue;
		//longValue = doubleValue;
		
		/*float*/
		//floatValue = booleanValue;
		floatValue = charValue;
		floatValue = byteValue;
		floatValue = shortValue;
		floatValue = intValue;
		floatValue = longValue;
		//floatValue = doubleValue;
		
		/*double*/
		//doubleValue = booleanValue;
		doubleValue = charValue;
		doubleValue = byteValue;
		doubleValue = shortValue;
		doubleValue = intValue;
		doubleValue = longValue;
		doubleValue = floatValue;
	}
}
