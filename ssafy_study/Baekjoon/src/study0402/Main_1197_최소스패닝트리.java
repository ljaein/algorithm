package study0402;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1197_최소스패닝트리 {

	static int V, E, A, B, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Ver> pq = new PriorityQueue<>();
		V = sc.nextInt();
		E = sc.nextInt();
		for (int i = 0; i < E; i++) {
			A = sc.nextInt()-1;
			B = sc.nextInt()-1;
			C = sc.nextInt();
			pq.add(new Ver(A, B, C));
		}
		int[] ver = new int[V];
		for (int i = 0; i < V; i++)
			ver[i] = i;
		int ans = 0;
		int cnt = 0;
		while (!pq.isEmpty()) {
			Ver cur = pq.poll();
			int a = ver[cur.a];
			int b = ver[cur.b];
			if (a != b) {
				cnt++;
				ans += cur.w;
				for (int i = 0; i < V; i++) {
					if (ver[i] == b)
						ver[i] = a;
				}
			}
			if(cnt==V-1)
				break;
		}
		System.out.println(ans);
	}

	static class Ver implements Comparable<Ver> {
		int a, b, w;

		public Ver(int a, int b, int w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Ver o) {
			return this.w - o.w;
		}

	}

}
