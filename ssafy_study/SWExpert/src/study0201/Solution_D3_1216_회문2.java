package study0201;

import java.util.Scanner;
import java.util.Stack;

public class Solution_D3_1216_È¸¹®2 {

	static int N, res, T;
	static char[][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = 100;
		for (int t = 1; t <= 10; t++) {

			T = sc.nextInt();

			arr = new char[N][N];
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				arr[i] = s.toCharArray();
			}

			for (int K = 1; K <= 100; K++) {

				for (int k = 0; k < N; k++) {
					for (int i = 0; i <= N - K; i++) {
						String f = "";
						String l = "";
						char[] c = new char[K];

						int start = i;
						for (int a = 0; a < K; a++) {
							c[a] = arr[k][start];
							start++;
						}

						for (int j = 0; j <= (K - 1) / 2; j++) {
							f += c[j];
						}
						for (int j = K - 1; j >= K / 2; j--) {
							l += c[j];
						}
						if (f.equals(l)) {
							res = K;
						}

					}
				}

				for (int k = 0; k < N; k++) {
					for (int i = 0; i <= N - K; i++) {
						String f = "";
						String l = "";
						char[] c = new char[K];

						int start = i;
						for (int a = 0; a < K; a++) {
							c[a] = arr[start][k];
							start++;
						}

						for (int j = 0; j <= (K - 1) / 2; j++) {
							f += c[j];
						}
						for (int j = K - 1; j >= K / 2; j--) {
							l += c[j];
						}
						if (f.equals(l)) {
							res = K;
						}

					}
				}
			}
			System.out.println("#" + T + " " + res);
		}
	}

}
