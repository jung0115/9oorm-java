// 14일차 - 작은 노드
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int N, M, K;
	static boolean[][] edge;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		edge = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int E1 = Integer.parseInt(st.nextToken());
			int E2 = Integer.parseInt(st.nextToken());
			
			// 간선 연결 표시
			edge[E1][E2] = true;
			edge[E2][E1] = true;
		}
		
		int preNode = K; // 현재 노드
		int nodeCount = 1; // 방문한 노드의 개수
		visited[preNode] = true;
		
		// 노드 방문
		while(true) {
			// 다음 방문할 노드
			int next = nextNode(preNode);
			
			// 더이상 이동할 수 있는 노드가 없을 경우
			if(next == 0) break;
			
			// 노드 이동 표시
			preNode = next;
			nodeCount++;
			visited[preNode] = true;
		}
		
		System.out.print(nodeCount + " " + preNode);
	}
	
	// 방문 가능한 노드
	static int nextNode(int preNode) {
		for(int i = 1; i <= N; i++) {
			if(edge[preNode][i] && !visited[i]) {
				return i;
			}
		}
		
		// 방문 가능한 노드가 없는 경우
		return 0;
	}
}