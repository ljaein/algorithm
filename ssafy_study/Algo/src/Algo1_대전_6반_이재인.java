import java.util.Scanner;

public class Algo1_대전_6반_이재인 {

	static int T, S, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			S = sc.nextInt(); //시급
			N = sc.nextInt(); //일한 시간
			int in = S * N; //일당
			int four = in / 400; //4딸라로 가져올 수 있는 양
			int one = in % 400 / 100; //4딸라로 가져온 후 남은 양 중에서 1딸라로 가져올 수 있는 양
			int ten = in % 400 % 100 / 10; //남은 양 중에서 10센트로 가져올 수 있는 양
			if (400 * four + 100 * one + 10 * ten == in) //가져온 돈이 일당과 맞아 떨어지면
				System.out.println("#" + t + " " + four + " " + one + " " + ten); //장 수 출력
			else //아니라면
				System.out.println("#" + t + " " + -1); //-1 출력
		}
	}

}
