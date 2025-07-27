import java.util.*;
import java.io.*;

public class Main {

    static int[][] board;
    static ArrayList<int[]> empties = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                board[i][j] = input[j] - '0';
                if (board[i][j] == 0) empties.add(new int[] {i, j});
            }
        }

        solution(0);
    }

    public static void solution(int current) {
        if (current == empties.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int v: board[i]) {
                    sb.append(v);
                }
                sb.append("\n");
            }

            sb.setLength(sb.length() - 1);
            System.out.println(sb.toString());
            System.exit(0);
            return;
        }

        int[] point = empties.get(current);
        int x = point[0]; int y = point[1];
        for (int i = 1; i <= 9; i++) {
            // 1. row 검사
            if (!checkRow(x, y, i) || !checkCol(x, y, i) || !checkSquare(x, y, i)) continue;

            board[x][y] = i;
            solution(current + 1);
            board[x][y] = 0;
        }
    }

    static boolean checkRow(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (i == y) continue;

            if (board[x][i] == value) return false;
        }

        return true;
    }


    static boolean checkCol(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (i == x) continue;

            if (board[i][y] == value) return false;
        }

        return true;
    }

    static boolean checkSquare(int x, int y, int value) {
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (x == i && y == j) continue;

                if (board[i][j] == value) return false;
            }
        }

        return true;
    }
}