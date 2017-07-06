package zadanie1;

public class PallindromChecker {
	
	public static boolean isPalindrom(String text) {
		String _text = text.replaceAll("[ ,.!?]", "");
		if(_text.length() < 2)
			return true;
		if(_text.toCharArray()[0] == _text.toCharArray()[_text.length()-1])
		{
			return isPalindrom(_text.substring(1, _text.length()-1));
		}
		return false;		
	}
}
