package study0301;

import java.util.Scanner;

public class Solution_모의_2105_디저트카페 {

	static int N, sy, sx, max;
	static int[][] map;
	static boolean[] ds;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 1, -1 };
	static int[] dx = { 1, 1, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			max = -1;
			N = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					ds = new boolean[101];
					sy = i;
					sx = j;
					dfs(i, j, 0, -1, 0);
				}
			}

			System.out.println("#" + t + " " + max);

		}

	}

	static void dfs(int y, int x, int cnt, int nd, int rocnt) {
		if (sy == y && sx == x && visited[y][x] && cnt >= 4 && rocnt == 4) {
			if (max < cnt) {
				max = cnt;
			}
			return;
		}
		if (rocnt > 4)
			return;
		if (visited[y][x] || ds[map[y][x]])
			return;

		visited[y][x] = true;
		ds[map[y][x]] = true;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= N || nx >= N)
				continue;
			if (nd != d)
				dfs(ny, nx, cnt + 1, d, rocnt + 1);
			else
				dfs(ny, nx, cnt + 1, d, rocnt);
		}
		visited[y][x] = false;
		ds[map[y][x]] = false;
	}

}
