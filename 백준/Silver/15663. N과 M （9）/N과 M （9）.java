import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] nums, current;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

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
            for (int t: current) {
                sb.append(t).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || before == nums[i]) continue;

            current[cnt] = nums[i];
            visited[i] = true;
            before = nums[i];
            combi(index + 1, cnt + 1);
            current[cnt] = 0;
            visited[i] = false;
        }
    }

}