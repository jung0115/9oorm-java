// 6일차 - 문자열 나누기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		HashSet<String> sets = new HashSet<>();
		//String[][] parts = new String[N][3];
		ArrayList<String[]> parts = new ArrayList<String[]>();
		
		// 부분문자열의 갯수: N-1개 중에 3개를 뽑는 조합
		// (N-1) * (N-2) ... / 1 * 2 * ...
		int first = 1;
		int second = 2;
		while(true) {
			String[] part = new String[3];
			part[0] = S.substring(0, first);
			part[1] = S.substring(first, second);
			part[2] = S.substring(second, N);
			
			sets.add(part[0]);
			sets.add(part[1]);
			sets.add(part[2]);
			
			parts.add(part);
			
			second++;
			if(second == N) {
				first++;
				second = first + 1;
				if(second >= N) break;
			}
			
		}
		
		// 부분문자열을 중복제거하고 사전순으로 정렬한 결과
		ArrayList<String> setToArray = new ArrayList<>(sets);
		Collections.sort(setToArray);
		
		// 각 부분문자열의 점수 계산
		int max = 0;
		for(int i = 0; i < parts.size(); i++) {
			int sum = 0;
			for(int j = 0; j < 3; j++) {
				// 부분문자열에서 해당 문자열의 점수
				int score = setToArray.indexOf(parts.get(i)[j]);
				sum += score + 1;
			}
			
			if(max < sum) max = sum;
		}
		
		System.out.print(max);
	}
}