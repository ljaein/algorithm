package study_2021_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3273_두수의합 {

	static int n,x;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		x = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		int ans = 0;
		int l = 0;
		int r = arr.length-1;
		while(l<r){
			int sum = arr[l]+arr[r];
			if(sum<=x){
				l++;
			}else if(sum>x){
				r--;
			}
			if(sum == x) ans++;
		}
		System.out.println(ans);
	
	}

}
