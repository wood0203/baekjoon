import java.util.*;
import java.io.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        String[] rcd = br.readLine().split(" ");
        int R = Integer.parseInt(rcd[0]);
        int C = Integer.parseInt(rcd[1]);
        int d = Integer.parseInt(rcd[2]);
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] rooms = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            if (rooms[R][C] == 0) {
                rooms[R][C] = 2;
                answer++;
            }
            boolean isAllCleaned = true;

            Outter:
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nx = R + dx[d];
                int ny = C + dy[d];
                if (rooms[nx][ny] == 0) {
                    R = nx;
                    C = ny;
                    isAllCleaned = false;
                    break Outter;
                }
            }

            if (isAllCleaned) {
                int backDir = (d + 2) % 4;
                int moveX = R + dx[backDir];
                int moveY = C + dy[backDir];
                if (rooms[moveX][moveY] != 1) {
                    R = moveX;
                    C = moveY;
                } else {
                    break;
                }
            }
        }
        
        System.out.println(answer);
    }
}