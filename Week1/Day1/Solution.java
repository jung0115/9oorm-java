// 1일차 - 운동 중독 플레이어
import java.io.*;
import java.util.StringTokenizer;
class Main {
	static int W, R;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 무게, 반복횟수 입력
		W = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
        // 계산
		double RM = (double)W * (1.0 + ((double)R / 30.0));
		
        // 출력 - 소수점 버림
		System.out.print((int)RM);
	}
}