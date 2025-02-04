package study0604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1486_등산 {

	static int N, M, T, D;
	static int[][] map, time;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static PriorityQueue<Point> high = new PriorityQueue<>(new CC());
	static boolean ans = false;

	public static class C implements Comparator<Point> {
		@Override
		public int compare(Point arg0, Point arg1) {
			return arg0.t - arg1.t;
		}
	}

	public static class CC implements Comparator<Point> {
		@Override
		public int compare(Point arg0, Point arg1) {
			return arg1.t - arg0.t;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		time = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				time[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (c[j] - 'A' < 26) {
					map[i][j] = c[j] - 'A';
				} else {
					map[i][j] = c[j] - 'a' + 26;
				}
				high.add(new Point(i, j, map[i][j]));
			}
		}
		bfs();
		comeback();
		if (!ans)
			System.out.println(map[0][0]);
	}

	static void comeback() {
		while (!high.isEmpty()) {
			int[][] ctime = new int[N][M];
			for (int i = 0; i < N; i++)
				Arrays.fill(ctime[i], Integer.MAX_VALUE);
			Point h = high.poll();

			PriorityQueue<Point> pq = new PriorityQueue<>(new C());
			pq.add(new Point(h.y, h.x, 0));
			ctime[h.y][h.x] = 0;
			while (!pq.isEmpty()) {
				Point cur = pq.poll();
				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];
					if (ny < 0 || nx < 0 || ny >= N || nx >= M)
						continue;
					if (Math.abs(map[cur.y][cur.x] - map[ny][nx]) > T)
						continue;
					if (map[cur.y][cur.x] >= map[ny][nx]) {
						if(ctime[ny][nx]>ctime[cur.y][cur.x]+1){
							ctime[ny][nx] = ctime[cur.y][cur.x]+1;
							pq.add(new Point(ny,nx,ctime[ny][nx]));
						}
					} else {
						int pow = (map[ny][nx] - map[cur.y][cur.x]) * (map[ny][nx] - map[cur.y][cur.x]);
						if(ctime[ny][nx]>ctime[cur.y][cur.x] + pow){
							ctime[ny][nx] = ctime[cur.y][cur.x] + pow;
							pq.add(new Point(ny, nx, ctime[ny][nx]));
						}
					}
				}
			}
			
			if(ctime[0][0]!=Integer.MAX_VALUE){
				if(ctime[0][0] + time[h.y][h.x] <= D){
					ans = true;
					System.out.println(map[h.y][h.x]);
					return;
				}
			}
		}
	}

	static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>(new C());
		pq.add(new Point(0, 0, 0));
		time[0][0] = 0;
		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M)
					continue;
				if (Math.abs(map[cur.y][cur.x] - map[ny][nx]) > T)
					continue;
				if (map[cur.y][cur.x] >= map[ny][nx]) {
					if(time[ny][nx]>time[cur.y][cur.x]+1){
						time[ny][nx] = time[cur.y][cur.x]+1;
						pq.add(new Point(ny,nx,time[ny][nx]));
					}
				} else {
					int pow = (map[ny][nx] - map[cur.y][cur.x]) * (map[ny][nx] - map[cur.y][cur.x]);
					if(time[ny][nx]>time[cur.y][cur.x] + pow){
						time[ny][nx] = time[cur.y][cur.x] + pow;
						pq.add(new Point(ny, nx, time[ny][nx]));
					}
				}
			}
		}
	}

	static class Point {
		int y, x, t;

		public Point(int y, int x, int t) {
			super();
			this.y = y;
			this.x = x;
			this.t = t;
		}

	}

}
