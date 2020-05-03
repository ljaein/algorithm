package study0404;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_2234_성곽 {

	static int n, m, max, cnt, sum;
	static int[][] map, nmap;
	static boolean[][] visit;
	static List<Integer> list = new LinkedList<>();
	static Queue<Point> q;
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[m][n];
		nmap = new int[m][n];
		visit = new boolean[m][n];
		q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int num = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					bfs(i, j, num++);
					cnt++;
				}
			}
		}

		System.out.println(cnt);
		System.out.println(max);
		sum();
		System.out.println(sum);
	}

	static void sum() {
		visit = new boolean[m][n];
		q = new LinkedList<>();
		visit[0][0] = true;
		q.add(new Point(0, 0));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= m || nx >= n || visit[ny][nx])
					continue;
				if (nmap[cur.y][cur.x] != nmap[ny][nx]) 
					sum = Math.max(sum, list.get(nmap[cur.y][cur.x]) + list.get(nmap[ny][nx]));
				visit[ny][nx] = true;
				q.add(new Point(ny, nx));
			}
		}
	}

	static void bfs(int y, int x, int num) {
		int size = 1;
		visit[y][x] = true;
		nmap[y][x] = num;
		q.add(new Point(y, x));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int d = 0; d < 4; d++) {
				if ((map[cur.y][cur.x] & (1 << d)) != 0)
					continue;
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= m || nx >= n || visit[ny][nx])
					continue;
				visit[ny][nx] = true;
				nmap[ny][nx] = num;
				size++;
				q.add(new Point(ny, nx));
			}
		}
		list.add(size);
		max = Math.max(max, size);
	}

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
