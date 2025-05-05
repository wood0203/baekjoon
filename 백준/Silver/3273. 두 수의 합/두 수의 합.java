import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, target;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		target = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		int answer = 0;
		int start = 0;
		int end = N - 1;
		while (start < end) {
			int sum = arr[start] + arr[end];
			if (sum == target) {
				answer++;
				end--;
			}
			else if (sum > target) {
				end--;
			}
			else {
				start++;
			}
		}
		
		System.out.println(answer);
	}

}