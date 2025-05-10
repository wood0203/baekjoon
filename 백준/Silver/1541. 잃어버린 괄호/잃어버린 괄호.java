import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
		ArrayList<String> arr = new ArrayList<>();
		while (st.hasMoreTokens()) {
			arr.add(st.nextToken());
		}
		
		int answer = Integer.parseInt(arr.get(0));
		int start = 1;
		int end = 1;
		int temp = 0;
		boolean isMinus = false;
		while (end < arr.size()) {
			if (arr.get(end).equals("-")) {
				if (isMinus) {
					answer -= temp;
					temp = 0;
				}
				
				temp += Integer.parseInt(arr.get(end + 1));
				start = end;
				isMinus = true;
			}
			else {
				if (isMinus) {
					temp += Integer.parseInt(arr.get(end + 1));
				} else {
					answer += Integer.parseInt(arr.get(end + 1));
				}
			}
			
			end += 2;
		}

		answer -= temp;
		System.out.println(answer);
	}
}