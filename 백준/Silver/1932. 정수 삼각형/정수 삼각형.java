import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                int num = Integer.parseInt(st.nextToken());
                int sum = 0;
                if (j > 0) {
                    sum = Integer.max(sum, dp[i - 1][j - 1]);
                }
                if (j < i) {
                    sum = Integer.max(sum, dp[i - 1][j]);
                }
                dp[i][j] = sum + num;
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Integer.max(answer, dp[n - 1][i]);
        }

        System.out.println(answer);
    }

}