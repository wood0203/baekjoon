import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[K + 1][2];

        if (K <= N) {
            System.out.println(N - K);
            System.out.println(1);
            return;
        }

        for (int i = 0; i <= N; i++) {
            dp[i][0] = N - i;
            dp[i][1] = 1;
        }

        for (int i = N + 1; i <= K; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
            dp[i][1] = dp[i - 1][1];

            if (i % 2 == 0) {
                if (dp[i / 2][0] + 1 < dp[i][0]) {
                    dp[i][0] = dp[i / 2][0] + 1;
                    dp[i][1] = dp[i / 2][1];
                } else if (dp[i / 2][0] + 1 == dp[i][0]) {
                    dp[i][1] += dp[i / 2][1];
                }
            } else {
                if (dp[(i + 1) / 2][0] + 2 < dp[i][0]) {
                    dp[i][0] = dp[(i + 1) / 2][0] + 2;
                    dp[i][1] = dp[(i + 1) / 2][1];
                } else if (dp[(i + 1) / 2][0] + 2 == dp[i][0]) {
                    dp[i][1] += dp[(i + 1) / 2][1];
                }
            }
        }

        System.out.println(dp[K][0]);
        System.out.println(dp[K][1]);

    }

}