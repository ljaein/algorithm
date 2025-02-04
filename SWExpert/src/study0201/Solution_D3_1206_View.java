package study0201;

import java.util.Scanner;

public class Solution_D3_1206_View {

	static int N, res;
	static int[][] bd;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			N = sc.nextInt();
			res = 0;
			bd = new int[1000][255];
			for (int i = 0; i < N; i++) {
				int b = sc.nextInt();
				for (int j = 0; j < b; j++) {
					bd[i][j] = 1;
				}
			}
			for (int i = 0; i < 1000; i++) {
				for (int j = 0; j < 255; j++) {
					if (bd[i][j] == 1) {
						if (bd[i - 1][j] == 0 && bd[i - 2][j] == 0 && bd[i + 1][j] == 0 && bd[i + 2][j] == 0) {
							res++;
						}
					}
				}
			}

			System.out.println("#" + t + " " + res);
		}
	}
}
