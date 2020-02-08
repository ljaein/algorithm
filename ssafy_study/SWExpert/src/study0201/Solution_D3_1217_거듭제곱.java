package study0201;

import java.util.Scanner;

public class Solution_D3_1217_°ÅµìÁ¦°ö {

	static int T, N, M;
	static int res;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			T = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			recursive(N, N, M);
			System.out.println("#" + T + " " + res);
		}
	}

	public static void recursive(int num, int n, int m) {
		if (m == 1) {
			res = num;
			return;
		}
		recursive(num * n, n, m - 1);
	}

}
