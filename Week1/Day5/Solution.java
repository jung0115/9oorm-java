// 5일차 - 이진수 정렬
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int num[][] = new int[N][2];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			// 10진수 정수 입력
			num[i][0] = Integer.parseInt(st.nextToken());
			
			// 2진수로 변환
			String binaryString = Integer.toBinaryString(num[i][0]);
			
			// 1의 개수 세기
			num[i][1] = 0;
			for(int j = 0; j < binaryString.length(); j++) {
				if(binaryString.charAt(j) == '1') num[i][1]++;
			}
		}
		
		// 정렬
		Arrays.sort(num, (o1, o2) -> {
			// 2진수에 포함된 1의 개수가 같지 않다면, 1의 개수를 기준으로 내림차순: o2[1] - o1[1]
			// 2진수에 포함된 1의 개수가 같다면, 10진수를 기준으로 내림차순 : o2[0] - o1[0]
			return o1[1] != o2[1] ? o2[1] - o1[1] : o2[0] - o1[0];
		});
		
		// K번째 위치한 수
		System.out.print(num[K-1][0]);
	}
}