// 18일차 - 중첩 점
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[][][] dp = new long[2][N+1][N+1];
		long spotCount = 0;

		for (int s = 0; s < M; s++) {
			st = new StringTokenizer(br.readLine());
			
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();

			if (dir.equals("D")) {
				for (int i = y; i <= N; i++) {
					spotCount += dp[1][i][x];
					dp[0][i][x] += 1;
				}
			} else if (dir.equals("U")) {
				for (int i = 1; i <= y; i++) {
					spotCount += dp[1][i][x];
					dp[0][i][x] += 1;
				}
			} else if (dir.equals("R")) {
				for (int i = x; i <= N; i++) {
					spotCount += dp[0][y][i];
					dp[1][y][i] += 1;
				}
			} else if (dir.equals("L")) {
				for (int i = 1; i <= x; i++) {
					spotCount += dp[0][y][i];
					dp[1][y][i] += 1;
				}
			}
		}

		System.out.println(spotCount);
	}
}