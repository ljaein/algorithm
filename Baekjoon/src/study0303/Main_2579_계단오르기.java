package study0303;

import java.util.Scanner;

public class Main_2579_계단오르기 {

	static int N;
	static int[] arr, dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		dp = new int[N];
		dp[0] = arr[0];
		if (N >= 2)
			dp[1] = arr[0] + arr[1];
		if (N >= 3) {
			dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
		}
		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(arr[i] + dp[i - 2], arr[i] + arr[i - 1] + dp[i - 3]);
		}
		System.out.println(dp[N-1]);
	}

}
