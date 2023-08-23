// 8일차 - 통증
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		int items = input / 14;
		input %= 14;
		
		items += input / 7;
		input %= 7;
		
		items += input;
		
		System.out.print(items);
		
	}
}