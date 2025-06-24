import java.io.*;

public class Main {

    static int K;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        if (K == 0) {
            System.out.println(0);
            return;
        }
        if (N == 0) {
            System.out.println(1);
            return;
        }

        int col = K + N + 1;
        dp = new long[N + 1][col];
        dp[0][K] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] += dp[i - 1][j - 1];
                if (j < col - 1) dp[i][j] += dp[i - 1][j + 1];
            }
        }

        long answer = 0;
        for (int j = 1; j < col; j++) {
            answer += dp[N][j];
        }

        System.out.println(answer);
    }
}