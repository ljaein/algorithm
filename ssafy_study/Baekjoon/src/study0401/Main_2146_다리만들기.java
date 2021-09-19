package study0401;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2146_다리만들기 {

	static int N, ans;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = Integer.MAX_VALUE;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		visit = new boolean[N][N];
		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					numbering(i, j, num++);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					visit = new boolean[N][N];
					bridge(i, j, map[i][j]);
				}
			}
		}

		System.out.println(ans);
	}

	static void bridge(int y, int x, int num) {
		Queue<Point> q = new LinkedList<>();
		visit[y][x] = true;
		q.add(new Point(y, x, 0));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			if(cur.l>ans)
				return;
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] == num)
					continue;
				if (map[ny][nx] == 0) {
					visit[ny][nx]=true;
					q.add(new Point(ny, nx, cur.l + 1));
				} else {
					ans = Math.min(ans, cur.l);
				}
			}
		}
	}

	static void numbering(int y, int x, int num) {
		Queue<Point> q = new LinkedList<>();
		map[y][x] = num;
		visit[y][x] = true;
		q.add(new Point(y, x));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] == 0)
					continue;
				visit[ny][nx] = true;
				map[ny][nx] = num;
				q.add(new Point(ny, nx));
			}
		}
	}

	static class Point {
		int y, x, l;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		public Point(int y, int x, int l) {
			this.y = y;
			this.x = x;
			this.l = l;
		}

	}

}
