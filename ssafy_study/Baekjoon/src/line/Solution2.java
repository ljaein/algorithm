package line;

import java.util.Scanner;

public class Solution2 {
	static int answer = 0;
	static String answer_sheet;
	static String[] sheets = new String[5];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		answer_sheet = sc.next();
		int N = 4;
		for (int i = 0; i < N; i++)
			sheets[i] = sc.next();
		char[] ans = answer_sheet.toCharArray();
		int qcnt = ans.length;
		int doubt = 0, long_d = 0, cnt=0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				doubt = 0;
				long_d = 0;
				cnt = 0;
				char[] one = sheets[i].toCharArray();
				char[] two = sheets[j].toCharArray();
				for (int k = 0; k < qcnt; k++) {
					if (one[k] == two[k] && one[k] != ans[k]) {
						doubt++;
						cnt++;
					} else{
						long_d = Math.max(long_d, cnt);
						cnt=0;
					}
					if(k==qcnt-1){
						long_d = Math.max(long_d, cnt);
						cnt=0;
					}
				}
				answer = Math.max(answer, doubt + long_d * long_d);
			}
		}
		System.out.println(answer);

	}

}
