import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] papers = new boolean[101][101];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            String[] paper = br.readLine().split(" ");
            int x = Integer.parseInt(paper[0]);
            int y = Integer.parseInt(paper[1]);
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (!papers[j][k]) {
                        answer++;
                        papers[j][k] = true;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}