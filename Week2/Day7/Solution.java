// 7일차 - 구름 찾기 깃발
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
	static int N, K;
	static int[][] M;
	static int count = 0;
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 게임판 입력
		M = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				M[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 각 칸마다 깃발의 값 체크
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// 구름이 없는 위치	
				if(M[i][j] == 0) {
					int value = valuePlag(i, j);
					if(value == K) count++;
				}
			}
		}
		
		System.out.print(count);
	}
	
	static int valuePlag(int x, int y) {
		int value = 0;
		
		// 대각선, 상하좌우 좌표 탐색
		for(int i = 0; i < 8; i++) {
			int moveX = x + dx[i];
			int moveY = y + dy[i];
			
			// 게임판을 벗어나지 않는 경우
			if(moveX >= 0 && moveX < N && moveY >=0 && moveY < N) {
				// 구름이면 카운트
				if(M[moveX][moveY] == 1) {
					value++;
					
					// 값이 K를 넘으면 더이상 계산하지 않고 중단
					if(value > K) break;
				}
			}
		}
		
		return value;
	}
}