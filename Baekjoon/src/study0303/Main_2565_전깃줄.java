package study0303;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2565_전깃줄 {

	static int N;
	static Point[] rope;
	static int[] cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		rope = new Point[N];
		cnt = new int[N];
		for (int i = 0; i < N; i++)
			cnt[i] = 1;
		for (int i = 0; i < N; i++) {
			rope[i] = new Point(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(rope);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (rope[i].b > rope[j].b) {
					cnt[i] = Math.max(cnt[i], cnt[j] + 1);
				}
			}
		}
		Arrays.sort(cnt);
		System.out.println(N-cnt[N-1]);

	}

	static class Point implements Comparable<Point> {
		int a, b;

		public Point(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Point arg0) {
			if (this.a > arg0.a)
				return 1;
			else
				return -1;
		}

	}

}
