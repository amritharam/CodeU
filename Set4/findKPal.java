import java.io.*;
import java.util.HashMap;
import java.lang.StringBuilder;
public class findKPal {
	static HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

	public static void main(String ar[]) throws IOException {
		InputStreamReader br = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(br);
		System.out.println("Enter a number!");
		int num = Integer.parseInt(in.readLine());
		int result = findpal(num);
		System.out.println("The result is = " + result);
	}

	private static String findBinary(int num) {
		int rem = 0;
		String s = "";
		while (num > 0) {
			int temp = num%2;
			num = num/2;
			s+=((char)(temp+48)); //the +48 took me a lot of time to figure out.
		}
		return s;
	}

	private static int findpal(int num) {
		if (hmap.containsKey(num)) {
			return hmap.get(num);
		} else {
			int counter = 0;
			int i = 1;
			while(counter < num) {
				boolean isPal = isPalindrome(findBinary(i));
				if (isPal) {
					counter++;
				}
				i++;
			}
			hmap.put(num, i);
			return i-1;
		}
	}

	private static boolean isPalindrome(String s) {
		//System.out.println("String received = " + s);
		StringBuilder sb = new StringBuilder(s);
		if(sb.toString().equals(sb.reverse().toString())) {
			//System.out.println("True");
			return true;
		}
		return false;
	}
}