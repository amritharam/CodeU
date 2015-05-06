import java.io.*;
import java.util.HashSet;
public class didyoumean {
	private static HashSet<String> existing;
	public static void main(String ar[]) throws IOException {
		InputStreamReader br = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(br);
		System.out.println("Enter the string.");
		String s = in.readLine();
		existing = new HashSet<>();
		existing.add("apple");
		existing.add("pie");
		existing.add("app");
		existing.add("leg");
		existing.add("rill");
		//splitstring(s);
		String result = splitrec(s);
		if (result.length() < s.length()) {
			System.out.println("No suggestions available.");
		} else {
			System.out.println("Did you mean : " + result +"?");
		}
	}
	//IMPLEMENTATION ONE
	private static void splitstring(String s) {
		int i = 0;
		//probably a naive implementation. 
		//Other ideas: tries? How do you code a trie? :/ Or checking different substrings if they are present
		//in the dictionary. How would this work? 
		String sub = s.substring(0,1);
		boolean flag = false;
		while (i < s.length() && !flag) {
			sub = s.substring(0,i);
			if(existing.contains(sub) && existing.contains(s.substring(i))) {
				System.out.println("Did you mean: '" + sub + " " + s.substring(i) + "'?");
				flag = true;
			}
			i++;
		}
		if (!flag) {
			System.out.println("No suggestions available.");
		}
	}


//IMPLEMENTATION TWO
	private static String splitrec(String s) {
		if(s == "") {
			return "";
		}
		//System.out.println(s);
		int i = 0;
		String sub = s.substring(0,1);
		String build = "";
		boolean flag = false;
		while (i <= s.length() && !flag) {
			sub = s.substring(0,i);
			if (existing.contains(sub)) {
				flag = true;
				if (i!=s.length()) {
					build = build + sub + " " + splitrec(s.substring(i));
				} else {
					build = build + sub;
				}
			}
			i++;
		}

		return build;
	}

}