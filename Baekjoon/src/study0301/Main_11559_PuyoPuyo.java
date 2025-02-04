package study0301;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11559_PuyoPuyo {

	static char[][] map = new char[12][6];
	static boolean[][] visited;
	static boolean check;
	static Queue<Point> q = new LinkedList<>();
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 12; i++) {
			map[i] = sc.next().toCharArray();
		}
		int ans = 0;
		while (true) {
			check = false;
			combo();
			if (!check)
				break;
			ans++;
		}
		System.out.println(ans);

	}

	static void combo() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j] != '.') {
					visited = new boolean[12][6];
					visited[i][j] = true;
					q.add(new Point(i, j, map[i][j]));
					bfs(i, j, map[i][j]);
				}
			}
		}
		
		for (int j = 0; j < 6; j++) {
			int idx = 11;
			for (int i = 11; i >= 0; i--) {
				if (map[i][j] != '.') {
					char temp = map[idx][j];
					map[idx][j] = map[i][j];
					map[i][j] = temp;
					idx--;
				}
			}
		}
	}

	static void bfs(int y, int x, char c) {
		int cnt = 1;
		Queue<Point> same = new LinkedList<>();
		same.add(new Point(y, x, c));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= 12 || nx >= 6 || visited[ny][nx])
					continue;
				if (map[ny][nx] == cur.c) {
					cnt++;
					visited[ny][nx] = true;
					q.add(new Point(ny, nx, map[ny][nx]));
					same.add(new Point(ny, nx, map[ny][nx]));
				}
			}
		}
		if (cnt >= 4) {
			check = true;
			while (!same.isEmpty()) {
				Point p = same.poll();
				map[p.y][p.x] = '.';
			}

		}
	}

	static class Point {
		int y, x;
		char c;

		public Point(int y, int x, char c) {
			super();
			this.y = y;
			this.x = x;
			this.c = c;
		}

	}
}
