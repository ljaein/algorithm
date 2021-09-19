package study0404;

import java.util.Scanner;

public class Solution_모의_1949_등산로조성 {

	static int T, N, K, ans;
	static boolean cut;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			visit = new boolean[N][N];
			ans = 0;
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					max = Math.max(max, map[i][j]);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						cut = false;
						dfs(i, j, 1);
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	static void dfs(int y, int x, int cnt) {
		ans = Math.max(ans, cnt);
		visit[y][x] = true;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx])
				continue;
			if (map[ny][nx] < map[y][x]) {
				dfs(ny, nx, cnt + 1);
			} else {
				if (!cut) {
					for (int k = 1; k <= K; k++) {
						map[ny][nx] -= k;
						cut = true;
						if (map[ny][nx] < map[y][x]) {
							dfs(ny, nx, cnt + 1);
						}
						cut = false;
						map[ny][nx] += k;
					}
				}
			}
		}
		visit[y][x] = false;
	}

}
