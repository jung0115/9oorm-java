// 10일차 - GameJam
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int N;
	static String[][] board;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] player = new int[2];
		int[] goorm = new int[2];
		
		// 구름이가 말을 올려둔 칸의 좌표
		StringTokenizer st = new StringTokenizer(br.readLine());
		goorm[0] = Integer.parseInt(st.nextToken()) - 1;
		goorm[1] = Integer.parseInt(st.nextToken()) - 1;
		
		// 플레이어가 말을 올려둔 칸의 좌표
		st = new StringTokenizer(br.readLine());
		player[0] = Integer.parseInt(st.nextToken()) - 1;
		player[1] = Integer.parseInt(st.nextToken()) - 1;
		
		// 보드의 각 칸에 적힌 지시 사항
		board = new String[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = st.nextToken();
			}
		}
		
		// 구름이 점수 계산
		visited = new boolean[N][N];
		visited[goorm[0]][goorm[1]] = true;
		checkScore(goorm[1], goorm[0]);
		int goormScore = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j]) goormScore++;
			}
		}
		
		// 플레이어 점수 계산
		visited = new boolean[N][N];
		visited[player[0]][player[1]] = true;
		checkScore(player[1], player[0]);
		int playerScore = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j]) playerScore++;
			}
		}
		
		// 플레이어의 점수가 더 클 경우
		if(playerScore > goormScore) {
			System.out.print("player " + playerScore);
		}
		// 구름이의 점수가 더 클 경우 
		else {
			System.out.print("goorm " + goormScore);
		}
	}
	
	static void checkScore(int x, int y) {
		int len = board[y][x].length();
		int count = Integer.parseInt(board[y][x].substring(0, len - 1));
		
		// 위
		if(board[y][x].charAt(len - 1) == 'U') {
			while(count > 0) {
				y--;
				if(y < 0) y = N - 1;
				if(visited[y][x]) return;
				visited[y][x] = true;
				
				count--;
			}

			checkScore(x, y);
		}
		
		// 아래
		else if(board[y][x].charAt(len - 1) == 'D') {
			while(count > 0) {
				y++;
				if(y >= N) y = 0;
				if(visited[y][x]) return;
				visited[y][x] = true;
				
				count--;
			}

			checkScore(x, y);
		}
		
		// 좌측
		else if(board[y][x].charAt(len - 1) == 'L') {
			while(count > 0) {
				x--;
				if(x < 0) x = N - 1;
				if(visited[y][x]) return;
				visited[y][x] = true;
				
				count--;
			}
			
			checkScore(x, y);
		}
		
		// 우측
		else if(board[y][x].charAt(len - 1) == 'R') {
			while(count > 0) {
				x++;
				if(x >= N) x = 0;
				if(visited[y][x]) return;
				visited[y][x] = true;
				
				count--;
			}
			
			checkScore(x, y);
		}
	}
}