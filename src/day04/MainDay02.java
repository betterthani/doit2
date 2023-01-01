package day04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class MainDay02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n]; // 수열 배열 생성
		int ans[] = new int[n]; // 정답 배열 생성
		String[] str = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(str[i]);
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // 처음에는 항상 스택이 비어있으므로, 최초 값을 push해 초기화
		for(int i= 1; i < n; i++) {
			// 스택이 비어있지 않고 현재 수열이 스택 top인덱스가 가리키는 수열보다 클 경우
			while(!stack.isEmpty() && a[stack.peek()] < a[i]) {
				ans[stack.pop()] = a[i]; // 정답 배열에 오큰수를 현재 수열로 저장하기
			}
			stack.push(i); // 신규 데이터 push
		}
		
		while(!stack.empty()) {
			// 반복문을 다 돌고 나왔는데 스택이 비어 있지 않다면 빌때까지
			ans[stack.pop()] = -1; // 스택에 쌓인 index에 -1를 넣고
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < n; i++) {
			bw.write(ans[i] + " ");
		}
		
		bw.write("\n");
		bw.flush();
	}

}
