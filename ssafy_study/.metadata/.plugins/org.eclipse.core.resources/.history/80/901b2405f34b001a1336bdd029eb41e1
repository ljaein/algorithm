package study0202;

import java.util.Scanner;

public class Solution_D5_7206_숫자게임 {

	static int T, len;
	static String num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			num = sc.next();
			len = num.length();
			dfs(0, Integer.parseInt(num));

		}
	}

	public static void dfs(int s, int n) {
		if (s < 10) {
			return;
		}
		for (int i = 1; i < len - 1; i++) {
			int a = Integer.parseInt(num.substring(0, i));
			int b = Integer.parseInt(num.substring(i, len));
			dfs(i + 1, a * b);
		}
	}

}
