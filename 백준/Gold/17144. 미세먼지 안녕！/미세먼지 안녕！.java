import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, T;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] room;
	static int circulatorX;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] rct = br.readLine().split(" ");
		R = Integer.parseInt(rct[0]);
		C = Integer.parseInt(rct[1]);
		T = Integer.parseInt(rct[2]);
		room = new int[R][C];
		for (int i = 0; i < R; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] == -1) {
					circulatorX = i;
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			expand();
			circulate();
		}
		
		int answer = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] > 0)
					answer += room[i][j];
			}
		}
		System.out.println(answer);
	}
	
	// 확산
	static void expand() {
		// 기존 room clone
		// clone 한데서 먼지를 확산하고, 데이터를 room에 누적
		int[][] clonedRoom = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				clonedRoom[i][j] = room[i][j];
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (clonedRoom[i][j] < 5) continue;
				
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (!check(nx, ny) || room[nx][ny] == -1) continue;
					
					room[nx][ny] += (clonedRoom[i][j] / 5);
					room[i][j] -= (clonedRoom[i][j] / 5);
				}
			}
		}
	}
	
	// 공기청정기 실행
	static void circulate() {
		int[][] clonedRoom = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				clonedRoom[i][j] = room[i][j];
			}
		}
		
		// 위쪽 공기청정기 순환
		int upX = circulatorX - 1;
		room[upX][1] = 0;
		for (int i = 2; i < C; i++) {
			room[upX][i] = clonedRoom[upX][i - 1];
		}
		for (int i = upX - 1; i >= 0; i--) {
			room[i][C - 1] = clonedRoom[i + 1][C - 1];
		}
		for (int i = C - 2; i >= 0; i--) {
			room[0][i] = clonedRoom[0][i + 1];
		}
		for (int i = 1; i < upX; i++) {
			room[i][0] = clonedRoom[i - 1][0];
		}
		
		//아래쪽 공기청정기 순환
		int downX = circulatorX;
		for (int i = 2; i < C; i++) {
			room[downX][i] = clonedRoom[downX][i - 1];
		}
		room[downX][1] = 0;
		for (int i = downX + 1; i < R; i++) {
			room[i][C - 1] = clonedRoom[i - 1][C - 1];
		}
		for (int i = C - 2; i >= 0; i--) {
			room[R - 1][i] = clonedRoom[R - 1][i + 1];
		}
		for (int i = R - 2; i > downX; i--) {
			room[i][0] = clonedRoom[i + 1][0];
		}
	}
	
	static boolean check(int x, int y) {
		return (0 <= x && x < R && 0 <= y && y < C);
	}
}
