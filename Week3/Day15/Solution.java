// 15일차 - 과일 구매
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {
	static int N, K;
	static int[][] fruits;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		fruits = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken()); // 과일의 가격
			int full = Integer.parseInt(st.nextToken()); // 포만감
			fruits[i][0] = price; // 조각 수
			fruits[i][1] = full / price; // 조각당 포만감
		}
		
		// 정렬
		Arrays.sort(fruits, (o1, o2) -> {
			// 조각당 포만감이 같지 않다면, 조각당 포만감을 기준으로 내림차순: o2[1] - o1[1]
			// 조각당 포만감이 같다면, 조각수를 기준으로 내림차순 : o2[0] - o1[0]
			return o1[1] != o2[1] ? o2[1] - o1[1] : o2[0] - o1[0];
		});
		
		long sum = 0L;
		for(int i = 0; i < N && K > 0; i++) {
			// 과일 하나를 다 살 수 있는 돈이 있을 때
			if(K >= fruits[i][0]) {
				sum += fruits[i][0] * fruits[i][1];
				K -= fruits[i][0];
			}
			// 과일 하나를 다 살 수 없을 때
			else {
				sum += K * fruits[i][1];
				K = 0;
				break;
			}
		}
		
		System.out.print(sum);
	}
}