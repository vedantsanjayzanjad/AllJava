package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharactorClasses {
	
	public static void main(String[] args) {
		Pattern p = Pattern.compile("[^a-zA-Z0-9]");
		Matcher m = p.matcher("a7@@12&ds");
		while(m.find())
		{
			System.out.println(m.group() + "  " + m.start() + " " + m.end());
		}
	}
}
