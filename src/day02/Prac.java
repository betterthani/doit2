package day02;

import java.util.Scanner;

public class Prac {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		long s[] = new long[n];	// 합배열
		long c[] = new long[m]; // 나머지 연산 카운트 배열
		
		s[0] = scan.nextLong();
		for(int i = 1; i < s.length; i++) {
			s[i] = s[i-1] + scan.nextLong();
		}
		
		long answer = 0; 
		for (int i = 0; i < s.length; i++) {
			long remainder = s[i] % m; // 합배열 m 으로 나눴을때의 연산
			if(remainder == 0) {
				answer++; // 첫번째 배열에 3으로 나눠떨어지는 구간 개수 카운드
			}
			
			c[(int)remainder]++; // 나머지 연산 배열 카운트
		}
		
		for(int i = 0; i < c.length; i++) {
			if(c[i] > 1) { // 나머지 연산이 2개일 경우 조합의 수
				answer += (c[i] * (c[i]-1)) / 2;
			}
		}
		
		System.out.println(answer);
	}
}
