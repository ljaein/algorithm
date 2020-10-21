package study0301;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_D4_1251_하나로 {

	static int N;
	static long ans;
	static double E;
	static long[] X, Y;
	static int[] ver;
	static PriorityQueue<Point> pq;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			ans = 0;
			N = sc.nextInt();
			X = new long[N];
			Y = new long[N];
			for (int i = 0; i < N; i++) {
				X[i] = sc.nextLong();
			}
			for (int i = 0; i < N; i++) {
				Y[i] = sc.nextLong();
			}
			E = sc.nextDouble();
			pq = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					long dis = (X[i] - X[j]) * (X[i] - X[j]) + (Y[i] - Y[j]) * (Y[i] - Y[j]);
					pq.add(new Point(i, j, dis));
				}
			}
			ver = new int[N];
			for (int i = 0; i < N; i++)
				ver[i] = i;
			mst();
			System.out.println("#" + t + " " + (long) Math.round(ans * E));
		}

	}

	static void mst() {
		int cnt = 0;
		while (cnt < N - 1) {
			Point cur = pq.poll();
			int v1 = ver[cur.a];
			int v2 = ver[cur.b];
			double dis = cur.w;
			if (v1 != v2) { // 선택
				for (int i = 0; i < N; i++) {
					if (ver[i] == v2)
						ver[i] = v1;
				}
				ans += dis;
				cnt++;
			}
		}
	}

	static class Point implements Comparable<Point> {
		int a, b;
		long w;

		public Point(int a, int b, long w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			if (this.w > o.w)
				return 1;
			else
				return -1;
		}

	}

}
