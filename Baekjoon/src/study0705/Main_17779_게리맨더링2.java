package study0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17779_게리맨더링2 {

   static int N, ans;
   static int[][] cnt, map;
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = null;
      N = Integer.parseInt(br.readLine());
      cnt = new int[N][N];
      ans = Integer.MAX_VALUE;
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < N; j++) {
            cnt[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      for(int i=0;i<N;i++) {
         for(int j=0;j<N;j++) {
            for(int d1=1;d1<N;d1++) {
               for(int d2=1;d2<N;d2++) {
                  if(i+d1+d2>=N||j+d2>=N||j-d1<0)
                     continue;
                  divide(i,j,d1,d2);
               }
            }
         }
      }
      System.out.println(ans);
   }
   static void divide(int y, int x, int d1, int d2) {
      map = new int[N][N];
      map[y][x] = 5;
      for(int i=0;i<d2;i++) {
         y ++;
         x ++;
         map[y][x] = 5;
      }
      for(int i=0;i<d1;i++) {
         y ++;
         x --;
         map[y][x] = 5;
      }
      for(int i=0;i<d2;i++) {
         y--;
         x --;
         map[y][x] =5;
      }
      for(int i=0;i<d1;i++) {
         y--;
         x++;
         map[y][x]=5;
      }//5구역
      for(int i=0;i<y+d1;i++) {
         for(int j=0;j<=x;j++) {
            if(map[i][j]==5)
               break;
            map[i][j]=1;
         }
      }//1구역
      for(int i=0;i<=y+d2;i++) {
         for(int j=N-1;j>x;j--) {
            if(map[i][j]==5)
               break;
            map[i][j]=2;
         }
      }//2구역
      for(int i=y+d1;i<N;i++) {
         for(int j=0;j<x-d1+d2;j++) {
            if(map[i][j]==5)
               break;
            map[i][j]=3;
         }
      }//3구역
      for(int i=y+d2+1;i<N;i++) {
         for(int j=N-1;j>=x-d1+d2;j--) {
            if(map[i][j]==5)
               break;
            map[i][j]=4;
         }
      }//4구역
      int max = 0;
      int min = Integer.MAX_VALUE;
      int[] sum = new int[5];
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
            if(map[i][j]==0)
               sum[4] += cnt[i][j];
            else
               sum[map[i][j]-1]+=cnt[i][j];
         }
      }
      for(int i=0;i<5;i++) {
         min = Math.min(min, sum[i]);
         max = Math.max(max, sum[i]);
      }
      ans = Math.min(ans, max-min);
   }

}