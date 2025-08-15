import java.util.*;
import java.io.*;

public class Main {

    static int N, answer;
    static int[][] board;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0) continue;
                if (board[i][j] == 0) {
                    System.out.println(dp[N - 1][N - 1]);
                    return;
                }

                int moveCnt = board[i][j];
                if (check(i + moveCnt, j)) {
                    dp[i + moveCnt][j] += dp[i][j];
                }
                if (check(i, j + moveCnt)) {
                    dp[i][j + moveCnt] += dp[i][j];
                }
            }
        }
    }

    static boolean check(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}