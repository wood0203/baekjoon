import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		String line;
		int totalCnt = 0;
		while ((line = br.readLine()) != null) {
			if (!map.containsKey(line)) {
				map.put(line, 1);
			} else {
				map.put(line, map.get(line) + 1);
			}
			totalCnt++;
		}
		
		StringBuilder sb = new StringBuilder();
		List<String> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet);
		for (String key: keySet) {
			sb.append(key).append(" ").append(String.format("%.4f", map.get(key) * 100.0 / totalCnt)).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
