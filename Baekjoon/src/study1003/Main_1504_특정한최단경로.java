package study1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504_특정한최단경로 {
	static int N, E, m1, m2;
	static int sm1, sm2, m1m2, m1e, m2e;
	static List<Point>[] list;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new LinkedList[N];
		for(int i=0;i<N;i++)
			list[i] = new LinkedList<Point>();
		dist = new int[N];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Point(b, c));
			list[b].add(new Point(a, c));
		}
		st = new StringTokenizer(br.readLine());
		m1 = Integer.parseInt(st.nextToken()) - 1;
		m2 = Integer.parseInt(st.nextToken()) - 1;
		calc(0);
		calc(m1);
		calc(m2);
		int ans = Math.min(sm1+m1m2+m2e, sm2+m1m2+m1e);
		System.out.println(ans);
	}

	static void calc(int s) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Point> pq = new PriorityQueue<>();
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
		if (s == 0) {
			sm1 = dist[m1];
			sm2 = dist[m2];
		} else if (s == m1) {
			m1m2 = dist[m2];
			m1e = dist[N - 1];
		} else {
			m2e = dist[N - 1];
		}
	}

	static class Point {
		int v, c;

		public Point(int v, int c) {
			super();
			this.v = v;
			this.c = c;
		}

	}

}
