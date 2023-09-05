// 16일차 - 연합
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M;
		boolean[][] edge;
		boolean[] visited;
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		edge = new boolean[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int finish = Integer.parseInt(st.nextToken());
			
			edge[start][finish] = true;
			
			map.putIfAbsent(start, new ArrayList<>());
			map.get(start).add(finish);
		}
		
		visited = new boolean[N + 1];
		int cnt = 0;
		
		// 섬을 돌면서 연합 확인
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);
				
				while(!queue.isEmpty()) {
					int island = queue.poll();
					visited[island] = true;
					// 해당 섬과 연결된 섬이 있을 경우(연결 = 다리 존재))
					if(map.containsKey(island)) {
						// 연결된 섬을 체크
						for(int moveIsland: map.get(island)) {
							// 연결된 섬에 또 다른 섬이 연결되었을 경우
							if(map.containsKey(moveIsland)) {
								// 다리가 존재하고, 이전에 방문한 적이 없는지 확인
								if(edge[moveIsland][island] && !visited[moveIsland]) {
									queue.add(moveIsland);
								}
							}
						}
					}
				}
				// 연합 추가
				cnt++;
			}
		}
		
		System.out.print(cnt);
	}
}