import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static class Member implements Comparable<Member> {
		int age;
		String name;
		int order;
		
		public Member(int age, String name, int order) {
			this.age = age;
			this.name = name;
			this.order = order;
		}

		@Override
		public int compareTo(Member o) {
			if (age == o.age) {
				return Integer.compare(order, o.order);
			}
			
			return Integer.compare(age, o.age);
		}
		
		
	}
	
	static ArrayList<Member> arr = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int age = Integer.parseInt(input[0]);
			arr.add(new Member(age, input[1], i));
		}
		
		Collections.sort(arr);
		for (Member m: arr) {
			sb.append(m.age).append(" ").append(m.name).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
