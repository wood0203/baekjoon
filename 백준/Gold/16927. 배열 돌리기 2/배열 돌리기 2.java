import java.util.*;
import java.io.*;

public class Main {
	static int N, M, R;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] arr, rotated;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		R = Integer.parseInt(nm[2]);
		arr = new int[N][M];
		rotated = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 제일 바깥부터 안쪽까지 rotate 함수 반복
		for(int i = 0; i < Integer.min(N, M) / 2; i++) {
			rotate(i, i, N - (2 * i), M - (2 * i));
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(rotated[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	// x, y에 해당하는 테두리부터 회전
	public static void rotate(int x, int y, int height, int width) {
		// 회전이 가능하면, 해당 테두리에서 반복시 결과가 같아지는 값을 나눠서 나머지를 구함.
		// (width + height - 2) * 2로 나눠서 나머지 구함
		int totalRotateCnt = ((width + height - 2) * 2);
		int startRotateCnt = totalRotateCnt - (R % ((width + height - 2) * 2));
		
		// 시작점 구하기
		int rotateCount = 0;
		int nx = x; int ny = y; int delta = 0;
		int originX = x; int originY = y; int delta2 = 0;
		while (rotateCount < startRotateCnt + totalRotateCnt) {
			if (rotateCount >= startRotateCnt) {
				rotated[originX][originY] = arr[nx][ny];
				originX += dx[delta2];
				originY += dy[delta2];

				if (originX == x + height - 1 && originY == y) {
					delta2++;
				} else if (originX == x + height - 1 && originY == y + width - 1) {
					delta2++;
				} else if (originX == x && originY == y + width - 1) {
					delta2++;
				} else if(originX == x && originY == y) {
					delta2 = 0;
				}
			}
			
			nx += dx[delta];
			ny += dy[delta];

			if (nx == x + height - 1 && ny == y) {
				delta++;
			} else if (nx == x + height - 1 && ny == y + width - 1) {
				delta++;
			} else if (nx == x && ny == y + width - 1) {
				delta++;
			} else if(nx == x && ny == y) {
				delta = 0;
			}
			
			rotateCount++;
		}
	}
}

