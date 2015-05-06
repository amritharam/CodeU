import java.io.*;
import java.util.HashSet;

public class boggle {
	private static HashSet<String> dict;
	private static char[][] grid = {{'w','y','e','s'},{'a','h','r','a'},{'s','i','n','t'},{'a','d','l','y'}};
	private static boolean[][] visited;
	public static void main(String arp[]) throws IOException {
		dict = new HashSet<>();
		visited = new boolean[4][4];
		dict.add("was");
		dict.add("shin");
		dict.add("his");
		dict.add("sear");
		dict.add("years");
		dict.add("sadly"); 
		dict.add("sin");
		printAllWords();
	}

	private static void findWords(int i, int j, String s) {
		visited[i][j] = true;
		s+=grid[i][j];
		if (isValid(s)) {
			System.out.println(s);
		}

		//Traverse in all 8 directions
		for(int row = i-1; row <= i+1 && row < 4; row++) {
			for(int col = j-1; col <= j+1 && col < 4; col++) {
				if (row>= 0 && col >=0 && !visited[row][col]) {
					findWords(row, col, s); //so while it recurses through, the visited will be true
					//so that it doesn't reuse that tile
					visited[row][col] = false; //now we want to clear up that character and take another path
					s = s.substring(0,s.length());
			}
			}
		}
	}

	private static void printAllWords() {
		for (int i = 0; i < 4; i++ ) {
			for(int j = 0; j < 4; j++) {
				visited[i][j] = false;
			}
		}

		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				findWords(i,j,"");
				visited[i][j] = false;
			}
		}

	}

	private static boolean isValid(String s) {
		if (dict.contains(s)) {
			return true;
		}
		return false;
	}
}