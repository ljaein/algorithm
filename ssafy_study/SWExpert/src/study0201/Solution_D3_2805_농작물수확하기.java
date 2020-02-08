package study0201;

import java.util.Scanner;

public class Solution_D3_2805_농작물수확하기 {

	static int T, N;
	static int[][] arr;
	static int sum;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			sum = 0;
			for (int i = 0; i < N; i++) {
				String[] s = sc.next().split("");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}

			int n = 1;
			int idx = N / 2; // 2
			for (int i = 0; i < N / 2; i++) {
				int nj = idx;
				for (int j = 0; j < n; j++) {
					sum += arr[i][nj++];
				}
				n += 2;
				idx--;
			}

			n = N;
			idx = 0;
			for (int i = N / 2; i < N; i++) {
				int nj = idx;
				for (int j = 0; j < n; j++) {
					sum += arr[i][nj++];
				}
				n -= 2;
				idx++;
			}
			System.out.println("#"+ t+" "+sum);
		}

	}
}
