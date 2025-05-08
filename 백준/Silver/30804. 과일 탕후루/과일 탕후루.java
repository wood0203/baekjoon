import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] fruits = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0; 
		int end = 0;
		int answer = 0;
		HashMap<Integer, Integer> types = new HashMap<>();
		while (end < N) {
			// 현재 end위치 포함시 2개 이상일 경우 -> start += 1
			if (types.get(fruits[end]) == null && types.keySet().size() == 2) {
				int remainCnt = types.get(fruits[start]);
				if (remainCnt == 1) {
					types.remove(fruits[start]);
				} else {
					types.put(fruits[start], remainCnt - 1);
				}
				start += 1;
			} else {
				int fruitCnt = types.getOrDefault(fruits[end], 0) + 1;
				types.put(fruits[end], fruitCnt);
				answer = Integer.max(answer, end - start + 1);
				end += 1;
			}
		}
		
		System.out.println(answer);
	}

}