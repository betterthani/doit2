package day04;

import java.util.Scanner;
import java.util.Stack;

public class MainDay01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int [] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		
		Stack<Integer> stack = new Stack<>();
		int num = 1; // 오름차순 수
		boolean result = true;
		StringBuffer bf = new StringBuffer(); 
		for (int i = 0; i < a.length; i++) {
			int su = a[i]; // 현재 수열의 수
			if (su >= num) { // 현재 수열 값 >= 오름차순 자연수 : 값이 같아질때까지 push()수행
				while(su >= num) {
					stack.push(num++);
					bf.append("+\n");
				}
				
				stack.pop();
				bf.append("-\n");
			} else { // 현재 수열 값 < 오름차순 자연수 : pop()을 수행해서 수열 원소 꺼냄
				int n1 = stack.pop();
				// 스택의 가장 위의 수가 마들어야 하는 수열의 수보다 크면 수열을 출력할 수 없음
				if(n1 > su) { // 스택 상단 수 > 현재 수열값
					System.out.println("NO");
					result = false;
					break;
				} else {
					bf.append("-\n");
				}
			}
		}
		
		if(result) {
			System.out.println(bf.toString());
		}
	}
}
