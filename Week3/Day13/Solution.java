// 13일차 - 발전기(2)
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	static int[][] M;
	static int N, K;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int[] complex = new int[31];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		M = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				M[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 단지의 개수
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(M[i][j] > 0) {
					checkConnect(i, j, M[i][j]);
				}
			}
		}
		
		// 단지의 개수가 가장 많은 건물 유형
		int max = 1;
		for(int i = 2; i <= 30; i++) {
			if(complex[max] <= complex[i]) {
				max = i;
			}
		}
		
		System.out.print(max);
	}
	
	static void checkConnect(int x, int y, int m) {
		// 속한 건물의 개수
		int count = 1;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{x, y});
		M[x][y] = 0;
		
		while(!queue.isEmpty()) {
			x = queue.peek()[0];
			y = queue.peek()[1];
			queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int moveX = x + dx[i];
				int moveY = y + dy[i];

				if(moveX >= 0 && moveX < N && moveY >= 0 && moveY < N) {
					if(M[moveX][moveY] == m) {
						M[moveX][moveY] = 0;
						queue.add(new int[]{moveX, moveY});
						count++;
					}
				}
			}
		}
		
		// 단지일 경우
		if(count >= K) {
			complex[m]++;
		}
	}
}