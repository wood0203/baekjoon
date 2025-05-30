import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static class Node implements Comparable<Node> {
		int value;
		int absValue;
		
		Node(int value) {
			this.value = value;
			this.absValue = Math.abs(value);
		}

		public int compareTo(Node n) {
			if (n.absValue == this.absValue) {
				return Integer.compare(this.value, n.value);
			}

			return Integer.compare(this.absValue, n.absValue);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> queue = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if (queue.isEmpty()) {
					sb.append(0);
				} else {
					sb.append(queue.poll().value);
				}
                sb.append("\n");
			} else {
				queue.offer(new Node(input));
			}
		}
		
		System.out.println(sb.toString());
	}

}
