package study0204;

import java.util.Scanner;

public class Solution_모의_2115_벌꿀채취 {

	static int T, N, M, C;
	static int[][] map, maxH;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			map = new int[N][N];
			maxH = new int[N][N - M + 1];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			selTong();
			System.out.println("#" + t + " " + selTwo());
		}
	}

	public static void selTong() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				selHoney(i, j, 0, 0, 0);
			}
		}
	}

	public static void selHoney(int y, int x, int cnt, int sum, int res) {
		if (sum > C) {
			return;
		}
		if (cnt == M) {
			// 저장하고
			maxH[y][x - M] = Math.max(maxH[y][x - M], res);
			return;
		}
		selHoney(y, x + 1, cnt + 1, sum + map[y][x], res + map[y][x] * map[y][x]);
		selHoney(y, x + 1, cnt + 1, sum, res);
	}

	public static int selTwo() {
		int max = 0;
		for (int r = 0; r < N; r++) {
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = i + M; j < N - M + 1; j++) {
					max = Math.max(max, maxH[r][i] + maxH[r][j]);
				} // 같은 행 비교
				for (int a = r + 1; a < N; a++) {
					for (int b = 0; b < N - M + 1; b++) {
						max = Math.max(max, maxH[r][i] + maxH[a][b]);
					}
				} // 다른 행 비교
			}
		}
		return max;
	}

}
