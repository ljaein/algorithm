package study0401;

import java.util.Scanner;

public class Solution_D3_5607_조합 {

	static int N, R;
	static final int MOD = 1234567891;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			R = sc.nextInt();
			long fac[] = new long[N + 1];
			fac[0] = 1;
			for (int i = 1; i <= N; i++)
				fac[i] = (fac[i - 1] * i) % MOD;
			long div = (fac[R] * fac[N - R]) % MOD;
			long rediv = fermat(div, MOD - 2);

			System.out.println("#"+t+" "+(fac[N] * rediv) % MOD);
		}
	}

	private static long fermat(long n, int x) {
		if (x == 0)
			return 1;
		long tmp = fermat(n, x / 2);
		long ret = (tmp * tmp) % MOD;
		if (x % 2 == 0)
			return ret;
		else
			return (ret * n) % MOD;
	}

}
