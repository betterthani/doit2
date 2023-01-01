package day04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Prac {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		int ans[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // stack 초기화
		for(int i = 1 ; i < n; i++) {
			while(!stack.isEmpty() && a[i] > a[stack.peek()]) {
				ans[stack.pop()] = a[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			ans[stack.pop()] = -1;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0 ; i < n; i++) {
			bw.write(ans[i] + " ");
		}
		
		bw.write("\n");
		bw.flush();
		
	}
}
