package study0302;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_6593_상범빌딩 {

	static int L, R, C, ans;
	static boolean check;
	static char[][][] map;
	static boolean visited[][][];
	static Queue<Point> q;
	static int[] dy = { 0, -1, 0, 1, 0, 0 };
	static int[] dx = { 1, 0, -1, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			L = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			map = new char[L][R][C];
			q = new LinkedList<>();
			visited = new boolean[L][R][C];
			ans = 0;
			check = false;
			if (L == 0 && R == 0 && C == 0)
				break;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					map[i][j] = sc.next().toCharArray();
					for (int k = 0; k < C; k++) {
						if (map[i][j][k] == 'S') {
							visited[i][j][k] = true;
							q.add(new Point(i, j, k));
						}
					}
				}
				String temp = sc.nextLine();
			}
			bfs();
			if (check)
				System.out.println("Escaped in " + ans + " minute(s).");
			else
				System.out.println("Trapped!");
		}
	}

	static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point cur = q.poll();
				for (int d = 0; d < 6; d++) {
					int z = cur.y + dy[d];
					int y = cur.x + dx[d];
					int x = cur.z + dz[d];
					if (z < 0 || y < 0 || x < 0 || z >= L || y >= R || x >= C || visited[z][y][x])
						continue;
					if (map[z][y][x] == 'E') {
						ans++;
						check = true;
						return;
					} else if (map[z][y][x] == '.') {
						visited[z][y][x] = true;
						q.add(new Point(z, y, x));
					}
				}
			}
			ans++;
		}
	}

	static class Point {
		int y, x, z;

		public Point(int y, int x, int z) {
			super();
			this.y = y;
			this.x = x;
			this.z = z;
		}

	}

}
