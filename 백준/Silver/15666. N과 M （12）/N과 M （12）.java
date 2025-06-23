import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] nums, current;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        nums = new int[N + 1];
        current = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        backTrack(1, 0);
        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }

    public static void backTrack(int index, int cnt) {
        if (cnt == M) {
            for (int num: current) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i <= N; i++) {
            if (nums[i] == nums[i - 1]) continue;

            current[cnt] = nums[i];
            backTrack(i, cnt + 1);
            current[cnt] = 0;
        }
    }

}