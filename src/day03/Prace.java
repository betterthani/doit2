package day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Prace {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Deque<Node> mydeque = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			while(!mydeque.isEmpty() && mydeque.getLast().value > now) {
				// 1) 현재의 값보다 마지막덱이 갖고있는 값이 크면 마지막덱 삭제
				mydeque.removeLast();
			}
			
			mydeque.addLast(new Node(now, i)); // 덱에 뒤에 새로운 값과 인덱스 추가
			
			// 2) index비교시 l(윈도우 크기)가 넘어가면 덱 맨 앞값 삭제하기
			if(mydeque.getFirst().index <= i - l) {
				mydeque.removeFirst();
			}
			
			// 맨 앞의 값이 제일 작으므로, 맨 앞의 값 뿌리기
			bw.write(mydeque.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
	}
	
	static class Node{
		public int value;
		public int index;
		
		Node(int value, int index){
			this.value = value;
			this.index = index;
		}
	}
}
