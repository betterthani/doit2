package day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class MainDay03 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 숫자 크기
		int l = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우 크기
		st = new StringTokenizer(br.readLine());
		Deque<Node> mydeque	= new LinkedList<>();
		for(int i = 0; i < n; i++) {
			// 새로운 값이 들어올때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄인다.
			int now = Integer.parseInt(st.nextToken());
			
			while(!mydeque.isEmpty() && mydeque.getLast().value > now) {
				mydeque.removeLast();
			}
			mydeque.addLast(new Node(now, i));
			
			// 범위에서 벗어난 값은 덱에서 제거
			if(mydeque.getFirst().index <= i - l) {
				mydeque.removeFirst();
			}
			
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

