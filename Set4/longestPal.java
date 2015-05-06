import java.io.*;
public class longestPal {
	public static void main(String ar[]) throws IOException {
		InputStreamReader br = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(br);
		System.out.println("Enter a string");
		String s = in.readLine();
		String result = findlongest(s);
		System.out.println("Result = "+result);
	}

	private static String findlongest(String s) {
		if (s.length() == 1) {
			return s;
		}
		String longest = s.substring(0,1);
		for (int i = 0; i <s.length(); i++) {
			String temp = sub(s, i, i);
			if(temp.length() > longest.length()) {
				longest = temp;
			}
			//but what if it's an even number of letters in the substring
			//looked this up. didn't think of this.
			temp = sub(s, i, i+1);
			if(temp.length() > longest.length()) {
				longest = temp;
			}
		}
		return longest;
	}

	private static String sub(String s, int start, int end) {
		while(start >= 0 && end < s.length() && s.charAt(start)==s.charAt(end)) {
			start--;
			end++;
		}
		return s.substring(start+1, end);
	}
}