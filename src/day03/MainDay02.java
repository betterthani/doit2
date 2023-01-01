package day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainDay02 {
	
	static int myArr[];
	static int checkSecret;
	static int checkArr[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int result = 0;
		checkArr = new int[4]; // 비번 요건 상태 배열
		myArr = new int[4]; // 비밀번호 체크 배열
		char a[] = new char[s];
		checkSecret = 0; // 4개중에 몇개가 비번의 요건과 맞습니까?
		
		a = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i] == 0) { // 0이라는건 요건에 이미 만족했다는 뜻
				checkSecret++;
			}
		}
		
		for(int i = 0; i < p; i++) { // 부분 문자열 처음 받을 때 세팅
			Add(a[i]);
		}
		
		if(checkSecret == 4) {
			result++;
		}
		
		// 슬라이딩 윈도우 (한 칸 오른쪽으로 넘어간 상태)
		for(int i = p; i < s; i++) {
			int j = i - p;
			Add(a[i]);
			Remove(a[j]);
			if(checkSecret == 4) {
				result++;
			}
			
		}
		System.out.println(result);
		br.close();
		
		
	}

	private static void Remove(char c) {
		switch (c) {
		case 'A' :
			
			if(myArr[0] == checkArr[0]) {
				checkSecret--;
			}
			myArr[0]--;
			break;
		case 'C' :
			if(myArr[1] == checkArr[1]) {
				checkSecret--;
			}
			myArr[1]--;
			break;
		case 'G' :
			if(myArr[2] == checkArr[2]) {
				checkSecret--;
			}
			myArr[2]--;
			break;
		case 'T' :
			if(myArr[3] == checkArr[3]) {
				checkSecret--;
			}
			myArr[3]--;
			break;
		}
	}

	private static void Add(char c) {
		switch (c) {
		case 'A' :
			myArr[0]++;
			if(myArr[0] == checkArr[0]) {
				checkSecret++;
			}
			break;
		case 'C' :
			myArr[1]++;
			if(myArr[1] == checkArr[1]) {
				checkSecret++;
			}
			break;
		case 'G' :
			myArr[2]++;
			if(myArr[2] == checkArr[2]) {
				checkSecret++;
			}
			break;
		case 'T' :
			myArr[3]++;
			if(myArr[3] == checkArr[3]) {
				checkSecret++;
			}
			break;
		}
		
	}
}
