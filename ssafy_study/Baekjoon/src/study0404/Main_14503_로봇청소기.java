package study0404;

import java.util.Scanner;

public class Main_14503_로봇청소기 {

	static int N, M, r, c, d;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		move(r, c, d);
		System.out.println(count());
	}

	static void move(int y, int x, int d) {
		visit[y][x] = true;
		int cnt = 0;
		while (true) {
			if (cnt == 4) {
				y -= dy[d];
				x -= dx[d];
				if (map[y][x] == 1)
					return;
				cnt = 0;
				continue;
			}
			int nd = d == 0 ? 3 : d - 1;
			int ny = y + dy[nd];
			int nx = x + dx[nd];
			if (!visit[ny][nx] && map[ny][nx]==0) {
				move(ny, nx, nd);
				break;
			} else if (visit[ny][nx] || map[ny][nx] == 1) {
				d = nd;
				cnt++;
				continue;
			}
		}
	}

	static int count() {
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j])
					ans++;
			}
		}
		return ans;
	}

}
