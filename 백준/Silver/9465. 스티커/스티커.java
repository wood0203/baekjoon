import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][N + 1];
            int[][] stickers = new int[2][N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                stickers[0][i] = Integer.parseInt(st.nextToken());
            }
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                stickers[1][i] = Integer.parseInt(st2.nextToken());
            }

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];
            for (int i = 2; i <= N; i++) {
                dp[0][i] = Integer.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
                dp[1][i] = Integer.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
            }

            sb.append(Integer.max(dp[0][N], dp[1][N])).append("\n");            
        }

        System.out.println(sb.toString());
    }

}