<<<<<<<< HEAD:src/test/java/CommonMethods/RandomStrings.java
package CommonMethods;
========
package commonUtil;
>>>>>>>> 87aa608 ( minor updates):src/main/java/commonUtil/RandomStrings.java

public class RandomStrings {
    public static String RequiredString(int n)
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz" + "               ";
		StringBuilder s = new StringBuilder(n);
		int y;
		for (y = 0; y < n; y++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			s.append(AlphaNumericString.charAt(index));
		}
		return s.toString();
	}
    
    public static String RequiredCharacters(int n)
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +  "abcdefghijklmnopqrstuvxyz";
		StringBuilder s = new StringBuilder(n);
		int y;
		for (y = 0; y < n; y++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			s.append(AlphaNumericString.charAt(index));
		}
		return s.toString();
	}
    
    public static String RequiredDigits(int n)
    {
        String AlphaNumericString = "1234567890";
		StringBuilder s = new StringBuilder(n);
		int y;
		for (y = 0; y < n; y++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			s.append(AlphaNumericString.charAt(index));
		}
		return s.toString();
	}
}
