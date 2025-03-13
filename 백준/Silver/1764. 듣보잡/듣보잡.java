import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] nm = br.readLine().split(" ");
		HashSet<String> set = new HashSet<>();
		ArrayList<String> arr = new ArrayList<>();
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		for (int i = 0; i < n + m; i++) {
			String word = br.readLine();
			if (set.contains(word)) {
				arr.add(word);
			} else {
				set.add(word);
			}
		}
		Collections.sort(arr);
		sb.append(arr.size()).append("\n");
		for (String a: arr) {
			sb.append(a).append("\n");
		}
		System.out.println(sb.toString());
	}
}