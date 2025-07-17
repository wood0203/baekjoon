import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] toys = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            toys[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;
        int cnt = 0;
        int answer = Integer.MAX_VALUE;
        while (end < N) {
            if (cnt == K) {
                if (toys[start] == 1) {
                    answer = Integer.min(end - start + 1, answer);
                    end++;
                    cnt--;
                }

                start++;
                continue;
            }
            
            if (toys[end] == 1) cnt++;

            if (cnt < K) end++;
        }

        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        System.out.println(answer);
    }
}
