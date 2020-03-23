package study0303;

import java.util.Scanner;

public class Main_1904_01타일 {

	static int N;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2])%15746;
		}
		System.out.println(dp[N]);
	}

}
