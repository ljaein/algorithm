package study0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의양팔저울 {

	static int T, N, ans, sum;
	static int[] weight, sel;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			sel = new int[N];
			weight = new int[N];
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			perm(0, 0);
			System.out.println("#" + t + " " + ans);
		}
	}

	static void perm(int flag, int cnt) {
		if (cnt == N) {
			dfs(0, 0, 0);
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & (1 << i)) == 0) {
				sel[cnt] = weight[i];
				perm(flag | (1 << i), cnt + 1);
			}
		}
	}

	static void dfs(int l, int r, int cnt) {
		if (cnt == N) {
			ans++;
			return;
		}
		sum = l + sel[cnt];
		dfs(sum, r, cnt + 1);
		sum = r + sel[cnt];
		if (sum <= l)
			dfs(l, sum, cnt + 1);
	}

}
