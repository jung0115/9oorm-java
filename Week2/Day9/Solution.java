// 9일차 - 폭탄 구현하기(2)
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[][] state = new char[N][N];
		int[][] bombValue = new int[N][N];
		int[] dx = {-1, -1, -1, -2, 0};
		int[] dy = {-1, -2, 0, -1, -1};
		
		// 땅의 상태 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				state[i][j] = st.nextToken().charAt(0);
			}
		}
		// 폭탄을 떨어트릴 땅의 좌표
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.aparseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 떨어진 위치와 상하좌우 살피기
			for(int j = 0; j < 5; j++) {
				if(x + dx[j] >= 0 && x + dx[j] < N && y + dy[j] >= 0 && y + dy[j] < N) {
					if(state[x + dx[j]][y + dy[j]] == '0') {
						bombValue[x + dx[j]][y + dy[j]]++;
					}
					else if(state[x + dx[j]][y + dy[j]] == '@') {
						bombValue[x + dx[j]][y + dy[j]] += 2;
					}
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(bombValue[i][j] > max) max = bombValue[i][j];
			}
		}
		
		System.out.print(max);
		
	}
}
