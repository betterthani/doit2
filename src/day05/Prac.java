package day05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Prac {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(
			(a,b) -> 
			{
				int firstAbs = Math.abs(a);
				int secondAbs = Math.abs(b);
				if(firstAbs == secondAbs) { // 절댓값이 같을 경우 음수 우선
					return a > b ? 1 : -1;
				} else { // 절댓값이 다를 경우 작은 값 우선
					return firstAbs - secondAbs;
				}
			}
		);
		
		for(int i = 0; i < n; i++) {
			int request = Integer.parseInt(br.readLine());
			if(request == 0) {
				if(pq.isEmpty()) {
					bw.write(0 + "\n");
				} else {
					bw.write(pq.poll() + "\n");
				}
			} else {
				pq.add(request);
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
