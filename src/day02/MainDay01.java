package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainDay01 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		long s[] = new long[(int)n]; // 합배열
		long c[] = new long[(int)m]; // 칸은 나머지 인덱스를 카운트하는 배열
		
		
		st = new StringTokenizer(br.readLine());
		s[0] = Long.parseLong(st.nextToken());
		
		for(int i = 1; i < s.length; i++) {
			s[i] = s[i-1] + Long.parseLong(st.nextToken());
		}
		
		long answer = 0;
		for(int i = 0; i < n; i++) { // 합 배열의 모든값에 %연산 수행
			int remainder = (int)(s[i] % m);
			
			// 0 ~ i까지의 구간 합 자체가 0일때 정답에 더하기
			if(remainder == 0) {
				answer++;
			}
			
			c[remainder]++;
		}
		
		for(int i = 0; i < m; i++) {
			if(c[i] > 1) {
				// 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
				answer += (c[i] * (c[i] - 1) / 2);
			}
		}
		System.out.println(answer);
	}
}
