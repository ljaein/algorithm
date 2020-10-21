package study0201;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11399_ATM {

	static int N, sum;
	static int[] time;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		time = new int[N];
		for(int i=0;i<N;i++){
			time[i] = sc.nextInt();
		}
		Arrays.sort(time);
		for(int i=0;i<N;i++){
			for(int j=0;j<i+1;j++){
				sum += time[j];
			}
		}
		System.out.println(sum);
		
	}

}
