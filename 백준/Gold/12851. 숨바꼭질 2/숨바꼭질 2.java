import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int answer = Integer.MAX_VALUE;
        int[] dist = new int[200001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        int cnt = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {n, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();

            if (p[0] == k) {
                answer = p[1];
                dist[k] = p[1];
                cnt++;
                continue;
            }

            if (p[1] > answer) continue;

            int temp = p[0] - 1;
            if (temp >= 0 && p[1] + 1 <= dist[temp]) {
                dist[temp] = p[1] + 1;
                queue.offer(new int[] {temp, p[1] + 1});
            }

            int temp2 = p[0] + 1;
            if (temp2 <= 100000 && p[1] + 1 <= dist[temp2]) {
                dist[temp2] = p[1] + 1;
                queue.offer(new int[] {temp2, p[1] + 1});
            }
            
            int temp3 = p[0] * 2;
            if (0 <= temp3 && temp3 <= 200001 && p[1] + 1 <= dist[temp3]) {
                dist[temp3] = p[1] + 1;
                queue.offer(new int[] {temp3, p[1] + 1});
            }
        }

        System.out.println(answer);
        System.out.println(cnt);
    }

}