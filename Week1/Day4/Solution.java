// 4일차 - 완벽한 햄버거 만들기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] hambuger = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			hambuger[i] = Integer.parseInt(st.nextToken());
		}
		
		int taste = hambuger[0];
		int maxIndex = 0;
		for(int i = 1; i < N; i++) {
			if(hambuger[i-1] <= hambuger[i]) {
				taste += hambuger[i];
				maxIndex = i;
			}
			else break;
		}
		
		for(int i = maxIndex + 1; i < N; i++) {
			if(hambuger[i - 1] >= hambuger[i]) {
				taste += hambuger[i];
			}
			else {
				taste = 0;
				break;
			}
		}
		
		System.out.print(taste);
	}
}