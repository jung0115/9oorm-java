// 3일차 - 합 계산기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			String operator = st.nextToken();
			int num2 = Integer.parseInt(st.nextToken());
			
			int result = 0;
			
			if(operator.equals("+")) {
				result = num1 + num2;
			}
			else if(operator.equals("-")) {
				result = num1 - num2;
			}
			else if(operator.equals("*")) {
				result = num1 * num2;
			}
			else if(operator.equals("/")) {
				result = num1 / num2;
			}
			
			sum += result;
		}
		
		System.out.print(sum);
	}
}