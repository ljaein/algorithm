package study0201;

import java.util.Scanner;
import java.util.Stack;

public class Solution_D3_1215_회문1 {

	static int N, cnt;
	static char[][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {

			N = sc.nextInt();
			arr = new char[8][8];
			cnt = 0;
			for (int i = 0; i < 8; i++) {
				String s = sc.next();
				arr[i] = s.toCharArray();
			}

			for (int k = 0; k < 8; k++) {
				for (int i = 0; i <= 8 - N; i++) {
					String f = "";
					String l = "";
					char[] c = new char[N];

					int start = i;
					for (int a = 0; a < N; a++) {
						c[a] = arr[k][start];
						start++;
					}

					for (int j = 0; j <= (N - 1) / 2; j++) {
						f += c[j];
					}
					for (int j = N - 1; j >= N / 2; j--) {
						l += c[j];
					}
					if (f.equals(l)) {
						cnt++;
					}

				}
			}

			for (int k = 0; k < 8; k++) {
				for (int i = 0; i <= 8 - N; i++) {
					String f = "";
					String l = "";
					char[] c = new char[N];

					int start = i;
					for (int a = 0; a < N; a++) {
						c[a] = arr[start][k];
						start++;
					}

					for (int j = 0; j <= (N - 1) / 2; j++) {
						f += c[j];
					}
					for (int j = N - 1; j >= N / 2; j--) {
						l += c[j];
					}
					if (f.equals(l)) {
						cnt++;
					}

				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

}
