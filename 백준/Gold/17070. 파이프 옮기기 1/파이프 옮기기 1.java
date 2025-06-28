import java.util.*;
import java.io.*;

public class Main {

    static int[][] house;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        house = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
                house[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1][N + 1][3];
        dp[1][2][0] = 1;
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (r == 0 || c == 0 || house[r][c] == 1) continue;
                if (r == 1 && c <= 2) continue;

                dp[r][c][0] = dp[r][c - 1][0] + dp[r][c - 1][2];
                dp[r][c][1] = dp[r - 1][c][1] + dp[r - 1][c][2];
                
                if (house[r - 1][c] == 1 || house[r][c - 1] == 1 || house[r][c] == 1) continue;
                dp[r][c][2] = dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2];
            }
        }

        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }
}