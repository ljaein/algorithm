package study0401;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main_15686_치킨배달 {

	static int N, M, sum, ans;
	static int[][] map;
	static List<Point> home;
	static List<Point> chi;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ans = Integer.MAX_VALUE;
		map = new int[N][N];
		home = new LinkedList<>();
		chi = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					home.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					chi.add(new Point(i, j));
				}
			}
		}
		Point[] sel = new Point[M];
		combi(0, 0, sel);
		System.out.println(ans);
	}

	static void combi(int start, int cnt, Point[] sel) {
		if (cnt == M) {
			go(sel);
			ans = Math.min(ans, sum);
			return;
		}

		for (int i = start; i < chi.size(); i++) {
			sel[cnt] = chi.get(i);
			combi(i + 1, cnt + 1, sel);
		}
	}

	static void go(Point[] sel) {
		sum = 0;
		for (Point p : home) {
			int dis = Integer.MAX_VALUE;
			for (Point sp : sel)
				dis = Math.min(dis, Math.abs(p.y - sp.y) + Math.abs(p.x - sp.x));
			sum += dis;
			if(sum > ans)
				return;
		}
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
