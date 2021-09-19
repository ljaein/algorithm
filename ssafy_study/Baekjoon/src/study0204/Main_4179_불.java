package study0204;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_4179_불 {

	static int R, C, res;
	static char[][] map;
	static boolean[][] visited, v;
	static Queue<Point> q = new LinkedList<>();
	static Queue<Point> fq = new LinkedList<>();
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		visited = new boolean[R][C];
		v = new boolean[R][C];
		res = Integer.MAX_VALUE;
		for (int i = 0; i < R; i++) {
			map[i] = sc.next().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'F') {
					visited[i][j] = true;
					fq.add(new Point(i, j, 0));
				} else if (map[i][j] == 'J') {
					v[i][j] = true;
					q.add(new Point(i, j, 0));
				}

			}
		}
		go();
		System.out.println(res==Integer.MAX_VALUE?"IMPOSSIBLE":res);
	}

	public static void go() {
		while (!fq.isEmpty() || !q.isEmpty()) {
			
			int size = fq.size();
			for (int s = 0; s < size; s++) {
				Point fcur = fq.poll();
				for (int d = 0; d < 4; d++) {
					int fy = fcur.y + dy[d];
					int fx = fcur.x + dx[d];
					if (fy < 0 || fx < 0 || fy >= R || fx >= C || visited[fy][fx] || map[fy][fx] == '#')
						continue;
					if (map[fy][fx] == '.') {
						visited[fy][fx] = true;
						map[fy][fx] = 'F';
						fq.add(new Point(fy, fx, 0));
					}

				}
			}
			int qsize = q.size();
			for (int s = 0; s < qsize; s++) {
				Point cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];
					if (ny < 0 || nx < 0 || ny == R || nx == C) { // 가장자리
						res = cur.t+1;
						return;
					}
					if (ny < 0 || nx < 0 || ny >= R || nx >= C || v[ny][nx])
						continue;
					if (map[ny][nx] == '.') {
						v[ny][nx] = true;
						q.add(new Point(ny, nx, cur.t + 1));
					}
				}
			}

		}
	}

	static class Point {
		int y, x, t;

		public Point(int y, int x, int t) {
			this.y = y;
			this.x = x;
			this.t = t;
		}

	}
}
