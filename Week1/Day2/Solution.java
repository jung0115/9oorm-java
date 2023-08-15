// 2일차 - 프로젝트 매니징
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
class Main {
	static int N, T, M;
	static int[] c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 현재 시각 T시 M분
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		c = new int[N];
		int sum = 0;
		// i번째 기능을 개발하는 데 걸리는 시간
		for(int i = 0; i < N; i++) {
			c[i] = Integer.parseInt(br.readLine());
			sum += c[i]; // N개의 기능을 개발하는 데 걸리는 시간 계산
		}
		
		T = (T + (sum / 60)) % 24;
		M = M + (sum % 60);
		
		// 분이 60분을 넘겨서 한 시간 추가
		if(M >= 60) {
			T = (T + 1) % 24;
			M %= 60;
		}
		
		System.out.print(T + " " + M);
	}
}