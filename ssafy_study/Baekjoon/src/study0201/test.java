package study0201;

public class test {
	public static void main(String[] args) {
		int[][] arr = new int[6][6];
		int num = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j < 6; j++) {
				arr[i][j] = num++;
			}
		}
		for (int i = 0; i <6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		int sy = 1-1; // 1
		int sx = 2-1; // 2
		int fy = 5-1; // 5
		int fx = 6-1; // 6
		int fin = ((fx+1) - (sx+1)) / 2;
		for (int n = 0; n <fin; n++) {
			int temp = arr[sy][fx];
			for (int i = fx; i > sx; i--) {
				arr[sy][i] = arr[sy][i - 1];
			}

			int temp2 = arr[fy][fx];
			for (int i = fy; i > sy + 1; i--) {
				arr[i][fx] = arr[i - 1][fx];
			}
			arr[sy + 1][fx] = temp;

			int temp3 = arr[fy][sx];
			for (int i = sx; i < fx - 1; i++) {
				arr[fy][i] = arr[fy][i + 1];
			}
			arr[fy][fx - 1] = temp2;

			for (int i = sy; i < fy - 1; i++) {
				arr[i][sx] = arr[i + 1][sx];
			}
			arr[fy - 1][sx] = temp3;

			sy += 1;
			sx += 1;
			fy -= 1;
			fx -= 1;
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
