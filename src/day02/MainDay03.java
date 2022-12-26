package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainDay03 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		long a[] = new long[n]; 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < a.length; i++) {
			a[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(a);
		int i = 0;
		int j = a.length - 1;
		int count = 0;
		while(i < j) {
			if(a[i] + a[j] < m) {
				i++;
			} else if (a[i] + a[j] > m) {
				j--;
			} else {
				count++;
				i++;
				j--;
			}
		}
		
		System.out.println(count);
	}
}
