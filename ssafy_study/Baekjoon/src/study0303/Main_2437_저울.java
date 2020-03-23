package study0303;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2437_저울 {

	static int N, ans;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int ans = 1;
		for(int i=0;i<N;i++){
			if(ans<arr[i])
				break;
			ans += arr[i];
		}
		System.out.println(ans);
	}

	

}
