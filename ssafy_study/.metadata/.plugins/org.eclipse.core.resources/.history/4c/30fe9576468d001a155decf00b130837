package todo;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_15683_감시 {

	static int N, M, min;
	static int[][] map;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 }; // 우 하 좌 상
	static List<Point> cam = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		min = Integer.MAX_VALUE;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] != 0 && map[i][j] != 6)
					cam.add(new Point(i, j, map[i][j]));
			}
		}
		System.out.println(min);
	}


	static class Point {
		int y, x, n;

		public Point(int y, int x, int n) {
			this.y = y;
			this.x = x;
			this.n = n;
		}
	}
}
