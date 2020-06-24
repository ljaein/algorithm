package study0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_1339_단어수학 {

	static int N, ans;
	static Integer[] alph = new Integer[26];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Arrays.fill(alph, 0);
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			int mul = (int) Math.pow(10, c.length - 1);
			for (int j = 0; j < c.length; j++) {
				alph[c[j] - 'A'] += mul;
				mul /=10;
			}
		}
		Arrays.sort(alph, Collections.reverseOrder());
		int num = 9;
		for(int i=0;i<26;i++){
			if(alph[i]==0)
				break;
			ans += alph[i] * num;
			num--;
		}
		System.out.println(ans);
	}

}
