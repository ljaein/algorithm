package study0302;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2206_벽부수고이동하기 {

	static int N, M, ans;
	static boolean check;
	static int[][] map;
	static int[][] visited;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ans = 0;
		check = false;
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] c = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = c[j] - '0';
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs();

		System.out.println(check ? ans : -1);
	}

	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		visited[0][0] = 0;
		q.add(new Point(0, 0, 1, 0));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.y == N - 1 && cur.x == M - 1) {
				ans = cur.dis;
				check = true;
				return;
			}
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] <= cur.one) {
					continue;
				}
				if (map[ny][nx] == 0) {
					visited[ny][nx] = cur.one;
					q.add(new Point(ny, nx, cur.dis + 1, cur.one));
				} else if (map[ny][nx] == 1) {
					if (cur.one == 0) {
						visited[ny][nx] = cur.one + 1;
						q.add(new Point(ny, nx, cur.dis + 1, cur.one + 1));
					}
				}
			}
		}
	}

	static class Point {
		int y, x, dis, one;

		public Point(int y, int x, int dis, int one) {
			super();
			this.y = y;
			this.x = x;
			this.dis = dis;
			this.one = one;
		}

	}

}
