import java.util.*;
import java.io.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        int K = Integer.parseInt(br.readLine());
        if (K > N * M) {
            System.out.println(0);
            return;
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] seats = new int[M][N];
        int x = M;
        int y = 0;
        int current = 1;
        int dir = 0;
        while (current <= K) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (!check(nx, ny) || seats[nx][ny] != 0) {
                dir = (dir + 1) % 4;
            }

            x += dx[dir];
            y += dy[dir];
            seats[x][y] = current;
            current++;
        }

        System.out.println((y + 1) + " " + (M - x));
    }

    static boolean check(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < N;
    }    
}