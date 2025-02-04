package study0301;

import java.util.HashSet;
import java.util.Scanner;

public class Solution_모의_2105_디저트카페2 {
	static int N, max, sy, sx;
	static int[][] map;
	static boolean[] visit;
	static int[][] direc = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			max = 0;
			N = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sy = i;
					sx = j;
					visit = new boolean[101];
					dfs(i, j, 0,1);
				}
			}
			System.out.println("#"+t+" "+(max==0?-1:max));
		}
	}

	static void dfs(int r, int c, int dir, int cnt) {
		visit[map[r][c]] = true;
		for (int d = dir; d < 4; d++) {
			int nr = r + direc[d][0];
			int nc = c + direc[d][1];
			if (nr == sy && nc == sx && cnt >= 4) {
				if (cnt > max) {
					max = cnt;
					return;
				}
			}
			if (nr > -1 && nr < N && nc > -1 && nc < N && !visit[map[nr][nc]]) {
				dfs(nr, nc, d,cnt+1);
			}
		}
		visit[map[r][c]] = false;
	}
}
