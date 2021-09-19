package study1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기 {
	static int N, M, s, e;
	static List<Point>[] list;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new LinkedList[N];
		dist = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = new LinkedList<Point>();
			dist[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Point> pq = new PriorityQueue<>();
		StringTokenizer st = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Point(b, c));
		}
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken()) - 1;
		e = Integer.parseInt(st.nextToken()) - 1;
		pq.add(new Point(s, 0));
		dist[s] = 0;
		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			for (Point p : list[cur.v]) {
				if (dist[p.v] > dist[cur.v] + p.c) {
					dist[p.v] = dist[cur.v] + p.c;
					pq.add(new Point(p.v, dist[p.v]));
				}
			}
		}
		System.out.println(dist[e]);

	}

	static class Point implements Comparable<Point> {
		int v, c;

		public Point(int v, int c) {
			super();
			this.v = v;
			this.c = c;
		}

		@Override
		public int compareTo(Point o) {
			return this.c - o.c;
		}

	}

}
