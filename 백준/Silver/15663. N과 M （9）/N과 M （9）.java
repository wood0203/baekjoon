import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] nums, current;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static HashSet<String> made = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        visited = new boolean[N];
        nums = new int[N];
        current = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        combi(0, 0);
        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }

    static void combi(int index, int cnt) {
        if (cnt == M) {
            String temp = "";
            for (int t: current) {
                temp += (t + " ");
            }
            
            if (made.contains(temp)) return;
            made.add(temp);
            sb.append(temp).append("\n");
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            current[cnt] = nums[i];
            visited[i] = true;
            combi(index + 1, cnt + 1);
            current[cnt] = 0;
            visited[i] = false;
        }
    }

}