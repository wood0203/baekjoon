import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	static HashSet<Integer> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			String[] inputs = br.readLine().split(" ");
			if (inputs.length == 2) {
				int value = Integer.parseInt(inputs[1]);
				if (inputs[0].equals("add")) {
					set.add(value);
				} else if(inputs[0].equals("remove")) {
					set.remove(value);
				} else if(inputs[0].equals("check")) {
					if (set.contains(value) == false) {
						sb.append("0").append("\n");
					} else {
						sb.append("1").append("\n");
					}
				} else if (inputs[0].equals("toggle")){
					if (set.contains(value)) {
						set.remove(value);
					} else {
						set.add(value);
					}
				}
			} else if (inputs.length == 1){
				if (inputs[0].equals("all")) {
					Integer[] arr = new Integer[20];
					for (int j = 1; j <= 20; j++)
						arr[j - 1] = j;

					set = new HashSet<Integer>(Arrays.asList(arr));
				} else if (inputs[0].equals("empty")){
					set.clear();
				}
			}
		}
		System.out.println(sb.toString());
	}
}
