package RegularExpression;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splits {
	public static void main(String[] args) {
		Pattern p = Pattern.compile(" ");
		String[] str  = p.split("what Is Your Name");
		for(String s1:str) 
		{
			System.out.println(s1);
		}
//		StringTokenizer st = new StringTokenizer("what Is YourName");
//		while(st.hasMoreTokens())
//		{
//			System.out.println(st.nextToken());
//		}
		StringTokenizer st = new StringTokenizer("what-Is-YourName","-");
		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}
	}
}
