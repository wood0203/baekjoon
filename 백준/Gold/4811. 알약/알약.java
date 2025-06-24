import java.util.*;
import java.io.*;

public class Main {

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new long[31][31];
        StringBuilder sb = new StringBuilder();
        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) break;

            sb.append(eatPill(input, 0)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static long eatPill(int whole, int half) {
        if (whole < 0 || half < 0) return 0;
        if (whole == 0 && half >= 0) return 1;

        if (dp[whole][half] != 0) return dp[whole][half];

        dp[whole][half] = eatPill(whole - 1, half + 1) + eatPill(whole, half - 1);
        return dp[whole][half];
    }
}