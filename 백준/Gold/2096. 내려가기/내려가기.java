import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[N][3][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                dp[i][j][0] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0][1] = dp[0][0][0];
        dp[0][0][2] = dp[0][0][0];
        dp[0][1][1] = dp[0][1][0];
        dp[0][1][2] = dp[0][1][0];
        dp[0][2][1] = dp[0][2][0];
        dp[0][2][2] = dp[0][2][0];

        // 1 -> 최대 / 2 -> 최소
        for (int i = 1; i < N; i++) {
            int bLeftMax = dp[i - 1][0][1];
            int bLeftMin = dp[i - 1][0][2];
            int bMidMax = dp[i - 1][1][1];
            int bMidMin = dp[i - 1][1][2];
            int bRightMax = dp[i - 1][2][1];
            int bRightMin = dp[i - 1][2][2];
            dp[i][0][1] = dp[i][0][0] + Integer.max(bLeftMax, bMidMax);
            dp[i][1][1] = dp[i][1][0] + Integer.max(bLeftMax, Integer.max(bMidMax, bRightMax));
            dp[i][2][1] = dp[i][2][0] + Integer.max(bRightMax, bMidMax);
            dp[i][0][2] = dp[i][0][0] + Integer.min(bLeftMin, bMidMin);
            dp[i][1][2] = dp[i][1][0] + Integer.min(bLeftMin, Integer.min(bMidMin, bRightMin));
            dp[i][2][2] = dp[i][2][0] + Integer.min(bRightMin, bMidMin);
        }

        int max = Integer.max(dp[N - 1][0][1], Integer.max(dp[N - 1][1][1], dp[N - 1][2][1]));
        int min = Integer.min(dp[N - 1][0][2], Integer.min(dp[N - 1][1][2], dp[N - 1][2][2]));
        System.out.println(max + " " + min);
    }

}