package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEgDemo 
{
	public static void main(String[] args) {
		int count =0;
		Pattern p = Pattern.compile("ab");
		Matcher m = p.matcher("ababababaab");
		while(m.find())
		{
			count++;
			System.out.println(m.start()+" "+ m.end()+ " "+m.group());
		}
		System.out.println("number of occuranceb " + count);
	}
}
