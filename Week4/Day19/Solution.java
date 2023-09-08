import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M, S, E;
		Map<Integer, List<Integer>> graph = new HashMap<>();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph.putIfAbsent(s, new ArrayList<>());
			graph.putIfAbsent(e, new ArrayList<>());
			
			graph.get(s).add(e);
			graph.get(e).add(s);
		}
		
		for (int off = 1; off <= N; off++) {
			if (off == S || off == E) {
				System.out.println(-1);
			} 
			else {
				int[] visited = new int[N + 1];
				
				Arrays.fill(visited, (int) 1e8);
				
				Queue<Integer> queue = new LinkedList<>();
				queue.add(S);
				
				visited[S] = 1;
				
				while (!queue.isEmpty()) {
					int curNode = queue.poll();
					
					if (graph.containsKey(curNode)) {
						for (int nextNode : graph.get(curNode)) {
							if (nextNode != off) {
								if (visited[nextNode] > visited[curNode] + 1) {
									visited[nextNode] = visited[curNode] + 1;
									queue.add(nextNode);
								}
								if (nextNode == E) break;
							}
						}
					}
				}
				
				System.out.println(visited[E] == (int) 1e8 ? -1 : visited[E]);
			}
		}
	}
}