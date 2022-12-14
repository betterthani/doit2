package day01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MainDay03 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int number [] = new int[N+1];
		int S[] = new int[N+1];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
			S[i] = S[i-1] + number[i];
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			bw.write(S[e] - S[s-1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}
