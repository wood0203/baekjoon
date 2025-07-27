import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            int cnt = 0;
            for (char c: input) {
                if (c == '(') {
                    cnt += 1;
                } else {
                    cnt -= 1;
                }

                if (cnt < 0) {
                    break;
                }
            }

            if (cnt == 0) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }
}