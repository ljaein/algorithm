package study0202;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_16637_괄호추가하기 {

	static int N, max;
	static String[] sik;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sik = sc.next().split("");
		for (int r = 1; r <= (N / 2 + 1) / 2; r++) {
			int[] sel = new int[r];
			dfs(1, 0, r, sel);
		}
		System.out.println(max);
	}

	public static void dfs(int start, int cnt, int r, int[] sel) {
		if (cnt == r) {
			selCalc(sel);
			return;
		}
		for (int i = start; i < N - 1; i = i + 2) {
			sel[cnt] = i;
			dfs(i + 4, cnt + 1, r, sel);
		}
	}

	public static void selCalc(int[] sel) {
		LinkedList<String> list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			boolean find = false;
			for (int j = 0; j < sel.length; j++) {
				if (i == sel[j] - 1) {
					list.add(calc(sik[i], sik[i + 1], sik[i + 2]));
					i += 2;
					find = true;
					break;
				}
			}
			if (!find)
				list.add(sik[i]);
		}
		while (list.size() != 1) {
			list.addFirst(calc(list.pop(), list.pop(), list.pop()));
		}
		max = Math.max(max, Integer.parseInt(list.get(0)));
	}

	public static String calc(String a, String c, String b) {
		int x = Integer.parseInt(a);
		int y = Integer.parseInt(b);
		if (c.equals("+")) {
			return String.valueOf(x + y);
		} else if (c.equals("-")) {
			return String.valueOf(x - y);
		} else {
			return String.valueOf(x * y);
		}
	}

}
