import java.io.*;
import java.util.ArrayList;

public class uglyNo {
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String ar[]) throws IOException {
		list.add(1);
		InputStreamReader br = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(br);
		System.out.println("Enter a number!");
		int num = Integer.parseInt(in.readLine());
		int result = findugly(num);
		System.out.println("The result is = " + result);
	}

	private static int findugly(int num) {
		//here num is the kth number.
		if (num < list.size()) {
			return list.get(num-1);
		}
		int lastnum = list.get(list.size() - 1);
		//System.out.println("Last = " + lastnum);
		lastnum++;
		int counter = list.size();
		while (counter < num) {
			if (isugly(lastnum)) {
				counter++;
				list.add(lastnum);
			}
			lastnum++;
		}
		return list.get(list.size()-1);
	}

	// private static boolean isugly(int n) {
	// 	while (n> 1 && (n%2==0 || n%3==0 || n%5 ==0)) {
	// 		if (n%2 == 0) {
	// 			n = n/2;
	// 		} else if (n%3==0) {
	// 			n = n/3;
	// 		} else if (n%5 ==0) {
	// 			n = n/5;
	// 		}
	// 	}
	// 	if(n==1) {
	// 		return true;
	// 	}
	// 	return false;
	// }
//MORE EFFICIENT
	private static boolean isugly(int n) {
		boolean flag = true;
		if (n==1 || list.contains(n)) {
			return true;
		}
		while(flag && (n%2==0 || n%3==0 || n%5 ==0)) {
			if (n%2 == 0) {
				n = n/2;
				return isugly(n);
			} else if (n%3==0) {
				n = n/3;
				return isugly(n);
			} else if (n%5==0) {
				n = n/5;
				return isugly(n);
			} else {
				flag = false;
			}
		}
		if (flag) {
			return false;
		}
		return true;


	}

}
