package study0202;

import java.util.Scanner;

public class Solution_D4_3347_올림픽종목투표 {

	static int T, N, M, max, res;
	static int[] A, B, vote;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			A = new int[N];
			B = new int[M];
			max = 0;
			res = 0;
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}
			vote = new int[N];

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (A[j] <= B[i]) {
						vote[j]++;
						break;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				if (max < vote[i]) {
					max = vote[i];
					res = i + 1;
				}
			}
			System.out.println("#" + t + " " + res);

		}
	}

}
