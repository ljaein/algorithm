package study0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {

   static int R, C, T;
   static int[][] map, temp;
   static int[] cleaner = new int[2];
   static int[] dy = { -1, 0, 1, 0 };
   static int[] dx = { 0, 1, 0, -1 };

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      T = Integer.parseInt(st.nextToken());
      map = new int[R][C];
      int idx = 0;
      for (int i = 0; i < R; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < C; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
            if (map[i][j] == -1) {
               cleaner[idx++] = i;
            }
         }
      }
      for (int i = 0; i < T; i++) {
         dust();
         cleanUp();
         cleanDown();
      }
      int ans = 0;
      for (int i = 0; i < R; i++) {
         for (int j = 0; j < C; j++) {
            ans += map[i][j];
         }
      }
      System.out.println(ans+2);
   }

   static void dust() {
      temp = new int[R][C];
      for (int i = 0; i < R; i++) {
         for (int j = 0; j < C; j++) {
            if (map[i][j] == 0 || map[i][j] == -1)
               continue;
            int spread = map[i][j] / 5;
            int cnt = 0;
            for (int d = 0; d < 4; d++) {
               int ny = i + dy[d];
               int nx = j + dx[d];
               if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == -1)
                  continue;
               temp[ny][nx] += spread;
               cnt++;
            }
            map[i][j] -= cnt * spread;
         }
      }
      for (int i = 0; i < R; i++) {
         for (int j = 0; j < C; j++) {
            map[i][j] += temp[i][j];
         }
      }
   }

   static void cleanUp() {
      int up = cleaner[0];
      int temp = map[up][C - 1];
      for (int i = C - 1; i >= 2; i--) {
         map[up][i] = map[up][i - 1];
      }
      map[up][1]=0;
      int temp2 = map[0][C - 1];
      for (int i = 0; i <= up - 2; i++) {
         map[i][C - 1] = map[i + 1][C - 1];
      }
      map[up - 1][C - 1] = temp;
      int temp3 = map[0][0];
      for (int i = 0; i <= C - 3; i++) {
         map[0][i] = map[0][i + 1];
      }
      map[0][C - 2] = temp2;
      for(int i=up-1;i>=1;i--) {
         map[i][0] = map[i-1][0];
      }
      map[1][0] = temp3;
   }
   
   static void cleanDown() {
      int down = cleaner[1];
      int temp = map[down][C - 1];
      for (int i = C - 1; i >= 2; i--) {
         map[down][i] = map[down][i - 1];
      }
      map[down][1]=0;
      int temp2 = map[R-1][C - 1];
      for (int i = R-1; i >= down + 2; i--) {
         map[i][C - 1] = map[i - 1][C - 1];
      }
      map[down + 1][C - 1] = temp;
      int temp3 = map[R-1][0];
      for (int i = 0; i <= C - 3; i++) {
         map[R-1][i] = map[R-1][i + 1];
      }
      map[R-1][C - 2] = temp2;
      for(int i=down+1;i<=R-3;i++) {
         map[i][0] = map[i+1][0];
      }
      map[R-2][0] = temp3;
   }

   static class Point {
      int y, x;

      public Point(int y, int x) {
         super();
         this.y = y;
         this.x = x;
      }

   }

}