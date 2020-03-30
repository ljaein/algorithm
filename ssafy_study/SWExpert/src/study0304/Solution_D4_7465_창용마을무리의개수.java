package study0304;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_D4_7465_창용마을무리의개수 {

	static int N,M;
	static int[] ver;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++){
			N=sc.nextInt();
			M=sc.nextInt();
			ver = new int[N];
			for(int i=0;i<N;i++)
				ver[i]=i;
			for(int i=0;i<M;i++){
				int a=sc.nextInt()-1;
				int b=sc.nextInt()-1;
				int v1 = ver[a];
				int v2 = ver[b];
				if(v1!=v2){
					for(int j=0;j<N;j++){
						if(ver[j]==v2){
							ver[j]=v1;
						}
					}
				}
			}
			Set<Integer> set = new HashSet<>();
			for(int i=0;i<N;i++){
				set.add(ver[i]);
			}
			System.out.println("#"+t+" "+set.size());
		}
	}

}
