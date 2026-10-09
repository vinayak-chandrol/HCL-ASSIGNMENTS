package basics;
import java.util.*;

public class StringFunctions {
	
	
	public static void main(String[] Args) {
		Scanner sc = new Scanner(System.in);
		String s = "Vinayak Chandrol";
		
		System.out.println("charAtfunction " + s.charAt(0));
		System.out.println("substring function " + s.substring(0,8));
		System.out.println("length function " + s.length());
		System.out.println("empty function "+s.isEmpty());
		System.out.println("Contains function " + s.contains("Chandrol"));
		System.out.println("replace function "+ s.replace("V","I"));
		System.out.println("Compare: " + s.compareTo("Vinayak"));
	    System.out.println("Contains: " + s.contains("Vinay"));
	    System.out.println("Index: " + s.indexOf("Chandrol"));
	    System.out.println("Last Index: " + s.lastIndexOf("r"));
	    System.out.println("Starts With: " + s.startsWith("Vinayak"));
	    System.out.println("Ends With: " + s.endsWith("World"));
	    System.out.println("Matches: " + s.matches("Hello World"));
	    System.out.println("Substring: " + s.substring(6));
	    System.out.println("Lowercase: " + s.toLowerCase());
	    System.out.println("Trim: " + s.trim());
	    
	    String[] parts = s.split(" ");
        for (String part : parts) {
            System.out.println(part);
        }
        
        System.out.println("Join: " + String.join("-", "vinayak", "chandrol")); 
	    sc.close();
	}
}
