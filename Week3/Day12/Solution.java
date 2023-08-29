// 12일차 - 발전기
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	static int[][] M;
	static int N;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		M = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				M[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(M[i][j] == 1) {
					cnt++;
					M[i][j] = 0;
					checkConnect(i, j);
				}
			}
		}
		
		System.out.print(cnt);
	}
	
	static void checkConnect(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{x, y});
		
		while(!queue.isEmpty()) {
			x = queue.peek()[0];
			y = queue.peek()[1];
			queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int moveX = x + dx[i];
				int moveY = y + dy[i];

				if(moveX >= 0 && moveX < N && moveY >= 0 && moveY < N) {
					if(M[moveX][moveY] == 1) {
						M[moveX][moveY] = 0;
						queue.add(new int[]{moveX, moveY});
					}
				}
			}
			
		}
	}
}