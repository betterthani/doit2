package day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainDay01 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long a[] = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(a);
		
		long count = 0;
		for (int k = 0; k < a.length; k++) {
			int i = 0;
			int j = a.length-1;
			long find = a[k];
			
			while(i < j) {
				if(a[i] + a[j] == find) {
					if(i != k && j != k) {
						count++;
						break;
					} else if(i == k) {
						i++;
					} else {
						j--;
					}
				} else if(a[i] + a[j] < find) {
					i++;
				} else {
					j--;
				}
			}
		}
		System.out.println(count);
	}

}
