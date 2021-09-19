package study0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2931_가스관 {

	static int N, M, sy, sx, ansy, ansx;
	static char ans;
	static char[][] map;
	static int[][] visit;
	static int[] dy = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dx = { 0, 1, 0, -1 };
	static boolean U, D, R, L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'M') {
					sy = i;
					sx = j;
				} else if (map[i][j] == '+') {
					visit[i][j] = -1;
				}
			}
		}
		for (int d = 0; d < 4; d++) {
			int ny = sy + dy[d];
			int nx = sx + dx[d];
			if (safe(ny, nx) && map[ny][nx] != '.') {
				dfs(ny, nx, d, ' ');
			}
		}
		System.out.println(ansy + " " + ansx + " " + ans);
	}

	static boolean safe(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= M)
			return false;
		return true;
	}

	static void dfs(int y, int x, int d, char c) {
		if (map[y][x] == '.') {
			ansy = y+1;
			ansx = x+1;
			check(y, x);
			return;

		} else if (map[y][x] == '|' || map[y][x] == '-' || map[y][x] == '+') {
			int ny = y + dy[d];
			int nx = x + dx[d];
			dfs(ny, nx, d, c);
		} else if (map[y][x] == '1') {
			int nd = d == 3 ? 2 : 1;
			dfs(y + dy[nd], x + dx[nd], nd, c);
		} else if (map[y][x] == '2') {
			int nd = d == 2 ? 1 : 0;
			dfs(y + dy[nd], x + dx[nd], nd, c);
		} else if (map[y][x] == '3') {
			int nd = d == 1 ? 0 : 3;
			dfs(y + dy[nd], x + dx[nd], nd, c);
		} else if (map[y][x] == '4') {
			int nd = d == 1 ? 2 : 3;
			dfs(y + dy[nd], x + dx[nd], nd, c);
		}
	}

	static void check(int y, int x) {
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (!safe(ny, nx))
				continue;
			char g = map[ny][nx];
			if (d == 0 && (g == '|' || g == '+' || g == '1' || g == '4'))
				U = true;
			else if (d == 1 && (g == '-' || g == '+' || g == '3' || g == '4'))
				R = true;
			else if (d == 2 && (g == '|' || g == '+' || g == '2' || g == '3'))
				D = true;
			else if (d == 3 && (g == '-' || g == '+' || g == '1' || g == '2'))
				L = true;
		}
		if (U && D && R && L)
			ans = '+';
		else if (L && R)
			ans = '-';
		else if (U && D)
			ans = '|';
		else if (D && R)
			ans = '1';
		else if (U && R)
			ans = '2';
		else if (L && U)
			ans = '3';
		else
			ans = '4';
	}

	static class Point {
		int y, x, d;

		public Point(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}

	}
}
