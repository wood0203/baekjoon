import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
        	String[] inputs = br.readLine().split(" ");
        	int[] arr = new int[3];
        	int total = 0;
        	for (int i = 0; i < 3; i++) {
        		arr[i] = Integer.parseInt(inputs[i]);
        		total += arr[i];
        	}
        	
        	if (total == 0) {
        		break;
        	}
        	
        	Arrays.sort(arr);
        	int squareX = arr[0] * arr[0];
        	int squareY = arr[1] * arr[1];
        	int squareZ = arr[2] * arr[2];
        	if (squareX + squareY == squareZ) {
        		sb.append("right");
        	} else {
        		sb.append("wrong");
        	}
        	sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}