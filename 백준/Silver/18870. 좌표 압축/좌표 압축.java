import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] sorted = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sorted[i] = nums[i];
		}
		Arrays.sort(sorted);
		
		int rank = 0;
		for (Integer x: sorted) {
			if (map.containsKey(x)) {
				continue;
			} else {
				map.put(x, rank++);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (Integer key: nums) {
			sb.append(map.get(key)).append(" ");
		}
		System.out.println(sb.toString());
	}

}
