package study0604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.print.attribute.standard.QueuedJobCount;

public class Main_4991_로봇청소기 {

	static int N, M, ans, num;
	static int[][] map, adj;
	static List<Point> room;
	static boolean[] ver;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0)
				break;
			map = new int[N][M];
			room = new LinkedList<>();
			ans = Integer.MAX_VALUE;
			num = 2;
			for (int i = 0; i < N; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (c[j] == 'o') {
						map[i][j] = 1;
						room.add(new Point(i, j, 0));
					} else if (c[j] == '*') {
						map[i][j] = num++;
						room.add(new Point(i, j, 0));
					} else if (c[j] == 'x') {
						map[i][j] = -1;
					}
				}
			}
			adj = new int[num][num];
			ver = new boolean[num];
			for (Point p : room) {
				dist(p.y, p.x);
			}
			ver[1]=true;
			dfs(1, 0);
			System.out.println(ans==Integer.MAX_VALUE?-1:ans);
		}
	}

	static void dfs(int v, int sum) {
		if (check()){
			ans = Math.min(ans, sum);
			return;
		}
		for (int i = 2; i < num; i++) {
			if (adj[v][i] != 0 && !ver[i]) {
				ver[i]=true;
				dfs(i, sum + adj[v][i]);
				ver[i]=false;
			}
		}
	}

	static boolean check() {
		for (int i = 1; i < num; i++) {
			if (!ver[i])
				return false;
		}
		return true;
	}

	static void dist(int y, int x) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		q.add(new Point(y, x, 0));
		visit[y][x] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == -1)
					continue;
				if (map[ny][nx] == 0) {
					q.add(new Point(ny, nx, cur.cnt + 1));
					visit[ny][nx] = true;
				} else {
					if (adj[map[y][x]][map[ny][nx]] != 0)
						continue;
					adj[map[y][x]][map[ny][nx]] = cur.cnt + 1;
					adj[map[ny][nx]][map[y][x]] = cur.cnt + 1;
					q.add(new Point(ny, nx, cur.cnt + 1));
					visit[ny][nx] = true;
				}
			}
		}
	}

	static class Point {
		int y, x, cnt;

		public Point(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

	}

}
