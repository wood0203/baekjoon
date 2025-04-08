import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> LIS = new ArrayList<>();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		LIS.add(arr[0]);
		for (int i = 1; i < N; i++) {
			if (LIS.get(LIS.size() - 1) < arr[i]) {
				LIS.add(arr[i]);
			} else {
				int index = Collections.binarySearch(LIS, arr[i]);
				if (index < 0) {
					index = (index + 1) * -1;
					LIS.set(index, arr[i]);
				}
			}
		}

		System.out.println(LIS.size());
	}
}