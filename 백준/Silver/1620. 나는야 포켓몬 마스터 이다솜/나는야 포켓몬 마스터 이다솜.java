import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		HashMap<String, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		String[] poketmons = new String[n + 1];
		for (int i = 1; i <= n; i++) {
			String poket = br.readLine();
			poketmons[i] = poket;
			map.put(poket, i);
		}
		
		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			try {
				int value = Integer.parseInt(input);
				sb.append(poketmons[value]).append("\n");
			} catch (Exception e) {
				sb.append(map.get(input)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}