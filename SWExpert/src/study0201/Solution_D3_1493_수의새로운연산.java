package study0201;

import java.util.Scanner;

public class Solution_D3_1493_수의새로운연산 {
	static int T, p, q, res;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		int x = 1;
		int y = 1;
		int ynum = 1;
		Point[] parr = new Point[45000];
		parr[0] = new Point(1, 1);
		for (int i = 1; i < 45000; i++) {
			x = x + 1;
			y = y - 1;
			if (y < 1) {
				x = 1;
				y = ++ynum;
			}
			parr[i] = new Point(x, y);
		}

		for (int t = 1; t <= T; t++) {
			p = sc.nextInt();
			q = sc.nextInt();
			res = 0;

			int resx = parr[p - 1].x + parr[q - 1].x;
			int resy = parr[p - 1].y + parr[q - 1].y;
			for (int i = 0; i < 45000; i++) {
				if (resx == parr[i].x && resy == parr[i].y) {
					res = i + 1;
				}
			}
			System.out.println("#" + t + " " + res);
		}

	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
