package study0502;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_2252_줄세우기 {

	static int N, M;
	static int s, e;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		Point[] info = new Point[N];
		for (int i = 0; i < N; i++) {
			info[i] = new Point(i, 0);
		}
		for (int i = 0; i < M; i++) {
			s = sc.nextInt() - 1;
			e = sc.nextInt() - 1;
			if (info[s].l == 0)
				info[e].l += 1;
			else if (info[e].l == 0)
				info[e].l += info[s].l + 1;
			else
				info[e].l += info[s].l;
		}
		PriorityQueue<Point> pq = new PriorityQueue<>();
		for (Point p : info) {
			pq.add(p);
		}
		while (!pq.isEmpty()) {
			System.out.print((pq.poll().n + 1) + " ");
		}

	}

	static class Point implements Comparable<Point> {
		int n, l;

		public Point(int n, int l) {
			super();
			this.n = n;
			this.l = l;
		}

		@Override
		public int compareTo(Point o) {
			if (this.l < o.l)
				return -1;
			else
				return 1;
		}
	}

}
