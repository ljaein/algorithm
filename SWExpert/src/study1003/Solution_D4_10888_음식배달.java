package study1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D4_10888_음식배달 {
	static int T, N, ans;
	static int[][] map;
	static List<Point> home;
	static List<Point> food;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			home = new LinkedList<>();
			food = new LinkedList<>();
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] >= 2)
						food.add(new Point(i, j));
					else if (map[i][j] == 1)
						home.add(new Point(i, j));
				}
			}
			for (int i = 1; i <= food.size(); i++) {
				Point[] sel = new Point[i];
				combi(0, 0, i, sel);
			}
			System.out.println("#"+t+" "+ans);
		}
	}

	static void combi(int start, int cnt, int K, Point[] sel) {
		if (cnt == K) {
			go(sel);
			return;
		}
		for (int i = start; i < food.size(); i++) {
			sel[cnt] = food.get(i);
			combi(i + 1, cnt + 1, K, sel);
		}
	}

	static void go(Point[] sel){
		int sum = 0;
		int foodSum = 0;
		for(Point h : home){
			int dis = Integer.MAX_VALUE;
			for(Point f: sel){
				dis = Math.min(dis, Math.abs(f.y-h.y)+Math.abs(f.x-h.x));
			}
			sum += dis;
			if(sum > ans)
				return;
		}
		for(Point f: sel){
			foodSum += map[f.y][f.x];
		}
		sum += foodSum;
		ans = Math.min(ans, sum);
		
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
