package todo;

import java.util.Scanner;

public class Solution_D4_5987_달리기 {

	static int N, M;
	static int[] low;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			low = new int[N];
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				low[x] = low[x] | (1 << y);
			}
			
		}

	}

}
