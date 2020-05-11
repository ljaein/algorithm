import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Algo2_대전_6반_이재인 {

	static int T, R, C, N;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
			}
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int col = Integer.parseInt(st.nextToken()) - 1;
				roll(0, col);
			}
			//입력 부분
			sb.append("# ").append(t).append("\n");
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	static void roll(int y, int x) {
		int ny = y + 1;
		int nx = x; //한칸 내려감
		if (ny == R || map[ny][nx] == 'X') { //내려간 곳이 장애물이거나 땅이라면
			map[y][x] = 'O'; //화석탄을 굳히고
			return; //함수 종료
		} else if (map[ny][nx] == '.') { //내려간 곳이 빈칸이면
			roll(ny, nx); //다음 칸으로 넘어감
		} else if (map[ny][nx] == 'O') { //내려간 곳에 화석탄이 있다면
			if (nx - 1 >= 0 && map[y][x - 1] == '.' && map[ny][nx - 1] == '.') {
				roll(ny, nx - 1); //왼쪽과 왼쪽 아래가 비어있고 범위 안이라면 왼쪽 아래로 넘어감
			} else {
				if (nx + 1 < C && map[y][x + 1] == '.' && map[ny][nx + 1] == '.') {
					roll(ny, nx + 1); //오른쪽과 오른쪽 아래가 비어있고 범위 안이라면 오른쪽 아래로 넘어감
				} else {
					map[y][x] = 'O'; //나머지의 경우엔 원래 자리에 화석탄을 굳히고
					return; //함수 종료
				}
			}
		}
	}

}
