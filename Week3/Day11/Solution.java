// 11일차 - 통증(2)
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int count = N / B;
		int R = N % B;
		
		for(int i = 0; i <= count; i++) {
			if(R % A == 0) {
				count = count - i + (R / A);
				R = 0;
				break;
			}
			R += B;
		}
		
		// 통증 수치를 0으로 만들 수 없는 경우
		if(R != 0) count = -1;
		
		System.out.print(count);
	}
}