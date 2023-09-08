// 17일차 - 그래프의 밀집도
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

class Main {
	static List<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		List<Integer> result = new ArrayList<>();
		double density = 0;

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				Pair pair = bfs(i);
				List<Integer> temp = pair.list;
				double tempDensity = pair.value;

				if (Math.abs(tempDensity - density) < 1e-8) {
					if (result.size() > temp.size()) {
						result = temp;
						density = tempDensity;
				} else if (result.size() == temp.size()) {
						if (temp.get(0) < result.get(0)) {
							result = temp;
							density = tempDensity;
						}
					}
				} else if (tempDensity > density) {
					result = temp;
					density = tempDensity;
				}
			}
		}

		for (int node : result) {
			System.out.print(node + " ");
		}
	}
	
	public static Pair bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);

		Set<Integer> component = new HashSet<>();

		while (!q.isEmpty()) {
			int now = q.poll();

			if (visited[now]) continue;

			visited[now] = true;
			component.add(now);

			for (int to : graph[now]) {
				if (!visited[to]) 
					q.add(to);
			}
		}

		int edge = 0;

		for (int i : component) {
			for (int to : graph[i]) {
				if (component.contains(to)) {
					edge++;
				}
			}
		}

		List<Integer> sortedList = new ArrayList<>(component);
		Collections.sort(sortedList);

		return new Pair(sortedList, (double) edge / component.size());
	}

	static class Pair {
		List<Integer> list;
		double value;

		Pair(List<Integer> list, double value) {
			this.list = list;
			this.value = value;
		}
	}
}