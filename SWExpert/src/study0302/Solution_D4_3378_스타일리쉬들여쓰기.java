package study0302;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution_D4_3378_스타일리쉬들여쓰기 {

	static int p, q;
	static String[] master, me;
	static int[] ans;
	static int a, b, c, d, e, f;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			a = b = c = d = e = f = 0;
			p = sc.nextInt();
			q = sc.nextInt();
			master = new String[p];
			me = new String[q];
			ans = new int[q];
			Arrays.fill(ans, Integer.MAX_VALUE);
			for (int i = 0; i < p; i++)
				master[i] = sc.next();
			for (int i = 0; i < q; i++)
				me[i] = sc.next();
			getRCS();
			System.out.print("#" + t + " ");
			for(int i=0;i<q;i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}

	}

	static void getRCS() {
		List<int[]> list = new LinkedList<>();
		for (int i = 0; i < p; i++) {
			char[] row = master[i].toCharArray();
			int dot = 0;
			for (int j = 0; j < row.length; j++) { // 들여쓰기 개수
				if (row[j] == '.') {
					dot++;
				} else {
					break;
				}
			}
			list.add(new int[] { a - b, c - d, e - f, dot });
			for (int j = dot; j < row.length; j++) { // 괄호 수 갱신
				if (row[j] == '(')
					a++;
				else if (row[j] == ')')
					b++;
				else if (row[j] == '{')
					c++;
				else if (row[j] == '}')
					d++;
				else if (row[j] == '[')
					e++;
				else if (row[j] == ']')
					f++;

			}
		}
		for (int r = 1; r < 21; r++) {
			for (int c = 1; c < 21; c++) {
				for (int s = 1; s < 21; s++) {
					boolean ok = true;
					for (int i = 0; i < list.size(); i++) {
						if (r * list.get(i)[0] + c * list.get(i)[1] + s * list.get(i)[2] != list.get(i)[3]) {
							ok = false;
							break;
						}
					}
					if (ok) { // 들어맞는 값 찾은 경우
						spaceMe(r, c, s);
					}
				}
			}
		}
	}

	static void spaceMe(int R, int C, int S) {
		a = b = c = e = d = f = 0;
		for (int i = 0; i < q; i++) {
			if (i == 0)
				ans[i] = 0;
			else {
				int res = R * (a - b) + C * (c - d) + S * (e - f);
				if (ans[i] == Integer.MAX_VALUE) // 처음으로 넣는 값
					ans[i] = res;
				else { // 이미 값이 존재
					if (ans[i] != res) // 결과가 다르다면
						ans[i] = -1;
				}
			}

			char[] row = me[i].toCharArray();
			for (int j = 0; j < row.length; j++) {
				if (row[j] == '(')
					a++;
				else if (row[j] == ')')
					b++;
				else if (row[j] == '{')
					c++;
				else if (row[j] == '}')
					d++;
				else if (row[j] == '[')
					e++;
				else if (row[j] == ']')
					f++;
			}
		}
	}

}
