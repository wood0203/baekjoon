import java.util.*;
import java.io.*;

public class Main {

    static int[][] board = new int[9][9];
    static ArrayList<int[]> arr = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) arr.add(new int[] {i, j});
            }
        }

        backTracking(0);
    }

    static void backTracking(int cnt) {
        if (cnt >= arr.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]);    
                    if (j < 8) sb.append(' ');
                }
                if (i < 8) sb.append('\n');
            }
            
            System.out.println(sb.toString());
            System.exit(0);
            return;
        }

        int[] current = arr.get(cnt);
        for (int i = 0; i <= 9; i++) {
            if (check(current[0], current[1], i) == false) continue;

            board[current[0]][current[1]] = i;
            backTracking(cnt + 1);
            board[current[0]][current[1]] = 0;
        }
    }

    static boolean check(int x, int y, int number) {
        int startX = (x / 3) * 3;
        int endX = startX + 3;
        int startY = (y / 3) * 3;
        int endY = startY + 3;
        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                if (board[i][j] == number) return false;
            }
        }

        // 행 검정
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == number) return false; 
        }

        // 열 검정
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == number) return false; 
        }

        return true;
    }
}