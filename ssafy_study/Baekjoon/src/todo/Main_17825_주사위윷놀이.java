package todo;

import java.util.Arrays;
import java.util.Scanner;

public class Main_17825_주사위윷놀이 {
	static int sum;
	static int[] num, sel, map;
	static Mal[] mal;
	static int[] b10 = { 10, 13, 16, 19, 25, 30, 35, 40, -1 };
	static int[] b20 = { 20, 22, 24, 25, 30, 35, 40, -1 };
	static int[] b30 = { 30, 28, 27, 26, 25, 30, 35, 40, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = new int[10];
		sel = new int[10];
		map = new int[22];
		mal = new Mal[4];
		for (int i = 0; i < 4; i++) {
			mal[i] = new Mal('R', 0);
		}
		for (int i = 0; i < 10; i++) {
			num[i] = sc.nextInt();
		}
		for (int i = 0; i < 21; i++) {
			map[i] = i * 2;
		}
		map[21] = -1;
		perm(0);
	}

	static void perm(int cnt) {
		if (cnt == 10) {
			move();
			return;
		}
		for (int i = 0; i < 4; i++) {
			sel[cnt] = i;
			perm(cnt + 1);
		}
	}

	static void move() {
		for (int i = 0; i < 10; i++) {
			Mal cur = mal[sel[i]];
			if (cur.c == 'R') {
				cur.n += num[i];
				if(cur.n>21)
					continue;
				if (map[cur.n] == 10) {
					cur.c = '1';
					cur.n=0;
				} else if (map[cur.n] == 20) {
					cur.c = '2';
					cur.n=0;
				} else if (map[cur.n] == 30) {
					cur.c = '3';
					cur.n=0;
				}
				sum += map[cur.n];
			} else if (cur.c == '1') {
				cur.n+=num[i];
				sum +=map[cur.n];
			}

		}
	}

	static class Mal {
		char c;
		int n;

		public Mal(char c, int n) {
			super();
			this.c = c;
			this.n = n;
		}

	}

}
