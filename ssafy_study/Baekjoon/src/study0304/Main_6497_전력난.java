package study0304;

import java.util.Arrays;
import java.util.Scanner;

public class Main_6497_전력난 {
	static int m, n;
	static int[] ver;
	static Cost[] cost;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			m = sc.nextInt();
			n = sc.nextInt();
			if (m == 0 && n == 0)
				break;
			ver = new int[m];
			cost = new Cost[n];
			int total = 0;
			for (int i = 0; i < m; i++)
				ver[i] = i;
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int c = sc.nextInt();
				cost[i] = new Cost(x, y, c);
				total += c;
			}
			Arrays.sort(cost);
			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				int v1 = ver[cost[i].x];
				int v2 = ver[cost[i].y];
				if (v1 != v2) {
					for (int j = 0; j < m; j++) {
						if (ver[j] == v2)
							ver[j] = v1;
					}
					sum += cost[i].c;
					cnt++;
				}
				if (cnt == m - 1)
					break;
			}
			System.out.println(total - sum);
		}
	}

	static class Cost implements Comparable<Cost> {
		int x, y, c;

		public Cost(int x, int y, int c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}

		@Override
		public int compareTo(Cost arg0) {
			if (this.c > arg0.c)
				return 1;
			else
				return -1;
		}

	}

}
