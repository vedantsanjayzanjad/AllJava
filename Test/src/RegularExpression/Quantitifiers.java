package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quantitifiers {
	public static void main(String[] args) {
		int count =0;
		Pattern p = Pattern.compile("a?");
		Matcher m = p.matcher("ababababaab");
		while(m.find())
		{
			count++;
			System.out.println(m.start()+" "+m.group());
		}
		System.out.println("number of occurance " + count);
	}
}
